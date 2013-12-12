package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.RegisteredUserDB;
import ch.bfh.btx8081.w2013.green.data.User;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * A class used to verify a user context.
 * The <code>LoginManager</code> takes a user context and verifies
 * the credentials of this user against the stored data in the database.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @author Corina von Känel, vonkc2@bfh.ch
 *
 * @version 11-12-2013
 */
public class LoginManager {

    private static LoginManager loginManagerInstance = null;

	private User currentUser = null;

    public RegisteredUserDB getUserDB() {
        return userDB;
    }

    private RegisteredUserDB userDB = new RegisteredUserDB();

    public static LoginManager getLoginManager() {

        if(loginManagerInstance == null) {
            loginManagerInstance = new LoginManager();
        }

        return loginManagerInstance;
    }

    /**
     * Constructor for the LoginManager.
     *
     */
    private LoginManager () {
    }

    /**
     * A getter for the User initiating the Session.
     *
     * @return the currentUser
     *      the User initiating the Session
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Verifies the given credentials as valid or invalid
     *
     * @param loginUsername
     *      A username
     * @param loginPassword
     *      A password
     * @return
     *      state of the verification (valid = true, invalid : false)
     */
	public boolean authenticateUserAccess(String loginUsername, String loginPassword) {

        boolean isVerified = userDB.verifyLogin(loginUsername, loginPassword);
        if (isVerified) {
            this.currentUser = userDB.getAuthenticatedUser(loginUsername, loginPassword);
        }

		return isVerified;

	}
}
