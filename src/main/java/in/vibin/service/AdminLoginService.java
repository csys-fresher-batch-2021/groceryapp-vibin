package in.vibin.service;

import in.vibin.validator.*;

import java.util.Map;

import in.vibin.util.*;

public class AdminLoginService {
	private AdminLoginService() {
	}
	static Map<Long, String> adminLogin = Util.getAdminLogin();

	public static boolean admin(long mobileNumber, String password) {
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(mobileNumber);// To check the
																								// mobilenumber format
		boolean isValidPassword = PasswordValidation.checkPassword(password);// To check the password format
		boolean isAdmin = false;
		if (isValidMobileNumber && isValidPassword) {
			if (adminLogin.containsKey(mobileNumber) && adminLogin.get(mobileNumber).equals(password)) {
				isAdmin=true;
			}else {
				isAdmin=false;
			}
		}
		return isAdmin;
	}
}
