<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
<title>Gestion des Sondages</title>
</head>
<body>
	<h1 align="center">NADIR...FABIEN...ET FAOUZI : BESTA TEAM powa!</h1>
	
<form>
	<div class="container">
	    <div class="col-md-5">
	        <div class="form-group">
	            <div class="input-group date" id="startDate">
	            	<label name="startDate" for="startDate">StartDate : </label>
	                <input name="startDate" type="date" class="form-control" />
	            </div>
	        </div>
	    </div>
	    <div class="col-md-5">
	        <div class="form-group">
	            <div class="input-group date" id="EndDate">
	            	<label  name="endDate" for="endDate">EndDate : </label>
	                <input name="endDate" type="date" class="form-control" />
	            </div>
	        </div>
	    </div>
	    <div class="col-md-5">
	        <div class="form-group">
	            <div class="input-group date" id="CloseDate">
	            	<label name="closeDate" for="closeDate">CloseDate : </label>
	                <input name="closeDate" type="date" class="form-control" />
	            </div>
	        </div>
	    </div>
		<button type="submit" class="btn btn-success">Valider</button>
	</div>
</form>

	
</body>
</html>