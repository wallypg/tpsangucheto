<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver Stock</title>

<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Header -->
		<header>
			<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
				<div class="container">
					<!-- Cabecera del Menu -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacionProyectoFinal">
							<span class="sr-only">Desplegar / Ocultar Menu</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a href="../" class="navbar-brand">SANGUCHETTO</a>
					</div>

					<!-- Cuerpo del Menu -->
					<div class="collapse navbar-collapse" id="navegacionProyectoFinal">
						<!-- Botones -->
						<ul class="nav navbar-nav">
							<li><a href="altaProducto.do">Crear producto</a></li>
							<li><a href="verStock.do">Stock</a></li>
							<li><a href="agregarCarrito.do">Carrito</a></li>
						</ul>	
					</div>
				</div>
			</nav>
		</header>	
		
		<!-- Contenido -->
		<section class="main container">
			<div class="row">

    <h1>LISTA DE INGREDIENTES</h1>
	<table border="1">
		<tr>
			<td>INGREDIENTE</td>
			<td>PRECIO</td>
			<td>TIPO</td>
			<td>STOCK</td>
			<td>AGREGAR STOCK</td>
			<td>ELIMINAR STOCK</td>
		</tr>
		<c:forEach items="${mapaIngredientes}" var="ingrediente">
			<tr>
				<td>${ingrediente.key.nombre}</td>
				<td>${ingrediente.key.precio}</td>
				<td>${ingrediente.key.tipo}</td>
				<td>${ingrediente.value}</td>
				<td>
					<form action="/SpringMVC/sucursal/agregarStock.do" method="POST">
						<input type="hidden" name="nombre" value="${ingrediente.key.nombre}">
						<input type="hidden" name="precio" value="${ingrediente.key.precio}">
						<input type="hidden" name="tipo" value="${ingrediente.key.tipo}">
						<input type="submit" value="Agregar">
					</form>
				</td>
				<td>
					<form action="/SpringMVC/sucursal/eliminarStock.do" method="POST">
						<input type="hidden" name="nombre" value="${ingrediente.key.nombre}">
						<input type="hidden" name="precio" value="${ingrediente.key.precio}">
						<input type="hidden" name="tipo" value="${ingrediente.key.tipo}">
						<input type="submit" value="Eliminar">
					</form>
				</td>
				
				<!-- 
				<td><a href="/agregarStock.do?clave=${ingrediente.key.nombre}">Agregar</a></td>
				<td><a href="/eliminarStock.do?clave=${ingrediente.key.nombre}">Eliminar</a></td>
				 -->
			</tr>
		</c:forEach>
	</table>	

			</div>
		</section>
		
		<!-- Footer -->
		<footer class="jumbotron" id="jumbotronFooter">
			<div class="container">
				<div class="row">
					<div class="col-xs-12" id="links">
                        <ul class="list-inline text-center">
                            <li>Materia: Taller Web 1</li>
                            <li>TP Final: Sanguchetto</li>
                            <li>Alumnos: Pérez Graciano, Walther - Coronel, Pablo</li>
                            <li>Universidad: UNLaM</li>
                            <li>Año: 2015</li>
                        </ul>
                    </div>
				</div>
			</div>
		</footer>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>