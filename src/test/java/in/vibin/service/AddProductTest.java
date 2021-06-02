package in.vibin.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vibin.model.Product;

public class AddProductTest {

	@Test
	// ID and name already exist it will return=1
	public void testExistingIDAndName() {
		Product product=new Product();
		product.setID(50);
		product.setName("wheat");
		product.setPrice(12);
		product.setQuantity(35);
		String errorMessage=null;
		try {
		ProductService.addProduct(product);
		}catch(Exception e) {
		errorMessage=e.getMessage();
		}
		assertEquals("ID and Name already exist",errorMessage);
	}

	@Test
	// ID already exist it will return=2
	public void testExistingID() {
		Product product=new Product();
		product.setID(50);
		product.setName("ragi");
		product.setPrice(12);
		product.setQuantity(35);
		String errorMessage=null;
		try {
		ProductService.addProduct(product);
		}catch(Exception e) {
		errorMessage=e.getMessage();
		}
		assertEquals("ID already exist",errorMessage);
	}

	@Test
	// ID and name already exist it will return=3
	public void testExistingName() {
		Product product=new Product();
		product.setID(35);
		product.setName("wheat");
		product.setPrice(12);
		product.setQuantity(35);
		String errorMessage=null;
		try {
		ProductService.addProduct(product);
		}catch(Exception e) {
		errorMessage=e.getMessage();
		}
		assertEquals("Name already exist",errorMessage);
	}
}
