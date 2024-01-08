package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;

public class ShareReviewBean {
	public int reviewId;
	public int userId;
	
	public ShareReviewBean() {
	
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void shareReview()
	{
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			rDao.shareReview(reviewId,userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
