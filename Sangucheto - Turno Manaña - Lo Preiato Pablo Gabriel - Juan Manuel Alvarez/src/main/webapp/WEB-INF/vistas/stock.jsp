<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Stock</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="../../dist/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="theme.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sangucheto</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/Sangucheto/">Home</a></li>
            <li class="active"><a href="http://localhost:8080/Sangucheto/stock">Stock</a></li>
            <li><a href="http://localhost:8080/Sangucheto/armarSangucheto">Arma tu sangucheto</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	<div class="page-header">
		<br><h1>Stock disponible:</h1>
	</div>
	<div class="row">
		<!-- 		lo mismo que para las tablas, se puede elegir un numero de 1 a 12 para indicar -->
		<!-- 		cuantas columnas de una fila queremos que ocupe el panel (mas ancho o mas delgado) -->
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Condimentos:</h3>
				</div>
				<div class="panel-body">
					<!-- 					cada fila se divide en 12 columnas, con el codigo de abajo podemos -->
					<!-- 					indicar cuantas columnas de esa fila queremos que ocupe el contenido -->
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th>Stock</th>
									<th>Nombre</th>
									<th>Precio</th>
									
								</tr>
							</thead>
							<tbody>
							
							<c:forEach items="${map}" var="condimento">
<c:if test = "${condimento.key.tipo== 'CONDIMENTO'}">
<tr>
<td>${condimento.value }</td>
<td>${condimento.key.nombre}</td>
<td>${condimento.key.precio}</td>
<form:form action="agregarStock" modelAttribute="producto" method="POST">
<form:input  type="hidden" value="${condimento.key.nombre}" path="nombre" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${condimento.key.precio}" path="precio" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${condimento.key.tipo}" path="tipo" readonly="True" class="form-control"/>
<td><form:input  type="number" path="cantidad" class="form-control"   min="0" value="0"/></td>
<td><button type="submit" class="btn btn-primary">Agregar</button></td>
</form:form>
<form:form action="eliminarStock" modelAttribute="producto" method="POST">
<form:input  type="hidden" value="${condimento.key.nombre}" path="nombre" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${condimento.key.precio}" path="precio" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${condimento.key.tipo}" path="tipo" readonly="True" class="form-control"/>
<td><button type="submit" class="btn btn-danger">Eliminar</button></td>
</form:form>
</tr>
</c:if>
</c:forEach>
			
							</tbody>
						</table>
			<c:if test = "${mensajeProductoTipo=='CONDIMENTO'}">
			<c:if test = "${mensajeTipo=='Success'}">
			<div class="alert alert-success" role="alert">
        <strong>${mensajeResumen}</strong>${mensajeDetallado }
      </div>
      </c:if>
      <c:if test = "${mensajeTipo=='Danger'}">
			<div class="alert alert-danger" role="alert">
        <strong>${mensajeResumen}</strong>${mensajeDetallado }
      </div>
      </c:if>
      </c:if>
					</div>
				</div>
			</div>
			</div>
			
			
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Ingredientes:</h3>
				</div>
				<div class="panel-body">
<!-- 										cada fila se divide en 12 columnas, con el codigo de abajo podemos -->
<!-- 										indicar cuantas columnas de esa fila queremos que ocupe el contenido -->
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th>Stock</th>
									<th>Nombre</th>
									<th>Precio</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${map}" var="ingrediente">
<c:if test = "${ingrediente.key.tipo=='INGREDIENTE'}">
<tr>
<td>${ingrediente.value }</td>
<td>${ingrediente.key.nombre}</td>
<td>${ingrediente.key.precio}</td>
<form:form action="agregarStock" modelAttribute="producto" method="POST">
<form:input  type="hidden" value="${ingrediente.key.nombre}" path="nombre" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${ingrediente.key.precio}" path="precio" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${ingrediente.key.tipo}" path="tipo" readonly="True" class="form-control"/>
<td><form:input  type="number" path="cantidad" class="form-control"   min="0" value="0"/></td>
<td><button type="submit" class="btn btn-primary">Agregar</button></td>
</form:form>
<form:form action="eliminarStock" modelAttribute="producto" method="POST">
<form:input  type="hidden" value="${ingrediente.key.nombre}" path="nombre" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${ingrediente.key.precio}" path="precio" readonly="True" class="form-control"/>
<form:input  type="hidden" value="${ingrediente.key.tipo}" path="tipo" readonly="True" class="form-control"/>
<td><button type="submit" class="btn btn-danger">Eliminar</button></td>
</form:form>
</tr>
</c:if>
</c:forEach>
							</tbody>
						</table>
						<c:if test = "${mensajeProductoTipo=='INGREDIENTE'}">
			<c:if test = "${mensajeTipo=='Success'}">
			<div class="alert alert-success" role="alert">
        <strong>${mensajeResumen}</strong>${mensajeDetallado }
      </div>
      </c:if>
      <c:if test = "${mensajeTipo=='Danger'}">
			<div class="alert alert-danger" role="alert">
        <strong>${mensajeResumen}</strong>${mensajeDetallado }
      </div>
      </c:if>
      </c:if>
					</div>
				</div>
			</div>
		</div>
				</div>
		

	<div class="row">
		<!-- 		lo mismo que para las tablas, se puede elegir un numero de 1 a 12 para indicar -->
		<!-- 		cuantas columnas de una fila queremos que ocupe el panel (mas ancho o mas delgado) -->
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Agrega un nuevo producto:</h3>
				</div>
				<div class="panel-body">
					<!-- 					cada fila se divide en 12 columnas, con el codigo de abajo podemos -->
					<!-- 					indicar cuantas columnas de esa fila queremos que ocupe el contenido -->
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th>Nombre:</th>
									<th>Precio:</th>
									<th>Tipo::</th>
									
								</tr>
							</thead>
							<tbody>
<form:form action="stock" modelAttribute="producto" role="form" method="POST">							
<td><form:input id="nombre" path="nombre" class="form-control"/> </td>
<td><form:input id="precio" path="precio" value="0.0" class="form-control"/> </td>
<td><select name="tipo" class="form-control"> 
  <option value="INGREDIENTE">Ingrediente</option>
  <option value="CONDIMENTO">Condimento</option>
</select> </td>
<form:input id="cantidad" path="cantidad" value="0" readonly="true" type="hidden"/>
<td><button type="submit" class="btn btn-primary">Agregar</button></td>
</form:form>
							</tbody>
						</table>
						<c:if test = "${mensajeProductoTipo=='PRODUCTO'}">
			<c:if test = "${mensajeTipo=='Success'}">
			<div class="alert alert-success" role="alert">
        <strong>${mensajeResumen}</strong>${mensajeDetallado }
      </div>
      </c:if>
      <c:if test = "${mensajeTipo=='Danger'}">
			<div class="alert alert-danger" role="alert">
        <strong>${mensajeResumen}</strong>${mensajeDetallado }
      </div>
      </c:if>
      </c:if>
					</div>
				</div>
			</div>
			</div>
			



</body>
</html>