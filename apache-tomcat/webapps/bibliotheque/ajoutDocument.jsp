<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<html class="no-js" lang="fr">
<head>
<title>Ajouter un Document</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./theme.css" media="all">
</head>

<div class="lines">
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
</div>


<div class="ajoutDocument-page">

  <div class="form">
      <h2 class="titre">Biblia.Net - Ajout de document</h2>
    <form class="ajoutDocument-form" action="/bibliotheque/ajout" method="post">
      <input type="text" name="nomDoc" placeholder="Nom du document" required="required"/>
      <input type="text" name="autDoc" placeholder="Auteur du document" required="required"/>
	  <select name="typeDoc" id="typeDoc" required="required">
		<option value="">--- choisissez un type</option>
		<option value="hide">Type de document</option>
		<option value="Livre">Livre</option>
		<option value="DVD">DVD</option>
		<option value="CD">CD</option>
	  </select> 
      <button type="submit" name="ajout" value="test">Ajout du document</button>
    </form>
    
  </div>
  <div class="btnRetour">
			<h2><p><a href="./indexBibliothecaire.jsp">Retour</a></p></h2>
	</div>
</div>

</html>