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
<title>Insert title here</title>
</head>
<body>
<a href="./homePage">Home</a><br>
	<fieldset>
		<legend style="background: navy; color: white;">User Reply</legend>
		<form action="./adminQueryForm" method="post">
			<table border="1">
				<tr>
					<td>Enter User ID</td>
					<td>:</td>
					<td><input type="number" name="userId" required></td>
				</tr>
				<tr>
					<select name="type">
					<option value="Question">Question</option>
						<option value="Answer">Answer</option>
					</select>
				</tr>
				<tr>
					<td>Enter message</td>
					<td>:</td>
					<td><input type="text" name="message" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Question"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<br>
	<br>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=msg%></h3>
	<%
		}
	%>
</body>
</html>