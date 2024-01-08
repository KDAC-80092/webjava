<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<title></title>
</head>
<body>	
	<jsp:useBean id="ub" class="com.sunbeam.beans.UserListBean"></jsp:useBean>
	<jsp:setProperty property="reviewId" name="ub" param="id"/>
	${ub.getUsers()}
	
	<div class="container">
		<div class="jumbotoron">
			<h3 class="display-4">Share review</h3>
			<hr class="my-4">
			<form method="post" action="ctl?page=share">
				<label for="reviewId" class="col-sm-2">Review Id:</label>
				<div class="col-sm-4 mt-1">
					<input type="number" class="form-control col-sm-10 mt-1" id="reviewId" name="reviewId" value="${ub.reviewId}" readOnly>
				</div>
				<label for="userId" class="col-sm-2" >Users</label>
				<div class="col-sm-4">
					<select class="form-select mt-1" name="userId">
						<c:forEach var="u" items="${ub.list}">
							<option value="${u.userId }" name="userId">${u.firstName} ${u.lastName}</option>
						</c:forEach>
					</select>
				</div>
					<button type="submit" class="mt-2 btn btn-success">Share Review</button>
			</form>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>