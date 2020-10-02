<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.helper.*,org.hibernate.*,com.enti.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<%@include file="all_js_cs.jsp"%>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>This is Edit Page</h1>

		<%
        int noteId=Integer.parseInt(request.getParameter("note_id").trim());
        Session s=FactoryProvider.getfactory().openSession();
		Note note= (Note)s.get(Note.class,noteId);
	
        %>
		<!--this is add form  -->
		<form action="UpdateServlet" method="post">

			<input value="<%=note.getId()%>" name="noteId" type="hidden" />

			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					type="text" class="form-control"
					placeholder="Please Enter Your Title"
					value="<%= note.getTitle() %>" required />

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" id="content"
					placeholder="Enter your content here" class="form-control"
					style="height: 300px;" required><%=note.getContent()%></textarea>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save Your
					Note</button>
			</div>
		</form>
	</div>
</body>
</html>