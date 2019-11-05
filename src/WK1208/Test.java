package WK1208;

public class Test {
	/*
	 * testing purpose
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String 	username = "user",
				password = "pw",
				passwordE = Encryption.encrypt(password),
				passwordD = Encryption.decrypt(passwordE);
		
		UserMngmt.createAccount(username, passwordE);
		
		
		System.out.println(password.equals(passwordE));
		System.out.println(password.equals(passwordD));
		
		
		
		
	}

}
