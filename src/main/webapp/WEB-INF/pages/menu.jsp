<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
		<nav class="navbar navbar-expand-md bg-dark navbar-dark"
			>
			<div>
				<a href="<%=request.getContextPath()%>/" class="navbar-brand"> Gestion Ecole </a>
			</div>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
				<li class="nav-item"><a href="<%=request.getContextPath()%>/college" class="nav-link">College</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/departement" class="nav-link">Departement</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/enseignant" class="nav-link">Enseignant</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/matiere" class="nav-link">Matiere</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/salle" class="nav-link">Salle</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/etudiant" class="nav-link">Etudiant</a></li>
			</ul>
			</div>
		</nav>
	</header>