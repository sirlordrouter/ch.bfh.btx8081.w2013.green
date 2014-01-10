package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;

import java.util.*;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * Manages all the <code>MedicationTask</code> for the medications a patient must take.
 * As a Medication must be taken, the <code>ReminderComponent</code> pushes this medication to its listener,
 * so that it can be displayed.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 28-12-2013
 */
public class ReminderComponent implements IReminderComponent, IReminderComponentListener {

	private final static long ONCE_PER_DAY = 1000 * 60 * 60 * 24;
	private final static long FIVE_MINUTES = 1000*60*5;
	private final static int BREAKFAST = 7;
	private final static int LUNCH_TIME = 12;
	private final static int DINNER = 19;
	private final static int[] DUE_TIMES = {BREAKFAST, LUNCH_TIME, DINNER};
	
	private IReminderComponentListener listener = null;
    private Timer timer = null;

    /**
     * Constructor creates a new Timer, to which the MedicationTasks are added.
     */
     public ReminderComponent() {

    	 this.timer = new Timer();
    	 
     }
     
     private Date getTaskStartTime(int hour) {

    	 GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Zurich"),  Locale.GERMANY);

    	 cal.set(GregorianCalendar.MINUTE, 27);
    	 cal.set(GregorianCalendar.HOUR_OF_DAY, hour);

    	 return cal.getTime();
     }

    /**
     *  Adds a new <code>MedicationTask</code> to the timer for each
     *  time the patient must take the medication. The task is then scheduled once per day.
     *
     * @param medication
     *      Medication to Remind on
     */
    @Override
     public void addToSchedule(Medication medication) {
    	 int[] dueTimes = medication.getDueTimes();

    	 for (int i = 0; i < dueTimes.length; i++) {
			if (dueTimes[i] == 1) {
				 this.timer.scheduleAtFixedRate(
			 				new MedicationTask(medication, this), 
			 				getTaskStartTime(DUE_TIMES[i]),
                         FIVE_MINUTES);
			}
		}	
    	 
    	 //TODO: Remove
    	 System.out.println("Timer added!");
     }

    /**
     * Pushes the Reminder for the Medication to its listener.
     *
     * @param medication
     *      Medication to Remind on
     */
	@Override
	public void pushReminder(Medication medication) {
		
		synchronized (ReminderComponent.this) {
			if (this.listener != null) {
				this.listener.pushReminder(medication);
            }
		}
	}

    /**
     * Adds a listener for medication reminder
     *
     * @param l
     *      a ReminderComponentListener
     */
	@Override
	public void addListener(IReminderComponentListener l) {
		this.listener = l;
	}

    /**
     * Removes the listener for medication reminder
     *
     * @param l
     *      a ReminderComponentListener
     */
	@Override
	public void removeListener(IReminderComponentListener l) {
		this.listener = l;
	}
}
