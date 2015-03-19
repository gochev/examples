<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>Articles</legend>
		<table class="admin-table">
			<tr>
				<td><i>Title</i></td>
				<td><i>Content</i></td>
				<td><i>Operations</i></td>
			</tr>
			<c:forEach var="article" items="${articles.content}">
				<tr>
					<td>${article.title}</td>
					<td>${article.content }</td>
					<td>
						<span style="float:left;"><a href="/admin/article/edit/${article.id}">Edit</a></span> &nbsp; 
						<span style="float:right;"><a href="/admin/article/remove/${article.id}"> Remove </a></span> 
					</td>
				</tr>
			</c:forEach>
		</table>
		&nbsp;
		<div>
			<a href="/admin/article/add">Add</a>
		</div>
	</fieldset>
</body>
</html>