<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update customer</title>
</head>
<body>

	<form action="customer" method="post">
			<fieldset style="width: 25%">

				    <input type="hidden" id="method_name" name="method_name" value="put">
				    existing customer id : <input type="number" name="customer_id"><br> 
					new address : <input type="text" name="address"><br> 
					new email : <input type="text" name="email"><br> 
					new phone : <input type="number" name="phone"><br>
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>