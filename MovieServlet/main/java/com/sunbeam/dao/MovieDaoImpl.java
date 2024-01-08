package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Movie;
import com.sunbeam.utils.DateTimeUtil;

public class MovieDaoImpl extends Dao implements MovieDao {

	public MovieDaoImpl() throws SQLException {
		
	}

	@Override
	public List<Movie> findAll() throws Exception {
		List<Movie> list=new ArrayList<>();
		Movie movie=null;
		String query="SELECT * FROM MOVIES";
		try(PreparedStatement pstmt=con.prepareStatement(query)){
			try(ResultSet rs=pstmt.executeQuery())
			{
				while(rs.next())
				{
					int movieId=rs.getInt("movie_id");
					String title=rs.getString("title");
					java.util.Date udate=new java.util.Date(rs.getDate("release_date").getTime());
					String date=DateTimeUtil.utilDateToString(udate);
					movie=new Movie(movieId,title,date);
					list.add(movie);
				}
			}
		}
		return list;
	}

	@Override
	public Movie findById(int id) throws Exception {
		Movie movie=null;
		String query="SELECT * FROM movies WHERE movie_id=?";
		try(PreparedStatement pstmt=con.prepareStatement(query))
		{
			pstmt.setInt(1, id);
			try(ResultSet rs=pstmt.executeQuery())
			{
				while(rs.next())
				{
					id=rs.getInt("movie_id");
					String title=rs.getString("title");
					java.util.Date udate=new java.util.Date(rs.getDate("release_date").getTime());
					String date=DateTimeUtil.utilDateToString(udate);
					movie=new Movie(id,title,date);
				}
			}
		}
		return movie;
	}

}
