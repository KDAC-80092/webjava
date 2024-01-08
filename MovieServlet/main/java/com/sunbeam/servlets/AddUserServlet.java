package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName=req.getParameter("firstname");
		String lastName=req.getParameter("lastname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobile=req.getParameter("mobile");
		String dob=req.getParameter("dob");
		User user=new User(0,firstName,lastName,email,password,mobile,dob);
		try(UserDao uDao=new UserDaoImpl())
		{
			uDao.save(user);
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<head><title>User Added</title></head>");
			out.println("<body>");
			out.println("<h3>User Added</h3>");
			out.println("<a href='index.html'>Login</a>");
			out.println("</body>");
			out.println("</html");
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
