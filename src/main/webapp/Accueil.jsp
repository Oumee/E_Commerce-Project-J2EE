<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="BO.Categorie, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    /* Style pour la classe 'categorie-image' */
    .categorie-image {
        display: flex; /* Utiliser flexbox pour le conteneur */
        flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
        justify-content: center; /* Centrer horizontalement les éléments */
        align-items: center; /* Centrer verticalement les éléments */
        background-color: #fff;
        border-radius: 50px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
        margin: 0 auto;
        max-width: 600px;
        width: 300px; /* Largeur de l'image */
        height: 300px; /* Hauteur de l'image */
        margin: 10px; /* Marge autour de l'image */
     }
    
    /* Style pour le conteneur de l'image */
    .categorie-container {
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
    
    /* Style pour les boutons */
    input[type="submit"] {
        width: 300px; /* Largeur fixe pour les boutons */
        height: 30px; /* Hauteur fixe pour les boutons */
        margin-top: 10px; /* Marge en haut des boutons */
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
        justify-content: center; /* Centrer horizontalement les éléments */
        background-color: orange;
        border-radius: 50px;
        
    }
    
    #marhaba{
         color : orange;
          display: flex; /* Utiliser flexbox pour le conteneur */
        flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
        justify-content: center; /* Centrer horizontalement les éléments */
        align-items: center; /* Centrer verticalement les éléments */
    }
</style>
</head>
<body>
<%
    // Récupérer la liste de catégories à partir de la requête
    ArrayList<Categorie> categories = (ArrayList<Categorie>) session.getAttribute("cat");
%>
<div id="marhaba"><h1>MARHABA مرحبا</h1></div>
<div class="categorie-container">
<%
    Iterator<Categorie> it = categories.iterator();
    while (it.hasNext()) {
    Categorie cat = it.next();
%>


 
    <div  class="mm">
        <form action="Controleur" method="POST">
            
            <input  type="hidden"  name="id_cat" value="<%= cat.getId_categorie() %>">
            <Button type="submit" value="<%= cat.getNom_categorie() %>"  >
            <img src=<%= cat.getImage() %> alt="<%= cat.getNom_categorie() %>" class="categorie-image">
            <%= cat.getNom_categorie() %>
            </Button>
        </form>
    </div>
                  <% } %>
                  
                  
    <!-- Remplacez 'chemin/vers/image' par le chemin vers votre image -->
    
     
   
</div>
<a href="logingestion.jsp" >GESTION DE STOCK</a>
</body>
</html>
