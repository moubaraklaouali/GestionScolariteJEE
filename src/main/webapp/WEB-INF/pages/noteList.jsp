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
				<c:if test="${NOTIFICATION != null}">
					<div class="alert alert-success">${NOTIFICATION}</div>
				</c:if>
				
			<div class="container text-right">
				<h5 style="float:left" class="text-left">Détail etudiant</h5>
				<a href="<%=request.getContextPath()%>/etudiant" class="btn btn-sm btn-warning">Retour</a>
				<a href="<%=request.getContextPath()%>/note/add-note?etudiantId=<c:out value='${etudiant.id}' />" class="btn btn-sm btn-info">Ajouter une note</a>
			</div>
			<hr>
			<table>
				<tr>
					<th>Matricule :</th>
					<th><c:out value='${etudiant.id}' /></th>
				</tr>
				<tr>
					<th>Nom :</th>
					<th><c:out value='${etudiant.nom}' /></th>
				</tr>
				<tr>
					<th>Prenom :</th>
					<th><c:out value='${etudiant.prenom}' /></th>
				</tr>
				<tr>
					<th>Moyenne generale :</th>
					<th><c:out value='${moyen}' /></th>
				</tr>
			</table>
			<table class="table table-bordered">
				<c:if test="${listMatiere != null}">
					<h5>Matiere non composee</h5>
					<thead>
						<th>Libelle matiere</th>
					</thead>
					<tbody>
					<c:forEach var="matiere" items="${listMatiere}">

						<tr>
							<td><c:out value="${matiere.libelleMatiere}" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</c:if>
			</table>
			
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Matiere</th>
						<th>note</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="affec" items="${listNote}">

						<tr>
							<td><c:out value="${affec.id}" /></td>
							<td><c:out value="${affec.matiere.libelleMatiere}" /></td>
							<td><c:out value="${affec.note}" /></td>
							<td>
								<a href="note/edit-note?id=<c:out value='${affec.id}' />&etudiantId=<c:out value='${etudiant.id}' />"
								 class="btn btn-sm btn-primary">Modifier</a>
								 |
								<a href="note/delete-note?id=<c:out value='${affec.id}' />&etudiantId=<c:out value='${etudiant.id}' />"
								 onclick="return confirm('Confirmer la suppression!')" 
								 class="btn btn-sm btn-danger">Supprimer</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
		
</body>
</html>
