<%@page import="com.capgemini.springmvc.medicalshop.beans.MessageBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="false"%>
<%
	List<MessageBean> messagList = (List<MessageBean>) request.getAttribute("messageList");
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
</style>
</head>
<body>
	<a href="./homePage">Home</a>
	<br>
	<br>
	<%
		if (messagList != null && !messagList.isEmpty()) {
	%>
	<div align="center">
		<table>
			<tr>
				<th>User Id</th>
				<th>Message</th>

			</tr>
			<%
				for (MessageBean bean : messagList) {
			%>
			<tr>
				<td><%=bean.getUserId()%></td>
				<td><%=bean.getMessage()%></td>
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