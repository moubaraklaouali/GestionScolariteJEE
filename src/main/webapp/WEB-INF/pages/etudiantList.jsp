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
				<h5 style="float:left" class="text-left">Liste des etudiants</h5>
				<a href="<%=request.getContextPath()%>/etudiant/add-etudiant" class="btn btn-sm btn-info">Créer</a>
			</div>
			<hr>
			<br>
			<div class="table-responsive-md ">
				<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date Naissance</th>
						<th>Telephone</th>
						<th>Email</th>
						<th>Date Entree</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="etudiant" items="${listEtudiants}">

						<tr>
							<td><c:out value="${etudiant.id}" /></td>
							<td><c:out value="${etudiant.nom}" /></td>
							<td><c:out value="${etudiant.prenom}" /></td>
							<td><c:out value="${ConvertDate.dateToString(etudiant.dateNaissance)}" /></td>
							<td><c:out value="${etudiant.telephone}" /></td>
							<td><c:out value="${etudiant.email}" /></td>
							<td><c:out value="${ConvertDate.dateToString(etudiant.dateEntree)}" /></td>
							
							<td>
								<a href="<%=request.getContextPath()%>/note/detail-note?etudiantId=<c:out value='${etudiant.id}' />"
								 class="btn btn-sm btn-primary">Détails</a>
								 |
								<a href="etudiant/edit-etudiant?id=<c:out value='${etudiant.id}' />"
									class="btn btn-sm btn-success">Modifier</a>
									|
								<a href="etudiant/delete-etudiant?id=<c:out value='${etudiant.id}' />"
									onclick="return confirm('Confirmer la suppression!')" 
									class="btn btn-sm btn-danger">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			</div>
		</div>
	</div>
</body>
</html>
