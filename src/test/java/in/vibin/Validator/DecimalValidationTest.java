package in.vibin.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalValidationTest {

	@Test
	// The number is 0.0;
	public void IntegerValidationtest1() {
		double number = 0.0;
		boolean isValid = NumberValidation.checkDecimal(number);
		assertFalse(isValid);
	}

	@Test
	// The number is less than 0.0;
	public void IntegerValidationtest2() {
		double number = -1.0;
		boolean isValid = NumberValidation.checkDecimal(number);
		assertFalse(isValid);
	}

	@Test
	// The number is greater than 0.0;
	public void IntegerValidationtest3() {
		double number = 1.0;
		boolean isValid = NumberValidation.checkDecimal(number);
		assertTrue(isValid);
	}

}
