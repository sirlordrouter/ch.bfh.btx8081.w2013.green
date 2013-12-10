package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.businesslogic.Medication;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.MessageBoxListener;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 03-12-2013
 */
public class ReminderPresenter implements 
	MessageBoxListener, IReminderComponentListener, IReminderView.IReminderListener {

	protected IReminderView view;
	private Model model;
	private Medication currentMedication;
	protected ReminderComponent reminder;
	
	public ReminderPresenter(IReminderView v, Model m, ReminderComponent rm) {
		this.view = v;
		this.model = m;
		reminder = rm;
		
		this.view.setReminderAnswerListener(this);
		this.view.addListener(this);
		
		reminder.addListener(this);
	}
	
	@Override
	public void buttonClicked(ButtonId buttonId) {
		synchronized(this) {
			switch (buttonId) {
			case YES:
                view.showNotification("Happy Congratulations you took your drugs!");
				//TODO: Happy Congratulations you took your drugs!
				break;
			case NO:
                view.showNotification("Bad habit, please change it! You have to take your drugs!");
				//TODO: Bad habit, please change it! You have to take your drugs!
				break;
			case IGNORE:
                view.showNotification("Later is better hmmmm?");
				//TODO: Later is better hmmmm?
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void pushReminder(Medication medicationName) {
		synchronized (ReminderPresenter.this) {
			this.currentMedication = medicationName;
			this.view.showReminder(medicationName.getMedicationName());
			
			//TODO: Remove
			System.out.println("Medication set!");
		}
			
	}

	@Override
	public void buttonClick(char operation) {
		synchronized (this) {
			
		}
	}

}
