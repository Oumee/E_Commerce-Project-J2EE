package BO;

import java.util.Objects;

public class Produit {

	private  int id_produit;
	private  String description;
	private  double prix ;
	private int quantite;
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Produit(String description, double prix, int quantite, String image) {
		super();
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
	}

	public Produit(int id_produit, String description, double prix, int quantite, String image) {
		super();
		this.id_produit = id_produit;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	 
	 
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", description=" + description + ", prix=" + prix + ", quantite="
				+ quantite + ", image=" + image + "]";
	}
	   @Override
	   public boolean equals(Object obj) {
	       if (this == obj) {
	           return true;
	       }
	       
	       if (obj == null || getClass() != obj.getClass()) {
	           return false;
	       }
	       
	       Produit other = (Produit) obj;
	       return Objects.equals(this.id_produit, other.id_produit);
	   }
}
