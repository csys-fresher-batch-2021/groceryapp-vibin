package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.vibin.util.ConnectionUtil;

public class GroceryListDAO {

	static HashMap<Integer, String> product = new HashMap<>();
	static HashMap<Integer, Double> productPrice = new HashMap<>();
	static HashMap<Integer, Integer> productQuantity = new HashMap<>();

	private GroceryListDAO() {
	}

	/*
	 * To get the product detail from the Data Base.
	 */
	public static void productDetail() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM grocery_list";
			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				product.put(id, name);
				productPrice.put(id, price);
				productQuantity.put(id, quantity);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			pst.close();
			ConnectionUtil.close(connection);
		}
	}

	/*
	 * To get the product name with ID
	 */
	public static Map<Integer, String> getProducts() {
		try {
			GroceryListDAO.productDetail();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	/*
	 * To get the product price with ID
	 */
	public static Map<Integer, Double> getProductsPrice() {
		try {
			GroceryListDAO.productDetail();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productPrice;
	}

	/*
	 * To get the product quantity with ID
	 */
	public static Map<Integer, Integer> getProductsQuantity() {
		try {
			GroceryListDAO.productDetail();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productQuantity;
	}

	/*
	 * To add the product to the data base.
	 */
	public static void addProduct(int id, String name, double price, int quantity)
			throws ClassNotFoundException, SQLException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO grocery_list(id,name,price,quantity) VALUES(?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, price);
			pst.setInt(4, quantity);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			pst.close();
			ConnectionUtil.close(connection);
		}
	}

	/*
	 * Delete the product from the database.
	 */
	public static void deleteTask(int id) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM grocery_list WHERE id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			pst.close();
			ConnectionUtil.close(connection);
		}
	}
}