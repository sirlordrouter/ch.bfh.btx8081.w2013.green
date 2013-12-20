package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;

import java.util.*;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Manages the rem</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 02-12-2013
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

     public ReminderComponent() {

    	 this.timer = new Timer();
    	 
     }
     
     private Date getTaskStartTime(int hour) {

    	 GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Zurich"),  Locale.GERMANY);

    	 cal.set(GregorianCalendar.MINUTE, 27);
    	 cal.set(GregorianCalendar.HOUR_OF_DAY, hour);

    	 return cal.getTime();
     }

    @Override
     public void addToSchedule(Medication medication) {
    	 int[] dueTimes = medication.getDueTimes();

    	 for (int i = 0; i < dueTimes.length; i++) {
			if (dueTimes[i] == 1) {
				 this.timer.scheduleAtFixedRate(
			 				new MedicationTask(medication, this), 
			 				getTaskStartTime(DUE_TIMES[i]),
			 				ONCE_PER_DAY);
			}
		}	
    	 
    	 //TODO: Remove
    	 System.out.println("Timer added!");
     }

	@Override
	public void pushReminder(Medication medicationName) {
		
		synchronized (ReminderComponent.this) {
			if (this.listener != null) {
				this.listener.pushReminder(medicationName);
            }
		}
	}

	@Override
	public void addListener(IReminderComponentListener l) {
		this.listener = l;
	}

	@Override
	public void removeListener(IReminderComponentListener l) {
		this.listener = l;
	}
     
//     public void addShortTimer(Medication medication, IReminderComponent listener) {
//
//				 timer.schedule(
//			 				new MedicationTask(medication.getMedicationName(), listener), 
//			 				getTaskStartTime(DUETIMES[i]), 
//			 				 FIVE_MINUTES);
//			}
//		}	
//     }

     
     
}
