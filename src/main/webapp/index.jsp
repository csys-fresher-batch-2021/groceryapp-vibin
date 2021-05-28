<!DOCTYPE html>
<html lang="en">
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String isAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
		String isUser = (String) session.getAttribute("LOGGED_IN_USER");
		if (isAdmin=="admin") {
			out.println("<font color='green'> ADMIN Login </font>");
		}
		if(isUser=="user"){
			out.println("<font color='green'> USER Login </font>");
		}
		%>
		<h3>Welcome To Grocery Management App</h3>

	</main>
</body>
</html>
