package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent;
import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.MessageBoxListener;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Presenter for a ReminderView. Pushes Reminder to the view ans listens to the user input on this reminder.</p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 03-12-2013
 */
public class ReminderPresenter implements 
	MessageBoxListener, IReminderComponentListener, IReminderView.IReminderPresenter {

    protected IReminderComponent reminder = null;
	protected IReminderView view = null;
	protected Model model = null;
	protected Medication currentMedication = null;
	
	public ReminderPresenter(ReminderView v, Model m, ReminderComponent rm) {
		this.view = v;
		this.model = m;
		this.reminder = rm;
		
		this.view.setReminderAnswerListener(this);
		this.view.addReminderPresenter(this);

        for (Medication medics : this.model.getMedications()) {
            this.reminder.addToSchedule(medics);

            //HACK: Reminder gets fired to much otherwise. No Solution found yet.
            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Add the listener to the reminder after added all the medications.
        //otherwise the events are directly fired when adding the timer.
        this.reminder.addListener(this);

	}
	
	@Override
	public void buttonClicked(ButtonId buttonId) {
		synchronized(this) {
			switch (buttonId) {
			case YES:
                this.view.showNotification("Happy Congratulations you took your drugs!");
				//TODO: Logging - navigation to Medication View
				break;
			case NO:
                this.view.showNotification("Bad habit, please change it! You have to take your drugs!");
				//TODO: Logging
				break;
			case IGNORE:
                this.view.showNotification("Later is better hmmmm?");
				//TODO: Logging - Postpone Timer
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void pushReminder(Medication medication) {
		synchronized (ReminderPresenter.this) {
			this.currentMedication = medication;
			this.view.showReminder(medication.getMedicationName());
			
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
