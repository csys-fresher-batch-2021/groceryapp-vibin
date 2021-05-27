package in.vibin.service;

import in.vibin.validator.*;

import java.sql.SQLException;

import in.vibin.dao.AdminListDAO;

public class AdminLoginService {
	private AdminLoginService() {
	}

	/**
	 * To che the Admin login.
	 * 
	 * @param mobileNumber
	 * @param password
	 * @return
	 */
	public static boolean admin(long mobileNumber, String password) {
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(mobileNumber);// To check the // //
																								// mobilenumber format
		boolean isValidPassword = PasswordValidation.checkPassword(password);// To check the password format
		boolean isAdmin = false;
		if (isValidMobileNumber && isValidPassword) {
			try {
				isAdmin = AdminListDAO.isAdmin(mobileNumber, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return isAdmin;
	}
}