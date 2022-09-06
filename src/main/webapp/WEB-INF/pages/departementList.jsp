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
		
		<div class="container">
			<c:if test="${NOTIFICATION != null}">
					<div class="alert alert-success">${NOTIFICATION}</div>
				</c:if>
			<div class="container text-right">
				<h5 style="float:left" class="text-left">Liste des departements</h5>
				<a href="<%=request.getContextPath()%>/departement/add-departement" class="btn btn-sm btn-info">Créer</a>
			</div>
			<hr>
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>libelle Departement</th>
						<th>Code departement</th>
						<th>Chef du departement</th>
						<th>Nom du college</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="departement" items="${listDepartements}">

						<tr>
							<td><c:out value="${departement.id}" /></td>
							<td><c:out value="${departement.libelleDepartement}" /></td>
							<td><c:out value="${departement.codeDepartement}" /></td>
							<td><c:out value="${departement.enseignant.nom}" /> <c:out value="${departement.enseignant.prenom}" /></td>
							<td><c:out value="${departement.college.nomCollege}" /></td>
							<td>
								<a href="<%=request.getContextPath()%>/departement/detail-departement?id=<c:out value='${departement.id}' />"
								 class="btn btn-sm btn-primary">Détails</a>
								 |
								<a href="departement/edit-departement?id=<c:out value='${departement.id}' />"
								 class="btn btn-sm btn-success">Modifier</a>
								 |
								<a href="departement/delete-departement?id=<c:out value='${departement.id}' />"
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
