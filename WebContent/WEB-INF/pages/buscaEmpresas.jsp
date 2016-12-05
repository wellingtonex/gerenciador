<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busca Empresas</title>
</head>
<body>

	<c:if test="${not empty usuarioLogado}">
		<p>Logado como ${usuarioLogado.email}</p>
	</c:if>
	<ul>
		<c:forEach var="empresa" items="${empresas}">
			<li>${empresa.id}: ${empresa.nome}</li>
		</c:forEach>	
	</ul>
</body>
</html>