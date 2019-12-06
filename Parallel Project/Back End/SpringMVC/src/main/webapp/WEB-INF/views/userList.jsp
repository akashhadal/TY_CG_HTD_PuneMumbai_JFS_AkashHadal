<%@page import="com.capgemini.springmvc.medicalshop.beans.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>

<%
	List<UserBean> userList = (List<UserBean>) request.getAttribute("userList");
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
		if (userList != null && !userList.isEmpty()) {
	%>
	<div align="center">
		<table>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>User Email</th>
				<th>User Password</th>
			</tr>
			<%
				for (UserBean bean : userList) {
			%>
			<tr>
				<td><%=bean.getUserId()%></td>
				<td><%=bean.getUserName()%></td>
				<td><%=bean.getUserEmail()%></td>
				<td><%=bean.getUserPassword()%></td>
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