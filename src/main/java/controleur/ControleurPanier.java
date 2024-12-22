package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.Console;
import java.io.IOException;

import javax.swing.JOptionPane;

import BO.Panier;
import BO.Produit;
import DAO.DAOProduit;

/**
 * Servlet implementation class ControleurPanier
 */
public class ControleurPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Panier panier= new Panier();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurPanier() {
        super();
    	

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
 
		    if(panier==null)
		    {
		        session.setAttribute("paniervide", "Votre panier est vide");
		        response.sendRedirect("achat.jsp");

		    }else
		    {
        session.setAttribute("panier",panier);
        response.sendRedirect("Panier.jsp");
		    }
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	     {
	           //
          // ajout au panier 
		HttpSession session= request.getSession();
        
		  int id_produit = Integer.parseInt(request.getParameter("produitSelectionne"));
		  int q_produit  = Integer.parseInt(request.getParameter("quantite"));

		  DAOProduit daop = new DAOProduit();
		  Produit p= daop.getProduitById(id_produit);
          p.setQuantite(q_produit);
          p.setPrix(q_produit*p.getPrix());
		   if(p!=null)
 		 {
          panier.add(p);
          session.setAttribute("panier",panier);

          //daop.modifier_quantite(id_produit, q_produit);
          response.sendRedirect("achat.jsp");
  		 }
 		 else
          JOptionPane.showMessageDialog(null, "kdjndkj","pas de produit",0);	
	       
	     }

}
