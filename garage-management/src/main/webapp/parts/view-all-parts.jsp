<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%@page import="java.util.List"%>
<%@page import="model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all data</title>
</head>
<body>
	<%
		List< Parts> parts = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>part id</th>
			<th>part name</th>
			<th>quantity</th>
			<th>price</th>
		</tr>
		<%
			for (Parts part : parts) {
		%>
		<tr>

			<td><%=part.getPart_id()%></td>
			<td><%=part.getPart_name()%></td>
			<td><%=part.getQty_available()%></td>
			<td><%=part.getPrice()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>
</body>
</html>
	
</body>
</html>