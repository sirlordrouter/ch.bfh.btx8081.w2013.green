/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * 
 *<p>Class Description</p>
 *
 * @author group_green, Johannes Gnaegi
 * @version 29-11-2013
 */
package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.RegisteredUserDB;
import ch.bfh.btx8081.w2013.green.data.User;

public class LoginManager {

	private User currentUser = null;
	private RegisteredUserDB userDB = new RegisteredUserDB();
	
	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public LoginManager (User newUser) {
		currentUser = newUser;

	}

	public boolean authenticateUserAccess(String loginUsername, String loginPassword) {
		boolean loginVerified = userDB.verifyLogin(loginUsername, loginPassword);
		return loginVerified;
		
	}
}
