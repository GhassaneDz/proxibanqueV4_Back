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
<h2>Détails de la Survey sélectionnée:</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<td>Commentaire:</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="feedback" items="${feedbacks}">
								<tr>
									<td><c:out value="${feedback.findFeedBackNotNull}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col">
				<span>Nombre de réponse négatives: ${feedback.feedNegCount}</span>
			</div>
			<div class="col">
				<span>Nombre de réponse positives: ${feedback.feedPosCount}</span>
			</div>
		</div>
	</div>
	<c:url value="/index.html" var="index" />
	<a href="${index}" class="btn btn-info">Revenir à l'accueil</a>
</body>
</html>