package com.sunbeam.pojo;

public class Review {
	 private int reviewId;
	 private int movieId ;
	 private String review;
	 private int rating;
	 private int userId;
	 private String modified;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int review_id, int movie_id, String review, int rating, int user_id, String modified) {
		super();
		this.reviewId = review_id;
		this.movieId = movie_id;
		this.review = review;
		this.rating = rating;
		this.userId = user_id;
		this.modified = modified;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int review_id) {
		this.reviewId = review_id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movie_id) {
		this.movieId = movie_id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + reviewId + ", movie_id=" + movieId + ", review=" + review + ", rating=" + rating
				+ ", user_id=" + userId + ", modified=" + modified + "]";
	}
	 
	
}
