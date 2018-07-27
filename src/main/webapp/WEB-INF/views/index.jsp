<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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