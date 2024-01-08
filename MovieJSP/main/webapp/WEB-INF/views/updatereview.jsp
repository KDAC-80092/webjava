<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update review</title>
</head>
<body>
	<jsp:useBean id="urb" class="com.sunbeam.beans.UpdateReviewBean"></jsp:useBean>
	<jsp:setProperty property="*" name="urb"/>
	${urb.updateReview() }
	
	<jsp:forward page="ctl?page=review&type=all">
		<jsp:param value="${urb.message }" name="urbMessage"/>
	</jsp:forward>
</body>
</html>