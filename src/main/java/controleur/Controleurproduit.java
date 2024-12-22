package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import BO.Categorie;
import BO.Produit;
import DAO.DAOCategorie;
import DAO.DAOProduit;

/**
 * Servlet implementation class Controleurproduit
 */
   @MultipartConfig
    public class Controleurproduit extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleurproduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
	response.sendRedirect("gestionproduit.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String action = request.getParameter("action");
 		if ("1".equals(action)) 
		{
			// ajouter une nouvelle produit 
			
  			String desc = request.getParameter("desc"); // Récupère la valeur du champ desc
 			String p = request.getParameter("prix"); // Récupère la valeur du champ prix et la convertit en double
 			String q = request.getParameter("quantite"); // Récupère la valeur du champ quantite et la convertit en entier
 			String  nom = request.getParameter("nom");
            
			
			
			Part P = request.getPart("image");
			String ifp = P.getSubmittedFileName(); 
				
			String destPath = "C:/Users/kalto/Downloads/UML/projet_e_commerce/src/main/webapp/images/"+ifp;
				try {
			FileOutputStream fos = new FileOutputStream(destPath);
			InputStream is = P.getInputStream();
			byte[] data= new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
				}catch(Exception e)
				{
				e.getStackTrace();	
				}
 			
			
				 
 			DAOCategorie daoc = new DAOCategorie();
            int id= daoc.getidBynom(nom);
			System.out.println("id "+ id);

            Produit produit = new Produit(desc,Double.parseDouble(p),Integer.parseInt(q),"images/"+ifp);
			System.out.println("prod! "+produit);

            DAOProduit daop = new DAOProduit();
            daop.create(produit, id);
            
 		    response.sendRedirect("Controleur"); 
		}  
 		if ("2".equals(action)) 
		{
 		// after 7 and 8
         // modifier   produit 
 			HttpSession session = request.getSession();
 			  int id =0;
 			Integer idInteger = (Integer) session.getAttribute("id_p");
 			if (idInteger != null) {
 			  id= idInteger.intValue(); // Convertir l'Integer en int
 			    String idString = idInteger.toString(); // Convertir l'Integer en String si nécessaire
  			} 
           
  		
 	 		String desc = request.getParameter("desc"); // Récupère la valeur du champ desc
 			String p = request.getParameter("prix"); // Récupère la valeur du champ prix et la convertit en double
 			
 			String q = request.getParameter("quantite"); // Récupère la valeur du champ quantite et la convertit en entier
            Part P = request.getPart("image");
			String ifp = P.getSubmittedFileName(); 
			
			
			String destPath = "C:/Users/kalto/Downloads/UML/projet_e_commerce/src/main/webapp/images/"+ifp;
				try {
			FileOutputStream fos = new FileOutputStream(destPath);
			InputStream is = P.getInputStream();
			byte[] data= new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
				}catch(Exception e)
				{
				e.getStackTrace();	
				}
 			
			
			 
            Produit produit = new Produit(id,desc,Double.parseDouble(p),Integer.parseInt(q),"images/"+ifp);
			System.out.println("prod! "+produit);
            DAOProduit daop = new DAOProduit();
            daop.update(produit);
 		    response.sendRedirect("Controleur"); 
	}

 		if ("5".equals(action)) 
		{
 			response.sendRedirect("supprimerproduit.jsp");
		}
 		if ("3".equals(action)) 
		{
 		   
 			response.sendRedirect("modifierproduit.jsp");
 			
		}
		
 		if ("7".equals(action)) 
		{
 			// produit par categorie
 		int id_cat = Integer.parseInt(request.getParameter("categorieSelect"));	
 		DAOProduit daop = new DAOProduit();
  		ArrayList<Produit> produits = daop.retreive(id_cat);	
		HttpSession session = request.getSession();
		session.setAttribute("produits", produits);
		response.sendRedirect("modifierproduit.jsp");
		}

 		if ("8".equals(action)) 
		{
 		 
 		int id = Integer.parseInt(request.getParameter("produitSelect"));
 		
        DAOProduit daop = new DAOProduit();
        Produit produit =daop.getProduitById(id);
        HttpSession session = request.getSession();
		session.setAttribute("produitmodifier", produit);
		session.setAttribute("id_p", id);
		response.sendRedirect("modifierproduit.jsp");
			
		}
 		if ("10".equals(action)) 
		{// after 11  
 		 // supprimer un produit
 		int id = Integer.parseInt(request.getParameter("produitSelect"));
 		
        DAOProduit daop = new DAOProduit();
          if( daop.delete(id))
         response.sendRedirect("Controleur");
          response.sendRedirect("supprimerproduit.jsp");
	
		}
 		if ("11".equals(action)) 
		{
 			// produit par categorie
 		int id_cat = Integer.parseInt(request.getParameter("categorieSelect"));	
 		DAOProduit daop = new DAOProduit();
  		ArrayList<Produit> produits = daop.retreive(id_cat);	
		HttpSession session = request.getSession();
		session.setAttribute("produits", produits);
		response.sendRedirect("supprimerproduit.jsp");
		}
 

	  }
   }

