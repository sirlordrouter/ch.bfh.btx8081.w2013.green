package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.User;

import java.util.ArrayList;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>All Registered Users are stored in this ArrayList-Database</p>
 *
 * @author Corina von Kaenel, vonkc2@bfh.ch
 * @version 08-12-2013
 */

public class RegisteredUserDB {

    private ArrayList<RegisteredUser> registeredUserList = new ArrayList<RegisteredUser>();

	// creation of default users for fast login during implementation phase
	private RegisteredUser admin = new RegisteredUser(0001,"a","a", "admin", "admin",  false);	
	private RegisteredUser patient = new RegisteredUser(1000,"p","p", "admin", "admin",  true);	
	// creation of users for all involved programmers
	private RegisteredUser dagde1 = new RegisteredUser(0010, "dagde1","dagde1", "Esma", "Dagdas", false);
	private RegisteredUser gnagj1 = new RegisteredUser(0011, "gnagj1","gnagj1", "Johannes", "Gnaegi", false);
	private RegisteredUser messv1 = new RegisteredUser(0012, "messv1","messv1", "Messerli", "Vinzenz", false);
	private RegisteredUser medim1 = new RegisteredUser(0013, "medim1","medim1", "Meryam", "Medini", false);
	private RegisteredUser vandj2 = new RegisteredUser(0014, "vandj2","vandj2", "Jan-Wiebe", "van der Sluis", false);
	private RegisteredUser vonkc2 = new RegisteredUser(0015,"vonkc2","vonkc2", "Corina", "von Kaenel", false);

	 public RegisteredUserDB(){
		 
		 this.registeredUserList.add( patient);
         this.registeredUserList.add( admin );
         this.registeredUserList.add( dagde1 );
         this.registeredUserList.add( medim1 );
         this.registeredUserList.add( messv1 );
         this.registeredUserList.add( gnagj1 ) ;
         this.registeredUserList.add( vandj2 );
         this.registeredUserList.add( vonkc2 );
	}
	
	 /*
	  * TODO (low priority, therefore not needed yet)
	  * @addRegisteredUser: add a new User to the DB-List
	  */
	 public void addRegisteredUser(RegisteredUser rUser){
		 this.registeredUserList.add(rUser);
	 }
	 
	 /*
	  * @verifyLogin: verify if the given loginUsername and loginPassword exist in the DB
	  * return true if the loginUsername and loginPassword exist in DB
	  */
	 public boolean verifyLogin(String loginUsername,String loginPassword){
		 if(registeredUserList.isEmpty()) {
		 	System.out.println("DB is empty");
		 	return false;
		 }
		 
		for (RegisteredUser ru: registeredUserList) {
			if(ru.getUsername().equals(loginUsername) && ru.getPassword().equals(loginPassword)) {
				System.out.println("hello " +  ru.getUsername());
				return true;
			}
		}
		 
		 return false;
	 }
	 
	 /*
	  * @verifyLogin: verify if the given loginUsername and loginPassword exist in the DB
	  * return true if the loginUsername and loginPassword exist in DB
	  */
	 public User assignUserAttributes(String username){
		 User currentUser = new User();
		 for (RegisteredUser ru : this.registeredUserList) {
			 if(ru.getUsername().equals(username)) {
				 currentUser.setId(ru.getId());
				 currentUser.setIsPatient(ru.getIsPatient());
				 currentUser.setFirstname(ru.getFirstname());
				 return currentUser;
			 }
		 }
		return currentUser;
	 }
	
}
