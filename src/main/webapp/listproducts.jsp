<%@page import="in.vibin.util.*"%>
<%@page import="java.util.Map"%>
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
			Map<Integer, String> Product =Util.getProducts();
			Map<Integer, Double> ProductPrice =Util.getProductsPrice();
			Map<Integer, Integer> ProductQuantity =Util.getProductsQuantity();
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
	<a href="addproduct.jsp">ADD Product</a>
</body>
</html>
