package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Review;
import com.sunbeam.utils.DateTimeUtil;

public class ReviewDaoImpl extends Dao implements ReviewDao {

	
	public ReviewDaoImpl() throws SQLException {
	}

	@Override
	public int save(Review r) throws Exception {
		String sql = "INSERT INTO reviews(review_id, movie_id, review, rating, user_id, modified) VALUES(default, ?, ?, ?, ?,now())";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getMovieId());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUserId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();	
	}

	@Override
	public int update(Review r) throws Exception {
		String sql = "UPDATE reviews SET movie_id=?, review=?, rating=?, user_id=?, modified=now() WHERE review_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getMovieId());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUserId());
			stmt.setInt(5, r.getReviewId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close
	}

	@Override
	public List<Review> findAll() throws Exception {
		List<Review> list = new ArrayList<Review>();
		String sql = "SELECT * FROM reviews ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("review_id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int userId = rs.getInt("user_id");
					String modified = DateTimeUtil.timeStampToString(rs.getTimestamp("modified"));
					Review r = new Review(id, movieId,review, rating,userId, modified);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public List<Review> findByUserId(int userId) throws Exception {
		List<Review> list = new ArrayList<Review>();
		String sql = "SELECT * FROM reviews WHERE user_id=? ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("review_id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					String modified = DateTimeUtil.timeStampToString(rs.getTimestamp("modified"));
					Review r = new Review(id, movieId,review ,rating, usrId,modified);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public List<Review> getSharedWithUser(int userId) throws Exception {
		List<Review> list = new ArrayList<Review>();
		String sql = "SELECT r.* FROM reviews r INNER JOIN shares s ON r.review_id=s.review_id WHERE s.user_id=? ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("review_id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					String modified = DateTimeUtil.timeStampToString(rs.getTimestamp("modified"));
					Review r = new Review(id, movieId, review,rating, usrId, modified);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public Review findById(int id) throws Exception {
		String sql = "SELECT * FROM reviews WHERE review_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					id = rs.getInt("review_id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					String modified = DateTimeUtil.timeStampToString(rs.getTimestamp("modified"));
					Review r = new Review(id, movieId, review,usrId, rating, modified);
					return r;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	@Override
	public int deleteById(int reviewId) throws Exception {
		String sql = "DELETE FROM reviews WHERE review_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			int count = stmt.executeUpdate();
			return count;
		}
	}

	@Override
	public int shareReview(int reviewId, int userId) throws Exception {
		String sql = "INSERT INTO shares(review_id, user_id) VALUES (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		}
		catch (SQLIntegrityConstraintViolationException e) {
			// do nothing
		}
		return 0;
	}

}
