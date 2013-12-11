package ch.bfh.btx8081.w2013.green.businesslogic;

import java.util.TimerTask;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.data.Medication;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 * <p>
 * Describes a Task to take a specific <code>Medication</code>
 * Extends the <code>TimerTask</code>.
 * When the timer is elapsed, the Task calls the <code>ReminderComponent</code>.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 11-12-2013
 */
public class MedicationTask extends TimerTask {

	private Medication medicationName = null;
	private IReminderComponentListener reminder = null;

    /**
     * Constructor for the <code>MedicationTask</code>.
     * It needs the Medication context for which the task is created
     * and a <code>ReminderComponent</code> to callback when it's time
     * to take the medication.
     *
     * @param medication
     *      a medication for which the task is defined.
     * @param reminderComponent
     *      a reminder component to call when it's time
     */
	public MedicationTask(Medication medication, IReminderComponentListener reminderComponent) {
		this.medicationName = medication;
		this.reminder = reminderComponent;
	}

    /**
     * callback for the timer on elapsed time
     */
	@Override
	public void run() {
		synchronized (this) {
			this.reminder.pushReminder(medicationName);
		}
		
	}

}
