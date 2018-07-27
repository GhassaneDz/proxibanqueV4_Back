<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>D�tails de la Survey s�lectionn�e:</h2>
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
							<c:forEach var="feedbacks" items="${feedbacks}">
								<tr>
									<td><c:out value="${feedbacks.feedBackText}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col">
				<span>Nombre de r�ponse n�gatives: ${feedbacks.feedBack}</span>
			</div>
			<div class="col">
				<span>Nombre de r�ponse positives: ${feedbacks.feedBack}</span>
			</div>
		</div>
	</div>
	<c:url value="/index.html" var="index" />
	<a href="${index}" class="btn btn-info">Revenir � l'accueil</a>
</body>
</html>