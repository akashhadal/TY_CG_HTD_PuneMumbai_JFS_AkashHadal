<%@page import="com.capgemini.springmvc.medicalshop.beans.CartBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="false" %>

<%	List<CartBean> cartBeans = (List<CartBean>) request.getAttribute("cartBean");
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
<a href="./cartForm">cart</a>
		<table border="1">
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Delete</th>
			</tr>
			<%
				for (CartBean bean : cartBeans) {
			%>
			<tr>
				<td><%=bean.getUserId()%></td>
				<td><%=bean.getUserName()%></td>
				<td><%=bean.getProductId()%></td>
				<td><%=bean.getProductName()%></td>
				<td><%=bean.getPrice() %></td>
				<td><a href="delete">delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	<br>
	<br>
	<a href="./prodceedToPay">Proceed to Pay</a>
	<% if (msg != null && !msg.isEmpty()) { %>
		<h3 style="color: red;">Cart Empty!!!</h3>
	<% } %>
</body>
</html>