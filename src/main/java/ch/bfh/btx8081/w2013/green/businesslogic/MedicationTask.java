package ch.bfh.btx8081.w2013.green.businesslogic;

import java.util.TimerTask;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;

public class MedicationTask extends TimerTask {

	
	private String medicationName;
	private IReminderComponentListener reminder;
	
	public MedicationTask(String medicationName, IReminderComponentListener reminderComponent) {
		this.medicationName = medicationName;
		this.reminder = reminderComponent;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			reminder.showAlert(medicationName);
		}
		
	}

}