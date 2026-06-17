<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<div class="row">
			<div class="col-6">
				<h1>Formulario de Usuario</h1>
				<!-- action: es la ruta donde se va a recibir la info -->
				<!-- method: tipo de petición que se encarga de enviar el form -->
				<form action="/usuarios/registrarUsuario" method="POST" >
					<input type="text" name="nombreUsuario" class="form-control mt-3" placeholder="Ingrese su nombre.">
					<input type="email" name="emailUsuario" class="form-control mt-3" placeholder="Ingrese su correo">
					<input type="submit" class="btn btn-success mt-3" value="Registrar" >
				</form>
			</div>
		</div>
	</main>
</body>
</html>