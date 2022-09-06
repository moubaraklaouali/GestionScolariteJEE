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
				<c:if test="${enseignant != null}">
					<form action="update-enseignant" method="post">
					<caption>
						<h5> Modification enseignant </h5>
					</caption>
				</c:if>
				<c:if test="${enseignant == null}">
					<form action="insert-enseignant" method="post">
					<caption>
						<h5> Nouveau enseignant </h5>
					</caption>
				</c:if>
				<c:if test="${enseignant != null}">
					<input type="hidden" name="id" value="<c:out value='${enseignant.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${enseignant.nom}' />" class="form-control"
						name="nom" required="required" placeholder="Entrez le nom">
				</fieldset>

				<fieldset class="form-group">
					<label>Prenom</label> <input type="text"
						value="<c:out value='${enseignant.prenom}' />" class="form-control"
						name="prenom" required="required" placeholder="Entrez le prenom">
				</fieldset>

				<fieldset class="form-group">
					<label>Date Naissance</label> <input type="date"
						value="<c:out value='${enseignant.dateNaissance}' />"class="form-control datepicker"
						name="dateNaissance" required="required" placeholder="Entrez la date de naissance">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Telephone</label> <input type="text"
						value="<c:out value='${enseignant.telephone}' />" class="form-control"
						name="telephone" placeholder="Entrez le numero telephone">
				</fieldset>
				<fieldset class="form-group">
					<label>email</label> <input type="text"
						value="<c:out value='${enseignant.email}' />" class="form-control"
						name="email" placeholder="Entrez le code matiere">
				</fieldset>
				<fieldset class="form-group">
					<label>Date de prise fonction</label> <input type="date"
						value="<c:out value='${enseignant.datePriseFonction}' />"class="form-control datepicker"
						name="datePriseFonction" required="required" placeholder="Entrez la date de prise de fonction">
				</fieldset>

                <fieldset class="form-group">
					<label>Indice</label> <input type="text"
						value="<c:out value='${enseignant.indice}' />"class="form-control "
						name="indice" required="required" placeholder="Entrez l'indice">
				</fieldset>

				<fieldset class="form-group">
					<label>Matiere de cours</label> 
					<select   name="matiereId" class="form-control">
						<option>
                           	Selectionner une matiere
                          </option>
                       <c:forEach var="matiere" items="${listMatiere}" >
                       <c:choose>  
                            <c:when test="${(enseignant != null) && (matiere.id == enseignant.matiere.id) }">  
                                
                                <option value="<c:out value="${matiere.id}" />" selected="selected">
                           			<c:out value="${matiere.libelleMatiere}" />
                           		</option>
                            </c:when>  
                            <c:otherwise>  
								<option value="<c:out value="${matiere.id}" />" >
                           			<c:out value="${matiere.libelleMatiere}" />
                           		</option>
                            </c:otherwise>  
                        </c:choose>
                       </c:forEach>
                    </select>
                    </fieldset>
                     
                    <fieldset class="form-group">
					<label>Departement </label> 
					<select   name="departementId" class="form-control">
						<option>
                           	Selectionner un departement
                          </option>
                       <c:forEach var="departement" items="${listDepartement}" >
                       <c:choose>  
                            <c:when test="${(enseignant != null) && (departement.id == enseignant.departement.id) }">  
                                
                                <option value="<c:out value="${departement.id}" />" selected="selected">
                           			<c:out value="${departement.libelleDepartement}" />
                           		</option>
                            </c:when>  
                            <c:otherwise>  
								<option value="<c:out value="${departement.id}" />" >
                           			<c:out value="${departement.libelleDepartement}" />
                           		</option>
                            </c:otherwise>  
                        </c:choose>
                       	

                       </c:forEach>
                    </select>
                    </fieldset> 
                
                    <br>
                    <fieldset class="form-group">
						<a href="<%=request.getContextPath()%>/enseignant" class="btn btn-sm btn-warning">Annuler</a>
						<button type="submit" class="btn btn-sm btn-success">Valider</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
