package ch.bfh.btx8081.w2013.green.data;
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
public class RegisteredUser {
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	// @isPatient has access to 
	private boolean isPatient;
	// @isAdmin has access to settings
	private boolean isAdmin;

	
	public RegisteredUser(String username, String password, String firstname, String lastname, boolean isPatient, boolean isAdmin){
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.isPatient=isPatient;
		this.isAdmin=isAdmin;
		
	}
	
	protected String getUsername(){
		return username;
	}
	
	protected String getPassword(){
		return password;
	}
	
	protected String getFirstname(){
		return firstname;
	}
	
	protected String getLastname(){
		return lastname;
	}
	
	protected boolean getIsPatient(){
		return isPatient;
	}
	
	protected boolean getIsAdmin(){
		return isAdmin;
	}
	
}
