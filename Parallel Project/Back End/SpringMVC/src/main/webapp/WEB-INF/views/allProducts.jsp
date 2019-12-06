<%@page import="java.util.List"%>
<%@page import="com.capgemini.springmvc.medicalshop.beans.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%
	List<ProductBean> productList = (List<ProductBean>) request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
      table, th, td {
      padding: 10px;
      border: 1px solid black; 
      border-collapse: collapse;
      text-align: center;
      }
      td:hover {
	 background-color: black;
	 color: white;
}
 th {
	 background-color: lightgreen;
	 color: blue;
}
    </style>
</head>
<body>
	<a href="./homePage">Home</a>
	<br>
	<br>
	<%
		if (productList != null && !productList.isEmpty()) {
	%>
	<div align="center">
		<table>
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>Price</th>
			</tr>
			<%
				for (ProductBean bean : productList) {
			%>
			<tr>
				<td><%=bean.getProductId()%></td>
				<td><%=bean.getProductName()%></td>
				<td><%=bean.getCategory()%></td>
				<td><%=bean.getPrice()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<%
		} else {
	%>
	<h3 style="color: red;">Unable To Fetch Records!!!</h3>
	<%
		}
	%>
</body>
</html>