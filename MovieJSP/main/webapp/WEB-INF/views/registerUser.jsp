<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register user</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterUserBean"></jsp:useBean>
	<jsp:setProperty property="*" name="rb"/>
	
	<%rb.addUser(); %>
	<%
		if(rb.getStatus())
			out.println("User registered Successfully");
		else
			out.println("Something happen wrong");
	%>
</body>
</html>