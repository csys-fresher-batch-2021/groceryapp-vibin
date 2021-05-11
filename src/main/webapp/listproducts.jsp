<%@page import="in.vibin.service.ProductService"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<title>GroceryManagementApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of products</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>S.NO</th>
					<th>ID</th>
					<th>Product Name</th>
					<th>Price(Rs)/Quantity(n)</th>
					<th>Available Quantity(n)</th>
			</thead>
			<%
			int i = 0;
				Map<Integer, String> Product = ProductService.getProducts();
				Map<Integer, Double> ProductPrice = ProductService.getProductsPrice();
				Map<Integer, Integer> ProductQuantity = ProductService.getProductsQuantity();
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
					<td>Rs.<%=price%></td>
					<td><%=quantity%>n</td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</main>
</body>
</html>
