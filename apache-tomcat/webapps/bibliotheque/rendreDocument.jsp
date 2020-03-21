<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<html class="no-js" lang="fr">
<head>
<title>Rendre un Document</title>
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
      <h2 class="titre">Biblia.Net - Rendre un Document</h2>
    <form class="ajoutDocument-form" action="./rendre" method="post">
      <input type="text" name="numLivreARendre" placeholder="Cote du Document"/>
      <button type="submit" name="ajout" value="test">Rendre le Document</button>
    </form>
    
  </div>
  <div class="btnRetour">
			<h2><p><a href="./indexUser.jsp">Retour</a></p></h2>
	</div>
</div>

</html>