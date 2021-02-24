<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Enter User</h1>
		${SPRING_SECURITY_LAST_EXCEPTION.message}
		<form action="welcome" method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>

					<td><input name="submit" type="submit" value="submit"></td>
				</tr>

			</table>
		</form>
<<<<<<< HEAD
*****************************************************************<br/>
=======

>>>>>>> 7958b1d (added error page)
New here?? <a href="/register"> Register Here</a>
	</div>

</body>
</html>