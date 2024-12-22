package DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BO.Categorie;
import BO.Compte;

public class DAOCategorie {
    public ArrayList<Categorie> retreive() {
        ArrayList<Categorie> categories = new ArrayList<>();

        try {
            // Utiliser la même méthode pour obtenir la connexion
            Connection con = Connexion.getCon();
            if (con != null) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT id_categorie, nom_categorie, image  FROM categorie");
                while (rs.next()) {
                    int id = rs.getInt("id_categorie");
                    String nom = rs.getString("nom_categorie");
                    String image = rs.getString("image");

                    Categorie cat = new Categorie(id, nom,image);
                    categories.add(cat);
                }
                return categories;
            } else {
            
            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
    
    public String getNom(String c) {
        ArrayList<Categorie> categories = new ArrayList<>();
        String nom=null;
        try {
            // Utiliser la même méthode pour obtenir la connexion
            Connection con = Connexion.getCon();
            if (con != null) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT  nom_categorie FROM categorie where nom_categorie like " + c);
                while (rs.next()) {
                    
                    nom = rs.getString("nom_categorie");
                     

                    
                }
                return nom;
            } else {
            
            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
    
    public boolean create(Categorie C) {
	    try {
	        Connection con = Connexion.getCon();
	        if (C != null) {
	            PreparedStatement pst = con.prepareStatement("INSERT INTO categorie(nom_categorie, image) VALUES (?,?) ");
	            //pst.setInt(1,C.getId_categorie());
	            pst.setString(1, C.getNom_categorie());
	            pst.setString(2, C.getImage());
	            pst.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "categorie est creer!", "", 1);
	             con.commit(); // Exécuter le commit après l'exécution de la requête SQL

	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Compte est null.", "", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	             System.err.println("Erreur lors de la création du categorie : " + e.getMessage());
	        return false;
	    }
	    return true;
	}
    
    
    
    public boolean updateNomCategorie(Categorie C, String c) {
        try {
            Connection con = Connexion.getCon();
            if (C != null) {
                PreparedStatement pst = con.prepareStatement("UPDATE categorie set nom_categorie=? where nom_categorie like ?");
                pst.setString(1, C.getNom_categorie());
                pst.setString(2, c + "%");
                pst.executeUpdate();
                con.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Cate est null.", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du nom de la catégorie : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateImageCategorie(Categorie C, String c) {
        try {
            Connection con = Connexion.getCon();
            if (C != null) {
                PreparedStatement pst = con.prepareStatement("UPDATE categorie set image=? where nom_categorie like ?");
                pst.setString(1, C.getImage());
                pst.setString(2, C.getNom_categorie() );
                pst.executeUpdate();
                con.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Cate est null.", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'image de la catégorie : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(String C) {
	    try {
	        Connection con = Connexion.getCon();
	        if (C != null) {
	            PreparedStatement pst = con.prepareStatement("delete from categorie where nom_categorie like ?");
 	            pst.setString(1,C+"%");
 	            pst.executeUpdate();
 	            con.commit(); // Exécuter le commit après l'exécution de la requête SQL

	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Compte est null.", "", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	             System.err.println("Erreur lors de la création du categorie : " + e.getMessage());
	        return false;
	    }
	    return true;
	}
    
	public int getidBynom(String s)
	{
	
	int id=0;
	try {
	 Connection con = Connexion.getCon();
     if (con != null) {
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT id_categorie FROM categorie WHERE nom_categorie LIKE '" + s + "%'");
         while (rs.next()) {
         id = rs.getInt("id_categorie");
           
              
         }
         return id;
     } else {
     
  JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);

     }
 } catch (SQLException e) {
     JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
 } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "Une erreur s'est produite : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
 }

 return 0;
}
}
