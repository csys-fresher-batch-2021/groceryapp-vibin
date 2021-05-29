<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">GroceryManagementApp</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<%
		String isAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
		String isUser=(String) session.getAttribute("LOGGED_IN_USER");
		%>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active">
				<%if(isAdmin=="admin") {%>
				<a class="nav-link"href="displayproduct.jsp">Overview<span class="sr-only">(current)</span></a>
				<%} %>
				<%if(isAdmin==null && isUser==null) {%>
				<a class="nav-link"href="displayproduct.jsp">Display Product<span class="sr-only">(current)</span></a>
				<%} %>
				</li>
				<%
				if (isUser=="user") {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="buyproduct.jsp">Buy Product</a></li>
				<%
				}
				%>
				<%
				if (isAdmin=="admin") {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="buyproduct.jsp">Alter List</a></li>
				<%
				}
				%>
			</ul>
			
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<%
			if (isAdmin == null && isUser==null) {
			%>
				<li class="nav-item active"><a class="nav-link"
					href=" adminlogin.jsp">Admin Login</a></li>
					<li class="nav-item active"><a class="nav-link"
					href=" userlogin.jsp">User Login</a></li>
				<%
				}
				%>
				<%
				if (isUser==null && isAdmin==null) {
				%>
				<li class="nav-item active"><a class="nav-link" href="registeruser.jsp">Register User</a></li>
				<%} %>
				<%
				if (isAdmin=="admin") {
				%>
				<li class="nav-item active"><a class="nav-link" href="AdminLogoutServlet">Logout=></a></li>
				<%
				}
				%>
				<%
				if (isUser=="user") {
				%>
				<li class="nav-item active"><a class="nav-link" href="UserLogoutServlet">Logout=></a></li>
				<%
				}
				%>
			</ul>

		</div>
	</nav>
</header>