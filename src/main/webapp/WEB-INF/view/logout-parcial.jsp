<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=Logout" var="linkServletLogout"/>
   
<!DOCTYPE html>
<html>
	<head>
		<title>Logout</title>
	</head>
	<body>
		<a href="${linkServletLogout}">sair</a>
		<br><br>
	</body>
</html>