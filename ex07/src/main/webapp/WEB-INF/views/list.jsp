<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User List</title>
	<style>
		.title{background:gray;color:white;text-align:center;}
		.row{text-align:center;}
		.row:hover{background:gray;color:white;}
	</style>
</head>
<body>
	<h1>[User List]</h1>
	<table border=1>
		<tr class="title">
			<td width=100>User Id</td>
			<td width=100>User Password</td>
			<td width=100>User Name</td>
			<td width=100>User Point</td>
			<td width=150>Sent Message</td>
			<td width=150>Received Message</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class="row">
				<td width=100>${vo.uid}</td>
				<td width=100>${vo.upw}</td>
				<td width=100>${vo.uname}</td>
				<td width=100>${vo.point}</td>
				<td width=100><button onClick="location.href='send?uid=${vo.uid}'">Send Message</button></td>
				<td width=100><button onClick="location.href='receive?uid=${vo.uid}'"}>Received Message</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>