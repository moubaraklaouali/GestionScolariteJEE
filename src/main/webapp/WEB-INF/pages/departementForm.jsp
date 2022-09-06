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
				<c:if test="${departement != null}">
					<form action="update-departement" method="post">
					<caption>
						<h5> Modification departement </h5>
					</caption>
				</c:if>
				<c:if test="${departement == null}">
					<form action="insert-departement" method="post">
					<caption>
						<h5> Nouveau departement </h5>
					</caption>
				</c:if>
				<c:if test="${departement != null}">
					<input type="hidden" name="id" value="<c:out value='${departement.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Libelle departement</label> <input type="text"
						value="<c:out value='${departement.libelleDepartement}' />" class="form-control"
						name="libelleDepartement" required="required" placeholder="Entrez le libelle departement">
				</fieldset>

				<fieldset class="form-group">
					<label>Code departement</label> <input type="text"
						value="<c:out value='${departement.codeDepartement}' />" class="form-control"
						name="codeDepartement" required="required" placeholder="Entrez le code departement">
				</fieldset>
				<fieldset class="form-group">
					<label>Chef du departement</label> 
					<select   name="enseignantId" class="form-control">
						<option>
                           	Selectionner un chef
                          </option>
                       <c:forEach var="enseignant" items="${listEnseignant}" >
                       <c:choose>  
                            <c:when test="${(departement != null) && (enseignant.id == departement.enseignant.id) }">  
                                
                                <option value="<c:out value="${enseignant.id}" />" selected="selected">
                           			<c:out value="${enseignant.nom}" /> <c:out value="${enseignant.prenom}" />
                           		</option>
                            </c:when>  
                            <c:otherwise>  
								<option value="<c:out value="${enseignant.id}" />" >
									<c:out value="${enseignant.nom}" /> <c:out value="${enseignant.prenom}" />
                           		</option>
                            </c:otherwise>  
                        </c:choose>
                       	

                       </c:forEach>
                    </select>
                    </fieldset> 

				<fieldset class="form-group">
					<label>College</label> 
					<select   name="collegeId" class="form-control">
						<option>
                           	Selectionner un college
                          </option>
                       <c:forEach var="college" items="${listCollege}" >
                       <c:choose>  
                            <c:when test="${(departement != null) && (college.id == departement.college.id) }">  
                                
                                <option value="<c:out value="${college.id}" />" selected="selected">
                           			<c:out value="${college.nomCollege}" />
                           		</option>
                            </c:when>  
                            <c:otherwise>  
								<option value="<c:out value="${college.id}" />" >
                           			<c:out value="${college.nomCollege}" />
                           		</option>
                            </c:otherwise>  
                        </c:choose>
                       	

                       </c:forEach>
                    </select>
                    </fieldset> 
                    <br>
                    <fieldset class="form-group">
						<a href="<%=request.getContextPath()%>/departement" class="btn btn-sm btn-warning">Annuler</a>
						<button type="submit" class="btn btn-sm btn-success">Valider</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
