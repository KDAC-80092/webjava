package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

public class UserListBean {
	private int reviewId;
	private List<User> list;
	
	public UserListBean() {
		this.list=new ArrayList<User>();
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
	
	

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public void getUsers()
	{
		try(UserDao uDao = new UserDaoImpl())
		{
			this.list=uDao.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
