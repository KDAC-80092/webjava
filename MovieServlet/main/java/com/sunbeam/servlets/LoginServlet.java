package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		try(UserDao uDao=new UserDaoImpl())
		{
			User user=uDao.findByEmail(email);
			if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password))
			{
				HttpSession session=req.getSession();
				session.setAttribute("curUser", user);
				resp.sendRedirect("reviews?type=allreviews");
			}
			else	
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html>");
				out.println("<head><title>Invalid login</title></head>");
				out.println("<body>");
				out.println("<h3>Invalid Login credentials</h3>");
				out.println("<a href='index.html'>login again</a>");
				out.println("</body>");
				out.println("</html>");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
