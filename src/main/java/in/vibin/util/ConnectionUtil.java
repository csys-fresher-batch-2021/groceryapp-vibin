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
	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
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