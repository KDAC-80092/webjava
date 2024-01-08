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

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

@WebServlet("/reviewshare")
public class ShareReviewServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id=req.getParameter("id");
			int rid=Integer.parseInt(id);
			int uid=Integer.parseInt(req.getParameter("userid"));
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<head><title>Edit review</title></head>");
			out.println("<body>");
			try(UserDao uDao=new UserDaoImpl()){
				List<User> list = uDao.findAll();
			out.println("<form method='post' action='reviewshare'>");
			out.printf("Review Id: <input type='text' name='reviewid' value='%d' readonly/>", rid);
			out.println("<select name='userid'>");
			for(User u:list) {
					if(u.getUserId()!=uid)
						out.printf("<option value='%d'>%s</option>", u.getUserId(), u.getFirstName());
			}
//				
			out.println("</select>");
			out.println("<input type='submit' value='Share'/>");
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
			int reviewId = Integer.parseInt(req.getParameter("reviewid"));
			int userId = Integer.parseInt(req.getParameter("userid"));
			try(ReviewDao rDao=new ReviewDaoImpl())
			{
				rDao.shareReview(reviewId, userId);
			}
			catch(Exception e)
			{
				throw new ServletException(e);
			}
			String message="Review Shared Successfully";
			req.setAttribute("message", message);
			RequestDispatcher rd=req.getRequestDispatcher("reviews?type=allreviews");
			rd.forward(req, resp);
		}
}
