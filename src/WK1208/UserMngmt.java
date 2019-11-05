package WK1208;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;

public class UserMngmt {
/*
 * This class is used for user management and should not be accessed from outside.
 */
	protected static boolean  validLogin(String username, String password) {
	
	File file = new File("res/usr.json");
	
	try {
		String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
		JSONObject json = new JSONObject(content);
		JSONObject client = json.getJSONObject(username);
		Encryption enc = new Encryption();
		String passwordR = new String(enc.decrypt(client.getString("Passwort").getBytes()));
		return password.equals(passwordR);
		
	} catch (JSONException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

	private static boolean userExist(String username) {
	File file = new File("res/usr.json");
	
	try {
		String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
		JSONObject json = new JSONObject(content);
		JSONObject user = json.getJSONObject(username);
		return true;
		
	} catch (JSONException  | IOException e) {
		return false;
	}
}

	protected static void createAccount(String username, String password) {
	if(!userExist(username))
		testInput(username, password);
	else
		System.err.println("Existing user!");
}

	private static void testInput(String username, String password) {
	if((!username.isEmpty() && !password.isEmpty()))
		if(username.trim().length() > 4 && password.trim().length() > 4)
			if(username.trim().length() < 19 && password.trim().length() < 19)
				setUser(username, password);		
}

	private static void setUser(String username, String password) {
	final long start = System.currentTimeMillis();  
		
		File file = new File("res/usr.json");
	try {
		String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
		JSONObject json = new JSONObject(content);
		
		JSONObject newUser = new JSONObject();
		Encryption enc = new Encryption();
		String encPassword = new String(enc.encrypt(password.getBytes()));
		newUser.put("Passwort", encPassword);
		json.accumulate(username, newUser);
		
		FileWriter fw = new FileWriter(file);
		fw.write(json.toString());
		fw.flush();
		fw.close();
		
	} catch (JSONException  | IOException e) {
		// TODO: handle exception
	}
	final long end = System.currentTimeMillis();
	System.out.printf("Account in %d ms erstellt%n",end-start);
	return;
	
	}
	}



