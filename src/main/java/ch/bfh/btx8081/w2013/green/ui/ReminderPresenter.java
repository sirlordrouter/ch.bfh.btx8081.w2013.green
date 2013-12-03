package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.IReminderView.IReminderListener;
import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.MessageBoxListener;

public class ReminderPresenter implements 
	MessageBoxListener, IReminderComponentListener, IReminderListener {

	private IReminderView view;
	private Model model;
	private String currentMedication;
	private ReminderComponent reminder;
	
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
				
				break;
			case NO:
				
				break;
			case IGNORE:
				
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void showAlert(String medicationName) {
		synchronized (this) {
			this.currentMedication = medicationName;
			this.view.showReminder(medicationName);
		}
			
	}

	@Override
	public void buttonClick(char operation) {
		synchronized (this) {
			
		}
	}

}
