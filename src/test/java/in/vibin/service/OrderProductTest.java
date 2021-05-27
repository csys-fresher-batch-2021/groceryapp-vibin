package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import in.vibin.model.Product;

class OrderProductTest {



	@Test
	void test() {
		Product orderedProduct=new Product();
		orderedProduct.setID(50);
		orderedProduct.setName("wheat");
		orderedProduct.setOrderedQuantity(2);
		orderedProduct.setQuantity(35);
		orderedProduct.setPrice(12);
		double amount=UserService.orderProduct(orderedProduct);
		assertEquals(24,amount);
		Product product=new Product();
		product.setID(50);
		product.setQuantity(33);
		product.setOrderedQuantity(2);
		UserService.addQuantity(product);
	}

}
