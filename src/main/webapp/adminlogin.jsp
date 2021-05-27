<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="AdminLoginServlet" method="post">
			<h3>Admin Login</h3>
			<label>Mobilenumber</label> <input type="tel" name="mobileNumber"
				id="mno" placeholder="Enter the mobile number"
				pattern="[6-9][0-9]{9}" autofocus required> <br> <label>Password</label>
			<input type="password" name="password" id="password"
				placeholder="Enter the password"
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
				required> <br>
			<button type="submit">ADMIN LOGIN</button>
			<br>
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
		</form>
	</main>

</body>
</html>