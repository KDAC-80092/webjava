package com.sunbeam.dao;
import com.sunbeam.pojo.Movie;
import java.util.List;



public interface MovieDao extends AutoCloseable{
	public List<Movie> findAll() throws Exception;
	public Movie findById(int id) throws Exception;
}
