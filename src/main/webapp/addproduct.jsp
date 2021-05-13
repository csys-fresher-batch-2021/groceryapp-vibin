<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="AddProductServlet">
			<h3>Add Products</h3>
			<label>Product ID</label>
			<input type="number" name="productID" id="id" min="1" max="500" placeholder="Enter the ID" autofocus required><br>
			<label>Product name</label>
			<input type="text" name="name" id="name" placeholder="Enter the name" required> <br>
			<label>Price per Quantity(Rs)</label>
			<input type="number" name="price" id="price" min="1" step="0.01" placeholder="Enter the price" required> <br>
			<label>Quantity</label>
			<input type="number" name="quantity" id="quantity" min="1" max="1000" placeholder="Enter the quantity" required> <br>
			<button class="btn btn-info">Add Product</button>
			<br>
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage != null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
			}
			%>
		</form>
	</main>
</body>
</html>