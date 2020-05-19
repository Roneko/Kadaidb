<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Person"%>
<%
  //ここでリクエストスコープを受け取る
  //getAttributeメソッド
  //→追加した属性を取り出す setAttributeで設定してるのでgetAttributeでとる 何のクラスやねんとなるのでキャストで(Books)をしている
  Person person = (Person) request.getAttribute("person");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>名前の情報</title>
</head>

<body>
	<h1>名前の情報</h1>
	<form method = "POST" action = "<%= request.getContextPath() %>/update">
		<input type="hidden" name="id" value="<%=person.getId()%>">
		<p>id:<%=person.getId()%></p>
		<p>名前:<input type="text" name ="name" value="<%=person.getName()%>"></p>
		<p>年齢:<input type="text" name="age" value="<%=person.getAge()%>"></p>
		<input type="submit" value="更新">
	</form>
	<p>
		<a href="<%= request.getContextPath() %>/delete?id=<%=person.getId()%>">削除する</a>
	</p>
	<p>
		<a href="<%= request.getContextPath() %>/index">戻る</a>
	</p>
</body>
</html>