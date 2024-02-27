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
		List<Bike> bikes = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>bike id</th>
			<th>customer id</th>
			<th>make</th>
			<th>model</th>
			<th>color</th>
			<th>number plate</th>
			<th>year</th>
		</tr>
		<%
			for (Bike bike : bikes) {
		%>
		<tr>

			<td><%=bike.getBike_id()%></td>
			<td><%=bike.getCustomer_id()%></td>
			<td><%=bike.getMake()%></td>
			<td><%=bike.getModel()%></td>
			<td><%=bike.getColor()%></td>
			<td><%=bike.getNumber_plate()%></td>
			<td><%=bike.getYear()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>
</body>
</html>
