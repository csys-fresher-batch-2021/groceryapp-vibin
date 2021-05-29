package in.vibin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public static List<Long> getMobileNumber() throws SQLException,ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pst = null;
		List<Long> userMobileNumber = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM user_details";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				userMobileNumber.add((rs.getLong("mobilenumber")));
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
		return userMobileNumber;
	}
	public static void addUser(Long mobileNumber,String password) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO user_details(mobilenumber,password) VALUES(?,?)";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, mobileNumber);
			pst.setString(2, password);
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
