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
				<c:if test="${college != null}">
					<form action="update-college" method="post">
					<caption>
						<h5> Modification college </h5>
					</caption>
				</c:if>
				<c:if test="${college == null}">
					<form action="insert-college" method="post">
					<caption>
						<h5> Nouvelle college </h5>
					</caption>
				</c:if>

				

				<c:if test="${college != null}">
					<input type="hidden" name="id" value="<c:out value='${college.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom college</label> <input type="text"
						value="<c:out value='${college.nomCollege}' />" class="form-control"
						name="nomCollege" required="required" placeholder="Entrez le nom du college">
				</fieldset>

				<fieldset class="form-group">
					<label>Adresse Site Web</label> <input type="text"
						value="<c:out value='${college.siteWeb}' />" class="form-control"
						name="siteWeb" required="required" placeholder="Entrez le Site web">
				</fieldset>
				<a href="<%=request.getContextPath()%>/college" class="btn btn-sm btn-warning">Annuler</a>

				<button type="submit" class="btn btn-sm btn-success">Valider</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>