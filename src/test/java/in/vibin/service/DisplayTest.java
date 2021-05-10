package in.vibin.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class DisplayTest {

	@Test
	//Check the no of products-True
	public void test1() {
			Map<Integer,String> products=DisplayProducts.getProducts();
			assertEquals(3,products.size());
		}
	@Test
	//Check the no of products-False
	public void test2() {
			Map<Integer,String> products=DisplayProducts.getProducts();
			assertNotEquals(5,products.size());
		}
	}

