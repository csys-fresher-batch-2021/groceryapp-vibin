<%@page import="in.vibin.service.OrderService"%>
<%@page import="in.vibin.dao.*"%>
<%@page import="java.util.List"%>
<%@page import="in.vibin.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<title>GroceryManagementApp</title>
</head>
<body>
	<main class="container-fluid">
	<%String isUser = (String) session.getAttribute("LOGGED_IN_USER"); %>
		<h3>####Grocery Store</h3>
		<h4>BILL</h4>
		<table  class="table table-hover table-bordered">
			<caption>BILL</caption>
			<thead>
				<tr>
					<th id="sNo">S.NO</th>
					<th id="name">Product Name</th>
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
					<%} %>
				</tr>
				<%
				if (isUser == "user" || isUser == "newUser") {
				%>
				<tr>
					<th id="totalamount" colspan=4 class="text-center">Total
						Amount</th>
					<th id="tamount">Rs. <%=totalAmount%></th>
				<tr>
					<%
					}
					%>
					<%
					if (isUser == "newUser") {
						double totalAmountOffer = Math.round(totalAmount - (totalAmount * 0.15));
					%>
				
				<tr>
					<th id="offeramount" colspan=4 class="text-center">Final
						Amount(15% Discount For New User)</th>
					<th id="oamount">Rs. <%=totalAmountOffer%></th>
				<tr>
					<%
					}
					%>
				
			</tbody>

		</table>
		<a href="UserLogoutServlet" class="btn btn-info">Go To Home</a>
		<%
			OrderService.deleteOrderProductTable();
			%>
	</main>
</body>
</html>
