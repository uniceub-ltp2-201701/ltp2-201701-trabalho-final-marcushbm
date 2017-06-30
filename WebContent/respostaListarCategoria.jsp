<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/respostaListarCategorias.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CATEGORIAS</title>
</head>
<body background="http://blog.hostbaby.com/wp-content/uploads/2014/03/PaintSquares_1920x1234.jpg">

	<h1 style="color:black;font-size:80px"align="center">CATEGORIAS</h1>

<table style = 'background-color:white' align="center" border="1px">

<tr>
			<td>CATEGORIAS</td>
			
			</tr>

	<% ArrayList<String> s = (ArrayList<String>) request.getAttribute("categorias");

for(int i=0; i<s.size(); i++){
	
//>	
%>
	<tr>
	<td>
	<a href="/FilmeMania/detalharCategoria?categoria=<%out.println(s.get(i)); %>">
		<% out.println(s.get(i)); %> 
		</a></td></tr>
		
<%}%>
	</table>
	
		<a href="/FilmeMania/paginaPrincipal">VOLTAR A PÁGINA PRINCIPAL</a>
</body>
</html>