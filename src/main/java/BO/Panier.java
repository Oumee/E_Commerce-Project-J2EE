package BO;

import java.util.ArrayList;
import java.util.Objects;

public class Panier {

private 	ArrayList<Produit> panier_produit;

	public ArrayList<Produit> getPanier_produit() {
	return panier_produit;
}

public void setPanier_produit(ArrayList<Produit> panier_produit) {
	this.panier_produit = panier_produit;
}

	public Panier() {
		panier_produit= new ArrayList<>();
	}
	
	
	   public void add(Produit p)
	   {
		this.panier_produit.add(p);   
	   }
	   
	   public void remove(Produit p)
	   {
		this.panier_produit.remove(p);   
	   }

	   @Override
	   public String toString() {
	       StringBuilder sb = new StringBuilder();
	       sb.append("Panier [");
	       for (Produit produit : panier_produit) {
	           sb.append(produit.toString());
	           sb.append(", ");
	       }
	       sb.delete(sb.length() - 2, sb.length()); // Supprimer la virgule finale
	       sb.append("]");
	       return sb.toString();
	   }
 

}
