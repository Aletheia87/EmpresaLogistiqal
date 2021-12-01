<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="cl.desafiolatam.empresaLogistiqal.model.Producto"%>
<%@page import="cl.desafiolatam.empresaLogistiqal.vo.ProductoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<title>Empresa Logistiqal</title>
</head>
<body>
	<section>
		<div class="container">
			<h1 class="mt-3">Empresa Logistiqal</h1>
			<h3 class="mt-3">AGREGAR PRODUCTO</h3>
			<h4>${mensaje}</h4>
			<form action="agregar" method="post">
				<table>
					<tr>
						<td>Código:</td>
						<td><input type="number" name="codigo" id="codigo" /></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="nombre" id="nombre" /></td>
					</tr>
					<tr>
						<td>Precio:</td>
						<td><input type="number" name="precio" id="precio" /></td>
					</tr>
					<tr>
						<td>Stock:</td>
						<td><input type="number" name="stock" id="stock" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Agregar" /></td>
					</tr>
				</table>


			</form>
		</div>
	</section>
</body>
</html>