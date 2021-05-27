package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.vibin.model.Product;
import in.vibin.util.ConnectionUtil;

public class GroceryListDAO {

	private GroceryListDAO() {
	}

	/*
	 * To get the product detail from the Data Base.
	 */
	public static List<Product> getProduct() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		List<Product> productList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM grocery_list";
			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setID(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				productList.add(product);

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
		return productList;
	}

	/*
	 * To add the product to the data base.
	 */
	public static void addProduct(Product product) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO grocery_list(id,name,price,quantity) VALUES(?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, product.getID());
			pst.setString(2, product.getName());
			pst.setDouble(3, product.getPrice());
			pst.setInt(4, product.getQuantity());
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
	public static void deleteProduct(int id) throws ClassNotFoundException, SQLException {
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
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				ConnectionUtil.close(connection);
			}
		}
	}

	public static void updateQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE grocery_list SET quantity =?WHERE id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, quantity);
			pst.setInt(2, id);
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
}
