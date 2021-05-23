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
				<%
				String isAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
				%>
				<tr>
					<th id="sNo">S.NO</th>
					<th id="id">ID</th>
					<th id="productName">Product Name</th>
					<th id="price">Price per Quantity</th>
					<th id="quantity">Available Quantity</th>
					
					
				
					<%
					if (isAdmin != null && isAdmin.equals("admin")) {
					%>
					<th id="delete">Delete</th>
					<%
					}
					%>
				
			</thead>
			<%
			int i = 0;
			Map<Integer, String> Product = GroceryListDAO.getProducts();
			Map<Integer, Double> ProductPrice = GroceryListDAO.getProductsPrice();
			Map<Integer, Integer> ProductQuantity = GroceryListDAO.getProductsQuantity();
			for (Integer id : Product.keySet()) {
				String name = Product.get(id);
				double price = ProductPrice.get(id);
				int quantity = ProductQuantity.get(id);
				i++;
				int serialNo = i;
			%>
			<tbody>
				<tr>
					<td><%=serialNo%></td>
					<td><%=id%></td>
					<td><%=name%></td>
					<td>Rs. <%=price%></td>
					<td><%=quantity%></td>
					
				
					
					<%
					if (isAdmin != null && isAdmin.equals("admin")) {
					%>
					<td><a href="DeleteProductServlet?productID=<%=id%>"
						class="btn btn-danger">Delete</a> <%
 }
 %>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</main>
	<%
	if (isAdmin != null && isAdmin.equals("admin")) {
	%>
	<a href="addproduct.jsp">ADD Product</a>
	<%
	}
	%>
</body>
</html>
