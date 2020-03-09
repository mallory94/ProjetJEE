<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<html class="no-js" lang="fr">
<head>
<title>Reserver un Document</title>
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
      <h2 class="titre">Biblia.Net - Reserver Document</h2>
    <form class="ajoutDocument-form" action="/bibliotheque/emprunt" method="post">
      <input type="text" name="numDoc" placeholder="Cote du document"/>
      <button type="submit" name="ajout" value="test">Reserver le document</button>
    </form>
    
  </div>
  <!--<div class="btnRetour">
			<h2><p><a href="./index.php?controleur=utilisateur&action=accueil">Retour</a></p></h2>
	</div>-->
</div>

</html>