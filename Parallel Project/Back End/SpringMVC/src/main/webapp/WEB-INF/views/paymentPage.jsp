<%@page import="com.capgemini.springmvc.medicalshop.beans.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<%
	Payment payment = (Payment) request.getAttribute("payment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./homePage">Home</a>
	<br>
	<br>
	<fieldset>
		<legend style="background: navy; color: white;">Cart</legend>
		<form action="./payment" method="get">
			<table>
				<tr>
					<td>Enter User Id</td>
					<td>:</td>
					<td><input type="number" name="userId" required></td>
				</tr>
				<tr>
					<td><select name="button">
							<option value="y">Yes</option>
							<option value="n">No</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Pay"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<br>
	
	
	<a href="./cartUserId">Cart Details</a>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=payment.getPrice()%></h3>
	<h3 style="color: red;"><%=payment.getPaymentStatus()%></h3>
	<%
		}
	%>
</body>
</html>