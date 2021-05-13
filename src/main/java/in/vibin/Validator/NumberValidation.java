package in.vibin.Validator;

public class NumberValidation {
	/**
	 * To check the number is not <=0
	 * 
	 * @param number
	 * @return
	 */
	public static boolean checkNumber(int number) {
		boolean isValid = true;
		if (number <= 0) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}

	public static int parseInt(String number, String errorMessage) {
		int value = 0;
		try {
			value = Integer.parseInt(number);
			return value;
		} catch (NumberFormatException e) {
			throw new RuntimeException(errorMessage);
		}
		
	}
	public static double parseDouble(String number, String errorMessage) {
		double value = 0;
		try {
			value = Double.parseDouble(number);
			return value;
		} catch (NumberFormatException e) {
			throw new RuntimeException(errorMessage);
		}
		
	}
}
