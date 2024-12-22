package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import BO.Categorie;
import DAO.DAOCategorie;
import DAO.DAOCompte;

/**
 * Servlet implementation class Controleurgestion
 */
@MultipartConfig
public class Controleurgestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleurgestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("logingestion.jsp");   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if ("1".equals(action)) 
		{
			// ajouter une nouvelle categorie 
			
			//int id_categorie = Integer.parseInt(request.getParameter("id"));
			String  nom = request.getParameter("nom");
			String url = request.getParameter("image");
           
			
			
			Part p = request.getPart("image");
			String ifp = p.getSubmittedFileName(); 
				
				String destPath = "C:/Users/kalto/Downloads/UML/projet_e_commerce/src/main/webapp/images/"+ifp;
				try {
				FileOutputStream fos = new FileOutputStream(destPath);
				InputStream is = p.getInputStream();
			byte[] data= new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
				}catch(Exception e)
				{
				e.getStackTrace();	
				}
			// Categorie categorie = new Categorie(id_categorie,nom,url);
			
			Categorie categorie = new Categorie(nom,"images/"+ifp);
			DAOCategorie daoc = new DAOCategorie();
			System.out.print("categorie : "+ categorie );
            daoc.create(categorie);
            request.setAttribute("creecat", "Categorie est crée");
		    response.sendRedirect("Controleur"); 
		
		}
		if ("2".equals(action)) 
		{
		
			response.sendRedirect("modifiercategorie.jsp");
		}
		if ("3".equals(action)) 
		{
			//modifier une categorie
			
 			            String  nom = request.getParameter("nom");	
			            String  nvnom = request.getParameter("nvnom");
						Part p = request.getPart("image");
						String ifp = p.getSubmittedFileName(); 
 						
 						String destPath = "C:/Users/kalto/Downloads/UML/projet_e_commerce/src/main/webapp/images/"+ifp;
 						try {
 						FileOutputStream fos = new FileOutputStream(destPath);
 						InputStream is = p.getInputStream();
						byte[] data= new byte[is.available()];
						is.read(data);
						fos.write(data);
						fos.close();
 						}catch(Exception e)
 						{
 						e.getStackTrace();	
 						}
 						
 						Categorie categorie = new Categorie(nvnom,"images/"+ifp);

 						//categorie.setImage(destPath);
 						DAOCategorie daoc = new DAOCategorie();
						System.out.print("categorie : "+ categorie );
			            daoc.updateNomCategorie(categorie,nom);
			            daoc.updateImageCategorie(categorie,nom);
			            request.setAttribute("creecat", "Categorie est crée");
					    response.sendRedirect("Controleur"); 
		}
		if ("4".equals(action)) 
		{
			// login 
			String login = request.getParameter("login");
			String passwd = request.getParameter("passwd");
			DAOCompte daocompte = new DAOCompte();			
		
             if(login != null && passwd != null &&daocompte.CompteExiste(login, passwd))   
		    {
        	response.sendRedirect("gestionstock.jsp");
	        }
		 }
		if ("5".equals(action)) 
		{
			// vers la page de suppression
		response.sendRedirect("supprimercategorie.jsp");	
		}
		if ("6".equals(action)) 
		{
	            String  nom = request.getParameter("nom");	
	            DAOCategorie daoc = new DAOCategorie();
 	            daoc.delete(nom);
			    response.sendRedirect("Controleur"); 

		}
	}
}
