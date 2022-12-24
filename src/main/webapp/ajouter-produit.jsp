<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Produit</title>
<link rel="stylesheet" type="text/css" href="css/app.css" />
<script src="js/app.js"></script>
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
        <h1 class="heading-tertiary">Liste des produits</h1>
        <div class="produits">
          <h3>Ajouter Produit :</h3>
          <p>pour ajouter un produit vous devez remplir le formulaire</p>

          <form method="POST">
            <div class="control">
              <label>Désignation</label>
              <input type="text" class="input" placeholder="nom de produit" name="designation"/>
            </div>
            <div class="control">
              <label>Quantité</label>
              <input type="number" class="input" placeholder="0" name="quantite"/>
            </div>
            <div>
              <button class="ajouter">Ajouter</button>
            </div>
          </form>
        </div>
      </main>
    </div>
</body>
</html>