package in.vibin.service;

import java.sql.SQLException;
import java.util.List;
import in.vibin.dao.SellingHistoryDAO;
import in.vibin.model.OrderHistory;
import in.vibin.model.OrderProduct;

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

	public static void addOrderHistory(long mobileNumber,List<OrderProduct> orderProduct) {
		
		try {
			SellingHistoryDAO.addSellingHistory(mobileNumber,orderProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
