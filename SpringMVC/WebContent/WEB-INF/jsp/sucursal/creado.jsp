<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lista de pajaros</title>
</head>
<body>
	<div>
		<table>
		<tr>
			<th>Nombre</th>
			<th>Tipo</th>
			<th>Activo</th>
		</tr>
		
		<c:forEach items="${listaPajaros}" var="cadaPajaro" varStatus="loop">
			<tr>
				<td>${cadaPajaro.nombre}</td>
				<td>${cadaPajaro.tipo}</td>
				<td>${cadaPajaro.activo}</td>
				<td><a href="borrar.do?miPajaro=${loop.index}">Borrar</a></td>
				<td><a href="tomarpajaro.do?nombre=${cadaPajaro.nombre}&tipo=${cadaPajaro.tipo}&activo=${cadaPajaro.activo}&indice=${loop.index}">Editar</a></td> 
			</tr>

		</c:forEach>
			
		
		</table>
		<a href="nuevo.do">Nuevo pajaro</a>
	</div>
</body>
</html>