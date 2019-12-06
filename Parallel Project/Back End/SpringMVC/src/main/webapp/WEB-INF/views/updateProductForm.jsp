<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
	<% String msg=(String) request.getAttribute("msg"); %>
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
		<legend>Update Product</legend>
		<form action="./updateProduct" method="post">
			<table>
				<tr>
					<td>Product Id</td>
					<td>:</td>
					<td><input type="number" name="productId"></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>:</td>
					<td><input type="text" name="productName"></td>
				</tr>
				<tr>
					<td>Product Category</td>
					<td>:</td>
					<td><input type="text" name="category"></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td>:</td>
					<td><input type="number" name="price"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Update Product"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>