package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.User;
import com.sunbeam.utils.DateTimeUtil;

public class UserDaoImpl extends Dao implements UserDao{

	public UserDaoImpl() throws Exception
	{

	}

	@Override
	public int save(User u) throws Exception {
		int count=0;
		String query="INSERT INTO users values(default,?,?,?,?,?,?)";
		try(PreparedStatement pstmt= con.prepareStatement(query))
		{
			pstmt.setString(1, u.getFirstName());
			pstmt.setString(2, u.getLastName());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getMobile());
			pstmt.setDate(6, DateTimeUtil.stringToSqlDate(u.getDob()));
			
			count=pstmt.executeUpdate();
		}
		return count;
	}

	@Override
	public int update(User u) throws Exception {
		String sql = "UPDATE users SET first_name=?, last_name=?, mobile=?, dob=? WHERE user_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getMobile());
			stmt.setDate(4, DateTimeUtil.stringToSqlDate(u.getDob()));
			stmt.setInt(5, u.getUserId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}

	@Override
	public int updatePassword(int userId, String newPassword) throws Exception {
		String sql="UPDATE users SET password=? WHERE user_id=?";
		try(PreparedStatement pstm=con.prepareStatement(sql)){
			pstm.setString(1, newPassword);
			pstm.setInt(2, userId);
			int count=pstm.executeUpdate();
			return count;
		}
	}

	@Override
	public User findByEmail(String email) throws Exception {
		String sql="SELECT * FROM users WHERE email=?";
		User u=null;
		try(PreparedStatement pstmt=con.prepareStatement(sql))
		{
			pstmt.setString(1, email);
			try(ResultSet rs=pstmt.executeQuery())
			{
				while(rs.next())
				{
					int userId=rs.getInt("user_id");
					String first_name=rs.getString("first_name");
					String last_name=rs.getString("last_name");
					email=rs.getString("email");
					String password=rs.getString("password");
					String mobile=rs.getString("mobile");
					java.util.Date date=new java.util.Date(rs.getDate("dob").getTime());
					String sdate=DateTimeUtil.utilDateToString(date);
					u=new User(userId,first_name,last_name,email,password,mobile,sdate);	
				}
			}
		}
		return u;
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> list=new ArrayList<>();
		User u=null;
		String query="SELECT * FROM users";
		try(PreparedStatement pstmt=con.prepareStatement(query))
		{
			try(ResultSet rs=pstmt.executeQuery())
			{
				while(rs.next())
				{
					int userId=rs.getInt("user_id");
					String first_name=rs.getString("first_name");
					String last_name=rs.getString("last_name");
					String email=rs.getString("email");
					String password=rs.getString("password");
					String mobile=rs.getString("mobile");
					java.util.Date date=new java.util.Date(rs.getDate("dob").getTime());
					String sdate=DateTimeUtil.utilDateToString(date);
					u=new User(userId,first_name,last_name,email,password,mobile,sdate);
					list.add(u);
				}
			}
		}
		return list;
	}
}
