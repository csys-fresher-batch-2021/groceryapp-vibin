package in.vibin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private ConnectionUtil() {
	}

	/**
	 * To get the connection from the Data Base.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/grocery_db";
		String username = "postgres";
		String password = "root";
		// Step 1: Load the jdbc driver in memory
		Class.forName(driverClass);
		// Step 2: Get the connection
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * To close the connection from the Data Base.
	 * 
	 * @param con
	 */
	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}