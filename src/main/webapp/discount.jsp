<%@page import="in.vibin.service.DiscountService"%>
<%@page import="in.vibin.dao.DiscountDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Discount</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%int discount=DiscountService.getDiscount();
	
	      %>
	<h3>Discount Details</h3>
		<form action="DiscountServlet">
		<p>Current discount for new user=<%=discount%>%</p>
			<label>Update the new discount % for new user</label> <input  type="number"
				name="updateddiscount" id="updateddiscount" min="0" max="100"
				 placeholder="Enter the discount %(0-100)" required autofocus><br>
			<button class="btn btn-info">Update Discount</button>
		</form>
		

	</main>
</body>
</html>