<%@ page trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="en">
<body>
	Your Articles: 
	<c:forEach var="article" items="${articles}">
		<p>
			<c:out value="${article.title}"/> <br/>
			<c:out value="${article.content}"/>
		</p>
	</c:forEach>
</body>
</html>