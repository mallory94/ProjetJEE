<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="java.util.List"%>
<%@ page import ="mediatek2020.items.Document"%>
<html class="no-js" lang="fr">
<head>
<title>Accueil</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./theme.css" media="all">
<link rel="stylesheet" type="text/css" href="./designTableau.css" media="all">

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
    <h1 class="titre">Biblia.Net</h1>
	<h2 id="sous-titre_Liste" >Liste des documents disponibles</h2>
<table class="rwd-table">
  <tr>
    <th>Côte</th>
    <th>Titre</th>
    <th>Auteur(s)</th>
    <th>Type</th>
  </tr>
  <% ArrayList<Document> listeDocDispo = 
		(ArrayList<Document>) request.getSession(false).getAttribute("listeDocumentDisponible");
	for (Document doc :  listeDocDispo) { 
		Object[] datas = doc.data();%>
		<tr>      
            <td data-th="Côte"><%=(int)datas[0]%></td>
			<td data-th="Titre"><%=(String)datas[1]%></td>
			<td data-th="Auteur(s)"><%=(String)datas[2]%></td>
			<td data-th="Type"><%=(String)datas[4]%></td>
        </tr>
	<%}
  %>
</table>

  </div>
  

  <div class="btnRetour">
			<h2><p><a href="./indexUser.jsp">Retour</a></p></h2>
	</div>
	<div class="espaceVide"></div>
</div>

</html>