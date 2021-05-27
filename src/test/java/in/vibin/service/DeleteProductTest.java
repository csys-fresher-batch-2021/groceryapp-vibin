package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import in.vibin.model.Product;

class DeleteProductTest {


	@Test
	void testValidInput(){
		ProductService.deleteProduct(50);
		assertEquals(0,ProductService.getProduct().size());
		Product product=new Product();
		product.setID(50);
		product.setName("wheat");
		product.setPrice(12);
		product.setQuantity(35);
	
		try {
			ProductService.addProduct(product);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	void testInValidInput() {
		ProductService.deleteProduct(40);
		assertEquals(1,ProductService.getProduct().size());
	}

}
