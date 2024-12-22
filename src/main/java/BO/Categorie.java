package BO;


public class Categorie{
	
	private int id_categorie;
	private String nom_categorie;
	private String image;
	
	public Categorie(int id_categorie, String nom_categorie, String image) {
		super();
		this.id_categorie = id_categorie;
		this.nom_categorie = nom_categorie;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public String getNom_categorie() {
		return nom_categorie;
	}
	
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	 
	public Categorie(String nom_categorie, String image) {
		super();
		this.nom_categorie = nom_categorie;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Categorie [id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + ", image=" + image
				+ "]";
	}
	
	
	
	
}