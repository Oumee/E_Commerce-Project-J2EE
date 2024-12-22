package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.swing.JOptionPane;

import BO.Panier;
import BO.Produit;
import DAO.DAOProduit;

/**
 * Servlet implementation class PanierSupprimerProduit
 */
public class PanierSupprimerProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierSupprimerProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        System.out.print(ControleurPanier.panier.getPanier_produit());

		if(!ControleurPanier.panier.getPanier_produit().isEmpty())
		response.sendRedirect("login.jsp");
		else 
			{
			request.setAttribute("pasachat","attention vous n avez pas effectué un achat ");
			request.getRequestDispatcher("Panier.jsp").forward(request,response);
			}

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 	// supprimer produit du panier 
		HttpSession session= request.getSession();
		DAOProduit daop = new DAOProduit();
		int id_produit = Integer.parseInt(request.getParameter("produitRetire"));
		Produit p = daop.getProduitById(id_produit);
 		//new ControleurPanier();
		ControleurPanier.panier.remove((Produit)p);
 		session.setAttribute("panier",ControleurPanier.panier);
		response.sendRedirect("Panier.jsp");
	}

}
