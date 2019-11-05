package WK1208;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;

public class UserMngmt {
/*
 * This class is used for user management and should not be accessed from outside.
 */
protected static boolean  validLogin(String username, String password) {
	
	if(username.trim().length() > 19 || password.trim().length()>19) {
		System.err.print("max 20 character");
		return false;
	}
	
	String dirPath = "res/usr.json";
	File file = new File(dirPath);
	
	try {
		String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
		JSONObject json = new JSONObject(content);
		JSONArray userArray = json.getJSONArray("users");
		
		for (Object object : userArray) {
			JSONObject temp = (JSONObject) object;
			String tempID = temp.getString("id");
			String tempPW = temp.getString("pw");
			
			if(!username.isEmpty() && !password.isEmpty()) {
				if(username.trim().equals(tempID) && password.trim().equals(tempPW))
				return true;
			}
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return false;
}

private static boolean userExist(String username) {
	String dirPath = "res/usr.json";
	File file = new File(dirPath);
	
	try {
		String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
		JSONObject json = new JSONObject(content);
		JSONArray userArray = json.getJSONArray("users");
		
		for (Object object : userArray) {
			JSONObject temp = (JSONObject) object;
			String tempID = temp.getString("id");
			if(username.equals(tempID))
				return true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
}
	return false;
}

protected static void createAccount(String username, String password) {
	if(!userExist(username)) {
		if(username.trim().length() > 19 || password.trim().length() >19) {
			System.err.println("Username or password to long! Please use max. 19 characters!");
			return;
		}
			if(username.trim().length() > 5 && password.trim().length() >5) { 
				String dirPath = "res/usr.json";
				File file = new File(dirPath);
				try {
					String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
					JSONObject json = new JSONObject(content);
					JSONArray jasonArray = json.getJSONArray("users");
					
					JSONObject otba = new JSONObject();
					otba.put("id", username.trim());
					otba.put("pw", password.trim());
					
					jasonArray.put(otba);
					
					FileWriter fw = new FileWriter(file);
					fw.write(json.toString());
					fw.flush();
					fw.close();
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			else
				System.err.println("Username and password need at least 6 characters");
			}
		
	else
		System.err.println("User already exists!");
}
}
