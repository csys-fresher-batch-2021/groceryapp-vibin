package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateDiscountTest {

	@Test
	void test() {
		int updateDiscount=13;
		DiscountService.updateDiscount(updateDiscount);
		int currentDiscount=DiscountService.getDiscount();
		assertEquals(13,currentDiscount);
	}

}
