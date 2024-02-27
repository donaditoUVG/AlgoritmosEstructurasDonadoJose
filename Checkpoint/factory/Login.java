/**
 * 
 */

import java.util.HashMap;

/**
 * @author MAAG
 *
 */
public class Login {

	HashMap<String, String> users;
	
	public Login() {
		users = new HashMap<String, String>();
		users.put("don22@uvg.edu.gt", "1");
		users.put("prof@uvg.edu.gt", "cr7");
		users.put("maalonso_adm@uvg.edu.gt", "password3");
        users.put("donadito_audi@uvg.edu.gt", "1234");
		
	}
	
	public boolean hasAccess(String username, String password) {
		String savedPassword = users.get(username);
		if (savedPassword != null) {
			if (savedPassword.equals(password)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
}
