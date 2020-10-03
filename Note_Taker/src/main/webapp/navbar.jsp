<%@page import="com.enti.Register_table"%>
<%
String   user1=(String)session.getAttribute("current-user");
%>

<!-- all js and css cdn link -->
<%-- <%@include file="all_js_cs.jsp"%> --%>



<%
    
		/* if(session.getAttribute("login_id")==null){
			
			out.println("Please login First!!!");
			
		    response.sendRedirect("index.jsp"); 
	
		} */
	 %>

<div class="container">
	<nav class="navbar navbar-expand-lg navbar-dark purple  mt-2">
	<a class="navbar-brand" href="home.jsp">Note Taker</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="add_notes.jsp">Add
					Note</a></li>

			<li class="nav-item"><a class="nav-link " href="all_notes.jsp">Show
					Notes</a></li>
		</ul>
		<% 
       if(user1!=null)
       {
       %>
		<ul class="navbar-nav ml-auto">

			<li class="nav-item active"><a class="nav-link" href="#"><%=user1 %>
			</a></li>

			<li class="nav-item"><a class="nav-link " href="Log_out">Log
					Out</a></li>
		</ul>


		<%
       }
       %>





	</div>
</nav>
	
</div>


