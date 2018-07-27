<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
>>>>>>> 48a34278ec04e0e6d8d41fdba5866d8f05cdf2a8

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />

<style type="text/css">
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
	margin-top: 25px;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	background-color: #4CAF50;
	color: white;
}
</style>

<title>Gestion des Sondages</title>
</head>
<body>
<<<<<<< HEAD
	<h1 align="center">NADIR...FABIEN...ET FAOUZI : BESTA TEAM powa!</h1>

	<form>
		<div class="container">
			<div class="col-md-5">
				<div class="form-group">
					<div class="input-group date" id="startDate">
						<label name="startDate" for="startDate">StartDate : </label> <input
							name="startDate" type="date" class="form-control" />
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<div class="input-group date" id="EndDate">
						<label name="endDate" for="endDate">EndDate : </label> <input
							name="endDate" type="date" class="form-control" />
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<div class="input-group date" id="CloseDate">
						<label name="closeDate" for="closeDate">CloseDate : </label> <input
							name="closeDate" type="date" class="form-control" />
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Valider</button>
		</div>
	</form>
	
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
							<c:url value="/DetailsSurvey.html?id=" var="DetailsSurvey" />
								<tr>
									<td><c:out value="${survey.startDate}" /></td>
									<td><c:out value="${survey.endDate}" /></td>
									<td><c:out value="${survey.closeDate}" /></td>
									<td><a href="${DetailsSurvey}${survey.id}" class="btn btn-info">see details</a></td>
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
>>>>>>> 48a34278ec04e0e6d8d41fdba5866d8f05cdf2a8
	
	<table id="customers">
		<tr>
			<th>ID</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Closed Date</th>
			<th>Close Survey</th>
		</tr>
		
	<c:url value="/detail.html" var="detail" />
	<c:url value="/edit.html" var="edit" />
	
		<c:forEach items="${surveyList}" var="survey">
			<tr>
				<td><c:out value="${survey.startDate}"></c:out></td>
				<td><c:out value="${survey.endDate}"></c:out></td>
				<td><c:out value="${survey.closeDate}"></c:out></td>
				<td><a href="${detail}?id=${survey.id}" class="detail">See Details</a></td>
				<td><a href="${edit}?id=${survey.id}" class="edit">Close Publication</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>