package ch.bfh.btx8081.w2013.green.businesslogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;



/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 02-12-2013
 */
public class ReminderComponent implements IReminderComponent, IReminderComponentListener {

	private final static long ONCE_PER_DAY = 1000 * 60 * 60 * 24;
	private final static int ZERO_MINUTES = 0;
	private final static long FIVE_MINUTES = 1000*60*5;
	private final static int BREAKFAST = 7;
	private final static int LUNCHTIME = 12;
	private final static int DINNER = 19;
	private final static int[] DUETIMES = {BREAKFAST, LUNCHTIME, DINNER};
	
	private List<IReminderComponentListener> listeners = new ArrayList<IReminderComponentListener>();
	
     Timer timer = null;

     public ReminderComponent() {
    	 timer = new Timer();
    	 
     }
     
     private Date getTaskStartTime(int hour) {

    	 GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Zurich"),  Locale.GERMANY);
    	 cal.set(GregorianCalendar.MINUTE, 59);
    	 cal.set(GregorianCalendar.HOUR_OF_DAY, hour);	 
    	 return cal.getTime();
     }
     
     public void addNormalTimer(Medication medication) {
    	 int[] dueTimes = medication.getDueTimes();
    	 for (int i = 0; i < dueTimes.length; i++) {
			if (dueTimes[i] == 1) {
				 timer.scheduleAtFixedRate(
			 				new MedicationTask(medication.getMedicationName(), this), 
			 				getTaskStartTime(DUETIMES[i]), 
			 				FIVE_MINUTES);
			}
		}	
    	 
    	 //TODO: Remove
    	 System.out.println("Timer added!");
     }

	@Override
	public void showAlert(String medicationName) {
		synchronized (ReminderComponent.this) {
			for (IReminderComponentListener l : listeners) {
				l.showAlert(medicationName);
			}
		}

		
	}

	@Override
	public void addListener(IReminderComponentListener l) {
		listeners.add(l);
	}

	@Override
	public void removeListener(IReminderComponentListener l) {
		// TODO Auto-generated method stub
		listeners.remove(l);
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
