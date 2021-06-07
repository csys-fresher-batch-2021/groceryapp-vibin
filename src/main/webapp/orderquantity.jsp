<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>GroceryManagementApp</title>
</head>
<body>
	<%
	String quantity = (String) session.getAttribute("availableQuantity");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Order Quantity</h3>
		<form action="OrderProductServlet">
			<label>Enter the quantity</label> <input type="number"
				name="orderedquantity" id="orderedquantity" min="1"
				max=<%=quantity%> placeholder="Enter the quantity" required><br>
			<button class="btn btn-info">Order</button>
		</form>

	</main>
</body>
</html>