package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.IReminderView.IReminderListener;
import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.MessageBoxListener;

public class ReminderPresenter implements 
	MessageBoxListener, IReminderComponentListener, IReminderListener {

	protected IReminderView view;
	private Model model;
	private String currentMedication;
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
				//TODO: Happy Congratulations you took your drugs!
				break;
			case NO:
				//TODO: Bad habit, please change it! You have to take your drugs!
				break;
			case IGNORE:
				//TODO: Later is better hmmmm?
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void showAlert(String medicationName) {
		synchronized (ReminderPresenter.this) {
			this.currentMedication = medicationName;
			this.view.showReminder(medicationName);
			
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
