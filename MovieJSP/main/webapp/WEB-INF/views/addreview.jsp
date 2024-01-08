<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add review</title>
</head>
<body>
	<jsp:useBean id="arb" class="com.sunbeam.beans.AddReviewBean"></jsp:useBean>
	<jsp:setProperty property="*" name="arb" />
	${arb.addReview() }
	
	<c:url var="redirectUrl" value="ctl">
	    <c:param name="page" value="review" />
	    <c:param name="type" value="all" />
	    <c:param name="arbMessage" value="${arb.message}" />
	</c:url>

	<c:redirect url="${redirectUrl}" />
	
	<%--<c:redirect url="ctl?page=review?type=all">
		<c:param name="arbMessage" value="${arb.message}"></c:param>
	</c:redirect>--%>
</body>
</html>