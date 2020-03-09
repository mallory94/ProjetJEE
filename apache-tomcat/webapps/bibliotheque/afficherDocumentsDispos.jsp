<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<html class="no-js" lang="fr">
<head>
<title>Accueil</title>
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
      <h2 class="titre">Biblia.Net</h2>
	
	<% List<Document> documents = session.getAttribute( "listeDocument" );
		for (Document doc : documents) { %> 
			if doc.
	<%} %> 

  </div>
  

  <div class="btnRetour">
			<h2><p><a href="./index.php?controleur=utilisateur&action=accueil">Déconnexion</a></p></h2>
	</div>
</div>

</html>