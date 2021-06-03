<%@page import="in.vibin.service.OrderService"%>
<%@page import="in.vibin.dao.*"%>
<%@page import="java.util.List"%>
<%@page import="in.vibin.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>GroceryManagementApp</title>
</head>
<body>
	<main class="container-fluid">
		<h3>####Grocery Store</h3>
		<table class="table table-bordered" border=1>
			<caption>BILL</caption>
			<thead>
				<tr>
					<th id="sNo">S.NO</th>
					<th id="name">Name</th>
					<th id="price">Price per Quantity</th>
					<th id="orderedquantity">Ordered Quantity</th>
					<th id="amount">Amount</th>
			</thead>
			<%
			int i = 0;
			double totalAmount=0;
			List<OrderProduct> orderProductList = OrderService.getProduct();
			for (OrderProduct orderProduct : orderProductList) {
				String name = orderProduct.getName();
				double price = orderProduct.getPrice();
				int quantity = orderProduct.getOrderedQuantity();
				double amount = orderProduct.getAmount();
				totalAmount=totalAmount+amount;
				i++;
				int serialNo = i;
				
			%>
			<tbody>
				<tr>
					<td><%=serialNo%></td>
					<td><%=name%></td>
					<td>Rs. <%=price%></td>
					<td><%=quantity%></td>
					<td>Rs. <%=amount%></td>
					<%}
			OrderService.deleteOrderProductTable();
			%>
				</tr>
			</tbody>
			
		</table>
		<label>Total Amount(Rs.)</label>
		<input value=<%=totalAmount %> readonly><br>
		<a href="UserLogoutServlet" class="btn btn-info">Go To Home</a>
	</main>
</body>
</html>
