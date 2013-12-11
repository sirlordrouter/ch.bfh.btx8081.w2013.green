package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.IDataAccess;
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
public abstract class UserDataManager {


	protected User currentUser = null;
	//TODO: Replace dataAccess with interface
	protected IDataAccess dataAccess = null;

    /**
     *  the Constructor
     */
	protected UserDataManager() {	}

    /**
     *  the Constructor
     */
    protected UserDataManager(User currentUser, IDataAccess dataAccess) {

        this.currentUser = currentUser;
        this.dataAccess = dataAccess;

    }

    /**
     * Gets all the Data related to this User
     */
	protected void getUserData() { }

	/**
     * getter for the current User.
     *
	 * @return the currentUser
	 */
	public final User getCurrentUser() {
		return this.currentUser;
	}

	/**
     * setter for the current User
     *
	 * @param currentUser the currentUser to set
	 */
	public final void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
