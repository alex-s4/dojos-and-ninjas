<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/create/dojo" method='post' modelAttribute="dojo">
	<div class="main-form">
	    <table>
	        <tr>
	            <td><form:label path="name">Name:</form:label></td>
	            <td><form:input path="name"/></td>
	        </tr>
    	</table>
    	<input type="submit" value="Submit">
    </div>
    </form:form>
</body>
</html>