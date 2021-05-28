package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.vibin.util.ConnectionUtil;

public class UserListDAO {
	private UserListDAO() {
	}
	public static boolean isUser(long mobileNumber, String password) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		boolean loggedIn = false;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT (mobilenumber,password) FROM user_details WHERE mobilenumber=? AND password=?";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, mobileNumber);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				loggedIn = true;
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
		return loggedIn;
	}
}
