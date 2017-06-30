<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaPaginaAdicionarFilme.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADICIONAR FILME</title>
</head>
<body>

<% HttpSession s = (HttpSession) request.getSession(true);
   Usuario u = (Usuario)s.getAttribute("admin"); 
   
   if(!(u==null) && u.getPrivilegio()==1){%>


	<table style="float:right;">
		<th style="padding:23px;">LOGADO <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/FilmeMania/logoff">SAIR</th>
	</table>

<br>

<h1 style="color:black;font-size:80px"" align="center">ADICIONAR - FILME</h1>
   
<div id="local">
  <form action="adicionarFilme" style="height:auto" method="post">
    <label for="titulo">TÍTULO</label>
    <input type="text" id="titulo" name="titulo" placeholder="Título do filme..">
    <br><br>

    <label for="sinopse">SINOPSE</label><br>   <textarea name="sinopse" cols="10" rows="5" style="width: 35%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; resize: vertical;"></textarea>
    
    <br>

    <label for="categoria">CATEGORIA</label>
    <br>
    <input type="text" id="categoria" name="categoria" placeholder="Terror, Acao, Suspense...?">
    <br><br>
    <label for="faixaetaria">FAIXA ETARIA</label><br>
    <input type="text" id="faixaetaria" name="faixaetaria" placeholder="SOMENTE NUMEROS"style="width:180px"><br>
    <br>
    <label for="pontuacao">PONTUAÇÃO</label><br>
    <input type="text" id="pontuacao" name="pontuacao" style="width:180px"><br>
    <br>
    <label for="duracao">DURAÇÃO DO FILME</label><br>
    <input type="text" id="duracao" name="duracao" placeholder="EM MINUTOS" style="width:180px"><br>
    <br>
    <label for="datalancamento">DIA DE LANÇAMENTO</label><br>
    <input type="text" id="datalancamento" name="datalancamento" placeholder="ANO, MES E DIA" style="width:180px"><br>
 <br>
 <br>
    <input type="submit" value="ADICIONAR">
  </form>
</div>
  	<% String m = (String) request.getAttribute("mensagem");
	if(m==null)
		m = "";
%>
<h1 style="margin-left:850px"><%out.println(m);%></h1>
<%}else{%>
	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">SOMENTE EDITORES</h1>
<%}%>
</body>
</html>