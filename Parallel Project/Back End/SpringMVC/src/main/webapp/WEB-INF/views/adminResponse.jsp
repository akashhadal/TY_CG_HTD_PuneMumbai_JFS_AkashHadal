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
	<fieldset>
		<legend style="background: navy; color: white;">Search Admin Response</legend>
		<form action="./adminResponseForm" method="get">
			<table border="1">
				<tr>
					<td>Enter User Id</td>
					<td> : </td>
					<td><input type="number" name="userId" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br>
						<input type="submit" value="Search">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>