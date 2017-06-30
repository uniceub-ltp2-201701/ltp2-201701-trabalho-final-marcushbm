<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaUsuario.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body background="http://kaba35.com/wp-content/uploads/2015/11/Savin-NY-Website-Background-Web1.jpg">

<%	HttpSession s = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)s.getAttribute("admin");

if(!(u==null)){%>
	
	<table style="border-collapse: collapse;align: center;text-align: left;color: black;;float:right;">
	<th style="padding:23px;">LOGADO COMO <%out.println(u.getNome());%></th>
	<th style="padding:23px;"><a href="/FilmeMania/logoff">SAIR</th>
	</table>
	
	<br><br>
	<h2 style="text-align:center; font-size:50px;">BEM VINDO, <%out.println(u.getNome());%> !<h2>

	<% if(u.getPrivilegio()==1){%>
	<h2 style="text-align:center; font-size:20px;">O que gostaria de fazer agora? </h2>
	
		<%--<div class="container" style="color:black; float: right;">
			<a href="/FilmeMania/paginaEditar" style="color:black;">EDITAR OU EXCLUIR</a>
		</div>
		<br><br><br> --%>
<br><br>
		<div class="container" style="color:black; text-align: center">
			<a href="/FilmeMania/paginaAdicionarFilme" style="color:blue;">ADICIONAR FILME</a>
		</div>
		<br><br><br>
		
		<div class="container" style="color:black;text-align: center">
			<a href="/FilmeMania/paginaAdicionarAtor" style="color:blue;">ADICIONAR ATOR</a>
		</div><br>
		<br><br>
		<div class="container" style="color:black;text-align: center">
			<a href="/FilmeMania/paginaAdicionarDiretor" style="color:blue;">ADICIONAR DIRETOR</a>
			</div>
			<br><br><br>
		<div class="container" style="color:black;text-align: center">
			<a href="/FilmeMania/listarFilmes" style="color:red;">MODIFICAR FILME</a>
		</div>
		<br><br><br>
		<div class="container" style="color:black;text-align: center">
			<a href="/FilmeMania/listarAtores" style="color:red;">MODIFICAR ATOR</a>
		</div><br>
		<br><br>
		<div class="container" style="color:black;text-align: center">
			<a href="/FilmeMania/listarDiretores" style="color:red;">MODIFICAR DIRETOR</a>
		</div>
			
	<%}%>
	<% if(u.getPrivilegio()==0){%>

		<div class="container" style="color:black; float: right;">
			<a href="/FilmeMania/listarFilmes" style="color:black;">VER FILMES</a>
		</div>
		<br><br><br>
		<div class="container" style="color:black; float: right;">
			<a href="/FilmeMania/listarAtores" style="color:black;">VER ATORES</a>
		</div><br>
		<br><br>
		<div class="container" style="color:black; float: right;">
			<a href="/FilmeMania/listarDiretores" style="color:black;">VER DIRETORES</a>
		</div>
	<%}%>
<%}else{%>
 
 	<h2 style="margin-top:80px; font-size: 35px; text-align:center;">SUA SENHA OU USUARIO ESTÃO ERRADOS!</h2>
 	<div style="text-align:center;">
 	<meta http-equiv="refresh" content="2; /FilmeMania/paginaPrincipal" />
 	<a href="/FilmeMania/paginaPrincipal" style="border: none; color: black; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block;
    font-size: 20px; align:center;">AGUARDE...</a>
    </div>
<%}%>
</body>
</html>