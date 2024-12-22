package DAO;

import java.sql.*;

public class Connexion {
    public static Connection getCon(){
        Connection con = null;
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","caisse","123");
        } catch(ClassNotFoundException e1) {
            System.err.println("Chargement du driver échoué : " + e1.getMessage());
        } catch(SQLException e2) {
            System.err.println("Erreur lors de la connexion : " + e2.getMessage());
        }
        
        return con;
    }

    public static void main(String[] f){
        Connection con = Connexion.getCon();
        if (con != null) {
            System.out.println("Connexion établie avec succès.");
            // Vous pouvez ajouter d'autres opérations avec la connexion ici si besoin
            try {
               con.close(); // Fermeture de la connexion après utilisation
            } catch(SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        } else {
            System.err.println("La connexion n'a pas pu être établie.");
        }
    }
}
