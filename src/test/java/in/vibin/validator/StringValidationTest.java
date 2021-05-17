package in.vibin.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringValidationTest {

	@Test
	public void testValidName() {
		String name="wheat";
		boolean isValid=StringValidation.checkString(name);
		assertTrue(isValid);
	}
	@Test
	public void testNullName() {
		String name=null;
		boolean isValid=StringValidation.checkString(name);
		assertFalse(isValid);
	}
	@Test
	public void testWEmptyName() {
		String name="";
		boolean isValid=StringValidation.checkString(name);
		assertFalse(isValid);
	}
}
