<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="bike" method="post">
			<fieldset style="width: 25%">

					<input type="hidden" id="method_name" name="method_name" value="put">
				    bike id : <input type="number" name="bike_id"><br> 
				    customer id : <input type="number" name="customer_id"><br> 
					make : <input type="text" name="make"><br> 
					model : <input type="text" name="model"><br> 
					color : <input type="text" name="color"><br> 
					number plate : <input type="text" name="number_plate"><br> 
					year : <input type="number" name="year"><br>
				<button>submit</button>
			</fieldset>
		</form>

	</center>
</body>
</html>