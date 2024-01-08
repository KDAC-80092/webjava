<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log Out</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

	 <div class="container mt-5">
    	<div class="card text-center mx-auto" style="max-width: 400px;">
      	<div class="card-header">
      		<% session.invalidate(); %>
        	Logout Successful
      	</div>
      	<div class="card-body">
        	<p class="card-text">Thank you </p>
        	<a href="ctl?page=index" class="btn btn-primary">Login Again</a>
      </div>
    </div>
  </div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>