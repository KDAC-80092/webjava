package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Review;
import com.sunbeam.pojo.User;

@WebServlet("/reviews")
public class ReviewsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("curUser");
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Reviews</title></head>");
		out.println("<body>");
		out.printf("<h3>Hello,%s %s</h3>",user.getFirstName(),user.getLastName());
		out.println("<hr></hr>");
		out.println("<a href='reviews?type=allreviews'>All reviews</a> | <a href='reviews?type=myreviews'>My Reviews</a> | <a href='reviews?type=sharedreviews'>Shared Reviews</a>");
		out.println("<hr></hr>");
		String type=req.getParameter("type");
		if(type.equals("allreviews"))
		{
			out.println("<h3>All Reviews</h3>");
		}
		else if(type.equals("myreviews"))
		{
			out.println("<h3>My Reviews</h3>");
		}
		else if(type.equals("sharedreviews"))
		{
			out.println("<h3>Shared Reviews</h3>");
		}
		
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<th>ID</th>");
		out.println("<th>Movie</th>");
		out.println("<th>Rating</th>");
		out.println("<th>Review</th>");
		out.println("<th>Actions</th>");
		out.println("</thead>");
		out.println("<tbody>");
		
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			List<Review> rlist=null;
			if(type.equals("allreviews"))
			{
				rlist=rDao.findAll();
			}
			else if(type.equals("myreviews"))
			{
				rlist=rDao.findByUserId(user.getUserId());
			}
			else if(type.equals("sharedreviews"))
			{
				rlist=rDao.getSharedWithUser(user.getUserId());
			}
				try(MovieDao mDao=new MovieDaoImpl())
				{
					for(Review r:rlist)
					{
						out.printf("<tr>");
						out.printf("<td>%d</td>",r.getReviewId());
						out.printf("<td>%s</td>",mDao.findById(r.getMovieId()).getTitle());
						out.printf("<td>%d</td>",r.getRating());
						out.printf("<td>%s</td>",r.getReview());
						out.printf("<td>");
							if(r.getUserId()==user.getUserId())
							{	
								out.printf("<a href='reviewedit?id=%s&userid=%s'><img src='edit.png' width='28' height='28' alt='edit' /></a>",r.getReviewId(),r.getUserId());
								out.printf("<a href='reviewedelete?id=%s'><img src='delete.png' width='28' height='28' alt='delete' /></a>",r.getReviewId());
								out.printf("<a href='reviewshare?id=%s&userid=%s'><img src='share.png' width='28' height='28' alt='share' /></a>",r.getReviewId(),r.getUserId());
							}
							else
							{
								out.printf("---");
							}
						out.printf("</td>");
						out.println("</tr>");
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		out.println("</tbody>");
		out.println("</table>");
		String msg=(String)req.getAttribute("message");
		if(msg!=null)
			out.printf("<h3>%s</h3>",msg);
		out.println("<a href='newReview'>Add Review</a> <span>      </span>");
		out.println("<a href='logOut'>SignOut</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
