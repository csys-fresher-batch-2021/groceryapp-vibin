package in.vibin.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MobileNumberValidationTest {
	@Test
	void testValidMobileNumber() {
		long mobileNumber = 9659644868L;
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(mobileNumber);
		assertTrue(isValidMobileNumber);
	}

	@ParameterizedTest
	@ValueSource(longs = { 5659644868L, 965964486878L, 96596448L })
	void inValidMobileNUmber(long arg) {
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(arg);
		assertFalse(isValidMobileNumber);
	}

}
