<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/movie.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reviews</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ReviewListBean"></jsp:useBean>
	<jsp:setProperty property="userId" name="rb" value="${lb.user.userId}"/>
	<jsp:setProperty property="type" name="rb" param="type"/>
	${rb.fetchData()}
	<div class="container">
		<div class="jumbotoron">
		<h3 class="display-4">Hello ${lb.user.firstName} ${lb.user.lastName} </h3>
		<hr class="my-4">
		<a href="ctl?page=review&type=all" class="btn btn-link">All Reviews</a> | <a href="ctl?page=review&type=my" class="btn btn-link">My Reviews</a> | <a href="ctl?page=review&type=share" class="btn btn-link">Shared Reviews</a>
		<hr class="my-4"> 
		<div class="table-responsive">
			<table class="table">
				<thead class="thead-light">
					<tr>
				      <th scope="col">Id</th>
				      <th scope="col">Movie Title</th>
				      <th scope="col">Rating</th>
				      <th scope="col">Review</th>
				      <th scope="col">Action</th>
				    </tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="c" items="${rb.reviewList}">
							<tr>
								<td>${c.reviewId}</td>
								<td>
								<m:title movieId="${c.movieId}"/>
								</td>
								<td>${c.rating}</td>
								<td>${c.review}</td>
								<c:choose>
									<c:when test="${c.userId==lb.user.userId}">
									<td>
										<a class="btn btn-success" href="ctl?page=editreview&id=${c.reviewId}">Edit</a>
										<a class="btn btn-danger" href="ctl?page=deletereview&id=${c.reviewId}" role="button">Delete</a>
										<a class="btn btn-warning" href="ctl?page=sharereview&id=${c.reviewId}" role="button">Share</a>
									</td>
									</c:when>
									<c:otherwise><td>---</td></c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<a class="btn btn-success" href="ctl?page=newreview" role="button">Add Review</a>
		<a class="btn btn-danger" href="ctl?page=logout" role="button">Sign Out</a>
		</div>
		
	
		<div class="alert alert-primary col-sm-8 mt-2" role="alert">
  			${param.arbMessage}
			${param.urbMessage }
		</div>
		<div class="alert alert-danger col-sm-8 mt-2" role="alert">
			${param.drbMessage }
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>