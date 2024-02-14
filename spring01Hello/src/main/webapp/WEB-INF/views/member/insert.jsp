<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insert.jsp</h1>
	
	<form action="m_insertOK.do" method="post">
		<input type="text" name="name" value="kim길동">
		<input type="number" name="age" value="33">
		<input type="submit"  value="send">
	</form>
</body>
</html>