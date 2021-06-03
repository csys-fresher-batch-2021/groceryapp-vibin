package in.vibin.service;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import in.vibin.model.Product;


public class DisplayTest {

	@Test
	// Check the no of products-True
	public void test1() {
		List<Product> product =ProductService.getProduct();
		int size=product.size();
		assertTrue(size>=0);
	}

	@Test
	// Check the no of products-True
	public void test2() {
		List<Product> product =ProductService.getProduct();
		int size=product.size();
		assertFalse(size<=0);
	}

}
