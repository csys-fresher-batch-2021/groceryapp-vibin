package in.vibin.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalConvertorTest {

	@Test
	public void validInputTest() {
		String number = "10.50";
		double number1 = 0.0;
		try {
			number1 = NumberValidation.parseDouble(number, "InvalidInput");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
		}
		assertEquals(10.50, number1, 0);
	}

	@Test
	public void inValidInputTest() {
		String number = "10ytjj56y";
		String errorMessage = null;
		try {
			NumberValidation.parseDouble(number, "InvalidInput");
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertEquals("InvalidInput", errorMessage);
	}

}
