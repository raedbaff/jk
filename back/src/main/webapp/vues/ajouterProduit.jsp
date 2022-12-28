<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<%@include file="navbar.html" %>
<br>
<br>
<c:if test="${message!= null}">
<div class="alert alert-success" role="alert">
<c:out value="${message }"></c:out>
      ${produit=null }
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header"><h2>Ajouter Produit</h2></div>
<div class="card-body">
<form action="/produit/saveproduit" method=post enctype="multipart/form-data">
 
 <div class="mb-3 mt-3">
 <label for="nom" class="form-label">Nom:</label>
 <input type=text class="form-control" id="nom" name="nom" value="${produit.nom}">
 </div>
 <div class="mb-3">
 <label for="prix" class="form-label">Prix:</label>
 <input type="number" class="form-control" id="prix" name="prix" value="${produit.prix}">
 </div>
 <div class="mb-3">
 <label for="quantite" class="form-label">Quantite:</label>
 <input type="number" class="form-control" id="quantite" name="quantite" value="${produit.quantite}">
 </div>
 <div class="mb-3">
 <input type=hidden name=photo value="${produit.photo }">
 <label class="form-Label">Photos</label>
 <input type="file" name="file" accept="image/png,image/jpeg" class="form-control"/>
 </div>
 <div class="mb-3">
 <label for="Categorie" class="form-label">Categorie:</label>
 <select name="categorie" >
 <option selected hidden>Choose here</option>
 <c:forEach items="${categorie}" var="cc">
 <option value=${cc.id} <c:if test="${produit.categorie.id==cc.id}">selected="true"</c:if>>${cc.nom} </option>
 </c:forEach>
 </select>
 </div>
 <input type=hidden name=idp value="${produit.id}">
 
 <button type="submit" class="btn btn-primary" >Save</button>
</form></div> </div></div></body>
</html>