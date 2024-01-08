<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Jsp</title>

</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"></jsp:useBean>
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="passwd" param="passwd"/>
	
	${lb.authenticate()} 
	<c:choose>
	<c:when test="${empty lb.user}">
		Invalid Password or email.<br>
		<a href="ctl?page=index">Login Again</a>
	</c:when>
	<c:otherwise>
		<c:redirect url="ctl?page=review&type=all"></c:redirect>
	</c:otherwise>
	</c:choose>
</body>
</html>