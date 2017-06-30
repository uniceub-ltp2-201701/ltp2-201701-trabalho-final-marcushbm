<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Filme" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TODOS OS FILMES</title>
</head>
<body background="http://blog.hostbaby.com/wp-content/uploads/2014/03/PaintSquares_1920x1234.jpg">

<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>

<h1 style="color:black;font-size:80px" align="center">FILMES</h1>
<table  style = 'background-color:white' align="center" border=1>
<tr><td style="color:black">FILMES</td><td style="color:black" >CATEGORIA</td></tr>

<%
 for(int i=0; i<filmes.size(); i++){
		out.println("<tr><td style='color:black'><a href='/FilmeMania/detalhaFilme?idfilme=" + filmes.get(i).getId_filme() + "&mensagem='>" + filmes.get(i).getTitulo() + "</a></td>");
		out.println("<td style='color:black'>" + filmes.get(i).getCategoria()+ "</td></tr>");
	}
%>

</table>
<br>
<a href="/FilmeMania/paginaPrincipal">VOLTAR A PÁGINA PRINCIPAL</a>

</body>
</html>