<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer home</title>
</head>
<body>

	<center>

<form action="customer" method="get">
				
					<input type="hidden" id="method_name" value="get">
					<button>view all customers</button>
				</form>
		<h2 align="centre">
			<a align="centre" href="add-customer.jsp"><button>add customer</button></a> 
			<a align="centre" href="update-customer.jsp"><button>update customer</button></a> 
			
		</h2>
	</center>
</body>
</html>
