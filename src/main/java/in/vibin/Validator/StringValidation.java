package in.vibin.Validator;

public class StringValidation {
	/**
	 * To check the string is not null. This method will return, reutrn true => If
	 * it is a valid string. return false =>If it is a invalid string.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean checkString(String name) {
		boolean isValid = true;
		if (name == null || name.trim().equals("")) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}
}
