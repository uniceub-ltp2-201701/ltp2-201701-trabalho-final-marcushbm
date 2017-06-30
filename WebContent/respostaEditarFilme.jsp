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
<title>EDITAR FILME</title>
</head>
<body background="http://kaba35.com/wp-content/uploads/2015/11/Savin-NY-Website-Background-Web1.jpg">

<% HttpSession s = (HttpSession) request.getSession(true);
   Usuario u = (Usuario)s.getAttribute("admin"); 
   
   Filme f = (Filme) request.getAttribute("filme");

   if(!(u==null) && u.getPrivilegio()==1){%>


	<table style="float:right;">
		<th style="padding:23px;">LOGADO  <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/FilmeMania/logoff">SAIR</th>
	</table>

<br><br><br><br>
	
	<div style="width: 250px;color:black; float: right; padding: 15px; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/FilmeMania/excluirFilme?idfilme=<%= f.getId_filme() %>" style="color:purple;">DELETAR FILME</a>
		</div>

<br>

<h1 style="text-align:center;">MODIFICAR FILME</h1>
   
<div id="local">
  <form action="editarFilme?idfilme=<%=f.getId_filme()%>" style="height:auto" method="post">
    <label for="titulo">TITULO</label>
    <br>
    <input type="text" id="titulo" name="titulo" placeholder="<%= f.getTitulo() %>">
<br><br>
    <label for="sinopse">SINOPSE</label>   <textarea name="sinopse" value="sinopse" id="sinopse" cols="40" rows="5" placeholder="<%= f.getSinopse() %>" style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; resize: vertical;"></textarea>
    
    <label for="faixaetaria">FAIXA ETARIA</label>
    <br>
    <input type="text" id="faixaetaria" name="faixaetaria" placeholder="<%= f.getFaixa_etaria() %>"style="width:180px"><br>
    
    <label for="pontuacao">PONTUAÇÃƒO</label><br>
    <input type="text" id="pontuacao" name="pontuacao" placeholder="<%= f.getPontuacao() %>" style="width:180px"><br>
    
    <label for="duracao">DURAÇÃƒO</label><br>
    <input type="text" id="duracao" name="duracao" placeholder="<%= f.getDuracao() %>" style="width:180px"><br>
    
    <label for="datalancamento">DATA DE LANÇAMENTO</label><br>
    <input type="text" id="datalancamento" name="datalancamento" placeholder="<%= f.getData_lancamento() %>" style="width:180px"><br>
    
    	
	<label for="categoria">CATEGORIA</label>
	<br>
    <input type="text" id="categoria" name="categoria" placeholder="<%= f.getCategoria() %>"  style="width:180px">
    
    <br><br>
    <input type="submit" value="MODIFICAR">
  </form>
  
</div>
  	<% String m = (String) request.getAttribute("mensagem");
	if(m==null)
		m = "";
		%>
<h1 style="margin-left:850px"><%out.println(m);%></h1>



<%}else{%>
	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">SOMENTE EDITORES</h1>
	<meta http-equiv="refresh" content="2; /FilmeMania/paginaPrincipal" />
<%}%>
</body>
</html>
