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
		<table class="table table-bordered">
			<caption>List of Products</caption>

			<thead>
				<tr>

					<th>ID</th>
					<th>Name</th>
					<th>Price per Quantity</th>
					<th>Available Quantity</th>

				</tr>
			</thead>
			<tbody id="product-tbl">
			</tbody>
		</table>
		<script>

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

getAllProducts();

</script>
	</main>
</body>

</html>