<%@page import="in.vibin.service.SellingHistory"%>
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
		<h3>Purchase History</h3>
		<label>Enter the name</label>
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for mobile number...">
		<table class="table table-bordered" id="table">
			<caption>Purchase History</caption>
			<thead>
				<tr>
					<th id="id">MobileNumber</th>
					<th id="productName">Product Name</th>
					<th id="price">Price per Quantity</th>
					<th id="quantity">Ordered Quantity</th>
					<th id="amount">Amount</th>
					<th id="quantity">Purchase Date</th>
					<th id="amount">Purchase Time</th>
				</tr>
			</thead>

			<%
			List<OrderHistory> orderProductHistory = SellingHistory.getOrderHistory();
			for (OrderHistory orderHistory : orderProductHistory) {
				Long mobileNumber = orderHistory.getMobileNumber();
				String name = orderHistory.getName();
				double price = orderHistory.getPrice();
				int quantity = orderHistory.getOrderedQuantity();
				double amount = orderHistory.getAmount();
				String date = orderHistory.getOrderDate();
				String time = orderHistory.getOrderTime();
			%>
			<tbody>
				<tr>
					<td><%=mobileNumber%></td>
					<td><%=name%></td>
					<td>Rs. <%=price%></td>
					<td><%=quantity%></td>
					<td>Rs. <%=amount%></td>
					<td><%=date%></td>
					<td><%=time%></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
		<script>
		function myFunction() {
	let input, filter, table, row, data, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("table");
	row = table.getElementsByTagName("tr");
	for (i = 0; i < row.length; i++) {
		data = row[i].getElementsByTagName("td")[0];
		if (data) {
			txtValue = data.textContent || data.innerText;
			if (txtValue.toUpperCase().indexOf(filter) ==0) {
				row[i].style.display = "";
			} else {
				row[i].style.display = "none";
			}
		}
	}
}

</script>
	</main>
</body>
</html>
