<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Ator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Filme"%>
<%@ page import="model.Usuario"%>
<%@page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body background="http://img.nyfilmfinance.net/2016/10/21/industrial-background-l-6fb20540a2eeaac8.jpg">

<%
	Ator a = (Ator) request.getAttribute("ator");
	ArrayList<Filme> f = (ArrayList<Filme>) request.getAttribute("filmes");
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
			<a href="/FilmeMania/editarAtor?idator=<%out.println(a.getId_ator());%>" style="color:black;">MODIFICAR ATOR</a>
		</div>
	
	<%}%>

<div class="texto" align="center">
	<p>
	<h1 style='color:black;font-size:80px'>
		<%
			out.println(a.getNome_ator());
		%>
	</h1>
	<br>
	<br>
	</p>
	<br>


	<table >
		<tr>
			<td><p style='color:black ;font-size:30px' align="center">
					<%
						out.println(a.getBio_ator());
					%>
				</p></td>
		</tr>
	</table>

	<br> <br>

	<table  style = 'background-color:white' align="center" border="1px">

		<tr>
			<td>FILMES EM QUE APARECE</td>
			<td>CATEGORIA</td>
		</tr>
		<%
			for (int i = 0; i < f.size(); i++) {
		%>
		<td>
			<%
				out.println("<a href='/FilmeMania/detalhaFilme?idfilme=" + f.get(i).getId_filme() + "&mensagem='>"
							+ f.get(i).getTitulo() + "</a>");
			%>
		</td>
		<td>
			<%
				out.println(f.get(i).getCategoria());
			%>
		</td>
		<%}%>

	</table>

</div>


<a href="/FilmeMania/paginaPrincipal">VOLTAR A PÁGINA PRINCIPAL</a>
<br>
<br>
<a href="/FilmeMania/listarAtores">ATORES</a>

</body>
</html>


