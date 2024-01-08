package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Review;

public class ReviewListBean {
	private int userId;
	private String type;
	private List<Review> reviewList;
	
	public ReviewListBean() {
		this.reviewList=new ArrayList<Review>();
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void fetchData()
	{
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			if(this.type.equals("all"))
			{
				this.reviewList=rDao.findAll();
			}
			else if(this.type.equals("my"))
			{
				this.reviewList=rDao.findByUserId(userId);
			}
			else if(this.type.equals("share"))
			{
				this.reviewList=rDao.getSharedWithUser(userId);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
