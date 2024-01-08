package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;

public class DeleteReviewBean {
	private int reviewId;
	private String message;
	
	public DeleteReviewBean() {
	
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void deleteReview()
	{
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			rDao.deleteById(reviewId);
			this.message="Review Deleted";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
