package BO;

public class Vente {
	private static int id_vente;
 private String dateVente;
 private double total;
public String getDateVente() {
	return dateVente;
}

public static int getId_vente() {
	id_vente++;
	return id_vente;
}

public static void setId_vente(int id_vente) {
	Vente.id_vente = id_vente;
}

public void setDateVente(String dateVente) {
	this.dateVente = dateVente;
}
public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public Vente(String dateVente, double total) {
    this.dateVente = dateVente;
	this.total = total;
}
 

}
