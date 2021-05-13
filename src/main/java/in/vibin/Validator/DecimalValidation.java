package in.vibin.Validator;

public class DecimalValidation {
	/**
	 * To check the decimal number is not <=0.0
	 * 
	 * @param number
	 * @return
	 */
	public static boolean checkDecimal(double price) {
		boolean isValid = true;
		if (price <= 0.0) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}
	public static double parseDouble(String number, String errorMessage) {
		double value = 0;
		try {
			value = Double.parseDouble(number);
		} catch (NumberFormatException e) {
			throw new RuntimeException(errorMessage);
		}
		return value;
	}
}
