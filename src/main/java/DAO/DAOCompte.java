package DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import BO.Compte;

public class DAOCompte  implements IDAOCompte{
	
	@Override
    public   boolean  CompteExiste(String s1,String s2) {
 
		try{
        
			Statement st = Connexion.getCon().createStatement();
			ResultSet rs=st.executeQuery("Select * from compte");
      
      while(rs.next()){
      if(rs.getString("login").equals(s1) && rs.getString("pwd").equals(s2))
    	  return true;
    
      }
      return false; 
      }
      catch(SQLException e){
      System.err.println(e.getMessage());
      return false;
      }
	
	
}

	@Override
	public boolean create(Compte C) {
	    try {
	        Connection con = Connexion.getCon();
	        if (C != null) {
	            PreparedStatement pst = con.prepareStatement("INSERT INTO compte(login, pwd) VALUES (?, ?)");
	            pst.setString(1, C.getLogin());
	            pst.setString(2, C.getPassword());
	            pst.executeUpdate();
	        } else {
	            JOptionPane.showMessageDialog(null, "Compte est null.", "", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        System.err.println("Erreur lors de la création du compte : " + e.getMessage());
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Compte C) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}