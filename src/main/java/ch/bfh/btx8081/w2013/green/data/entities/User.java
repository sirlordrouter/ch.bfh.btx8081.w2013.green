package ch.bfh.btx8081.w2013.green.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * A class used to now about the current logged in user.
 * The <code>User</code> contains id, username, firstname, and isPatient information of the current logged in user
 *</p>
 *
 * @author Corina von Känel, vonkc2@bfh.ch
 *
 * @version 17-12-2013
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private int id = -1;
	private boolean isPatient = false;
	private String firstname = null;
	private String lastname = null;

	
	// TODO get Name and FirstName from DB to display in Views
	
			/* the following boolean gets moved to state classes*/
			/* User hasAccess == true, if the entered Username and Password is registered in the DB 
			private boolean hasAccess = false;*/

	public User(){
		
	}
	
	public User(int id, boolean isPatient, String firstname, String lastname) {
		
		this.id = id;
		this.isPatient = isPatient;
		this.firstname = firstname;
		this.lastname = lastname;

	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param isPatient the Role of the User (true:Patient or false:Admin)
	 */
	public void setIsPatient(boolean isPatient) {
		this.isPatient = isPatient;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.firstname = lastname;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
    /**
	 * @return isPatient
	 */
	public boolean getIsPatient() {
		return isPatient;
	}
    /**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
}
