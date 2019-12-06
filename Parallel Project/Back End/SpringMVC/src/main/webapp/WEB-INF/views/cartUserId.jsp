<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./homePage">Home</a><br>
<a href="./cartForm">cart</a>
	<br><br>
	<fieldset>
		<legend style="background: navy; color: white;">Cart User Id</legend>
		<form action="./cartDetails" method="get">
			<table border="1">
				<tr>
					<td>Enter user ID</td>
					<td> : </td>
					<td><input type="number" name="userId" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br>
						<input type="submit" value="Cart">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>