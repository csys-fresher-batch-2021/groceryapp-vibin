package in.vibin.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminLoginTest {

	@Test
	public void testValidAdmin() {
		long mobileNumber=9659644868L;
		String password="Vibin#321";
		boolean isAdmin=AdminLoginService.admin(mobileNumber, password);
		assertTrue(isAdmin);
	}
	@Test
	public void testInValidAdmin() {
		long mobileNumber=6380998915L;
		String password="Vibin#321";
		boolean isAdmin=AdminLoginService.admin(mobileNumber, password);
		assertFalse(isAdmin);
	}

}
