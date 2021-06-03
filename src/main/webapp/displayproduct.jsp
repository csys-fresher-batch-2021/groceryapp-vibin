<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script>
	src="http://cdnjs.cloudflare.com/ajax/lib/axios/0.21.1/axio.min.js"></script>
<meta charset="ISO-8859-1">
<title>Display product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Display product</h3>
		<label>Enter the name</label>
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names...">
		<table class="table table-bordered" id="table">
			<caption>List of Products</caption>

			<thead>
				<tr>

					<th id="id">ID</th>
					<th id="name">Name</th>
					<th id="price">Price per Quantity</th>
					<th id="quantity">Available Quantity</th>

				</tr>
			</thead>
			<tbody id="product-tbl">
			</tbody>
		</table>
		<script>
		getAllProducts();
function getAllProducts(){
	
	console.log("Fetching all tasks");
	let url="DisplayProductServlet";
	fetch(url).then(res=>res.json()).then(res=>{
		console.log(res);
		let products=res;
		console.log("Got response from servlet");
		 let content="";
		for (let product of products){
			
 				content +="<tr><td>"+ product.id + "</td><td>"+ product.name +"</td><td>"+"Rs. "+product.price+"</td><td>"+product.quantity+"</td></tr>";					
		}
		console.log(content);
		document.querySelector("#product-tbl").innerHTML=content; 
		
		})
		
	}


function myFunction() {
	let input, filter, table, row, data, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("table");
	row = table.getElementsByTagName("tr");
	for (i = 0; i < row.length; i++) {
		data = row[i].getElementsByTagName("td")[1];
		if (data) {
			txtValue = data.textContent || data.innerText;
			if (txtValue.toUpperCase().indexOf(filter) >-1) {
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