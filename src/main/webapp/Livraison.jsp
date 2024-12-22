<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
.creecompte{

}
</style>
</head>
<body>
<div id="marhaba"><h1>MARHABA مرحبا</h1></div>
<div id="marhaba"><h3 style="black"> Entrer les informations de Livraison</h3></div>

<div id="logindiv">
  <form action="controleur_user?action=3" method="Post">
    Entrer votre nom : <input type="text" name="nom" required> <br>
    Entrer votre adresse de livraison : <input type="text" name="adresse" required> <br>
    Entrer votre numero de téléphone : <input type="text" name="phone" required> <br>
    Entrer la date ou vous etes disponible :  <input type="date" name="date" required> <br>
     <span>
     <% if((String)request.getAttribute("erreur")!=null) {%>
     <%=(String)request.getAttribute("erreur") %>
     </span> 
    
    <% } %>  <input type="submit" value="se connecter ">
  </form>
  <br>
   
  </div>
  
  <div class="image-container">
  <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>
 

</body>
</html>
	