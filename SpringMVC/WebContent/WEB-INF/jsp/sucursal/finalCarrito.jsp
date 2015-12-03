<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Carrito Final</title>

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
				<h1>Carrito Final</h1>
				<h3>Precio Final: ${precioFinal}</h3>
				
				
				<table border="1">
					<tr>
						<td colspan="4" align="center">Ingredientes</td>
					</tr>
					<tr>
						<td>Tipo</td>
						<td>Nombre</td>
						<td>Precio c/u</td>
						<td>Unidades</td>
					</tr>
					
					<c:forEach items="${mapaProductosIngrediente}" var="cadaIngrediente">
						<tr>
							<td>${cadaIngrediente.key.tipo}</td>
							<td>${cadaIngrediente.key.nombre}</td>
							<td>${cadaIngrediente.key.precio}</td>
							<td>${cadaIngrediente.value}</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="4" align="center">Condimentos</td>
					</tr>
					<tr>
						<td>Tipo</td>
						<td>Nombre</td>
						<td>Precio c/u</td>
						<td>Unidades</td>
					</tr>
					
					<c:forEach items="${mapaProductosCondimento}" var="cadaCondimento">
						<tr>
							<td>${cadaCondimento.key.tipo}</td>
							<td>${cadaCondimento.key.nombre}</td>
							<td>${cadaCondimento.key.precio}</td>
							<td>${cadaCondimento.value}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
		
		<!-- Footer -->
		<footer style="position:absolute;bottom:0px;width:100%;margin-bottom:0px;" class="jumbotron" id="jumbotronFooter">
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