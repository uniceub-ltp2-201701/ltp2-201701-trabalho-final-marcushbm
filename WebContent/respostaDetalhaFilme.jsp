<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Filme" %>
    <%@ page import="model.Ator" %>
    <%@ page import="model.Diretor" %>
        <%@ page import="model.Usuario"%>
    <%@ page import="java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DETALHES DO FILME</title>
</head>
<body background="http://img.nyfilmfinance.net/2016/10/21/industrial-background-l-6fb20540a2eeaac8.jpg">

<%  Filme f = (Filme)request.getAttribute("filme");
	ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("atores");
	ArrayList<Diretor> diretores = (ArrayList<Diretor>) request.getAttribute("diretores");
	HttpSession s = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)s.getAttribute("admin");

if(!(u==null)){%>


		<table style="float:right;">
			<th style="padding:23px;">LOGAGO <%out.println(u.getNome());%></th>
			<th style="padding:23px;"><a href="/FilmeMania/logoff">SAIR</th>
		</table>
	
	<br>
<%}%>

	<%if(!(u==null) && u.getPrivilegio()==1){ %>
	
	<br><br><br>
	
	<div class="container" style="width: 250px;color:black; float: right; padding: 15px; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/FilmeMania/paginaEditarFilme?idfilme=<%out.println(f.getId_filme());%>" style="color:black;">MODIFICAR FILME</a>
		</div>
	
	<%}%>
	<div class="texto" align="center">
	<h1 style='color:black;font-size:80px'><%out.println(f.getTitulo());%></h1><br><br>
	
	<table border="0">
	<tr><td style='color:black'><p style="width: 1200px; font-size:25px;font-weight:bold; word-wrap:break-word; white-space: normal;">
		<% out.println(f.getSinopse()); %>
	</p></td></tr>
	</table>
	
	<br>
	
	<table border="1" style="float:left;margin-left:500px; font-size:15px;background-color:white">
	<tr><td style='color:black'><% out.println(f.getCategoria()); %></td></tr>
	</table>
	
	<table border="1" style="float:left; font-size:15px;background-color:white">
	<tr><td style='color:black'><% out.println(f.getDuracao() + " minutos"); %></td></tr>
	</table>
	
	<table border="1" style="float:left; font-size:15px;background-color:white">
	<tr><td style='color:black' ><% out.println("Avaliação: " + f.getPontuacao()); %></td></tr>
	</table>
	
	<table border="1" style="float:left; font-size:15px;background-color:white">
	<tr><td style='color:black' ><% out.println("Data de Lançamento: " + f.getData_lancamento()); %></td></tr>
	</table>
	
	<table border="1" style="float:left; font-size:15px;background-color:white">
	<tr><td style='color:black' ><% out.println("Faixa etária: " + f.getFaixa_etaria()); %></td></tr>
	</table>
	
	<br><br>
	
	<table border="1" style="float:left; margin-left:550px;background-color:white">
	
	<tr><td style='color:black'>ATORES DO FILME</td></tr>
	<% for(int i=0; i<atores.size(); i++){%>
		<tr>
		<td><%out.println("<a href='/FilmeMania/detalhaAtor?idator=" + atores.get(i).getId_ator() + "&mensagem='>" + atores.get(i).getNome_ator() + "</a>");%></td>
		</tr>
	<%}%>
	
	</table>
	
	<table border="1" style="float:left; margin-left:20px;background-color:white">
	
	<tr><td style='color:black'>DIRETORES DO FILME</td></tr>
	<% for(int i=0; i<diretores.size(); i++){%>
		<tr>
		<td><%out.println("<a href='/FilmeMania/detalhaDiretor?iddiretor=" + diretores.get(i).getId_diretor() + "&mensagem='>" + diretores.get(i).getNome_diretor() + "</a>");%></td>
		</tr>
	<%}%>
	
	</table>
	<br>
<br><br>
<br>
<a style= color:black href="/FilmeMania/paginaPrincipal">VOLTAR A PÁGINA PRINCIPAL</a>
<br>
<br>
<a style=color:black href="/FilmeMania/listarFilmes">FILMES</a>

</body>
</html>