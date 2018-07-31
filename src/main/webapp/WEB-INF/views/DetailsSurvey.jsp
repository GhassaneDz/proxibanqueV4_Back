<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>

<style>
ul > li {
	list-style-type: none;
}
</style>

<title>Gestion des Sondages</title>
</head>
<body>
<h1 align="center">Gestion des Sondages</h1>
<div class="container">
	<h2>Détails de la Survey sélectionnée:</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">
					<table id="customers">
						<thead>
							<tr>
								<th>Commentaire:</th>
								<th>Avis positifs</th>
								<th>Avis négatifs</th>
								<th>nombre de nouveaux clients</th>
							</tr>
						</thead>
						<tbody>
							<td>
							<c:forEach var="feedback" items="${feedBackText}">
								<ul>
								<c:choose>
								    <c:when test="${empty feedback.feedBackText}">
								        <h2></h2>
								    </c:when>
							         <c:otherwise>
							            <li><c:out value="${feedback.feedBackText}" /></li>
							         </c:otherwise>
								</c:choose>
								</ul>
							</c:forEach>
							</td>
							<td>${feedPosCount}</td>
							<td>${feedNegCount}</td>
							<td>${feedNewClient}</td>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<c:url value="/index.html" var="index" />
	<a href="${index}" class="btn btn-info">Retour</a>
</div>
</body>
</html>