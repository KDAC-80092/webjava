package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Review;

public class UpdateReviewBean {
	private int reviewId;
	private int rating;
	private String review;
	private int userId;
	private int movieId;
	private String message;
	public UpdateReviewBean() {
	
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void updateReview()
	{
		Review r=new Review(reviewId, movieId, review, rating, userId, null);
		try(ReviewDao rDao=new ReviewDaoImpl())
		{	
			rDao.update(r);
			this.message="Review updated";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
