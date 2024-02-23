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
		List<Request> requests = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>request id</th>
			<th>bike id</th>
			<th>status</th>
			<th>discription</th>
		</tr>
		<%
			for (Request request1 : requests) {
		%>
		<tr>

			<td><%=request1.getRequest_id()%></td>
			<td><%=request1.getBike_id()%></td>
			<td><%=request1.getStatus()%></td>
			<td><%=request1.getDescription()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>
