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
				<h5 style="float:left" class="text-left">Détail matiere</h5>
				<a href="<%=request.getContextPath()%>/matiere" class="btn btn-sm btn-warning">Retour</a>
			</div>
			<hr>
			<table>
				<tr>
					<th>Id matiere :</th>
					<th><c:out value='${matiere.id}' /></th>
				</tr>
				<tr>
					<th>Nom matiere :</th>
					<th><c:out value='${matiere.libelleMatiere}' /></th>
				</tr>
				<tr>
					<th>Code matiere :</th>
					<th><c:out value='${matiere.codeMatiere}' /></th>
				</tr>
				<tr>
					<th>Salle de cours :</th>
					<th><c:out value='${matiere.salle.libelleSalle}' /> </th>
				</tr>
				<c:choose>  
					<c:when test="${(moyen != 0) }">  
						
						<tr>
							<th>Moyenne generale de la matiere :</th>
							<th><c:out value='${moyen}' /></th>
						</tr>
					</c:when>  
					<c:otherwise>  
						<tr>
							<th>Moyenne generale de la matiere :</th>
							<th>Matiere non composee</th>
						</tr>
					</c:otherwise>  
				</c:choose>
			
		</div>
	</div>
		
</body>
</html>
