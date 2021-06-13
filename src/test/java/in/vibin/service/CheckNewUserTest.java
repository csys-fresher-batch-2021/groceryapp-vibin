package in.vibin.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckNewUserTest {

	@Test
	void testExistingUser() {
		long mobileNumber=9659644868L;
		boolean isNewUser=UserLoginService.isNewUser(mobileNumber);
		assertFalse(isNewUser);
	}
	@Test
	void testNewUser() {
		long mobileNumber=6380998915L;
		boolean isNewUser=UserLoginService.isNewUser(mobileNumber);
		assertTrue(isNewUser);
	}

}