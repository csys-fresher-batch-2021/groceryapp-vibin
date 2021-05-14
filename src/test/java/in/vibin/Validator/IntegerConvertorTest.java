package in.vibin.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerConvertorTest {

	@Test
	public void validInputTest() {
		String number = "10";
		int number1=0;
		try {
			 number1=NumberValidation.parseInt(number, "InvalidInput");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
		}assertEquals(10,number1);
	}
	@Test
	public void inValidInputTest() {
		String number = "10ytjj56y";
		String errorMessage=null;
		try {
			 NumberValidation.parseInt(number, "InvalidInput");
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}assertEquals("InvalidInput",errorMessage);
}
}
