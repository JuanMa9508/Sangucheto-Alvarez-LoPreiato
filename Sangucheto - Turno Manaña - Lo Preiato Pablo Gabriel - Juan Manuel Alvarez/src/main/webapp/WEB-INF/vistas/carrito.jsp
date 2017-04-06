<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Carrito:</title>
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
            <li class="active"><a href="http://localhost:8080/Sangucheto/">Home</a></li>
            <li><a href="http://localhost:8080/Sangucheto/stock">Stock</a></li>
            <li><a href="http://localhost:8080/Sangucheto/armarSangucheto">Arma tu sangucheto</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	<div class="page-header">
		<h1>Carrito:</h1>
	</div>
	<div class="row">
		<div class="col-sm-5">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Carrito:</h3>
				</div>
				<div class="panel-body">
					<!-- 					cada fila se divide en 12 columnas, con el codigo de abajo podemos -->
					<!-- 					indicar cuantas columnas de esa fila queremos que ocupe el contenido -->
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th>Producto:</th>
									<th>Precio:</th>
								</tr>
							</thead>
							<tbody>
							<tr>
							<td>Sanguche:</td>
                            <td>$ ${precioSanguche}</td>
							</tr>
								<c:forEach items="${lista}" var="producto">
									<tr>
										<td>${producto.nombre}</td>
										<td>$ ${producto.precio}</td>
									</tr>
</c:forEach>
								<tr>
									<td>Descuento: ${descuento}</td>
									<td>Total sin descuento: ${totalSinDescuento}
									<td>Total:$ ${total}</td>
								</tr>
								<tr>
								<td>
<form:form action="cancelarCompra"  method="POST">
<td><button type="submit" class="btn btn-danger">Cancelar</button></td>
</form:form>
<form:form action="comprar"  method="POST">
<td><button type="submit" class="btn btn-success">Confirmar</button></td>
</form:form>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>