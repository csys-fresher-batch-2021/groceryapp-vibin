package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.vibin.model.OrderHistory;
import in.vibin.model.OrderProduct;

class AddOrderHistoryTest {

	@Test
	void testAddOrderHistory() {
		OrderProduct orderHistory = new OrderProduct();
		long mobileNumber=9659644868L;
		orderHistory.setName("rice");
		orderHistory.setPrice(35);
		orderHistory.setOrderedQuantity(2);
		orderHistory.setAmount(70);
		List<OrderProduct>orderProductList=new ArrayList<>();
		orderProductList.add(orderHistory);
		SellingHistory.addOrderHistory(mobileNumber,orderProductList);
		List<OrderHistory> orderHistoryList = SellingHistory.getOrderHistory();
		int size = orderHistoryList.size();
		assertTrue(size >= 1);
	}

}
