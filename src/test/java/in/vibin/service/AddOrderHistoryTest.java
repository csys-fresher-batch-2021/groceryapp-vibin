package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.vibin.model.OrderHistory;

class AddOrderHistoryTest {

	@Test
	void testAddOrderHistory() {
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setMobileNumber(9659679989L);
		orderHistory.setName("rice");
		orderHistory.setPrice(35);
		orderHistory.setOrderedQuantity(2);
		orderHistory.setAmount(70);
		SellingHistory.addOrderHistory(orderHistory);
		List<OrderHistory> orderHistoryList = SellingHistory.getOrderHistory();
		int size = orderHistoryList.size();
		assertTrue(size >= 1);
	}

}
