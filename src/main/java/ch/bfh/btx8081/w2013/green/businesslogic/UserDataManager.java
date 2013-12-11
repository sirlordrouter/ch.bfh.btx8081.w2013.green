package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.DataAccess;
import ch.bfh.btx8081.w2013.green.data.User;

public class UserDataManager {

	private static UserDataManager singleton = null;

	private User currentUser = null;
	//TODO: Replace dataAccess with interface
	private DataAccess dataAccess = null;
	
	public static UserDataManager getSingleton() { 
		if (singleton == null) {
				singleton = new UserDataManager();
		}
	    return singleton;
	}
	
	private UserDataManager() {	}
	
	public void getUserData() {
		
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
