<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>名前の情報</title>
</head>

<body>
	<h1>名前の情報</h1>
	<form method = "POST" action = "<%= request.getContextPath() %>/new">
		<p>名前:<input type="text" name ="name"></p>
		<p>年齢:<input type="text" name="age"></p>
		<input type="submit" value="登録">
	</form>
	<p>
		<a href="<%= request.getContextPath() %>/index">戻る</a>
	</p>
</body>
</html>