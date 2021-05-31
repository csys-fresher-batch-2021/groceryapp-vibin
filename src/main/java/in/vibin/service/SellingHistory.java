package in.vibin.service;

import java.sql.SQLException;
import java.util.List;
import in.vibin.dao.SellingHistoryDAO;
import in.vibin.model.OrderHistory;

public class SellingHistory {
	private SellingHistory() {
	}

	public static List<OrderHistory> getOrderHistory() {
		List<OrderHistory> orderHistoryList = null;

		try {
			orderHistoryList = SellingHistoryDAO.getOrderHistory();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return orderHistoryList;
	}

	public static void addOrderHistory(OrderHistory orderProduct) {
		try {
			SellingHistoryDAO.addSellingHistory(orderProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
