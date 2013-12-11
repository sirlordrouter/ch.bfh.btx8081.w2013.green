package ch.bfh.btx8081.w2013.green.data;

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

	// creation of default users
	private RegisteredUser admin = new RegisteredUser("admin","Vaadmin", "admin", "admin",  true, true);	
	private RegisteredUser dagde1 = new RegisteredUser("dagde1","dagde1", "Esma", "Dagdas", true, true);
	private RegisteredUser gnagj1 = new RegisteredUser("gnagj1","gnagj1", "Johannes", "Gnaegi", true, true);
	private RegisteredUser messv1 = new RegisteredUser("messv1","messv1", "Messerli", "Vinzenz", true, true);
	private RegisteredUser medim1 = new RegisteredUser("medim1","medim1", "Meryam", "Medini", true, true);
	private RegisteredUser vandj2 = new RegisteredUser("vandj2","vandj2", "Jan-Wiebe", "van der Sluis", true, true);
	private RegisteredUser vonkc2 = new RegisteredUser("vonkc2","vonkc2", "Corina", "von Kaenel", true, true);

	 public RegisteredUserDB(){
		 
		 this.registeredUserList.add( vonkc2 );
         this.registeredUserList.add( admin );
         this.registeredUserList.add( dagde1 );
         this.registeredUserList.add( medim1 );
         this.registeredUserList.add( messv1 );
         this.registeredUserList.add( gnagj1 ) ;
         this.registeredUserList.add( vandj2 );
	}
	
	 // @addRegisteredUser: add a new User to the DB-List
	 public void addRegisteredUser(RegisteredUser rUser){
		 this.registeredUserList.add(rUser);
	 }
	 
	 //@verifyLogin: verify if the given loginUsername and loginPassword exist in the DB
	 public boolean verifyLogin(String loginUsername,String loginPassword){
		 if(registeredUserList.isEmpty() == true) { 
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
	
}
