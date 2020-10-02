package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.enti.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
			 response.setContentType("text/html");
		     PrintWriter out=response.getWriter();
			
			//title,content fetch
			HttpSession session1=request.getSession(false);
			if(session1!=null)
			{	
			String title= request.getParameter("title");
			String content=request.getParameter("content");
			int rid=(Integer) session1.getAttribute("id");
			/*Query q=s.createQuery("update Note set title=:t ,content=:c where login_id=:l and password=:p");
            q.setParameter("t",title);
            q.setParameter("c",content);
            q.setParameter("l",log);
            q.setParameter("p",pass);
            int r=q.executeUpdate();
            out.println("Objected updated");*/
            
			Note note=new Note(title,content,rid);
			
			//hibernate:save()
			Session s= FactoryProvider.getfactory().openSession();
			Transaction tx =s.beginTransaction();
			
			
			s.save(note);
			tx.commit();
			s.close();
			response.sendRedirect("add_notes.jsp");
			}
			else{
				out.print("Please login first");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
