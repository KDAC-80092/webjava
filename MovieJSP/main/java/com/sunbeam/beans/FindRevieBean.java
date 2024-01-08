package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Review;

public class FindRevieBean {
	private int reviewId;
	private Review review;
	
	public FindRevieBean() {
		this.review=null;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	public void findReview()
	{
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			this.review=rDao.findById(reviewId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
