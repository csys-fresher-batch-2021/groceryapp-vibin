package in.vibin.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddProductTest {

	@Test
	//ID and name already exist it will return=1
	public void testExistingIDAndName() {
		int ID=50;
		String name="wheat";
		double price=12;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(1,isAdded);
	}
	@Test
	//ID already exist it will return=2
	public void testExistingID() {
		int ID=50;
		String name="ragi";
		double price=12;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(2,isAdded);
	}
	@Test
	//ID and name already exist it will return=3
	public void testExistingName() {
		int ID=6;
		String name="wheat";
		double price=12;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(3,isAdded);
	}
	@Test
	//null name it will return=5
	public void testNullName() {
		int ID=66;
		String name=null;
		double price=12;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//null name it will return=5
	public void testWithoutName() {
		int ID=66;
		String name="";
		double price=12;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//null ID it will return=5
	public void testNullID() {
		int ID=0;
		String name="ragi";
		double price=12;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//Null price it will return=5
	public void testNullPrice() {
		int ID=66;
		String name="ragi";
		double price=0;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//Null price it will return=5
	public void testNullQuantity() {
		int ID=66;
		String name="ragi";
		double price=5;
		int quantity=0;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//Negative price it will return=0
	public void testNegativePrice() {
		int ID=66;
		String name="ragi";
		double price=-1;
		int quantity=35;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//Negative quantity it will return=0
	public void testNegativeQuantity() {
		int ID=66;
		String name="ragi";
		double price=5;
		int quantity=-1;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(0,isAdded);
	}
	@Test
	//Valid inputs it will return=4
	public void testvalidInputs() {
		int ID=66;
		String name="ragi";
		double price=5;
		int quantity=55;
		int isAdded= ProductService.addProduct(ID, name, price, quantity);
		assertEquals(4,isAdded);
	}

}
