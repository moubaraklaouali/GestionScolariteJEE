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
				<h5 style="float:left" class="text-left">Liste des enseignants</h5>
				<a href="<%=request.getContextPath()%>/enseignant/add-enseignant" class="btn btn-sm btn-info">Créer</a>
			</div>
			<hr>
			
			<br>
			<div class="table-responsive-md  ">
				<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date Naissance</th>
						<th>Telephone</th>
						<th>Email</th>
                        <th>indice</th>
						<th>Date de prise fonction</th>
                        <th>Specialite</th>
                        <th>Departement</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="enseignant" items="${listEnseignants}">

						<tr>
							<td><c:out value="${enseignant.id}" /></td>
							<td><c:out value="${enseignant.nom}" /></td>
							<td><c:out value="${enseignant.prenom}" /></td>
							<td><c:out value="${ConvertDate.dateToString(enseignant.dateNaissance)}" /></td>
							<td><c:out value="${enseignant.telephone}" /></td>
							<td><c:out value="${enseignant.email}" /></td>
							<td><c:out value="${enseignant.indice}" /></td>
							<td><c:out value="${ConvertDate.dateToString(enseignant.datePriseFonction)}" /></td>
                            <td><c:out value="${enseignant.matiere.libelleMatiere}" /></td>
                            <td><c:out value="${enseignant.departement.libelleDepartement}" /></td>
							
							<td>
								<a href="enseignant/edit-enseignant?id=<c:out value='${enseignant.id}' />"
								 class="btn btn-sm btn-success">Modifier</a>
								 |
								<a href="enseignant/delete-enseignant?id=<c:out value='${enseignant.id}' />"
								 onclick="return confirm('Confirmer la suppression!')" 
								 class="btn btn-sm btn-danger">Supprimer</a></td>
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
