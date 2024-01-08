package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ctl")
public class FrontController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page=req.getParameter("page");
		String jspPath="";
		if(page.equals("index"))
			jspPath="/WEB-INF/views/index.html";
		else if(page.equals("login"))
			jspPath="/WEB-INF/views/login.jsp";
		else if(page.equals("register"))
			jspPath="/WEB-INF/views/register.html";
		else if(page.equals("review"))
			jspPath="/WEB-INF/views/review.jsp";
		else if(page.equals("newreview"))
			jspPath="/WEB-INF/views/newreview.jsp";
		else if(page.equals("addreview"))
			jspPath="/WEB-INF/views/addreview.jsp";
		else if(page.equals("logout"))
			jspPath="/WEB-INF/views/logout.jsp";
		else if(page.equals("editreview"))
			jspPath="/WEB-INF/views/editreview.jsp";
		else if(page.equals("deletereview"))
			jspPath="/WEB-INF/views/deletereview.jsp";
		else if(page.equals("sharereview"))
			jspPath="/WEB-INF/views/sharereview.jsp";
		else if(page.equals("updatereview"))
			jspPath="/WEB-INF/views/updatereview.jsp";
		else if(page.equals("newreview"))
			jspPath="/WEB-INF/views/newreview.jsp";
		else if(page.equals("registerUser"))
			jspPath="/WEB-INF/views/registerUser.jsp";
		else if(page.equals("registerUser"))
			jspPath="/WEB-INF/views/registerUser.jsp";
		else if(page.equals("share"))
			jspPath="/WEB-INF/views/share.jsp";
		else if(page.equals("unauthenticated"))
			jspPath="unauthenticated.jsp";
		
		ServletContext ctx=this.getServletContext();
		RequestDispatcher rd=ctx.getRequestDispatcher(jspPath);
		rd.forward(req, resp);
	}
}
