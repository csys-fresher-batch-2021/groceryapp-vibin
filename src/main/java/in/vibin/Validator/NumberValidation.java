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
}
