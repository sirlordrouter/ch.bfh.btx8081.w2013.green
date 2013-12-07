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

import ch.bfh.btx8081.w2013.green.data.User;

public class LoginManager {

	private User currentUser;
	
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
		authenticateUserAccess();

	}

	private void authenticateUserAccess() {
		//TODO: Change default value to false to enable user checking!!!!
		boolean isCorrectUserPassword = true;

		//DataAccess get User(username,pw)
		//set Patient true/false
		//falls gefunden => true
		if (isCorrectUserPassword) {
			//currentUser.setHasAccess(true);
		}
		
	}
}
