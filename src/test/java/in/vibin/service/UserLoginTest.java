package in.vibin.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UserLoginTest {

	@Test
	public void testValidUser() {
		long mobileNumber=9659644868L;
		String password="Vibin#321";
		boolean isUser=UserLoginService.user(mobileNumber, password);
		assertTrue(isUser);
	}
	@Test
	public void testInValidAdmin() {
		long mobileNumber=6380998915L;
		String password="Vibin#321";
		boolean isUser=UserLoginService.user(mobileNumber, password);
		assertFalse(isUser);
	}

}
