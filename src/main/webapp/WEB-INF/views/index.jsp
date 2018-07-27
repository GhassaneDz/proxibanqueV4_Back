<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
<title>Gestion des Sondages</title>
</head>
<body>
	
	<h1 align="center">NADIR...FABIEN...ET FAOUZI : BESTA TEAM powa!</h1>
<div =class="container">
	<h2>Ajouter un sondage</h2>
	<div class="container-fluid">
		<form:form modelAttribute="modelSurvey" method="post">
			<div class="container">
			    <div class="col-md-4">
			        <div class="form-group">
			            <div class="input-group date" id="startDate">
			            	<label for="startDate">StartDate : </label>
			                <input name="startDate" type="date" class="form-control" id="startDate" required="required" />
			            </div>
			        </div>
			    </div>
			    <div class="col-md-4">
			        <div class="form-group">
			            <div class="input-group date" id="EndDate">
			            	<label for="endDate">EndDate : </label>
			                <input name="endDate" type="date" class="form-control" id="endDate" required="required" />
			            </div>
			        </div>
			    </div>
				<button type="submit" class="btn btn-success">Valider</button>
			</div>
		</form:form>
	</div>
	<h2>Sondage en cours</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6" align="center">
				<div class="panel-body">
					<table class="table" align="center">
						<thead>
							<tr>
								<td>StartDate</td>
								<td>EndDate</td>
								<td>CloseDate</td>
								<td>Details</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="survey" items="${surveys}">
							<c:url value="/EditSurvey.html?id=" var="EditSurvey" />
							<c:url value="/DetailSurvey.html?id=" var="DetailSurvey" />
								<tr>
									<td><c:out value="${survey.startDate}" /></td>
									<td><c:out value="${survey.endDate}" /></td>
									<td><c:out value="${survey.closeDate}" /></td>
									<td><a href="${DetailSurvey}${survey.id}" class="btn btn-info">see details</a></td>
									<td><a href="${EditSurvey}${survey.id}" class="btn btn-danger">Close the publication</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
	
</body>
</html>