<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com./jsp/jstl/core" prefix="c" %>
<h1>Search Email</h1>
	<form action="/search">
		<label>Search Email::</label>
		<input type="text" id="email" name="email">
		<button type="submit">Search</button>
	</form>
<c:choose>
	<c:when test="${!empty list }">
		<c:forEach var="email" items="${list}">
			${email}
		</c:forEach>
	</c:when>
</c:choose>

