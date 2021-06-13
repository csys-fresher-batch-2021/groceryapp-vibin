<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>GroceryManagementApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Add Quantity</h3>
		<form action="AddProductQuantityServlet">
			<label>Enter the quantity to add</label> <input type="number"
				name="addedquantity" id="addedquantity" min="1" max="1000"
				 placeholder="Enter the quantity" required autofocus><br>
			<button class="btn btn-info">Add Quantity</button>
		</form>

	</main>
</body>
</html>