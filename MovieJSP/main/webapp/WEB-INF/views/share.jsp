<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>share jsp</title>
</head>
<body>
	<jsp:useBean id="srb" class="com.sunbeam.beans.ShareReviewBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="srb" />
	${srb.shareReview() }
	
	<c:redirect url="ctl?page=review&type=all"></c:redirect>
</body>
</html>