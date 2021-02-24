<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display task</title>
</head>
<style type="text/css">
table {
	width: 100%;
	align-content: center;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: center;
}
</style>
<body>
	<div align="center">
	${msg}
	<form method="post" >
		<table style="width: 75%">
			<tr>
				<th>ID</th>
				<th>Task Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Description</th>
				<th>Severity</th>
				<th>User id</th>
				<th>select task</th>
			</tr>
			<c:forEach items="${tasks}" var="task">
				<tr>

					<td>${task.id}</td>
					<td>${task.taskname}</td>
					<td>${task.startdate}</td>
					<td>${task.enddate}</td>
					<td>${task.description}</td>
					<td>${task.severity}</td>
					<td>${task.user.userid}</td>
					<td><input type="radio" name="selected" value="${task.id}" ></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Update" onclick="form.action='${pageContext.request.contextPath}/update';">
		&nbsp;
		<input type="submit" value="Delete" onclick="form.action='${pageContext.request.contextPath}/delete';">
		</form>
		
	</div>
	&nbsp;
		<a href="/logout">
			<button>logout</button>
		</a>&nbsp;&nbsp;
		<a href="/">
			<button>Back to Home</button>
		</a>
</body>
</html>