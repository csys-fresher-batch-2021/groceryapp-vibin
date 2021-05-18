package in.vibin.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MobileNumberValidationTest {

	@Test
	public void testValidMobileNumber() {
		long mobileNumber=9659644868L;
		boolean isValidMobileNumber=MobileNumberValidation.checkMobileNumber(mobileNumber);
		assertTrue(isValidMobileNumber);
	}
	
	@Test
	public void testmobileNumberFormat() {
		long mobileNumber=5659644868L;
		boolean isValidMobileNumber=MobileNumberValidation.checkMobileNumber(mobileNumber);
		assertFalse(isValidMobileNumber);
	}
	@Test
	public void testmobileNumberLengthGreaterThanTen() {
		long mobileNumber=965964486878L;
		boolean isValidMobileNumber=MobileNumberValidation.checkMobileNumber(mobileNumber);
		assertFalse(isValidMobileNumber);
	}
	@Test
	public void testmobileNumberLengthLesserThanTen() {
		long mobileNumber = 96596448L;
		boolean isValidMobileNumber=MobileNumberValidation.checkMobileNumber(mobileNumber);
		assertFalse(isValidMobileNumber);
	}
}
