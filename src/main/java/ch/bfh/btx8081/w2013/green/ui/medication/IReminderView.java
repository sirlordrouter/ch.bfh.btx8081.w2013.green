package ch.bfh.btx8081.w2013.green.ui.medication;

import de.steinwedel.messagebox.MessageBoxListener;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for a ReminderView, allows displaying a reminder-message.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 08-01-2014
 */
public interface IReminderView {

	public void showReminder(String medicationName);
    public void showNotification(String message);
	public void addReminderPresenter(IReminderPresenter presenter);
	public void setReminderAnswerListener(MessageBoxListener listener);
	
	interface IReminderPresenter {
		void buttonClick(char operation);
	}
}
