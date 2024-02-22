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

		<form action="assignment" method="post">
			<fieldset style="width: 25%">
					
					 <input type="hidden" id="method_name" name="method_name" value="post">
				    assignment id : <input type="number" name="assignment_id"><br> 
				    request id : <input type="number" name="request_id"><br> 
					technician id : <input type="number" name="technician_id"> 
					part id : <input type="number" name="part_id"><br> 
					status : <input type="email" name="status"><br> 
					date : <input type="text" name="date"><br>
				<button>submit</button>
			</fieldset>
		</form>

	</center>
</body>
</html>