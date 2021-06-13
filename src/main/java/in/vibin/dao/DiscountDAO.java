package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.vibin.util.ConnectionUtil;

public class DiscountDAO {
	private DiscountDAO() {
	}

	/*
	 * To get the product detail from the Data Base.
	 */
	public static int getDiscount() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		int discount=0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT discount FROM discount WHERE sno=1";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				discount=rs.getInt("discount");
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
		return discount;
	}
	public static void updateDiscount(int discount) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE discount SET discount="+discount+"WHERE sno=1";
			pst = connection.prepareStatement(sql);
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
}
