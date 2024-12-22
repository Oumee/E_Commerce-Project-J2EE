<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="BO.Panier,BO.Produit, java.util.ArrayList " %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="javax.swing.JOptionPane" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
    display: flex; /* Utiliser flexbox pour le conteneur */
    flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
    justify-content: center; /* Centrer horizontalement les éléments */
    align-items: center; /* Centrer verticalement les éléments */
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    margin: 0 auto;
    max-width: 600px;
}

.container form {
    margin-bottom: 20px;
}

.container th {
    padding: 10px;
}

span {
    color: red;
}
#marhaba{
         color : orange;
          display: flex; /* Utiliser flexbox pour le conteneur */
        flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
        justify-content: center; /* Centrer horizontalement les éléments */
        align-items: center; /* Centrer verticalement les éléments */
    }
   
  .image {
    flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
        justify-content: center; /* Centrer horizontalement les éléments */
        align-items: center; /* Centrer verticalement les éléments */
        width: 70px; /* Largeur fixe pour les boutons */
        height: 70px; /* Hauteur fixe pour les boutons */
        
    }
    
    .image-container {
  position: absolute;
  top: 0; /* Positionner l'élément en haut */
  right: 0; /* Positionner l'élément le plus à droite */
}   
</style>
</head>
<body>
  <div id="marhaba"><h1>MARHABA مرحبا</h1></div>

<%
	    Panier panier = (Panier) session.getAttribute("panier");
%>

<div class="container">
    <table border="2">
        <tr>
            <th colspan="3">
                <h2> Produits </h2>
            </th>
        </tr>

        <% for (Produit elem: panier.getPanier_produit()) { %>
        <tr>
            <th>
                <form action="PanierSupprimerProduit" method="Post">

                    <input type="hidden" name="produitRetire" value="<%=elem.getId_produit()%>">

                    Le produit : <%=elem.getDescription()%><br>
                    Le prix : <%=elem.getPrix()/elem.getQuantite()%><br>
                    Le prix de sous total : <%=elem.getPrix()%>

            </th>
            <th>
                <input type="number" id="quantite" name="quantite" placeholder="<%=elem.getQuantite() %>" readonly>
            </th>
            <th>
                <input type="submit" value="supprimer produit du panier">
            </form>
            </th>
        </tr>
        <% } %>
    </table>

    <form action="PanierSupprimerProduit" method="Get">
        <input type="submit" value="acheter">
        <span>
       <% 
    Object pasachatObj = request.getAttribute("pasachat");
    if (pasachatObj != null && pasachatObj instanceof Boolean && ((Boolean) pasachatObj)) { 
%>
    <%= pasachatObj %>
<% } %>

    </form>
</div>
 <div class="image-container">
  <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>

</body>
</html>
