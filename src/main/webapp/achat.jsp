<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="BO.Produit, java.util.ArrayList " %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="javax.swing.JOptionPane" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        table {
       
	    display: flex;
	    align-items: center;
	    margin: auto;
            background-color: #fff;
                     padding: 0 0 20px 0;
         
        
        }
        .re {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
             max-width: 600px;
            
          display: flex;
          align-items: center;
         margin: auto;
 
            
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
    .product{
     flex-wrap: wrap; /* Permettre le retour à la ligne des éléments */
        justify-content: center; /* Centrer horizontalement les éléments */
        align-items: center; /* Centrer verticalement les éléments */
    width: 70px; /* Largeur fixe pour les boutons */
        height: 70px; /* Hauteur fixe pour les boutons */
        
    }
    .panier{
        width: 90px; /* Largeur fixe pour les boutons */
        height: 70px; /* Hauteur fixe pour les boutons */
    position: absolute;
  top: 0; /* Positionner l'élément en haut */
  right: 5; /* Positionner l'élément le plus à droite */
    
    
    }
  
    
    </style>
</style>
</head>

<body>
<div id="marhaba"><h1>MARHABA مرحبا</h1></div>
<div class="re">
<%
    // Récupérer la liste de catégories à partir de la requête
    ArrayList<Produit> produits = (ArrayList<Produit>) session.getAttribute("p");
%>


    <table border="1" >
        <tr>
            <th colspan="4">
                <h2> Produits </h2>
            </th>
        </tr>

        <% for (Produit elem: produits) { %>
        <tr>
        <% if(elem.getQuantite()>0) { %>
        
           
        <form action="ControleurPanier" method="Post">
         <th>       
                <img src="<%= elem.getImage() %>" alt="image du produit" class="product" >
</th>
<th>
        <input type="hidden" name="produitSelectionne" value="<%=elem.getId_produit()%>">
                  
        <div class="item">
        <span>Produit:</span><%= elem.getDescription() %>
        </div>
        <div class="item">
            <span> Prix: </span>  <%= elem.getPrix() %>
        </div>
        <div class="item">
            <span>Quantité:</span> <%= elem.getQuantite() %>
        </div>
            </th>
            <th>
            
        <input type="number" id="quantite" name="quantite" value="1" placeholder="1" min="1" max="<%= elem.getQuantite() %>">
      
           </th>  
           <th>      
    
        <input type="submit" value="ajouter au panier">     
            </th>
            </form>
        </tr>
           <%  }  %>
        
        
        <% } %>
    </table>
    <br>
  
</div>
  <div class="panier">
  <form action="ControleurPanier" method="Get">
    <button type="submit" class="panier-button">
      <img src="images/panier.png" alt="Description de l'image" class="image">
      Voir mon panier
    </button>
        <span>
        <% if(session.getAttribute("paniervide")!=null) {%>
    	<%=session.getAttribute("paniervide")  %>
    	</span>
    	<%} %>
  </form>
</div>
    </div>
<body>
  <div class="image-container">
  <a  href="Controleur">
    <img src="images/ac.jpeg" alt="allez à l'accueil" class="image">
  </a>
  </div>
</body>

<br>

</body>
</html>
