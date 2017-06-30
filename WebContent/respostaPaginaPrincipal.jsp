<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FILME MANIA</title>
</head>
<body background="http://blog.hostbaby.com/wp-content/uploads/2014/03/PaintSwatches_1400x900.jpg">
<h1  style="color:black;font-size:80px"" align="center"> BEM VINDO AO FILME MANIA!</h1>
<div style= 'margin-top: 40px'>
	<table style='margin-top:-400px'align="center" border="0px">
		<tr>
			<td>
	
	<ul style= font-size:30px;text-align:center align="center">
		<a style=color:black href="/FilmeMania/listarFilmes">FILMES</a><br>
		<br>
		<a style=color:black href="/FilmeMania/listarAtores">ATORES</a><br>
		<br>
		<a style=color:black href="/FilmeMania/listarDiretores">DIRETORES</a><br>
		<br>
		<a style=color:black href="/FilmeMania/listarCategoria">CATEGORIAS</a><br>
		<br>
	</ul>
			</td>
		</tr>
		
		</div>	
		
		<div class="login">
  
  <h2 class="login-header">ENTRE</h2>

  <form action="usuario" class="login-container" method="post">
  	<br>
  	<p><input type="text" placeholder="Usuario" name="loginUsuario"></p>
    <p><input type="password" placeholder="Senha" name="loginSenha"></p>
    <p><input type="submit" value="ENTRAR"></p>
  </form>
</div>

<div class="register">
  
  <h2 class="register-header">REGISTRE-SE</h2>

  <form action="registrarUsuario" class="register-container" method="post">
  	<br>
  	<p><input type="text" placeholder="Usuario" name="registerUsuario"></p>
    <p><input type="password" placeholder="Senha" name="registerSenha"></p>
    <p><input type="submit" value="REGISTRAR"></p>
  </form>
</div>

	
	
</body>
</html>