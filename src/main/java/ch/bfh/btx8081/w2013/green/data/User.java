package ch.bfh.btx8081.w2013.green.data;


public class User {

    private int id = -1;
	private String username = null;
	private boolean isPatient = true;
	
	// TODO get Name and FirstName from DB to display in Views
	
			/* the following boolean get moved to state classes*/
			/* User hasAccess == true, if the entered Username and Password is registered in the DB 
			private boolean hasAccess = false;*/
			/* User isPatient == true, if Patientviews are connected with his Account
			private boolean isPatient = true; */
	
	public User() {
		
	}
	
	public User(int id, String username, boolean isAdmin) {
		this.username = username;
		this.id = id;
        this.isPatient = isAdmin;
	}
	
	
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

    public int getId() {
        return id;
    }

    public boolean isPatient() {
        return isPatient;
    }

    /**
	 * @return the isPatient
	 
	public boolean isPatient() {
		return isPatient;
	}*/

	/**
	 * @param isPatient the isPatient to set
	 
	public void setPatient(boolean isPatient) {
		this.isPatient = isPatient;
	} */

	/**
	 * @return the hasAccess
	 
	public boolean getHasAccess() {
		return hasAccess;
	}*/

	/**
	 * @param hasAccess the hasAccess to set
	 
	public void setHasAccess(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}*/


}
