package WK1208;

public class Encryption {
	/*
	 * Jo Louis hier die Challenge:
	 * Verbessere den Algorithmus (Hab ich geklaut).
	 * Bevor du anfängst kannst du wenn du willst die "createAccount" Methode auf dumme Eingaben überprüfen. :D
	 * Du musst dir nicht die implementierung angucken.
	 * 
	 */
	
	//f(x)=y
	protected byte[] encrypt(byte[] data) {
		// TODO Auto-generated method stub
		byte[] enc = new byte[data.length];
		
		for (int i = 0; i < data.length; i++) {
		enc[i] = (byte) ((i%2 == 0)? data[i]+1:data[i]-1);	
		}
		return enc;
	}
	//g(y) = x
	protected byte[] decrypt(byte[] data) {
		// TODO Auto-generated method stub
		byte[] enc = new byte[data.length];
		
		for (int i = 0; i < data.length; i++) {
		enc[i] = (byte) ((i%2 == 0)? data[i] -1 :data[i] +1);	
		}
		return enc;
	}
}
