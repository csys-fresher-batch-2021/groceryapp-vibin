package in.vibin.dao;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;


public class DisplayTest {

	@Test
	// Check the no of products-True
	public void test1() {
		Map<Integer, String> product =  GroceryListDAO.getProducts();
		assertEquals(1, product.size());
	}

	@Test
	// Check the no of products-False
	public void test2() {
		Map<Integer, String> product =  GroceryListDAO.getProducts();
		assertNotEquals(5, product.size());
	}

	@Test
	// Check the no of products-True
	public void test3() {
		Map<Integer, Double> productPrice =  GroceryListDAO.getProductsPrice();
		assertEquals(1, productPrice.size());
	}

	@Test
	// Check the no of products-False
	public void test4() {
		Map<Integer, Double> productPrice = GroceryListDAO.getProductsPrice();
		assertNotEquals(5, productPrice.size());
	}

	@Test
	// Check the no of products-True
	public void test5() {
		Map<Integer, Integer> ProductsQuantity = GroceryListDAO.getProductsQuantity();
		assertEquals(1, ProductsQuantity.size());
	}

	@Test
	// Check the no of products-False
	public void test6() {
		Map<Integer, Integer> ProductsQuantity =  GroceryListDAO.getProductsQuantity();
		assertNotEquals(5, ProductsQuantity.size());
	}
}
