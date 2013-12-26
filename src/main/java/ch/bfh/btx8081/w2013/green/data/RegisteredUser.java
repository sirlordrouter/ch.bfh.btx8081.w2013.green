package ch.bfh.btx8081.w2013.green.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>User with all Attributes that are registered in the Database</p>
 *
 * @author Corina von Kaenel, vonkc2@bfh.ch
 * @version 08-12-2013
 */
@Entity
public class RegisteredUser {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String username = null;
	private String password = null;
	private String firstname = null;
	private String lastname = null;
	
	// @isPatient: true has access to PatientView; false (means is Admin) has access to Settingsview
	private boolean isPatient = false;

	
	public RegisteredUser(int id, String username, String password, String firstname, String lastname, boolean isPatient){
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.isPatient = isPatient;
	}
	
	protected int getId(){
		return this.id;
	}	
	protected String getUsername(){
		return this.username;
	}
	
	protected String getPassword(){
		return this.password;
	}
	
	protected String getFirstname(){
		return this.firstname;
	}
	
	protected String getLastname(){
		return this.lastname;
	}
	
	protected boolean getIsPatient(){
		return this.isPatient;
	}
	
	
}
