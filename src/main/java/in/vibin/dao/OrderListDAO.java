package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.vibin.model.OrderProduct;
import in.vibin.util.ConnectionUtil;

public class OrderListDAO {
	private OrderListDAO() {
	}

	/*
	 * To get the product detail from the Data Base.
	 */
	public static List<OrderProduct> getOrderedProduct() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		List<OrderProduct> orderProductList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM order_list";
			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setName(rs.getString("name"));
				orderProduct.setPrice(rs.getDouble("price_per_quantity"));
				orderProduct.setOrderedQuantity(rs.getInt("ordered_quantity"));
				orderProduct.setAmount(rs.getDouble("amount"));
				orderProduct.setID(rs.getInt("ordered_id"));
				orderProductList.add(orderProduct);
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
		return orderProductList;
	}

	/*
	 * To add the product to the data base.
	 */
	public static void addOrderedProduct(OrderProduct orderProduct) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO order_list(name,price_per_quantity,ordered_quantity,amount) VALUES(?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, orderProduct.getName());
			pst.setDouble(2, orderProduct.getPrice());
			pst.setInt(3, orderProduct.getOrderedQuantity());
			pst.setDouble(4, orderProduct.getAmount());

			pst.executeUpdate();
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

	/*
	 * Delete the product from the database.
	 */
	public static void deleteOrderedProduct(int id) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM order_list WHERE ordered_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
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

	/*
	 * To get the product detail from the Data Base.
	 */
	public static void deleteOrderedProductTable() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "TRUNCATE TABLE order_list";
			pst = connection.prepareStatement(sql);
			pst.executeQuery();
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
