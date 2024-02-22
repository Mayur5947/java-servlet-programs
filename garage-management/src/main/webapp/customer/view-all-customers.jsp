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
		List<Customer> customers = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>customer id</th>
			<th>first name</th>
			<th>last name</th>
			<th>address</th>
			<th>phone</th>
			<th>email</th>
		</tr>
		<%
			for (Customer customer : customers) {
		%>
		<tr>

			<td><%=customer.getCustomer_id()%></td>
			<td><%=customer.getFirst_name()%></td>
			<td><%=customer.getLast_name()%></td>
			<td><%=customer.getAddress()%></td>
			<td><%=customer.getPhone()%></td>
			<td><%=customer.getEmail()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>
</body>
</html>