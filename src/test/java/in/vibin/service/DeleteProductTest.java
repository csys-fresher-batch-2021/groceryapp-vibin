package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import in.vibin.dao.GroceryListDAO;

class DeleteProductTest {


	@Test
	void testValidInput() {
		ProductService.deleteProduct(50);
		Map<Integer,String>products=GroceryListDAO.getProducts();
		assertEquals(0,products.size());
		ProductService.addProduct(50, "wheat", 45, 65);
	}
	@Test
	void testInValidInput() {
		ProductService.deleteProduct(40);
		Map<Integer,String>products=GroceryListDAO.getProducts();
		assertEquals(1,products.size());
	}

}
