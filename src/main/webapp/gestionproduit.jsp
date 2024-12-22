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
      width: 600px; /* Largeur fixe pour les boutons */
        height: 300px; /* Hauteur fixe pour les boutons */
        
  }
  #d{
     width: 300px; /* Largeur fixe pour les boutons */
     
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
        <h5>Ajouter un produit</h5>
     
  <form action="Controleurproduit?action=1" method="Post" enctype="multipart/form-data">
    
    Entrer le nom du categorie  : <input type="text" name="nom" value="pat"  required><br>
    Entrer la description du produit  : <input type="text" name="desc" value="jvkf" id="d" required><br>
    Entrer le prix  : <input type="text" name="prix"  value="20" ><br>
    Entrer la quantite  : <input type="text" name="quantite"  value="34" required><br>
    Entrer   l'image : <input type="file" name="image" value="pain.jpeg" id="d" required><br>
       
    
     
    <input type="submit" value="Ajouter produit">
  </form>
  
  
  
  <br>
  <form action="Controleurproduit?action=3" method="Post">
   
    <input type="submit" value="modifier produit" style="color : orange">
         
  </form>
  <br>
  <form action="Controleurproduit?action=5" method="Post">
   
    <input type="submit" value="supprimer un produit"  style="color : red" >
         
  </form>
  </div>
  <br>
   <div class="image-container">
   <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>
  

</body>
</html>
