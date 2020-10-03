package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
		try {
			Connection con = Jdbcconnection.initializeDatabase();
		    String log=request.getParameter("loginid");
		    String pass=request.getParameter("password");
		
		    PreparedStatement ps=(PreparedStatement) con.prepareStatement
    	    		("select id,name,password from Register_table where Login_id=? and Password=?");
			/*
			 * (select Register_table.id,login_id,password from Register_table left join
			 * orders on Register_table.rid = Note.id;)
			 */
          
           ps.setString(1,log);
           ps.setString(2,pass);
             ResultSet rs=ps.executeQuery();
            if(rs.next())
            {	
            	int  id=rs.getInt(1); 
            	String name=rs.getString(2);
            	HttpSession session=request.getSession(); 
        		session.setAttribute("login_id",log);
        		session.setAttribute("password",pass);
        		session.setAttribute("id",id);
        		session.setAttribute("current-user",name);
        		
        		response.sendRedirect("home.jsp");
        		//request.getRequestDispatcher("navbar.jsp").include(request, response);
            }
            else 
           {            	
            	HttpSession session=request.getSession(); 
        		session.setAttribute("message","Sorry,Please Enter valid username or password !!!");
        		response.sendRedirect("index.jsp");
    			return;
    			
                 
           }
		   
            }
		catch (Exception e) {e.printStackTrace();};
	} 
		}


