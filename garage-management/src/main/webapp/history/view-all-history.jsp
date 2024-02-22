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
		List< History> histories = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>history id</th>
			<th>request id</th>
			<th>technician id</th>
			<th>part id</th>
			<th>date </th>
			<th>comments</th>
		</tr>
		<%
			for (History history : histories) {
		%>
		<tr>

			<td><%=history.getHistory_id()%></td>
			<td><%=history.getRequest_id()%></td>
			<td><%=history.getTechnician_id()%></td>
			<td><%=history.getPart_id()%></td>
			<td><%=history.getDate()%></td>
			<td><%=history.getComments()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>
</body>
</html>