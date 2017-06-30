<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Usuario"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Filme" %>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaPaginaAdicionarDiretor.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADICIONAR DIRETOR</title>
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

<h1 style="color:black;font-size:80px"" align="center">ADICIONAR DIRETOR</h1>
   
<div id="local">
  <form action="adicionarDiretor" style="height:auto" method="post">
    <label for="nome">NOME</label>
    <input type="text" id=""nome" name="nome"><br>
	<br>
    <label for="biografia">BIOGRAFIA</label>  <br> <textarea name="biografia" cols="10" rows="5" style="width: 35%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; resize: vertical;"></textarea>
    <br><br>
    
    <label for="nascimento">NASCIMENTO</label><br>
    <input type="text" id="nascimento" name="nascimento" placeholder="DIGITE ANO, MES E DIA" style="width:250px"><br><br>
    
    <label for="idfilme">FILME DO DIRETOR</label><br>
    <select id="idfilme" name="idfilme"> 
    <% 
    	ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");
    
  	for(int i=0; i<filmes.size(); i++){ %>
  

  		<option value="<%out.print(filmes.get(i).getId_filme());%>"><%out.print(filmes.get(i).getTitulo());%></option>
  		
	<%}%>

	</select>
		<br><br>

    <input type="submit" value="ADICIONAR">
  </form>
</div>
<% String m = (String) request.getAttribute("mensagem");
	if(m==null)
		m = "";
%>
<h1 style="margin-left:850px"><%out.println(m);%></h1>
<%}else{%>
	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">SOMENTE EDITORES!</h1>
<%}%>
</body>
</html>