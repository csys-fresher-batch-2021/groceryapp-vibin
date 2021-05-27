<%@page import="in.vibin.service.ProductService"%>
<%@page import="in.vibin.dao.*"%>
<%@page import="java.util.List"%>
<%@page import="in.vibin.model.*"%>
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
					if (isAdmin == null) {
					%>
					<th id="buy">Buy</th>
					<%
					}
					%>
					<%
					if (isAdmin != null && isAdmin.equals("admin")) {
					%>
					<th id="addquantity">Add quantity</th>
					<th id="delete">Delete</th>
					<%
					}
					%>
				
			</thead>
			<%
			int i = 0;
			List<Product> productList = ProductService.getProduct();
			for (Product product : productList) {
				int id = product.getID();
				String name = product.getName();
				double price = product.getPrice();
				int quantity = product.getQuantity();
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
					if (isAdmin == null) {
					%>
					<td><a
						href="BuyProductServlet?id=<%=id%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>"
						class="btn btn-info">Buy</a></td>
					<%
					}
					%>

					<%
					if (isAdmin != null && isAdmin.equals("admin")) {
					%>
					<td><a href="AddQuantityServlet?productID=<%=id%>&availablequantity=<%=quantity%>"
						class="btn btn-info">Add quantity</a>
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
	<a href="addproduct.jsp" class="btn btn-info">ADD Product</a>
	<%
	}
	%>
</body>
</html>
