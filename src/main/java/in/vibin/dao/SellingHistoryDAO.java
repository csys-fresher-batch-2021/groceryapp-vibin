package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.vibin.model.OrderHistory;
import in.vibin.model.OrderProduct;
import in.vibin.util.ConnectionUtil;

public class SellingHistoryDAO {
	private SellingHistoryDAO() {
	}

	public static List<OrderHistory> getOrderHistory() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		List<OrderHistory> orderHistoryList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM selling_history";
			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				OrderHistory orderHistory = new OrderHistory();
				orderHistory.setMobileNumber(rs.getLong("mobilenumber"));
				orderHistory.setName(rs.getString("product_name"));
				orderHistory.setPrice(rs.getDouble("price_per_quantity"));
				orderHistory.setOrderedQuantity(rs.getInt("ordered_quantity"));
				orderHistory.setAmount(rs.getDouble("amount"));
				orderHistory.setOrderDate(rs.getString("buy_date"));
				orderHistory.setOrderTime(rs.getString("buy_time"));
				orderHistoryList.add(orderHistory);
			}
			ConnectionUtil.close(connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				ConnectionUtil.close(connection);
			}
		}
		return orderHistoryList;
	}

	public static void addSellingHistory(long mobileNumber,List<OrderProduct> orderedProduct) throws SQLException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			for(OrderProduct orderProduct:orderedProduct) {
			String sql = "INSERT INTO selling_history(mobilenumber,product_name,price_per_quantity,ordered_quantity,amount) VALUES(?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, mobileNumber);
			pst.setString(2, orderProduct.getName());
			pst.setDouble(3, orderProduct.getPrice());
			pst.setInt(4, orderProduct.getOrderedQuantity());
			pst.setDouble(5, orderProduct.getAmount());
			pst.executeUpdate();
			pst.close();
			}
			ConnectionUtil.close(connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				ConnectionUtil.close(connection);
			}
		}
	}

}
