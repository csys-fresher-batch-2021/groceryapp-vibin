package in.vibin.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerValidationTest {

	@Test
	//The number is 0;
	public void IntegerValidationtest1() {
		int number=0;
		boolean isValid=NumberValidation.checkInteger(number);
		assertFalse(isValid);
	}
	@Test
	//The number is less than 0;
	public void IntegerValidationtest2() {
		int number=-1;
		boolean isValid=NumberValidation.checkInteger(number);
		assertFalse(isValid);
	}
	@Test
	//The number is greater than 0;
	public void IntegerValidationtest3() {
		int number=1;
		boolean isValid=NumberValidation.checkInteger(number);
		assertTrue(isValid);
	}

}
