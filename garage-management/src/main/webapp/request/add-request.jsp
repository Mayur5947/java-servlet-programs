<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
</head>
<body>
	<form action="request" method="post">
			<fieldset style="width: 25%">

				    <input type="hidden" id="method_name" name="method_name" value="post">
				    request id : <input type="number" name="request_id"><br> 
					bike id : <input type="number" name="bike_id"><br> 
					status : <input type="text" name="status"><br> 
					discription : <input type="text" name="discription"><br> 
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>