
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Filme"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>DETALHAR CATEGORIA</title>
<body background="http://img.nyfilmfinance.net/2016/10/21/industrial-background-l-6fb20540a2eeaac8.jpg">
	
<%
	ArrayList<Filme>filmes= (ArrayList<Filme>) request.getAttribute("filmes");
	%>
<h1 style="color:black;font-size:50px"align="center" >FILMES QUE ESTÃO NESTA CATEGORIA</h1>
<table style = 'background-color:white' align="center" border="1px" >
		<%for (int i = 0; i < filmes.size(); i++) {
			out.println("<tr><td style='color:black'><a href='/FilmeMania/detalhaFilme?idfilme=" + filmes.get(i).getId_filme() + "&mensagem='>" + filmes.get(i).getTitulo() + "</a></td>");
		%>
<%}%>
	</table>
<br>
<br>
<br>

<a style="color:black" href="/FilmeMania/paginaPrincipal">VOLTAR A PÁGINA PRINCIPAL</a>
</body>
</html>