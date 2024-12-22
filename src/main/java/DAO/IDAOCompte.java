package DAO;

import java.util.Collection;

import BO.Compte;

public interface IDAOCompte {

 
        public   boolean create(Compte C);
       public   boolean update(Compte C);
       public   boolean delete(int id);
       public   boolean CompteExiste(String s1,String s2); 
}
