package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.vibin.model.OrderHistory;

class GetSellingHistoryTest {

	@Test
	void testGetSellingHistory() {
		List<OrderHistory> orderHistory = SellingHistory.getOrderHistory();
		int size = orderHistory.size();
		assertTrue(size >= 1);
	}

}
