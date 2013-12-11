package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.DataAccess;
import ch.bfh.btx8081.w2013.green.data.User;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Manages all the data for the the specific user</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 *
 * @version 11-12-2013
 */
public class UserDataManager {

	private static UserDataManager singleton = null;

	private User currentUser = null;
	//TODO: Replace dataAccess with interface
	private DataAccess dataAccess = null;

    /**
     * getter for the <code>UserDataManger</code> instance.
     *
     * @return
     *      the instance of the <code>UserDataManager</code>
     */
	public static UserDataManager getSingleton() { 
		if (singleton == null) {
				singleton = new UserDataManager();
		}
	    return singleton;
	}

    /**
     *  the Constructor for this singleton
     */
	private UserDataManager() {	}

    /**
     * Gets all the Data related to this User
     */
	public void getUserData() {
		
	}

	/**
     * getter for the current User.
     *
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}

	/**
     * setter for the current User
     *
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
