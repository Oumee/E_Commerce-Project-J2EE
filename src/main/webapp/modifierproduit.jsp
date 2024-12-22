<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="BO.Categorie, BO.Produit, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion de stock</title>
    <style>
  #logindiv {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: lightcyan;
    padding: 20px;
    border-radius: 10px;
  }
  #comptediv {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: green;
    padding: 20px;
    border-radius: 10px;
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
    <script>
        // Vos scripts JavaScript ici
    </script>
</head>
<body>
<div id="marhaba"><h1>MARHABA مرحبا</h1></div>

    <div id="logindiv">
        <h3>Gestion de stock</h3>
              <h5>Modifier un produit</h5>
        
        <form action="Controleurproduit?action=7" method="Post">
            Sélectionner le nom du categorie :
            <select id="categorieSelect" name="categorieSelect">
      <% ArrayList<Categorie> cat = (ArrayList<Categorie>) session.getAttribute("cat"); %>
                <option value="">Sélectionner une catégorie</option>
           
                <% for (Categorie categorie : cat) { %>
                    <option value="<%= categorie.getId_categorie() %>"><%= categorie.getNom_categorie() %></option>
                <% } %>
            </select>
            <input type="submit" value="Sélectionner">
        </form>

        <%ArrayList<Produit> produits = (ArrayList<Produit>) session.getAttribute("produits"); 
        if  (produits!=null) { %>
            <form action="Controleurproduit?action=8" method="Post">
                Sélectionner le nom du produit :
                <select name="produitSelect">
                       <option value="">Sélectionner un produit </option>
                   
                    <% for (Produit produit : produits) { %>
                        <option value="<%= produit.getId_produit() %>"><%= produit.getDescription() %></option>
                    <% } %>
                </select>
                <input type="submit" value="Sélectionner">
                
                </form>
                <%} %>
                <%Produit p = (Produit) session.getAttribute("produitmodifier"); 
    if  (p!=null) { %>
         
                <form action="Controleurproduit?action=2" method="Post" enctype="multipart/form-data">
                
                <!-- Autres champs pour modifier le produit -->
     La description :            <input type="text" name="desc" id="d" value="<%=p.getDescription() %>" required><br>
     Le prix :            <input type="text" name="prix" value="<%=p.getPrix() %>" required><br>
     La quantite           <input type="text" name="quantite" value="<%=p.getQuantite() %>" required><br>
     Selectionne une image :            <input type="file" name="image" id="d" value="<%=p.getImage() %>" required><br>
                <input type="submit" value="Modifier produit">
               </form>
        
        	<%} %>
    </div>
  <div class="image-container">
   <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>
 </body>
</html>
