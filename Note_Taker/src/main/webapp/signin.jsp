<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Note Taker: Sign In Page</title>
<%@include file="all_js_cs.jsp"%>
</head>
<body>

	<div class="container">
		<div class="col-md-6 offset-md-3">
			<div class="card mt-3">
				<div class="card-header purple ">
					<div class="container">
						<h1 class="text-white">This is Login page</h1>
					</div>
				</div>
				<%@include file="message.jsp"%>


				<form class="px-4 py-3" action="Signin" method="post">
					<div class="form-group">
						<label for="login">Login Id</label> <input type="text"
							class="form-control" name="loginid"
							id="exampleDropdownFormEmail1"
							placeholder="Enter here Your Login Id">
					</div>
					<div class="form-group">
						<label for="exampleDropdownFormPassword1">Password</label> <input
							type="password" class="form-control" name="password"
							id="exampleDropdownFormPassword1" placeholder="Password">
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="dropdownCheck">
						<label class="form-check-label" for="dropdownCheck">
							Remember me </label>
					</div>
					<button type="submit" class="btn purple text-white mt-2">Sign
						in</button>
				</form>
				<div class="dropdown-divider "></div>
				<a class="dropdown-item" href="sign_up.jsp">New User here? Sign
					up</a> <a class="dropdown-item" href="#">Forgot password?</a>
			</div>
		</div>
	</div>
</body>
</html>