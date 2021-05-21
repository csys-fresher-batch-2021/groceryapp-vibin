package in.vibin.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidationTest {

	@Test
	void testValidPassword() {
		String password = "Vibin#321";
		boolean isValidPassword = PasswordValidation.checkPassword(password);
		assertTrue(isValidPassword);
	}

	@Test
	void testPasswordIsNull() {
		String password = null;
		boolean isValidPassword = PasswordValidation.checkPassword(password);
		assertFalse(isValidPassword);
	}

	@ParameterizedTest
	@ValueSource(strings = { "vibin#321", "VIBIN#321", "Vibin4321", "VIBIN#vibin", "Vibin#3", "Vibin#3210987", "   ",
			"Vibin#32 1 " })
	void testinValidPassword(String arg) {
		boolean isValidPassword = PasswordValidation.checkPassword(arg);
		assertFalse(isValidPassword);
	}
}
