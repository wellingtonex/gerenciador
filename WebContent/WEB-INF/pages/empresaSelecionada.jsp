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

	<c:if test="${not empty empresaSelecionada}">
		<p>A empresa selecionada foi ${empresaSelecionada.nome}</p>
	</c:if>
	
	<form action="executar">
		<select name="empresa">
			<c:forEach var="empresa" items="${empresas}">
				<option value="${empresa.id}" ${empresa.id eq empresaSelecionada.id ? 'selected' : '' }>${empresa.nome}</option>
			</c:forEach>
		</select>
		<input type="hidden" id="tarefa" name="tarefa" value="Combo">
	</form>
	
</body>
</html>