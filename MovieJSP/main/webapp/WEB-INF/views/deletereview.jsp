<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete review</title>
</head>
<body>
	<jsp:useBean id="drb" class="com.sunbeam.beans.DeleteReviewBean"></jsp:useBean>
	<jsp:setProperty property="reviewId" name="drb" param="id"/>
	${drb.deleteReview() }
	<c:redirect url="/ctl">
	    <c:param name="page" value="review" />
	    <c:param name="type" value="all" />
	    <c:param name="arbMessage" value="${drb.message}" />
	</c:redirect>

</body>
</html>