<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<%	String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./homePage">Home</a><br>
	<br><br>
	<fieldset>
		<legend style="background: navy; color: white;">Search Employee</legend>
		<form action="./deleteProduct" method="get">
			<table border="1">
				<tr>
					<td>Enter Product ID</td>
					<td> : </td>
					<td><input type="number" name="productId" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br>
						<input type="submit" value="Delete">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
	<br>
	<% if (msg != null && !msg.isEmpty()) { %>
		<h3 style="color: red;"><%=msg%></h3>
	<% } %>
</body>
</html>