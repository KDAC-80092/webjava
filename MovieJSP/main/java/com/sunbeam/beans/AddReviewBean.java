package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Review;

public class AddReviewBean {
	public int userId;
	public int movieId;
	public int rating;
	public String review;
	public String message;
	public AddReviewBean() {
	
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public void addReview()
	{
		Review r=new Review(0, movieId, review, rating, userId, null);
		System.out.println(r);
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			rDao.save(r);
			this.message="Review added successfully";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
