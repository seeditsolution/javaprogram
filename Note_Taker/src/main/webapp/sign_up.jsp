<html>
<head>
<title>Note Taker:Sign Up</title>
<%@include file="all_js_cs.jsp"%>
</head>
<body>


	<div class="container">
		<div class="col-md-6 offset-md-3">
			<div class="card mt-3">

				<div class="card-header purple ">
					<div class="container text-center">
						<h1 class="text-white">This is a Register page</h1>
					</div>
				</div>

				<form class="px-4 py-3" action="Signup" method="post">
					<div class="form-group">
						<label for="login">Name</label> <input type="text"
							class="form-control" name="name" id="exampleDropdownFormEmail1"
							placeholder="Full Name Enter Here">
					</div>
					<div class="form-group">
						<label for="exampleDropdownFormEmail2">Email address</label> <input
							type="email" class="form-control" name="email"
							id="exampleDropdownFormEmail2" placeholder="email@example.com">
					</div>
					<div class="form-group">
						<label for="login">Login Id</label> <input type="text"
							class="form-control" name="loginid"
							id="exampleDropdownFormEmail1" placeholder="Login Id Enter Here">
					</div>
					<div class="form-group">
						<label for="exampleDropdownFormPassword1">Password</label> <input
							type="password" class="form-control" name="password"
							id="exampleDropdownFormPassword1" placeholder="Password">
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="dropdownCheck"
							required> <label class="form-check-label"
							for="dropdownCheck"> Remember me </label>
					</div>
					<button type="submit" class="btn btn-primary">Sign Up</button>
				</form>
				<div class="dropdown-divider"></div>
				<div class="container signin">
					<p>
						Already have an account? <a href="index.jsp">Sign in</a>.
					</p>

				</div>
			</div>

		</div>

	</div>
</body>
</html>

