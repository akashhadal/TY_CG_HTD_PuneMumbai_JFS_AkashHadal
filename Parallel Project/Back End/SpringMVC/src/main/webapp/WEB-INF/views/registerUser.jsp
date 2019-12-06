<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3><%=msg%></h3>
	<%
		}
	%>
	<fieldset>
		<legend>Register User</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>User Id</td>
					<td>:</td>
					<td><input type="text" name="userId" ></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td>:</td>
					<td><input type="text" name="userName" ></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="text" name="userEmail" ></td>
				</tr>
				
				<tr>
					<td>User Password</td>
					<td>:</td>
					<td><input type="password" name="userPassword" ></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Register"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>