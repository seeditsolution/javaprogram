package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Log_out extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			HttpSession session=request.getSession();
    		//session.setAttribute("message","You are successfully log out!!!");
    		session.invalidate();
    		response.sendRedirect("signin.jsp");
    		
			
			
		
	}
}
