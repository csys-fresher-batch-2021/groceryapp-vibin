package in.vibin.service;

import java.sql.SQLException;
import java.util.List;

import in.vibin.dao.UserListDAO;
import in.vibin.exception.RegisterUserException;
import in.vibin.exception.SuccessfullException;

public class RegisterUserService {
private RegisterUserService() {
}
public static boolean isUserMobileNumberExist(long mobileNumber) {
	boolean isExist=false;
	try {
		List<Long>userMobileNumberList=UserListDAO.getMobileNumber();
		for(Long existMobileNumber:userMobileNumberList) {
			if(existMobileNumber==mobileNumber) {
				isExist=true;
			}
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return isExist;
}

public static void registerUser(Long mobileNumberLong,String password,String rePassword) throws RegisterUserException, SuccessfullException {
boolean isExistMobileNumber=RegisterUserService.isUserMobileNumberExist(mobileNumberLong);
if(isExistMobileNumber) {
	throw new RegisterUserException("User Already exist. Please Check The Mobile Number");
}
else if(password.equals(rePassword)) {
		try {
			UserListDAO.addUser(mobileNumberLong, rePassword);
			throw new SuccessfullException("User Registered successfully \n Now you can login");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	else {
		throw new RegisterUserException("Confirmation password is not matched");
	}
}
}
