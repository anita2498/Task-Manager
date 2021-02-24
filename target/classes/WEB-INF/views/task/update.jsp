<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update task</title>
</head>
<style>
th {
  background-color: #4CAF50;
  color: white;
}
.button {
  transition-duration: 0.4s;
}

.button:hover {
  background-color: #4CAF50; /* Green */
  color: white;
}
</style>
<body>
${msg}
<div align="center">
		<form action="updateconf" method="post" ><!-- modelAttribute="task" -->
		<a href="/logout"> <button class="button">logout</button> </a>&nbsp;&nbsp;
		<a href="/"><button class="button">Back to Home</button></a>
		<br />
		<br />
			<table style="width: 75%">
				<tr>
					<th> Task Id </th>
					<th>Task Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Description</th>
					<th>Severity</th>
					<th>User id</th>

				</tr>

				<tr>

				<td><input type="text" name="id" id="id" value="${task.id}"
					readonly /></td>
				<td><input type="text" name="taskname" id="taskname"
					value="${task.taskname}"  /></td>
				<td><input type="Date" name="startdate" id="startdate"
					value="${task.startdate}"  /></td>
				<td><input type="Date" name="enddate" id="enddate"
					value="${task.enddate}"  /></td>
				<td><input type="text" name="description" id="enddate"
					value="${task.description}" /></td>
					<td><select name="severity" id="severity" >
							<option value="${task.severity}">Current : ${task.severity}</option>
							<option value="HIGH">HIGH</option>
							<option value="MEDIUM">MEDIUM</option>
							<option value="LOW">LOW</option>
					</select></td>
				<td><input type="text" name="user.userid" id="user.userid"
					value="${task.user.userid}"  readonly/></td>

			</tr>

			</table>
			<input type="submit" value="update" />
			
			
		</form>
	</div>
&nbsp;
		
</body>
</html>