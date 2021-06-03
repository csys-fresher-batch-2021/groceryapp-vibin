<%@page import="in.vibin.service.OrderService"%>
<%@page import="in.vibin.dao.*"%>
<%@page import="java.util.List"%>
<%@page import="in.vibin.model.*"%>
<%@page import="java.lang.Math"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>GroceryManagementApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String isUser = (String) session.getAttribute("LOGGED_IN_USER");
		%>
		<h3>Ordered Product List</h3>
		<table class="table table-bordered">
			<caption>List of Products</caption>
			<thead>
				<tr>
					<th id="sNo">S.NO</th>
					<th id="name">Name</th>
					<th id="price">Price per Quantity</th>
					<th id="orderedquantity">Ordered Quantity</th>
					<th id="amount">Amount</th>
					<th id="amount">Cancel Order</th>
			</thead>
			<%
			int i = 0;
			double totalAmount = 0;
			String name = null;
			double price = 0;
			int quantity = 0;
			double amount = 0;

			List<OrderProduct> orderProductList = OrderService.getProduct();
			for (OrderProduct orderProduct : orderProductList) {
				name = orderProduct.getName();
				price = orderProduct.getPrice();
				quantity = orderProduct.getOrderedQuantity();
				amount = orderProduct.getAmount();
				int id = orderProduct.getID();
				totalAmount = totalAmount + amount;
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
					<td><a
						href="RemoveOrderProductServlet?name=<%=name%>&id=<%=id%>&price=<%=price%>&quantity=<%=quantity%>"
						class="btn btn-danger">Cancel</a></td>
					<%
					}
					%>
				</tr>
				<tr>
					<th id="totalamount" colspan=4 class="text-center">TOTAL
						AMOUNT</th>
					<th id="tamount">Rs. <%=totalAmount%></th>
				<tr>
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



		<a href="SellingHistoryServlet" class="btn btn-info">Proceed for
			Bill</a>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
	</main>
</body>
</html>
