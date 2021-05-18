package in.vibin.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalConverterTest {

	@Test
	public void validInputTest() {
		String number = "10.50";
		double number1 = 0.0;
			number1 = NumberValidation.parseDouble(number, "InvalidInput");
		assertEquals(10.50, number1, 0);
	}

	@Test
	public void inValidInputTest() {
		String number = "10ytjj56y";
		String errorMessage = null;
		double value=0.0;
		try {
			value=NumberValidation.parseDouble(number, "InvalidInput");
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertEquals("InvalidInput", errorMessage);
		assertEquals(0.0,value,0);
	}

}
