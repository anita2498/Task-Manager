<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form action="register" method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="text" name="role" value="ROLE_USER" readonly="readonly"/></td>
				</tr>
				<tr>

					<td><input name="submit" type="submit" value="submit"></td>
				</tr>

			</table>
		</form>
</body>
</html>