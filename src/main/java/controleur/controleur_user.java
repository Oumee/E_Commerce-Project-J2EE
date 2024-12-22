package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import BO.Compte;
import BO.Produit;
import BO.Vente;
import DAO.DAOCompte;
import DAO.DAOProduit;
import DAO.DAOVente;

/**
 * Servlet implementation class controleur_user
 */

 public class controleur_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controleur_user() {
        super();
        // TODO Auto-generated constructor stub
                             }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{          // TODO Auto-generated method stub
	           // à la fin lors l appel reçus
 				String login = request.getParameter("login");
				String passwd = request.getParameter("passwd");
 				
	            DAOCompte daocompte = new DAOCompte();			
				
	            if(login != null && passwd != null &&daocompte.CompteExiste(login, passwd))   
				    {
	            	
	            	 response.sendRedirect("Livraison.jsp");

				    } else 
				    {
				      
				    	request.setAttribute("erreur", "Login ou password incorrecte");
						request.getRequestDispatcher("login.jsp").forward(request,response);
    
				     }
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	   String action = request.getParameter("action");
		if ("1".equals(action)) 
		{
			// creation de compte 
			response.sendRedirect("Compte.jsp");	
		}
		if ("2".equals(action)) 
		{

	     String login = request.getParameter("login1");
	     String pass1 = request.getParameter("pass1");
	     String pass2 = request.getParameter("pass2");
                  if(!pass1.equals(pass2))
                	  {
                	  
                	  request.setAttribute("erreurCode","mode de passe non satistfait" );
					  request.getRequestDispatcher("Compte.jsp").forward(request,response);
					  
                	  }
                  else 
                	  {
 
                   	  
                      Compte compte = new Compte(login,pass1);
                	  DAOCompte daoc = new DAOCompte();
                	  daoc.create(compte);
                	  response.sendRedirect("login.jsp");
                	  
                	  }
	   }
		
		if ("3".equals(action)) 
		{
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
        // livraison 
		
		// dec la qt from daoproduit
    	DAOProduit daop = new DAOProduit();
     	// Obtenir la date actuelle
        LocalDate currentDate = LocalDate.now();

        // Formater la date en tant que chaîne de caractères
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        double t=0;
        for(Produit p : ControleurPanier.panier.getPanier_produit())
        {    
         	daop.modifier_quantite(p.getId_produit(), p.getQuantite());
        	t+=p.getPrix();
        }
	    // creer un vente 
    	 Vente vente = new Vente(formattedDate,t);
    	 DAOVente daov = new DAOVente();
    	 daov.create(vente);
    	 
    	// Authentification réussie
        //supprimer panier 
    	// ControleurPanier.panier.getPanier_produit().removeAll(ControleurPanier.panier.getPanier_produit());
		
		response.sendRedirect("fin.jsp");
		}
		
	}

}
