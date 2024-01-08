package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.pojo.Movie;

public class MovieListBean {
	private List<Movie> movieList;
	
	public MovieListBean() {
		this.movieList=new ArrayList<Movie>();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public void fetchMovies()
	{
		try(MovieDao mDao=new MovieDaoImpl())
		{
			movieList=mDao.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
