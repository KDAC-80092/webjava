package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

public class RegisterUserBean {
	private String firstName;
	private String lastName;
	private String email;
	private String passwd;
	private String mobile;
	private String dob;
	private boolean status;
	
	public RegisterUserBean() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void addUser()
	{
		User user=new User(0,firstName,lastName,email,passwd,mobile,dob);
		try(UserDao uDao=new UserDaoImpl())
		{
			int cnt=uDao.save(user);
			if(cnt==1)
			{
				this.status=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
