package ch.bfh.btx8081.w2013.green.ui;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;
import de.steinwedel.messagebox.MessageBoxListener;

public class ReminderView extends VerticalLayout implements IReminderView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Only the presenter registers one listener... */
    private List<IReminderListener> listeners =
            new ArrayList<IReminderListener>();
    private MessageBoxListener mbListener;

	public ReminderView () {
		
	}
	
	@Override
	public void showReminder(String medicationName) {
		
		MessageBox mb = MessageBox.showPlain(
				Icon.INFO, 
				"Medication", "Please Take Medication " + medicationName,
				mbListener, ButtonId.NO, ButtonId.IGNORE, ButtonId.YES).setWidth("220px");
		MyVaadinUI.getCurrent().push();

	}

	@Override
	public void addListener(IReminderListener l) {
		listeners.add(l);	
	}

	@Override
	public void setReminderAnswerListener(MessageBoxListener l) {
		mbListener = l;
	}
}
