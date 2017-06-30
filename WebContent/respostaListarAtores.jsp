<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Ator"%>
<%@ page import="java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ATORES</title>
</head>
<body background="http://blog.hostbaby.com/wp-content/uploads/2014/03/PaintSquares_1920x1234.jpg">


	<h1  style="color:black;font-size:80px" align="center">ATORES</h1>


	<table style = 'background-color:white' align="center" border="1px">

		<tr>
			<td>NOME</td>
			<td>NASCIMENTO</td>
		</tr>

		<%
			ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("atores");

			for (int i = 0; i < atores.size(); i++) {
		%>


		<tr>
			<td>
				<%
					out.println("<a href='/FilmeMania/detalhaAtor?idator=" + atores.get(i).getId_ator() + "&mensagem='>"
								+ atores.get(i).getNome_ator() + "</a>");
				%>
			</td>
			<td>
				<%
					out.println(atores.get(i).getData_nasc());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>

	<a href="/FilmeMania/paginaPrincipal">VOLTAR A PÁGINA PRINCIPAL</a>

</body>
</html>