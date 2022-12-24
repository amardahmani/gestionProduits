<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste de Produits</title>
<link rel="stylesheet" type="text/css" href="css/app.css" />
</head>
<body>
	<div class="container">
      <div class="sidebar">
        <div class="logo">
          <h1 class="heading-primary">E-commerce</h1>
        </div>
        <ul>
          <li><a href="">Menu</a></li>
          <li><a href="/gestionProduits99999/produits">Listes des produits</a></li>
          <li><a href="/gestionProduits99999/AjouterProduit">nouveau produit</a></li>
          <li><a href="/gestionProduits99999/NouvelAchat">Nouvel achat</a></li>
          <li><a href="/gestionProduits99999/achats">Liste des achats</a></li>
        </ul>
      </div>
      <main>
        <header>
          <div class="search">
            <input
              type="search"
              name=""
              id=""
              class="input"
              placeholder="Rechercher un produit"
            />
            <button class="btn">
              <svg
                fill="#607afe"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 64 64"
                width="60px"
                height="60px"
              >
                <path
                  d="M 38.515625 11.074219 C 38.2064 11.065845 37.894464 11.066438 37.580078 11.076172 C 33.807446 11.192982 29.683988 12.65195 25.851562 16.484375 C 21.606068 20.729869 20.587188 25.572931 20.990234 29.748047 C 21.350033 33.475167 22.759954 36.529098 23.917969 38.621094 C 21.013404 40.23647 16.840379 43.151103 13.494141 46.439453 C 11.68051 48.22171 10.149822 50.052706 9.3027344 51.857422 C 8.8791906 52.75978 8.6187935 53.669133 8.6523438 54.583984 C 8.6858937 55.498835 9.057765 56.409163 9.7539062 57.105469 C 10.505209 57.856949 11.573402 58.120541 12.560547 57.980469 C 13.547691 57.840397 14.507902 57.382897 15.488281 56.753906 C 17.44904 55.495925 19.504191 53.49728 21.427734 51.378906 C 24.730643 47.741455 27.205154 44.285535 27.955078 43.224609 C 28.434814 43.621556 28.873435 44.0411 30.191406 44.84375 C 32.032124 45.964755 34.452002 47.130209 36.958984 47.078125 A 1.0002103 1.0002103 0 0 0 36.917969 45.078125 C 35.092951 45.116045 32.910251 44.159714 31.230469 43.136719 C 29.550686 42.113724 28.396484 41.087891 28.396484 41.087891 A 1.0001 1.0001 0 0 0 26.910156 41.265625 C 26.910156 41.265625 23.675179 45.929653 19.947266 50.035156 C 18.083309 52.087908 16.085398 53.995514 14.410156 55.070312 C 13.572536 55.607712 12.818574 55.923756 12.28125 56 C 11.743926 56.07624 11.477166 56.000676 11.167969 55.691406 C 10.80361 55.326962 10.669766 54.984844 10.652344 54.509766 C 10.634924 54.034687 10.780091 53.416892 11.113281 52.707031 C 11.779662 51.287309 13.174787 49.555228 14.894531 47.865234 C 18.334019 44.485247 23.077407 41.202095 25.660156 39.875 A 1.0001 1.0001 0 0 0 26.0625 38.474609 C 24.95124 36.598488 23.340172 33.282775 22.980469 29.556641 C 22.620765 25.830506 23.435119 21.728943 27.265625 17.898438 C 31.949725 13.214336 36.725698 12.548034 40.835938 13.333984 C 44.946176 14.119935 48.380422 16.505421 49.773438 17.898438 C 51.321281 19.446281 53.478579 22.776479 53.994141 26.556641 C 54.509702 30.336802 53.54681 34.572093 48.759766 38.537109 C 44.517635 42.050621 40.637092 42.229352 37.390625 41.236328 C 34.144158 40.243305 31.553204 37.928379 30.472656 36.494141 C 29.34082 34.991562 28.049664 32.386693 27.773438 29.556641 C 27.497211 26.726588 28.151775 23.693928 30.921875 20.923828 C 32.865908 18.979795 34.945288 18.294394 36.900391 18.169922 C 38.855494 18.045449 40.680072 18.520008 41.910156 18.976562 C 42.345672 19.138198 42.54705 19.62487 42.357422 20.066406 A 1.0001 1.0001 0 0 0 42.347656 20.087891 C 42.081977 20.747652 41.388908 21.10689 40.728516 20.923828 C 38.799326 20.388249 35.584737 20.14093 33.009766 22.607422 C 31.75435 23.809771 31.85373 25.891085 33.224609 26.962891 A 1.0001 1.0001 0 0 0 33.226562 26.964844 L 33.353516 27.064453 L 33.353516 27.0625 C 34.406012 27.883662 35.864808 27.825966 36.894531 27.0625 C 37.655441 26.497685 38.834756 25.918781 41.193359 27.353516 A 1.0001 1.0001 0 1 0 42.232422 25.646484 C 39.337025 23.885219 36.952215 24.529846 35.703125 25.457031 C 35.332848 25.731565 34.905488 25.737164 34.583984 25.486328 A 1.0001 1.0001 0 0 0 34.582031 25.486328 L 34.455078 25.386719 C 34.022182 25.046164 33.99271 24.4357 34.392578 24.052734 C 36.327607 22.199226 38.628549 22.415189 40.193359 22.849609 A 1.0001 1.0001 0 0 0 40.193359 22.851562 C 41.845157 23.309445 43.559452 22.407311 44.195312 20.84375 C 44.811538 19.388077 44.105312 17.658206 42.605469 17.101562 C 41.200553 16.580118 39.122084 16.024301 36.773438 16.173828 C 34.42479 16.323356 31.799779 17.217799 29.507812 19.509766 C 26.319914 22.697666 25.46143 26.455255 25.783203 29.751953 C 26.104977 33.048651 27.524836 35.904844 28.875 37.697266 C 30.235452 39.503027 33.035608 41.99496 36.806641 43.148438 C 40.577674 44.301913 45.340287 43.966613 50.035156 40.078125 C 55.276112 35.737142 56.569001 30.630948 55.976562 26.287109 C 55.384158 21.943226 53.069656 18.366531 51.1875 16.484375 C 49.466515 14.76339 45.836151 12.25319 41.212891 11.369141 C 40.346029 11.203381 39.443301 11.099341 38.515625 11.074219 z"
                />
              </svg>
            </button>
          </div>
        </header>
   ²
        <h1 class="heading-tertiary">Liste des produits</h1>
        <div id="produits">
          <h3>Produits :</h3>
          <p>Fair un Recherche pour filter les produits</p>
          <button id="ajouterP" class="ajouter">Ajouter Produit</button>
          <table id="produits">
            <tr>
              <th>Désignation</th>
              <th>Quantité</th>
              <th></th>
     
            </tr>
            <tbody>
            <c:forEach var="tempProduit" items="${produits}">
					<c:url var="supprimer" value="produits">
						<c:param name="command" value="DELETE" /> 
						<c:param name="numero_produit" value="${tempProduit.numero}" />
					</c:url>
					<c:url var="modifier" value="produits">
						<c:param name="command" value="LOAD" /> 
						<c:param name="numero_produit" value="${tempProduit.numero}" />
					</c:url>
					
					
					<tr>
					<input type="hidden" name="numero" value="${tempProduit.numero}" />
					<td>${tempProduit.designation}</td>
					<td>${tempProduit.quantite}</td>
					<td>
						 <a href="${supprimer}" class="delete">Supprimer</a>
						 <a href="${modifier}" class="update">Modifier</a>
					</td>
					
					</tr>
					
					
				</c:forEach>
			</tbody>
          </table>
          
          <script type="text/javascript">
          	function deleteRow(r){
          		let text = "confirmez vous la suppression?";
          		
          		if(confirm(text) == true){
          			var i = r.parentNode.parentNode.rowIndex;
          			var num = document.getElementsByName("numero");
          			var xhttp;
          			xhttp = new XMLHttpRequest();
          			
          			xhttp.onreadystatechange = function () {
                        if (this.readyState === 4 && this.status === 200) {
                            document.getElementById("result").innerHTML = this.responseText;
                        }
                    };
                    
                    xhttp.open("GET", 'produits?num=' + encodeURIComponent(num), true);
          			
                    xhttp.send(null);

                    document.getElementById("produits").deleteRow(num);
				
          		}
          		
          	}
          </script>
          
        </div>
      </main>
    </div>
    </div>
</body>
</html>