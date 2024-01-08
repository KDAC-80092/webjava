package com.sunbeam.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.sunbeam.beans.LoginBean;

@WebFilter("/ctl")
public class SecurityFilter implements Filter {



	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		LoginBean lb=null;
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String page=req.getParameter("page");
		
		//allow index and login page for all users
		if((page.equals("index") || page.equals("login") || page.equals("register"))) {
					chain.doFilter(req, res);
					return;
		}
		
		HttpSession session=req.getSession();
		
		lb=(LoginBean)session.getAttribute("lb");
		
		if (!(page.equals("index") || page.equals("login"))) {
		    if (lb == null || lb.getUser() == null) {
		        // Redirect before any content is written to the response
		        res.sendRedirect("unauthenticated.jsp");
		        return; // Return to stop further processing
		    }
		}
		if(lb==null)
		{
			res.sendRedirect("ctl?page=unauthenticated");
		}
		chain.doFilter(req, res);
	}


}
