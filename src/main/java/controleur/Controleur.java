package controleur;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import BO.Categorie;
import BO.Panier;
import BO.Produit;
import DAO.Connexion;
import DAO.DAOCategorie;
import DAO.DAOProduit;
// produit ajouter dans le panier est dans la session !! 

 



public class Controleur extends HttpServlet {
	  
	
    public Controleur() {
    	super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session = request.getSession();
		ArrayList<Categorie> categories = new ArrayList<>();
  		
		
		DAOCategorie daocat = new DAOCategorie();
 
  		
  		categories=daocat.retreive();
 	 
  	 
 		session.setAttribute("cat",categories);
 
		request.getRequestDispatcher("Accueil.jsp").forward(request,response);

  
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    
         String id_c = request.getParameter("id_cat");
 
	    DAOProduit daop = new DAOProduit();
 		ArrayList<Produit> produits=daop.retreive(Integer.parseInt(id_c));
		
 		HttpSession session = request.getSession();
 	    session.setAttribute("p",produits);
		
 	    request.getRequestDispatcher("achat.jsp").forward(request,response);
           
	}
	
	 
}
