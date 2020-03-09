<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<html class="no-js" lang="fr">
<head>
<title>Se connecter</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./connexion.css" media="all">
</head>

<div class="lines">
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
</div>


<div class="login-page">
  <div class="form">
    <form class="login-form" action="/bibliotheque/authentification" method="post">
      <input type="text" name="pseudo" placeholder="Pseudo"/>
      <input type="password" name="mdp" placeholder="Mot de passe"/>
      <button type="submit" name="connexion" value="test">Connexion</button>
    </form>
    
  </div>
  <!--<div class="btnRetour">
			<h2><p><a href="./index.php?controleur=utilisateur&action=accueil">Retour</a></p></h2>
	</div>-->
</div>

</html>