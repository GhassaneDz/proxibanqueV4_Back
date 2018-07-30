<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
<title>Gestion des Sondages</title>
</head>
<body>
<h1 align="center">Gestion des Sondages</h1>
<div class="container">
	<h2>Ajouter un sondage</h2>
	<div class="container-fluid">
		<form method="post" class="needs-validation">
			    <div class="col-md-4">
			        <div class="form-group">
		            	<label for="startDate">StartDate : </label>
		                <input name="startDate" type="date" class="form-control" id="startDate" required="required" >
		                <div class="invalid-feedback">Merci de remplir ce champ pour validation</div>
			        </div>
			    </div>
			    <div class="col-md-4">
			        <div class="form-group">
		            	<label for="endDate">EndDate : </label>
		                <input name="endDate" type="date" class="form-control" id="endDate" required="required" >
		                <div class="invalid-feedback">Merci de remplir ce champ pour validation</div>
			        </div>
			    </div>
			    <c:if test="${not empty isActualSurveyExist}">
					<button type="submit" class="btn btn-success" disabled="disabled">Valider</button><hr>
					<div class="alert alert-warning col-md-8">
					  Vous ne pouvez plus créer un nouveau sondage car il existe un sondage en cours. Cloturez le sondage actuel pour pouvoir en créer un nouveau.
					</div>
				</c:if>
				<c:if test="${not empty endDateExc }">
					<div class="alert alert-warning col-md-8">
						<strong>Attention! </strong>${endDateExc}
					</div>
				</c:if>	
				<c:if test="${empty isActualSurveyExist }">
					<button type="submit" class="btn btn-success">Valider</button>
				</c:if>		    
		</form>
	</div>
	<br><hr>
	<h2>Sondage en cours</h2>	
	<table id="customers">
		<tr>
			<th>ID</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Close Date</th>
			<th>See Details</th>
			<th>Close Publication</th>
		</tr>
		
	<c:url value="/DetailsSurvey.html" var="detail" />
	<c:url value="/EditSurvey.html" var="edit" />
	
		<c:forEach items="${surveyList}" var="survey">
			<tr>
				<td><c:out value="${survey.id}"></c:out></td>
				<td><c:out value="${survey.startDate}"></c:out></td>
				<td><c:out value="${survey.endDate}"></c:out></td>
				<td><c:out value="${survey.closeDate}"></c:out></td>
				<td><a href="${detail}?id=${survey.id}" class="detail">See Details</a></td>
				<c:if test="${survey.closeDate==null}">
					<td><a href="${edit}?id=${survey.id}" class="edit">Close Publication</a></td>
				</c:if>
				<c:if test="${survey.closeDate!=null}">
					<td></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</div>
<br>
<hr>
</body>
</html>