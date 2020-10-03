package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.enti.Register_table;
import com.helper.FactoryProvider;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String log=request.getParameter("loginid");
		String pass=request.getParameter("password");
		
       
		Register_table reg=new Register_table(name,email,log,pass);
		
		//hibernate:save()
		Session s= FactoryProvider.getfactory().openSession();
		Transaction tx =s.beginTransaction();
		
		s.save(reg);
		tx.commit();
		s.close(); 
           
           response.sendRedirect("index.jsp");
	
		} catch (Exception e) {e.printStackTrace();}  
	}
}
