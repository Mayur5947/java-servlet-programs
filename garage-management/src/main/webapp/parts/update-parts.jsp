<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update part</title>
</head>
<body>
	
	<form action="part" method="post">
			<fieldset style="width: 25%">

				    <input type="hidden" id="method_name" name="method_name" value="put">
				    existing part id : <input type="number" name="part_id"><br> 
					update qty available : <input type="number" name="qty"><br> 
					update price : <input type="number" name="price"><br> 
				<button>submit</button>
			</fieldset>
		</form>
	
</body>
</html>