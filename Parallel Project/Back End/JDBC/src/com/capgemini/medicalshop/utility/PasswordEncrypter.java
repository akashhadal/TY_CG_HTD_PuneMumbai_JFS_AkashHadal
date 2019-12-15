package com.capgemini.medicalshop.utility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncrypter {
	public static String encryptPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}//End of encryptPassword
	
	public static boolean checkPassword(String plainTextPassword,String encryptedPassword) {
		
		if(BCrypt.checkpw(plainTextPassword, encryptedPassword)) {
			return true;
		}else {
			return false;
		}
		
	}//End of checkPassword
	
	
}//End of PasswordEncrypter
