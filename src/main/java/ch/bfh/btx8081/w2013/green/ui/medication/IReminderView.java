package ch.bfh.btx8081.w2013.green.ui.medication;

import de.steinwedel.messagebox.MessageBoxListener;

public interface IReminderView {

	public void showReminder(String medicationName);
    public void showNotification(String message);
	public void addListener(IReminderListener l);
	public void setReminderAnswerListener(MessageBoxListener l);
	
	interface IReminderListener {
		void buttonClick(char operation);
	}
}
