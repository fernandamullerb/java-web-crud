<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletLogin"/>

<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form action="${linkServletLogin}" method="post">
			Login: <input type="text" name="login"/>
			Senha: <input type="password" name="senha"/>
			<input type="submit">
			<input type="hidden" name="acao" value="Login">
		</form>
	</body>
</html>