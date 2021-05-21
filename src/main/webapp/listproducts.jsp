<%@page import="in.vibin.dao.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>GroceryManagementApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of products</h3>
		<table class="table table-bordered">
			<caption>List of Products</caption>
			<thead>
				<tr>
					<th id="sNo">S.NO</th>
					<th id="id">ID</th>
					<th id="productName">Product Name</th>
					<th id="price">Price per Quantity</th>
					<th id="quantity">Available Quantity</th>
			</thead>
			<%
			int i = 0;
			Map<Integer, String> Product = GroceryListDAO.getProducts();
			Map<Integer, Double> ProductPrice = GroceryListDAO.getProductsPrice();
			Map<Integer, Integer> ProductQuantity = GroceryListDAO.getProductsQuantity();
			for (Integer id : Product.keySet()) {
				String value = Product.get(id);
				double price = ProductPrice.get(id);
				int quantity = ProductQuantity.get(id);
				i++;
				int serialNo = i;
			%>
			<tbody>
				<tr>
					<td><%=serialNo%></td>
					<td><%=id%></td>
					<td><%=value%></td>
					<td>Rs. <%=price%></td>
					<td><%=quantity%></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</main>
	<%
	String isAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
	if (isAdmin != null && isAdmin.equals("admin")) {
	%>
	<a href="addproduct.jsp">ADD Product</a>
	<%
	}
	%>
</body>
</html>
