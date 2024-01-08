package com.sunbeam.pojo;

public class Movie {
	private int movieId;
	private String title;
	private String releaseDate;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int movieId, String title, String releaseDate) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", releaseDate=" + releaseDate + "]";
	}
	
}
