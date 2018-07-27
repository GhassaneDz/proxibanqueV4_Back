<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Gestion des Sondages</title>
</head>
<body>

	<h1 align="center">NADIR...FABIEN...ET FAOUZI : BESTA TEAM powa!</h1>
	<div class="container">
		<h2>Editer le sondage</h2>
		<div class="container-fluid">
			<form:form modelAttribute="modelSurvey" method="post">
				<div class="container">
					<div class="col-md-4">
						<div class="form-group">
							<div class="input-group date" id="startDate">
								<label for="startDate">StartDate : </label> <input
									name="startDate" type="date" class="form-control"
									id="startDate" value="${survey.startDate}" required="required"
									disabled />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<div class="input-group date" id="EndDate">
								<label for="id">EndDate : </label> <input name="endDate"
									type="date" class="form-control" id="endDate"
									value="${survey.endDate}" required="required" disabled />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<div class="input-group date" id="CloseDate">
								<label for="closeDate">CloseDate : </label> <input
									name="closeDate" type="date" class="form-control"
									id="closeDate" required="required" />
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>