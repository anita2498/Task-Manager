<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to task manager for users</title>
</head>
<style>

.button {
  transition-duration: 0.4s;
}

.button:hover {
  background-color: #4CAF50; /* Green */
  color: white;
}

</style>
<body>
	<div align="center">
	${msg}
		<a href="/create"> <button class="button">Create Task</button> </a>
		 &nbsp;
		<a href="/deletefromwelcome"> <button class="button">Delete Task</button> </a> 
		&nbsp;
		<a href="/display"> <button class="button">Display Tasks</button> </a> 
		 &nbsp;
		<a href="/updatefromwelcome"> <button class="button">Update Tasks</button> </a> 
		&nbsp;
		<a href="/logout"> <button class="button">logout</button> </a> 
	
	
	</div>
	
</body>
</html>