package in.vibin.service;
import java.sql.SQLException;

import in.vibin.dao.SellingHistoryDAO;
import in.vibin.dao.UserListDAO;
import in.vibin.validator.MobileNumberValidation;
import in.vibin.validator.PasswordValidation;

public class UserLoginService {
	private UserLoginService() {
	}
	public static boolean user(long mobileNumber, String password) {
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(mobileNumber);// To check the // //
																								// mobilenumber format
		boolean isValidPassword = PasswordValidation.checkPassword(password);// To check the password format
		boolean isUser = false;
		if (isValidMobileNumber && isValidPassword) {
			try {
				isUser = UserListDAO.isUser(mobileNumber, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return isUser;
	}
	public static boolean isNewUser(long mobileNumber) {
		boolean isNewUser=true;
		try {
			isNewUser = SellingHistoryDAO.isNewUser(mobileNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return isNewUser;
	}
}
