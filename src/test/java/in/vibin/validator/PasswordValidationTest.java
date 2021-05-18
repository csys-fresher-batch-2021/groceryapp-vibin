package in.vibin.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordValidationTest {

	@Test
	public void testValidPassword() {
		String password="Vibin#321";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertTrue(isValidPassword);
	}
	@Test
	public void testWithoutCaps() {
		String password="vibin#321";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testWithoutSmall() {
		String password="VIBIN#321";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testWithoutSpecialChar() {
		String password="VIBIN4321";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testWithoutNumber() {
		String password="VIBIN#vibin";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testPasswordLengthLessThanEight() {
		String password="Vibin#3";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testPasswordLengthGreaterThanTwelve() {
		String password="Vibin#3210987";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testPasswordIsNull() {
		String password=null;
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testPasswordIsEmptySpace() {
		String password="   ";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
	@Test
	public void testSpacesBetweenPassword() {
		String password="Vibin#32 1 ";
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}
}
