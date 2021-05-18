package in.vibin.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongConverterTest {

	@Test
	public void testValidNumber() {
		String number="9659644868";
		long longNumber=NumberValidation.parseLong(number,"Invalid number");
		assertEquals(9659644868L,longNumber);
	}
	@Test
	public void testInValidNumber() {
		String errorMessage=null;
		String number="96596ty78";
		long mobileNumber=0;
		try {
		mobileNumber=NumberValidation.parseLong(number,"Invalid number");
		}catch(NumberFormatException e) {
			errorMessage=e.getMessage();
		}
		assertEquals("Invalid number",errorMessage);
		assertEquals(0,mobileNumber);
	}
}
