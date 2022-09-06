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
				<c:if test="${matiere != null}">
					<form action="update-matiere" method="post">
					<caption>
						<h5> Modification matiere </h5>
					</caption>
				</c:if>
				<c:if test="${matiere == null}">
					<form action="insert-matiere" method="post">
					<caption>
						<h5> Nouvelle matiere </h5>
					</caption>
				</c:if>
				<c:if test="${matiere != null}">
					<input type="hidden" name="id" value="<c:out value='${matiere.id}' />"  />
				</c:if>

				<fieldset class="form-group">
					<label>Libelle Matiere</label> <input type="text"
						value="<c:out value='${matiere.libelleMatiere}'/>" class="form-control"
						name="libelleMatiere" required="required" placeholder="Entrez le libelle matiere">
				</fieldset>

				<fieldset class="form-group">
					<label>Code Matiere</label> <input type="text"
						value="<c:out value='${matiere.codeMatiere}' />" class="form-control"
						name="codeMatiere" required="required" placeholder="Entrez le code matiere">
				</fieldset>

				<fieldset class="form-group">
					<label>Salle de cours</label> 
					<select   name="salleId" class="form-control">
						<option>
                           	Selectionner une salle
                          </option>
                       <c:forEach var="salle" items="${listSalle}" >
                       <c:choose>  
                            <c:when test="${(matiere != null) && (salle.id == matiere.salle.id) }">  
                                
                                <option value="<c:out value="${salle.id}" />" selected="selected">
                           			<c:out value="${salle.libelleSalle}" />
                           		</option>
                            </c:when>  
                            <c:otherwise>  
								<option value="<c:out value="${salle.id}" />" >
                           			<c:out value="${salle.libelleSalle}" />
                           		</option>
                            </c:otherwise>  
                        </c:choose>
                       	

                       </c:forEach>
                    </select>
                    </fieldset> 
                    <br>
                    <fieldset class="form-group">
						<a href="<%=request.getContextPath()%>/matiere" class="btn btn-sm btn-warning">Annuler</a>
						<button type="submit" class="btn btn-sm btn-success">Valider</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
