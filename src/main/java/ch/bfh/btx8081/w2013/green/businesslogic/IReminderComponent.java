package ch.bfh.btx8081.w2013.green.businesslogic;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>
 *An Interface which describes the functions which the  
 *<code>ReminderComponent</code> must implement.
 *It implements the <code>IReminderComponentListener</code> for 
 *<code>IReminderComponent</code> callbacks.
 *</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 04-12-2013
 */
public interface IReminderComponent {
	
	/**
	 * Must implement a Method to get Reminder Information.
	 * @param medicationName
	 */
	public void pushReminder(Medication medicationName);
	
	/**
	 * Must implement a Method to add new Listener.
	 * @param listener
	 */
	public void addListener(IReminderComponentListener listener);
	
	/**
	 * Must implement a Mthod to remove listener
	 * @param llistener
	 */
	public void removeListener(IReminderComponentListener llistener);
	
	/**
	 * Berner Fachhochschule</br>
	 * Medizininformatik BSc</br>
	 * Modul 8081, HS2013</br>
	 * 
	 *<p>An Interface which describes an Interface for callbacks from the <code>IReminderComponent</code></p>
	 *
	 * @author Johannes Gnaegi, gnaegj1@bfh.ch
	 * @version 04-12-2013
	 */
	interface IReminderComponentListener {
		void pushReminder(Medication medicationName);
	}
}
