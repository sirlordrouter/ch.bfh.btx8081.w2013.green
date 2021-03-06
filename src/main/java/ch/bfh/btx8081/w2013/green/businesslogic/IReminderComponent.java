package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;

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
     *      the medication to remind
	 */
	void pushReminder(Medication medicationName);
	
	/**
	 * Must implement a Method to add new Listener.
     *
	 * @param listener
     *      the listener listening to the <code>ReminderComponent</code>
	 */
	void addListener(IReminderComponentListener listener);
	
	/**
	 * Must implement a Method to remove listener
	 * @param listener
     *      the listener listening to the <code>ReminderComponent</code>
	 */
	void removeListener(IReminderComponentListener listener);


    /**
     * Must implement a Method vor scheduling a Timer for the given <code>Medication</code>
     * @param medication
     *      a medication to add to Timer
     */
    void addToSchedule(Medication medication);

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

        /**
         * Method to call when the ReminderComponent has a Medication which the Patient should take.
         *
         * @param medication
         *      Medication to remind on.
         */
		void pushReminder(Medication medication);
	}
}
