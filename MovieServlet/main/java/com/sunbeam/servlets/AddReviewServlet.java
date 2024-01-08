package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Review;
import com.sunbeam.pojo.User;

@WebServlet("/addReviewServlet")
public class AddReviewServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mId=req.getParameter("movies");
		String rat=req.getParameter("rating");
		
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("curUser");
		
		int userId=user.getUserId();
		int rating=Integer.parseInt(rat);
		int movieId=Integer.parseInt(mId);
		String description=req.getParameter("review");
		
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			Review review=new Review(0,movieId,description,rating,userId,null);
			int cnt=rDao.save(review);
			if(cnt==1)
			{
				resp.sendRedirect("reviews");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

