package regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private Register reg;
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_PASSWORD_REGEX = Pattern
			.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

	public Validator(Register reg) {
		this.reg = reg;
	}

	public boolean validateEmail() {
		return validate(reg.getEmail(), VALID_EMAIL_ADDRESS_REGEX);
	}

	public boolean validatePassword() {
		return validate(reg.getPassword(), VALID_PASSWORD_REGEX);
	}

	private boolean validate(String Str, Pattern pattern) {
		Matcher matcher = pattern.matcher(Str);
		return matcher.matches();
	}
}
