<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="cl.desafiolatam.empresaLogistiqal.model.Producto"%>
<%@page import="cl.desafiolatam.empresaLogistiqal.vo.ProductoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link 
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	rel="stylesheet" id="fontawesome">

<title>Empresa Logistiqal</title>
</head>
<body>
	<section>
		<div class="container">
			<h1 class="mt-3">Empresa Logistiqal</h1>
			<h3 class="mt-3">${mensaje}</h3>
			<div class="container-fluid d-flex justify-content-between mx-2">
				<div>
					<h2 class="mt-3">Listado de Productos</h2>
				</div>
				<div class="btn-toolbar" role="toolbar"
					aria-label="Toolbar with button groups">
					<div class="btn-group" role="group" aria-label="second group">
						<div class="col-md-12 text-start">
							<a class="btn btn-primary  mt-3" href="agregarForm" role="button">Agregar
								Producto</a>
						</div>
					</div>
				</div>
			</div>
			<div>
				<ul class="pagination pagination-lg justify-content-center">
					<c:forEach items="${paginas}" var="pagina">
						<li class="page-item ${paginaActual == pagina ? 'disabled' : ''}"><a
							class="page-link" href="home?p=${pagina}" tabindex="-1">${pagina}</a></li>
					</c:forEach>
				</ul>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Stock</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${VO.productos}" var="producto">
						<tr>
							<td><c:out value="${producto.getCodigo()}"></c:out></td>
							<td><c:out value="${producto.getNombre()}"></c:out></td>
							<td><c:out value="${producto.getPrecio()}"></c:out></td>
							<td><c:out value="${producto.getStock()}"></c:out></td>
							<td><a href="editarForm?id=${producto.getCodigo()}"><i
									class="fas fa-pencil-alt"></i></a></td>
							<td><a href="eliminar?id=${producto.getCodigo()}"><i
									class="fas fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

</body>
</html>