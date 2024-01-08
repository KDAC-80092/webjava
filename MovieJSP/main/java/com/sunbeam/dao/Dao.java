package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.utils.DbUtil;

public class Dao implements AutoCloseable{
	protected Connection con;
	
	public Dao() throws SQLException 
	{
		con=DbUtil.getConnection();
	}
	
	@Override
	public void close() {
		try {
			if(con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
