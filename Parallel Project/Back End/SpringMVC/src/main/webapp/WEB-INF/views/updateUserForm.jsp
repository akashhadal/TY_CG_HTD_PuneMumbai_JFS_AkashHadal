<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page session="false"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User Form</title>
</head>
<body>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3>
		<%=msg%>
	</h3>
	<%
		}
	%>
	
	<fieldset>
		<legend>Update User</legend>
		<form action="./updateUser" method="post">
			<table>
				<tr>
					<td>User Id</td>
					<td>:</td>
					<td><input type="number" name="userId"></td>
				</tr>
				<tr>
					<td>User name</td>
					<td>:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>User Mail</td>
					<td>:</td>
					<td><input type="email" name="userEmail" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="userPassword" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Update"></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>