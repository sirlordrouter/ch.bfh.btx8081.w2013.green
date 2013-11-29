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
		
		authenticateUser();
	}

	private void authenticateUser() {
		//TODO: Change default value to false to enable user checking!!!!
		boolean isCorrectUserPassword = true;
		//TODO: Auto-generated method stub
		//DataAccess get User(username,pw)
		//set Patient true/false
		//falls gefunden => true
		if (isCorrectUserPassword) {
			currentUser.setHasAccess(true);
		}
		
	}
}
