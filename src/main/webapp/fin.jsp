<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
 %>
     <%@ page import="BO.Panier,BO.Produit,controleur.ControleurPanier" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reçu d'Achat</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .receipt {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 0 auto;
            max-width: 600px;
        }
        .item {
            margin-bottom: 10px;
        }
        .item:last-child {
            margin-bottom: 0;
        }
        .item span {
            font-weight: bold;
        }
        .total {
            margin-top: 20px;
            text-align: right;
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

<%! double total=0; %>
<%       Panier panier1 = (Panier) session.getAttribute("panier");

   
%>
    <div class="receipt">
        <h2>Reçu d'Achat</h2>
        <% for (Produit elem: panier1.getPanier_produit()) { %>
        
        <div class="item">
            <span>Produit:</span><%= elem.getDescription() %>
        </div>
        <div class="item">
            <span> Prix: </span>  <%= elem.getPrix()/elem.getQuantite() %>
        </div>
        <div class="item">
            <span>Quantité:</span> <%= elem.getQuantite() %>
        </div>
       
           <div class="item">
            <span>Le prix de sous total :</span> <%=elem.getPrix()%>
        </div>            
       
        
       
           <% total=total+elem.getPrix();  } %>
            <div class="item">
            <span>Total:</span> <%=total %>
        </div>
        
    </div>
    <% total=0; %>
 
   <div class="image-container">
  <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>
   <% // Supprime tous les éléments du tableau contenu dans l'objet panier
   ControleurPanier.panier.getPanier_produit().clear();

   session.removeAttribute("panier"); 
   %>
 
</body>
</html>
