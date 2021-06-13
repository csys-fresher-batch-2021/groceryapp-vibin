<!DOCTYPE html>
<%@page import="in.vibin.dao.DiscountDAO"%>
<%@page import="in.vibin.service.OrderService"%>
<html lang="en">
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Welcome To Grocery Management App</h3><br>
		<%
		String isAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
		String isUser = (String) session.getAttribute("LOGGED_IN_USER");
		if(isUser==null){
			OrderService.removeCart();
		}
		if (isAdmin=="admin") {
			out.println("<font color='green'> ADMIN Login </font>");%><br>
			
	<%}
		if(isUser=="user"){
			out.println("<font color='green'> USER Login </font>");%><br>
		<% }
		if(isUser=="newUser"){
			out.println("<font color='green'>NEW USER Login </font>");%><br>
		<% }
		int discount=DiscountDAO.getDiscount();
		if(discount!=0){
			out.println("<font color='red'>"+discount+"% Discount for * NEW USER *</font>");

		}
		%>
		
		<p>REFERENCE(for test purpose only I show this login credentials...)</p><br>
		<p>Admin login<br>MobileNumber=9659644868<br>Password=Vibin#321</p><br>
		<p>User login<br>MobileNumber=9659644868<br>Password=Vibin#321</p>
	</main>
</body>
</html>
