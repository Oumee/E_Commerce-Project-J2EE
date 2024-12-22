package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BO.Categorie;
import BO.Produit;

public class DAOProduit {
	public ArrayList<Produit> retreive(int id_categorie) {
        ArrayList<Produit> produits = new ArrayList<>();

        try {
            // Utiliser la même méthode pour obtenir la connexion
            Connection con = Connexion.getCon();
            if (con != null) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT id_produit, description,prix, quantite, image FROM produit where id_categorie="+id_categorie);
                while (rs.next()) {
                    int id = rs.getInt("id_produit");
                    String nom = rs.getString("description");
                    double prix = rs.getDouble("prix");
                    int quantite = rs.getInt("quantite");
                    String image = rs.getString("image");

                    Produit p = new Produit(id, nom,prix,quantite,image);
                    produits.add(p);
                }
               con.commit();    
            } else {
            
            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return produits;

        
    }
	public Produit getProduitById(int id_p) {
        
        try {
            // Utiliser la même méthode pour obtenir la connexion
            Connection con = Connexion.getCon();
            if (con != null) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT id_produit, description,prix,image, quantite  FROM produit where id_produit="+id_p);
               rs.next();
                  
                	int id = rs.getInt("id_produit");
                    String nom = rs.getString("description");
                    double prix = rs.getDouble("prix");
                    int q = rs.getInt("quantite");
                    String im = rs.getString("image");

                    Produit p = new Produit(id, nom,prix,q,im);
                    return p;
                
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
    public void modifier_quantite(int id_p, int q)
    {
    	try{
            Connection con = Connexion.getCon();

        PreparedStatement pst=con.prepareStatement("update produit set quantite = quantite - "+q+ " where id_produit="+id_p);
     
        pst.clearParameters();
        pst.executeUpdate();

                
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
         }
    }

    public boolean delete( int id) {
	    try {
	        Connection con = Connexion.getCon();
 	            PreparedStatement pst = con.prepareStatement("DELETE FROM PRODUIT WHERE id_produit = ?");
 	            pst.setInt(1,id);
	            

	            pst.executeUpdate();
	             con.commit(); // Exécuter le commit après l'exécution de la requête SQL

	            
 	         
	    } catch (SQLException e) {
	             System.err.println("Erreur lors de la création du produit : " + e.getMessage());
	        return false;
	    }
	    return true;
	}
 
    public boolean create(Produit P, int id) {
	    try {
	        Connection con = Connexion.getCon();
	        if (P!=null) {
	            PreparedStatement pst = con.prepareStatement("INSERT INTO produit(description, prix,id_categorie,quantite,image) VALUES (?,?,?,?,?) ");
	            //pst.setInt(1,C.getId_categorie());
	            pst.setString(1,P.getDescription());
	            pst.setDouble(2,P.getPrix()); 
	            pst.setInt(3,id);
	            pst.setInt(4,P.getQuantite());
	            pst.setString(5,P.getImage());

	            pst.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "categorie est creer!", "", 1);
	             con.commit(); // Exécuter le commit après l'exécution de la requête SQL

	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Compte est null.", "", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	             System.err.println("Erreur lors de la création du produit : " + e.getMessage());
	        return false;
	    }
	    return true;
	}
 
    public boolean update(Produit P) {
        try {
            Connection con = Connexion.getCon();
            if (P != null) {
                PreparedStatement pst = con.prepareStatement("UPDATE produit SET description=?, prix=?, quantite=?, image=? WHERE id_produit=?");
                pst.setString(1, P.getDescription());
                pst.setDouble(2, P.getPrix());
                pst.setInt(3, P.getQuantite());
                pst.setString(4, P.getImage());
                pst.setInt(5 , P.getId_produit()); // Si vous souhaitez également mettre à jour l'id de catégorie, sinon, utilisez P.getIdCategorie()

 
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected == 0) {
                    // Aucune ligne mise à jour, le produit avec l'ID spécifié n'existe peut-être pas dans la base de données
                    System.err.println("Aucune ligne mise à jour, produit avec l'ID " + P.getId_produit() + " non trouvé.");
                    return false;
                }

                con.commit(); // Exécuter le commit après l'exécution de la requête SQL
            } else {
                JOptionPane.showMessageDialog(null, "Le produit est null.", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du produit : " + e.getMessage());
            return false;
        }
        return true;
    }

    
    
}
