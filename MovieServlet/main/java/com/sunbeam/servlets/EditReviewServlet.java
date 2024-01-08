package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.Review;


@WebServlet("/reviewedit")
public class EditReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int rid=Integer.parseInt(id);
		String uid=req.getParameter("userid");
		int userId=Integer.parseInt(uid);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Edit review</title></head>");
		out.println("<body>");
		try(MovieDao mDao=new MovieDaoImpl()){
			List<Movie> list = mDao.findAll();
		out.println("<form method='post' action='reviewedit'>");
		out.printf("Review Id: <input type='text' name='reviewid' value='%d' readonly/><br><br>", rid);
		out.println("Movie:<select name='movie'>");
		for(Movie m:list)
			out.printf("<option value='%d'>%s</option>", m.getMovieId(), m.getTitle());
		out.println("</select><br><br>");
		out.printf("Rating: <input type='number' name='rating' /><br><br>");
		out.printf("User Id: <input type='number' name='userid' value='%d' readonly/><br><br>", userId);
		out.println("<textarea name='review' value='review' rows='5' cols='40'></textarea><br><br>");
		out.println("<input type='submit' value='Update'/>");
		out.println("</form>");
		
		}catch(Exception e)
		{
			throw new ServletException(e);
		}
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int reviewId=Integer.parseInt(req.getParameter("reviewid"));
		int userId=Integer.parseInt(req.getParameter("userid"));
		int rating=Integer.parseInt(req.getParameter("rating"));
		String review=req.getParameter("review");
		int movieId=Integer.parseInt(req.getParameter("movie")); 
		Review r=new Review(reviewId,movieId,review,rating,userId,null);
		System.out.println(reviewId+","+userId+","+rating+","+review+","+movieId);
		int cnt=0;
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			cnt=rDao.update(r);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		if(cnt==1)
		{
			String message="Review Updated Successfully";
			req.setAttribute("message", message);
			RequestDispatcher rd=req.getRequestDispatcher("reviews?type=allreviews");
			rd.forward(req, resp);
		}
	}
}
