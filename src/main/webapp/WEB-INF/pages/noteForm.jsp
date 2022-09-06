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
<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${affectationNote != null}">
					<form action="update-note" method="post">
					<caption>
						<h5> Modification note </h5>
					</caption>
				</c:if>
				<c:if test="${affectationNote == null}">
					<form action="insert-note" method="post">
					<caption>
						<h5> Nouvelle note </h5>
					</caption>
				</c:if>
				<c:if test="${affectationNote != null}">
					<input type="hidden" name="id" value="<c:out value='${affectationNote.id}' />" />
				</c:if>
				<c:if test="${etudiantId != null}">
					<input type="hidden" name="etudiantId" value="<c:out value='${etudiantId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Matiere</label> 
					<select   name="matiereId" class="form-control">
						<option>
                           	Selectionner une matiere
                          </option>
                       <c:forEach var="matiere" items="${listMatieres}" >
                       <c:choose>  
                            <c:when test="${(affectationNote != null)  }">  
                                
                                <option value="<c:out value="${matiere.id}" />" selected="selected">
                           			<c:out value="${matiere.libelleMatiere}" />
                           		</option>
                            </c:when>  
                            <c:otherwise>  
                               <option value="<c:out value="${matiere.id}" />">
                           			<c:out value="${matiere.libelleMatiere}" />
                           		</option>
                            </c:otherwise>  
                        </c:choose>
                       	

                       </c:forEach>
                    </select>
                    </fieldset> 
                    <fieldset class="form-group">
					<label>Note</label> <input type="number"
						value="<c:out value='${affectationNote.note}' />" class="form-control"
						name="note" required="required" placeholder="Entrez la note">
				</fieldset>
                    <br>
                    <fieldset class="form-group">
						<a href="<%=request.getContextPath()%>/ligne/detail-note?etudiantId=<c:out value='${etudiantId}' />" class="btn btn-sm btn-warning">Annuler</a>
						<button type="submit" class="btn btn-sm btn-success">Valider</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
