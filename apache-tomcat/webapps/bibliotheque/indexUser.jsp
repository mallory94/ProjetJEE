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
	
	<form class="ajoutDocument-form" action="./afficherDocumentsDispos" method="post">
		<button type="submit" name="serviceRendre" value="test">afficher les livres disponibles</button>
	</form>
	
    <form class="ajoutDocument-form" action="./emprunterDocument.jsp" method="post">
      <button type="submit" name="serviceEmprunt" value="test">Emprunter un Livre</button>
    </form>


    <form class="ajoutDocument-form" action="./rendreDocument.jsp" method="post">
      <button type="submit" name="serviceRendre" value="test">Rendre un Livre</button>
    </form>

  </div>
  

  <div class="btnRetour">
			<h2><p><a href="./deconnexion">Déconnexion</a></p></h2>
	</div>
</div>

</html>