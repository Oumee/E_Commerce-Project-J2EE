package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BO.Compte;
import BO.Vente;

public class DAOVente {
	public boolean create(Vente C) {
	    try {
	        Connection con = Connexion.getCon();
	        if (C != null) {
 	            PreparedStatement pst=con.prepareStatement("INSERT INTO VENTE VALUES ( ?,TO_DATE(?, 'DD-MM-YYYY'),?)");
                pst.setInt(1, C.getId_vente());
	            pst.setString(2, C.getDateVente());
	            pst.setDouble(3, C.getTotal());
	            pst.executeUpdate();
 
	        } else {
	            JOptionPane.showMessageDialog(null, "Compte est null.", "", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
 
	    	System.err.println("Erreur lors de la création du vente : " + e.getMessage());
	              
	        return false;
	    }
	    return true;
	}
	
}
