package com.sunbeam.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.pojo.Movie;

public class MovieTitleTag extends SimpleTagSupport {
	
	private int movieId;
	
	public MovieTitleTag() {
	
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
	
		Movie movie=null;
		try(MovieDao mDao=new MovieDaoImpl())
		{
			movie=mDao.findById(movieId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		PageContext pageContext= (PageContext)this.getJspContext();
		
		JspWriter out= pageContext.getOut();
		
		if(movie!=null)
		{
			out.println(movie.getTitle());
		}
	}
}
