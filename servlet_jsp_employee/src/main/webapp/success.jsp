<%@page import="java.util.List"%>
<%@page import="servlet_jsp_employee.Employee"%>
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
		List<Employee> employees = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>id</th>
			<th>name</th>
			<th>phone</th>
			<th>address</th>
			<th>email</th>
			<th>password</th>
		</tr>
		<%
			for (Employee employee : employees) {
		%>
		<tr>

			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPassword()%></td>
		</tr>
		<%
			}
		%>



	</table>
</body>
</html>