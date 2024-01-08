package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;

@WebServlet("/reviewedelete")
public class DeleteReviewServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int rId=Integer.parseInt(id);
		int cnt=0;
		try(ReviewDao rDao=new ReviewDaoImpl())
		{
			cnt=rDao.deleteById(rId);
		}catch(Exception e)
		{
			throw new ServletException(e);
		}
		String message="Review Deleted:"+cnt;
		req.setAttribute("message", message);
		
		RequestDispatcher rd=req.getRequestDispatcher("reviews");
		rd.forward(req, resp);
	}
}
