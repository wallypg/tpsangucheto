<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ejemplo de Spring MVC</title>
</head>
<body>
   <form action="/SpringMVC/sucursal/crear.do" method="get">
   	<table>
   		<tr>
   			<td>Nombre</td>
   			<td><input type="text" name="nombre"></td>
   		</tr>
   		<tr>
   			<td>Tipo</td>
   			<td>
   				<select name="tipo">
   					<option value="Gorrión">Gorrión</option>
   					<option value="Hornero">Hornero</option>
   					<option value="Canario">Canario</option>
   					<option value="Águila">Águila</option>
   					<option value="Halcón">Halcón</option>
   					<option value="Gaviota">Gaviota</option>
   				</select>
   			</td>
   		</tr>
   		<tr>
   			<td>Activo</td>
   			<td><input type="checkbox" name="activo"></td>
   		</tr>
   		<tr>
   			<td><input type="reset" value="Cancelar"></td>
   			<td><input type="submit" value="Enviar"></td>
   		</tr>
   	
   	</table>
   	</form>
</body>
</html>