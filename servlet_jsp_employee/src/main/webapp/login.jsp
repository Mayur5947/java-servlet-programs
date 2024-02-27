<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<fieldset>
		<%String message = (String)request.getAttribute("message");
		if (message!=null) {
		%>
		<h2><%=message %></h2>
		<%
		}
		%>
			<form action="login" method="post">


				email : <input type="email" name="email"><br>
				<br> password : <input type="text" name="password"><br>
				<br>
				<button>login</button>
			</form>

		</fieldset>
	</center>
</body>
</html>