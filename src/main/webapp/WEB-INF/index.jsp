<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>
<h1>${dojo.getName()} Location Ninjas</h1>

<table>
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age</th>
</tr>
<c:forEach var="oneNinja" items="${ninjas}">
<tr>
    <th>${oneNinja.getFirstName()}</th>
    <th>${oneNinja.getLastName()}</th>
    <th>${oneNinja.getAge()}</th>
</tr>
</c:forEach>
</table>


</body>
</html>