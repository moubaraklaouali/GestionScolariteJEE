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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${etudiant != null}">
					<form action="update-etudiant" method="post">
					<caption>
						<h5> Modification etudiant </h5>
					</caption>
				</c:if>
				<c:if test="${etudiant == null}">
					<form action="insert-etudiant" method="post">
					<caption>
						<h5> Nouveau etudiant </h5>
					</caption>
				</c:if>

				

				<c:if test="${etudiant != null}">
					<input type="hidden" name="id" value="<c:out value='${etudiant.id}' />"  />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${etudiant.nom}' />" class="form-control"
						name="nom" required="required" placeholder="Entrez le nom">
				</fieldset>

				<fieldset class="form-group">
					<label>Prenom</label> <input type="text"
						value="<c:out value='${etudiant.prenom}' />" class="form-control"
						name="prenom" required="required" placeholder="Entrez prenom">
				</fieldset>

				<fieldset class="form-group">
					<label>Date Naissance</label> <input type="date"
						value="<c:out value='${etudiant.dateNaissance}' />"class="form-control datepicker"
						name="dateNaissance" required="required" placeholder="Entrez la date de naissance">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Telephone</label> <input type="text"
						value="<c:out value='${etudiant.telephone}' />" class="form-control"
						name="telephone">
				</fieldset>
				<fieldset class="form-group">
					<label>email</label> <input type="text"
						value="<c:out value='${etudiant.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Date Inscription</label> <input type="date"
						value="<c:out value='${etudiant.dateEntree}' />"class="form-control datepicker"
						name="dateEntree" required="required">
				</fieldset>
				<a href="<%=request.getContextPath()%>/etudiant" class="btn btn-sm btn-warning">Annuler</a>

				<button type="submit" class="btn btn-sm btn-success">Valider</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>