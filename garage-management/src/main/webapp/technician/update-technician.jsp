<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="request" method="post">
			<fieldset style="width: 25%">

				   <input type="hidden" id="method_name" name="method_name" value="put">
				   existing technician id : <input type="number" name="technician_id"><br> 
					update specialization : <input type="text" name="specialization"><br> 
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>