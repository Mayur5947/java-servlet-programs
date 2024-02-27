<%@page import="java.util.List"%>
<%@page import="model.*"%>
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
		List<Assignment> assignments = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>assignment id</th>
			<th>request id</th>
			<th>technician id</th>
			<th>part id</th>
			<th>status</th>
			<th>date</th>
		</tr>
		<%
			for (Assignment assignment :  assignments) {
		%>
		<tr>

			<td><%=assignment.getAssignment_id()%></td>
			<td><%=assignment.getRequest_id()%></td>
			<td><%=assignment.getTechnician_id()%></td>
			<td><%=assignment.getPart_id()%></td>
			<td><%=assignment.getStatus()%></td>
			<td><%=assignment.getDate()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>
</body>
</html>
