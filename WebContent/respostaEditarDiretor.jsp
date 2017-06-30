<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
    <%@ page import="model.Filme" %>
    <%@ page import="model.Categoria" %>
    <%@ page import="model.Ator" %>
    <%@ page import="model.Diretor" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDITAR DIRETOR</title>
</head>
<body background="http://kaba35.com/wp-content/uploads/2015/11/Savin-NY-Website-Background-Web1.jpg">

<% HttpSession s = (HttpSession) request.getSession(true);
   Usuario u = (Usuario)s.getAttribute("admin"); 
   
   Diretor d = (Diretor) request.getAttribute("diretor");
   
   if(!(u==null) && u.getPrivilegio()==1){%>


	<table style="float:right;">
		<th style="padding:23px;">LOGADO <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/FilmeMania/logoff">SAIR</th>
	</table>

<br><br><br><br>
	
	<div class="container" style="width: 250px;color:black; float: right; padding: 15px; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/FilmeMania/excluirDiretor?iddiretor=<%= d.getId_diretor() %>" style="color:purple;">DELETAR DIRETOR</a>
		</div>

<br>

<h1 style="text-align:center;">MODIFICAR DIRETOR</h1>
   
<div id="local">
  <form action="editarDiretor?iddiretor=<%= d.getId_diretor() %>" style="height:auto" method="post">
    <label for="nome">NOME</label>
    <br>
    <input type="text" id="nome" name="nome" placeholder="<%= d.getNome_diretor() %>">
<input type="hidden" name="iddiretor" value = "<%= d.getId_diretor() %>">
    <label for="biografia">BIOGRAFIA</label>   <textarea name="biografia" cols="40" rows="5" placeholder="<%= d.getBiografia() %>" style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; resize: vertical;"></textarea>
    
    <label for="datanasc">DATA DE NASCIMENTO</label><br>
    <input type="text" id="datanasc" name="datanasc" placeholder="<%= d.getData_nasc() %>" style="width:250px"><br>
  
<br>
    <input type="submit" value="MODIFICAR">
  </form>
</div>
  	<% String m = (String) request.getAttribute("mensagem");
	if(m==null)
		m = "";
		%>
<h1 style="margin-left:850px"><%out.println(m);%></h1>

<%}else{%>
	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">SOMENETE EDITORES</h1>
	<meta http-equiv="refresh" content="2; /FilmeMania/paginaPrincipal" />
<%}%>
</body>
</html>