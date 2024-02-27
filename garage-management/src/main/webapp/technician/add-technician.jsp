<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="technician" method="post">
			<fieldset style="width: 25%">

				    <input type="hidden" id="method_name" name="method_name" value="post">
				    technician id : <input type="number" name="technician_id"><br> 
					first_name : <input type="text" name="first_name"><br> 
					last_name : <input type="text" name="last_name"><br> 
					specialization : <input type="text" name="specialization"><br> 
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>
