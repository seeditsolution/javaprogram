<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import=" javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_js_cs.jsp"%>
</head>
<body>

	<div class="container">

		<%
		if(session.getAttribute("login_id")==null){
			out.println("Please login First!!!");
		   // response.sendRedirect("index.jsp"); 
		  }
        	
		String id1=(String) session.getAttribute("login_id");
	     %>

		<%@include file="navbar.jsp"%>
		<br>
		<h1>Please fill note Detail</h1>



		<br> <br>
		<!--this is add form  -->
		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					type="text" class="form-control"
					placeholder="Please Enter Your Title" required />

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" id="content"
					placeholder="Enter your content here" class="form-control"
					style="height: 300px" required></textarea>
			</div>

			<div class="container text-center">
				<button type="submit" onclick="add()" class="btn btn-primary">Add</button>
				<span id="h"></span>
			</div>
		</form>
	</div>

	<script>
   function add()
       {
	   document.getElementById("h").innerHTML("*Note Added Successfully*");
	   }

</script>

</body>
</html>