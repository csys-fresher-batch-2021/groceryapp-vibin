package in.vibin.Util;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class DisplayTest {

	@Test
	// Check the no of products-True
	public void test1() {
		Map<Integer, String> product = Util.getProducts();
		assertEquals(3, product.size());
	}

	@Test
	// Check the no of products-False
	public void test2() {
		Map<Integer, String> product = Util.getProducts();
		assertNotEquals(5, product.size());
	}

	@Test
	// Check the no of products-True
	public void test3() {
		Map<Integer, Double> productPrice = Util.getProductsPrice();
		assertEquals(3, productPrice.size());
	}

	@Test
	// Check the no of products-False
	public void test4() {
		Map<Integer, Double> productPrice = Util.getProductsPrice();
		assertNotEquals(5, productPrice.size());
	}

	@Test
	// Check the no of products-True
	public void test5() {
		Map<Integer, Integer> ProductsQuantity = Util.getProductsQuantity();
		assertEquals(3, ProductsQuantity.size());
	}

	@Test
	// Check the no of products-False
	public void test6() {
		Map<Integer, Integer> ProductsQuantity = Util.getProductsQuantity();
		assertNotEquals(5, ProductsQuantity.size());
	}
}
