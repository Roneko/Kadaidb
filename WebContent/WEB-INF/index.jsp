<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Person"%>
	<%@ page import="java.util.List"%>
<%
List<Person> personList = (List<Person>) request.getAttribute("PersonLists");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PersonLists</title>
</head>
<body>
<h1>一覧</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>年齢</th>
		</tr>
		<% for(int i=0;i<personList.size();i++) {
			Person person = (Person)personList.get(i); %>
		<tr>
			<td><a href="<%= request.getContextPath() %>/show?id=<%= person.getId() %>"><%= person.getId() %></a></td>
	 		<td><%= person.getName() %></td>
			<td><%= person.getAge() %></td>
		</tr>
		<% } %>
	</table>
	<p>
		<!-- ↓前の値がいらないので直接jspを指定する。servletは経由しない -->
		<a href="<%= request.getContextPath() %>/new.jsp">新規登録</a>
	</p>
</body>
</html>