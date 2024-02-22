<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add part</title>
</head>
<body>
	<form action="part" method="post">
			<fieldset style="width: 25%">

				   <input type="hidden" id="method_name" name="method_name" value="post">
				    part id : <input type="number" name="part_id"><br> 
					qty available : <input type="number" name="qty"><br> 
					part name : <input type="text" name="part_name"><br> 
					price : <input type="number" name="price"><br> 
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>