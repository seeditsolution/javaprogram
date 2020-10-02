package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.enti.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int noteid=Integer.parseInt(request.getParameter("noteId").trim());
		
		Session s=FactoryProvider.getfactory().openSession();
		Transaction tx=s.beginTransaction();
		
		Note note= s.get(Note.class,noteid);
		note.setTitle(title);
		note.setContent(content);
		//note.setAddedDate(new Date());
		
		tx.commit();
		s.close();
		response.sendRedirect("all_notes.jsp");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
