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
				<c:if test="${salle != null}">
					<form action="update-salle" method="post">
					<caption>
						<h5> Modification salle </h5>
					</caption>
				</c:if>
				<c:if test="${salle == null}">
					<form action="insert-salle" method="post">
					<caption>
						<h5> Nouvelle salle </h5>
					</caption>
				</c:if>

				

				<c:if test="${salle != null}">
					<input type="hidden" name="id" value="<c:out value='${salle.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Libelle Salle</label> <input type="text"
						value="<c:out value='${salle.libelleSalle}' />" class="form-control"
						name="libelleSalle" required="required" placeholder="Entrez le libelle salle">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre de place</label> <input type="text"
						value="<c:out value='${salle.nbPlace}' />" class="form-control"
						name="nbPlace" required="required" placeholder="Entrez le nombre de place">
				</fieldset>
				<a href="<%=request.getContextPath()%>/salle" class="btn btn-sm btn-warning">Annuler</a>

				<button type="submit" class="btn btn-sm btn-success">Valider</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>