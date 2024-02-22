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
				    existing request id : <input type="number" name="request_id"><br> 
					update status : <input type="text" name="status"><br> 
					update discription : <input type="text" name="discription"><br> 
				<button>submit</button>
			</fieldset>
		</form>
</body>
</html>