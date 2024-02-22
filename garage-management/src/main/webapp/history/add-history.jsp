<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add history</title>
</head>
<body>
	<form action="history" method="post">
			<fieldset style="width: 25%">

					<input type="hidden" id="method_name" name="method_name" value="post">
				    history id : <input type="number" name="history_id"><br> 
					request_id : <input type="number" name="request_id"><br> 
					technician_id : <input type="number" name=technician_id><br> 
					part_id : <input type="number" name="part_id"><br> 
					date : <input type="text" name="date"><br> 
					comments : <input type="text" name="text"><br>
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>