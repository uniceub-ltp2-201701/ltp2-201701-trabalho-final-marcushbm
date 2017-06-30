<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="/respostaRegistrarUsuario.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PAGINA PRINCIPAL</title>
</head>
<body>

<%  
	boolean resultado = (boolean) request.getAttribute("resultado");
%>
<%--
<div class="login">
  
  <h2 class="login-header">ENTRE</h2>

  <form action="usuario" class="login-container" method="post">
  
  	<p><input type="text" placeholder="Usuario" name="loginUsuario"></p>
    <p><input type="password" placeholder="Senha" name="loginSenha"></p>
    <p><input type="submit" value="ENTRAR"></p>
  </form>
</div>
<br>

<div class="register">
  
  <h2 class="register-header">REGISTRE-SE</h2>

  <form action="registrarUsuario" class="register-container" method="post">

  	<p><input type="text" placeholder="Usuario" name="registerUsuario"></p>
    <p><input type="password" placeholder="Senha" name="registerSenha"></p>
    <p><input type="submit" value="REGISTRAR"></p>
  </form>
</div>

--%>

<% if(resultado){ %>
<meta http-equiv="refresh" content="2; /FilmeMania/paginaPrincipal" />
	<h1 style="text-align:center; margin-top:40px;">USUARIO CRIADO COM SUCESSO!</h1>
	<h2 style="text-align:center">AGUARDE...</h2>
<%}else{%>
	<h2 style="text-align:center; margin-top:40px;">ERRO AO CRIAR USUARIO</h2>
<%}%>
</body>
</html>