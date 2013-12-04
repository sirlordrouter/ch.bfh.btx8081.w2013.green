package ch.bfh.btx8081.w2013.green.data;

public class User {

	private String username;
	private String password;
	/* User hasAccess == true, if the entered Username and Password is registered in the DB */
	private boolean hasAccess = false;
	/* User isPatient == true, if Patientviews are connected with his Account*/
	private boolean isPatient = true;
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isPatient
	 */
	public boolean isPatient() {
		return isPatient;
	}

	/**
	 * @param isPatient the isPatient to set
	 */
	public void setPatient(boolean isPatient) {
		this.isPatient = isPatient;
	}

	/**
	 * @return the hasAccess
	 */
	public boolean getHasAccess() {
		return hasAccess;
	}

	/**
	 * @param hasAccess the hasAccess to set
	 */
	public void setHasAccess(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}

	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
