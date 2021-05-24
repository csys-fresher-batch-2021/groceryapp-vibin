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
	<%
		String id=request.getParameter("id");
		String price=request.getParameter("price");
		String quantity=request.getParameter("orderquantity");
		String name=request.getParameter("name");
		String amount=request.getParameter("amount");
		%>
		
	<form >
	<h3>Bill</h3>
	<label>Product name</label>
	<input id="ordername" name="ordername" value=<%=name %> readonly><br>
	<label>Product price</label>
	<input id="orderprice" name="orderprice" value=<%=price %> readonly><br>
	<label>Ordered quantity</label>
	<input id="orderquantity" name="orderquantity" value=<%=quantity %> readonly><br>
	<label>Total amount</label>
	<input id="amount" name="amount" value=<%=amount %> readonly><br>
	<p>!!!Thank you for purchase!!!<br>
	-----Visit Again-----</p>
	</form>

	</main>
</body>
</html>