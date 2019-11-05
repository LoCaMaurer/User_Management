package WK1208;

public class Encryption {
	/*
	 * Jo Louis hier die Challenge:
	 * Schreibe in folgende zwei Methoden ein Algorithmus zum verschlüsseln und
	 * entschlüsseln der Passwörter. (bitte die Algorithmen in der Klasse UserMngmt in ruhe lassen^^)
	 * Ist schwierig deswegen Challenge.
	 * 
	 * 
	 * Bevor du anfängst kannst du wenn du willst die "createAccount" Methode auf dumme Eingaben überprüfen. :D
	 * Du musst dir nicht die implementierung angucken.
	 * Ein Besipiel ist für die createAccount Methode ist in der Klasse Test.
	 * Lasset die Spiele beginnen!
	 * 
	 * ps. Du kannst die Rechtschreibfehler hier korrigieren.
	 * 
	 */
	
	

	/*
	 * Encrypt must !equals! decrypt!
	 * Example in class Test with existing methods
	 */
	
	protected byte[] encrypt(byte[] data) {
		// TODO Auto-generated method stub
		byte[] enc = new byte[data.length];
		
		for (int i = 0; i < data.length; i++) {
		enc[i] = (byte) ((i%2 == 0)? data[i]+1:data[i]-1);	
		}
		return enc;
	}
	
	protected byte[] decrypt(byte[] data) {
		// TODO Auto-generated method stub
		byte[] enc = new byte[data.length];
		
		for (int i = 0; i < data.length; i++) {
		enc[i] = (byte) ((i%2 == 0)? data[i] -1 :data[i] +1);	
		}
		return enc;
	}
}
