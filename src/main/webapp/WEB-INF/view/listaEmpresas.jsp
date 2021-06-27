<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import = "java.util.List, br.com.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=RemoveEmpresa&id=" var="linkServletRemoveEmpresa"/>
<c:url value="/entrada?acao=MostraEmpresa&id=" var="linkServletMostraEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<title>Lista de Empresas Cadastradas</title>
	</head>
	<body>
		<c:if test="${not empty empresa}">
			Empresa ${empresa} cadastrada com sucesso.
		</c:if>
		Lista de empresas: <br/>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li> ${empresa.nome} <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
					<a href="${linkServletRemoveEmpresa}${empresa.id}">excluir</a>
					<a href="${linkServletMostraEmpresa}${empresa.id}">editar</a>
				</li>
			</c:forEach>
		</ul>	
	</body>
</html>