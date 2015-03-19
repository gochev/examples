<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="article" method="post"
		action="/admin/article/add">
		<fieldset>
			<legend>Add/Edit Article</legend>
			<p>
				<form:errors />
			</p>
			<dl>
				<dt>
					<label for="title">Title</label>
				</dt>
				<dd>
					<form:input path="title" />
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="content">Content</label>
				</dt>
				<dd>
					<form:textarea path="content" cols="70" rows="20" />
				</dd>
			</dl>
			<form:hidden path="id" />
			<sec:csrfInput />
			<button type="submit">Save</button>
		</fieldset>

	</form:form>
</body>
</html>