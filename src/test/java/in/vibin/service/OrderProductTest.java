package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class OrderProductTest {



	@Test
	void test() {
		int id=50;
		int quantity=2;
		double amount=UserService.orderProduct(id,quantity);
		assertEquals(100,amount);
		UserService.addQuantity(id, quantity);
	}

}
