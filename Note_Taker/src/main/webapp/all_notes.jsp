<%@page import="java.util.List"%>
<%@page import="org.hibernate.*"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.enti.*"%>
<%@page import=" javax.servlet.http.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All notes: Note Taker</title>
<%@include file="all_js_cs.jsp"%>
</head>
<body>

	<div class="container">
		<%
		
			if(session.getAttribute("login_id")==null)
			  {
				out.println("Please login First!!!");
				 response.sendRedirect("index.jsp");
			   
			  }
			else{
				String id=(String) session.getAttribute("login_id");
				int id1=(Integer)session.getAttribute("id");
			
			%>
		<%@include file="navbar.jsp"%>
		<br>
		<div class="row">
			<div class="col-12">


				<br>
				<%
        Session s=FactoryProvider.getfactory().openSession();
        /* //Query q= s.createQuery("from Note"); */
        String query="from Note as s where s.rid=:x"; 
        Query q=s.createQuery(query);
        q.setParameter("x",id1);
        List<Note> list=q.list();
        for(Note note:list)
        {
        %>
				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
						src="img/notepad.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle() %></h5>
						<p class="card-text"><%=note.getContent() %></p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%=note.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="edit.jsp?note_id=<%=note.getId()%>"
								class="btn btn-primary">Update</a>
						</div>
					</div>
				</div>
				<% 
        }
		
         s.close();  
			} %>
			</div>
		</div>
	</div>
</body>
</html>