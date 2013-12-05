package ch.bfh.btx8081.w2013.green.businesslogic;

import java.util.TimerTask;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;

public class MedicationTask extends TimerTask {

	
	private Medication medicationName;
	private IReminderComponentListener reminder;
	
	public MedicationTask(Medication medication, IReminderComponentListener reminderComponent) {
		this.medicationName = medication;
		this.reminder = reminderComponent;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			reminder.pushReminder(medicationName);
		}
		
	}

}
