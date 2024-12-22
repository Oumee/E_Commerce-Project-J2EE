<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body>
<div id="marhaba"><h1>MARHABA مرحبا</h1></div>

<div id="logindiv">
      <h3>Gestion de stock</h3>  
      <h5>Ajouter une categorie</h5>
  <form action="Controleurgestion?action=1" method="Post" enctype="multipart/form-data">
    
    Entrer le nom du categorie  : <input type="text" name="nom"><br>
    Entrer   l'image : <input type="file" name="image"><br>
   
    <span  style="color : green" >
    <% if((String)request.getAttribute("creecat")!=null) { %>
    <%=request.getAttribute("creecat") %> 
    </span> 
    
    <% } %>  
    <input type="submit" value="ajouter categorie">
  </form>
  <br>
  <form action="Controleurgestion?action=2" method="Post">
   
    <input type="submit" value="modifier une catégorie" style="color : orange">
         
  </form>
  <form action="Controleurgestion?action=5" method="Post">
   
    <input type="submit" value="supprimer une categorie"  style="color : red" >
         
  </form>
  </div>
  
   <div class="image-container">
   <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>
 
 <div class="">
   <a  href="Controleurproduit">
   <img src="images/pproduit.jpeg" alt="gestion produit" class="image">
   
     <h3>gestion de produit</h3>
  </a>
  </div>

</body>
</html>
