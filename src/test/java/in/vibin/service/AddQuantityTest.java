package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.vibin.model.Product;

class AddQuantityTest {

	@Test
	void testAddQuantity() {
		Product product=new Product();
		product.setID(50);
		product.setQuantity(50);
		product.setOrderedQuantity(5);
		ProductService.addQuantity(product);
		List<Product>productList=ProductService.getProduct();
		for(Product product2:productList) {
			int quantity=product2.getQuantity();
			assertEquals(55,quantity);
		}
	}

}
