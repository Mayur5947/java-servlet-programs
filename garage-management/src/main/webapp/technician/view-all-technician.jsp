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
		List<Technician> technicians = (List) request.getAttribute("list");
	%>
	<table align="center" border="solid" cellspaccing="0px" cellpadding="20px">
		<tr>

			<th>technician id</th>
			<th>first name</th>
			<th>last name</th>
			<th>specialization</th>
		</tr>
		<%
			for (Technician technician : technicians) {
		%>
		<tr>

			<td><%=technician.getTechnician_id()%></td>
			<td><%=technician.getFirst_name()%></td>
			<td><%=technician.getLast_name()%></td>
			<td><%=technician.getSpecialization()%></td>
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