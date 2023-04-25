<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
<h1>New Ninja</h1>
    <form:form action="/create/ninja" method='post' modelAttribute="ninja">
        <div class="main-form">
            <table>
                <tr>
                    <td><form:label path="dojo">Dojo</form:label></td>
                    <td>
                        <form:select path="dojo">
                        	<c:forEach var="oneDojo" items="${dojos}">
                        		<form:option value="${oneDojo.getId()}">${oneDojo.getName()}</form:option>
                        	</c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="firstName">First Name:</form:label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name:</form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="age">Age:</form:label></td>
                    <td><form:input type="number" path="age"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create"></td>
                </tr>
            </table>
            
        </div>
    </form:form>
</body>
</html>