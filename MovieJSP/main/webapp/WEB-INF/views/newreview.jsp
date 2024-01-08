<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Review</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

	<jsp:useBean id="mlb" class="com.sunbeam.beans.MovieListBean"></jsp:useBean>
	${mlb.fetchMovies()}
	<div class="container" >
		<div class="jumbotoron">
			<h3 class="display-4">Hello ${lb.user.firstName} ${lb.user.lastName} </h3>
			<hr class="my-4">
			<form method="post" action="ctl?page=addreview">
			<div class="mt-2 form-group">
			<input type="hidden" name="userId" value="${lb.user.userId }">
			<label for="movie" class="col-sm-2">Movie:</label>
				<div class="col-sm-4">
					<select class="form-select mt-1" name="movieId">
					  <c:forEach var="c" items="${mlb.movieList}">
					  	<option value="${c.movieId}" name="movieId">${c.title}</option>
					  </c:forEach>
					</select>
				</div>
				<label for="rating" class="col-sm-2">Rating:</label>
				<div class="col-sm-4 mt-1">
					<input type="number" class="form-control col-sm-10 mt-1" id="rating" name="rating" placeholder="enter rating">
				</div>
				<label for="review" class="col-sm-2 mt-1">Review:</label>
				<div class="col-sm-4">
					<textarea class="form-control col-sm-10 mt-1" row="3" id="review" name="review" placeholder="enter review"></textarea>
				</div>
				<button type="submit" class="mt-2 btn btn-success">Add Review</button>
			</div>
			</form>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>