<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
<title>Gestion des Sondages</title>
</head>
<body>
<h1 align="center">Gestion des Sondages</h1>
<div class="container">
	<h2>Fermer le sondage en cours</h2>
	<div class="container-fluid">
		<form method="post">
			<div class="container">
			    <div class="col-md-4">
			        <div class="form-group">
		            	<label for="startDate">StartDate : </label>
		                <input name="startDate" type="date" class="form-control" id="startDate" value="${survey.startDate}" required="required" disabled />
			        </div>
			    </div>
			    <div class="col-md-4">
			        <div class="form-group">
		            	<label for="id">EndDate : </label>
		                <input name="endDate" type="date" class="form-control" id="endDate" value="${survey.endDate}" required="required" disabled/>
			        </div>
			    </div>
			    <div class="col-md-4">
			        <div class="form-group">
		            	<label for="closeDate">CloseDate : </label>
		                <input name="closeDate" type="date" class="form-control" id="closeDate" required="required"/>
		                
		                <input name="startDate"  class="form-control" id="startDate" value="${survey.startDate}" type="hidden"/>
		                <input name="endDate"  class="form-control" id="endDate" value="${survey.endDate}" type="hidden"/>
			        </div>
			    </div>
			    <c:if test="${not empty CloseDateExc}">
					<button type="submit" class="btn btn-success">Valider</button><hr>
					<div class="alert alert-warning col-md-8">${CloseDateExc}</div>
				</c:if>
				<c:if test="${empty CloseDateExc}">
					<button type="submit" class="btn btn-success" >Valider</button>
				</c:if>
			</div>
		</form>
	</div>
	<hr>
<c:url value="/index.html" var="index" />
	<a href="${index}" class="btn btn-info">Retour</a>
</div>
</body>
</html>