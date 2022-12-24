<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajouter achat</title>
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
 
        <h1 class="heading-tertiary">Ajouter un achat</h1>
        <div class="produits">
          <h3>Ajouter un achat :</h3>
          <p>pour ajouter un achat vous devez remplir le formulaire</p>

          <form method="POST">
            <div class="control">
              <label>Désignation</label>
              <input name="designation" class="input" name="designation"/>
            </div>
            <div class="control">
              <label>Quantité</label>
              <input type="number" class="input" placeholder="0" name="quantite"/>
            </div>
            <div>
                 <div class="control">
              <label>Date</label>
              <input type="date" class="input" placeholder="0" name="date"/>
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