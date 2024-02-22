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

		<form action="assignment" method="put">
			<fieldset style="width: 25%">
					<input type="hidden" id="method_name" name="method_name" value="put">
				    assignment id : <input type="number" name="assignment_id"><br> 
				    assignment date : <input type="number" name="date"><br> 
					 update status : <input type="email" name="status"><br> 
				<button>submit</button>
			</fieldset>
		</form>

	</center>
</body>
</html>