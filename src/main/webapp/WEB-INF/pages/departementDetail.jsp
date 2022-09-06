<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="college.ing2.utils.ConvertDate" %>
<html>
<head>
<title>Gestion College</title>
<style><%@include file="/WEB-INF/css/bootstrap.min.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/pages/menu.jsp"%>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
				
				
			<div class="container text-right">
				<h5 style="float:left" class="text-left">Détail departement</h5>
				<a href="<%=request.getContextPath()%>/departement" class="btn btn-sm btn-warning">Retour</a>
			</div>
			<hr>
			<table>
				<tr>
					<th>Id departement :</th>
					<th><c:out value='${departement.id}' /></th>
				</tr>
				<tr>
					<th>Nom departement :</th>
					<th><c:out value='${departement.libelleDepartement}' /></th>
				</tr>
				<tr>
					<th>Code departement :</th>
					<th><c:out value='${departement.codeDepartement}' /></th>
				</tr>
				<tr>
					<th>Chef du departement :</th>
					<th><c:out value='${departement.enseignant.nom}' /> <c:out value='${departement.enseignant.prenom}' /></th>
				</tr>
				<tr>
					<th>Moyenne generale du departement :</th>
					<th><c:out value='${moyen}' /></th>
				</tr>
			
		</div>
	</div>
		
</body>
</html>
