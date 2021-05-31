<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="RegisterUserServlet" method="post">
			<h3>Register User</h3>
			<h6 style="color:Tomato;">The mobile number must start with(6-9)and contains 10 digit</h6>
			<h6 style="color:Tomato;">The pasword must contain one(a-z)(A-Z)(0-9)(!@#$%^*_=+-)and(8-12 digit)</h6>
			<label>Enter the Mobilenumber</label> <input type="tel"
				name="mobileNumber" id="mno" placeholder="Enter the mobile number"
				pattern="[6-9][0-9]{9}" autofocus required> <br> <label>Enter
				the Password</label> <input type="password" name="password" id="password"
				placeholder="Enter the password"
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
				required> <br> <label>Re-Enter the Password</label> <input
				type="password" name="repassword" id="repassword"
				placeholder="Enter the password"
				pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
				required> <br>
			<button type="submit" class="btn btn-info">REGISTER</button>
			<br>
			<%
			String errorMessage = request.getParameter("errorMessage");
			String infoMessage = request.getParameter("infoMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			if (infoMessage != null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
			}
			%>
		</form>
	</main>

</body>
</html>