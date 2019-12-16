package com.capgemini.medicalshop.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class ValidationsImpli implements Validations {

	static Validations validate = new ValidationsImpli();

	
	// Regex
		@Override
		public Integer validateNumber(String id) {
			Pattern pat = Pattern.compile("\\d+");
			Matcher mat = pat.matcher(id);
			if (mat.matches()) {
				return Integer.parseInt(id);
			} else {
				return null;
			}
		}// End of numberValidate()
	
	@Override
	public String emailIdValidate(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			return email;
		} else {
			return null;
		}
	}// End of emailIdValidate()

	@Override
	public Double doubleValidate(String number) {
		Pattern pat = Pattern.compile("\\d+.\\d\\d");
		Matcher mat = pat.matcher(number);
		if (mat.matches()) {
			return Double.parseDouble(number);
		}
		return null;
	}// End of doubleValidate()

	@Override
	public Long contactValidate(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if (mat.matches()) {
			return Long.parseLong(contact);
		}
		return null;
	}// End of contactValidate()

	@Override
	public String passwordValidate(String password) {
		Pattern pat = Pattern.compile(".{8,}");
		Matcher mat = pat.matcher(password);
		if (mat.matches()) {
			return password;
		}
		return null;
	}//End of passwordValidate()
	
	@Override
	public String charValidate(String character) {
		Pattern pat = Pattern.compile("[a-z]");
		Matcher mat = pat.matcher(character);
		if (mat.matches()) {
			return character;
		}
		return null;
	}//End of passwordValidate()
	
	@Override
	public Long cardNumberValidator(String cardNumber) {
		Pattern pat = Pattern.compile("\\d{16}");
		Matcher mat = pat.matcher(cardNumber);
		if (mat.matches()) {
			return Long.parseLong(cardNumber);
		}
		return null;

	}// End of cardNumberValidator()

	@Override
	public int month(int month) {
		if (month < 1 && month > 12) {
			return month;
		}
		return 0;
	}

	@Override
	public Integer year(String year) {
		Pattern pat = Pattern.compile("\\d{4}");
		Matcher mat = pat.matcher(year);
		if (mat.matches()) {
			return Integer.parseInt(year);
		}
		return null;
	}

	@Override
	public Integer checkCVV(String cvv) {
		Pattern pat = Pattern.compile("\\d{3}");
		Matcher mat = pat.matcher(cvv);
		if (mat.matches()) {
			return Integer.parseInt(cvv);
		}
		return null;
	}

	@Override
	public boolean userNameValidate(String userName) {
		 
		return false;
	}


}
