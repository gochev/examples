<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit submission</title>
</head>
<body>
	<form:form modelAttribute="submission" method="post" action="/submit">
		<fieldset>
        <dl>
            <dt>
                <label for="title">Title</label>
            </dt>
            <dd>
                <form:input path="title" />
                <form:errors path="title"/>
            </dd>
        </dl>
         <dl>
            <dt>
                <label for="headline">Headline</label>
            </dt>
            <dd>
                <form:input path="headline" />
            </dd>
        </dl>
        <dl>
            <dt>
                <label for="description">Abstract</label>
            </dt>
            <dd>
                <form:textarea path="description"  style="width:80%" rows="5"/>
            </dd>
        </dl>
        <dl>
            <dt>
                <label for="level">Session level</label>
            </dt>
            <dd>
                <form:select path="level" items="${levels}"/>
            </dd>
        </dl>
        <dl>
            <dt>
                <label for="email">Email</label>
            </dt>
            <dd>
                <form:input path="email" />
            </dd>
        </dl>
        <dl>
            <dt>
                <label for="speaker">speaker</label>
            </dt>
            <dd>
                <form:input path="speaker" />
            </dd>
        </dl>
        <dl>
            <dt>
                <label for="bio">Bio</label>
            </dt>
            <dd>
                <form:textarea path="bio" style="width:80%" rows="5" />
            </dd>
        </dl>
        <button type="submit">Submit</button>
    </fieldset>
	</form:form>
</body>
</html>

