package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vibin.exception.RegisterUserException;
import in.vibin.exception.SuccessfullException;

class RegisterUserTest {
	@ParameterizedTest
    @CsvSource({
        "9659644868, Vibin@123,Vibin@123",
    })
  
	
	void testExistingMobileNumber(long mobileNumber,String password,String rePassword) {
		
		String errorMessage=null;
		try {
			RegisterUserService.registerUser(mobileNumber, password, rePassword);
		} catch (RegisterUserException e) {
			errorMessage=e.getMessage(); 
		} catch (SuccessfullException e) {
			errorMessage=e.getMessage(); 

		}
		assertEquals("MobileNumber Already Exist",errorMessage);
		//assertEquals("User Registered successfully /n Now you can login",errorMessage);
	}
	@ParameterizedTest
    @CsvSource({
        "9659644860, Vibin@123,Vibin@124",
    })
	void testPasswordMisMatched(long mobileNumber,String password,String rePassword) {
		
		String errorMessage=null;
		try {
			RegisterUserService.registerUser(mobileNumber, password, rePassword);
		} catch (RegisterUserException e) {
			errorMessage=e.getMessage(); 
		} catch (SuccessfullException e) {
			errorMessage=e.getMessage(); 

		}
		assertEquals("Confirmation password is not matched",errorMessage);
}
	@ParameterizedTest
    @CsvSource({
        "9659644865, Vibin@123,Vibin@123",
    })
	void testValidRegister(long mobileNumber,String password,String rePassword) {
		
		String errorMessage=null;
		try {
			RegisterUserService.registerUser(mobileNumber, password, rePassword);
		} catch (RegisterUserException e) {
			errorMessage=e.getMessage(); 
		} catch (SuccessfullException e) {
			errorMessage=e.getMessage(); 

		}
		assertEquals("User Registered successfully \n Now you can login",errorMessage);
}
}
