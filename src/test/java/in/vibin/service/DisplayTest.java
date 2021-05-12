package in.vibin.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class DisplayTest {

	@Test
	// Check the no of products-True
	public void test1() {
		Map<Integer, String> product = ProductService.getProducts();
		assertEquals(3, product.size());
	}

	@Test
	// Check the no of products-False
	public void test2() {
		Map<Integer, String> product = ProductService.getProducts();
		assertNotEquals(5, product.size());
	}

	@Test
	// Check the no of products-True
	public void test3() {
		Map<Integer, Double> product = ProductService.getProductsPrice();
		assertEquals(3, product.size());
	}

	@Test
	// Check the no of products-False
	public void test4() {
		Map<Integer, Double> product = ProductService.getProductsPrice();
		assertNotEquals(5, product.size());
	}

	@Test
	// Check the no of products-True
	public void test5() {
		Map<Integer, Integer> product = ProductService.getProductsQuantity();
		assertEquals(3, product.size());
	}

	@Test
	// Check the no of products-False
	public void test6() {
		Map<Integer, Integer> product = ProductService.getProductsQuantity();
		assertNotEquals(5, product.size());
	}
}
