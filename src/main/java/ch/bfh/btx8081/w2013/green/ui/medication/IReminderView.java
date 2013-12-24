package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.ui.IPresenter;
import de.steinwedel.messagebox.MessageBoxListener;

public interface IReminderView {

	public void showReminder(String medicationName);
    public void showNotification(String message);
	public void addReminderPresenter(IReminderPresenter presenter);
	public void setReminderAnswerListener(MessageBoxListener listener);
	
	interface IReminderPresenter {
		void buttonClick(char operation);
	}
}
