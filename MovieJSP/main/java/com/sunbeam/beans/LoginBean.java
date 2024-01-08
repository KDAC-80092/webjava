package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	
	

	public LoginBean() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate()
	{
		User u;
		try(UserDao uDao=new UserDaoImpl())
		{
			u=uDao.findByEmail(email);
			if(u!=null && u.getPassword().equals(passwd))
			{	
				this.user=u;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
