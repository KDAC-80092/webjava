package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.pojo.Movie;

@WebServlet("/newReview")
public class NewReviewServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req,resp);
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<head><title>Add review</title></head>");
			out.println("<body>");
			out.println("<form method='post' action='addReviewServlet'>");
			try(MovieDao mDao=new MovieDaoImpl())
			{
				List<Movie> list=mDao.findAll();
				out.println("<label for='movies'>Movie:</label>");
				out.println(" <select id='movie' name='movies'><br><br>");
				for(Movie m:list)
				{
					out.printf("<option value='%d'>%s</option>",m.getMovieId(),m.getTitle());
				}
				out.println("</select>");
				out.println("<br><br>");
				out.println("Rating: <input value='Rating' name='rating' type='number'/><br><br>");
				out.println("Review:<br><br>");	
				out.println("<textarea name='review' value='Rating' rows='5' cols='40'></textarea><br><br>");
				out.println("<input type='submit' value='Save'/>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new ServletException(e);
			}
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
}
