package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;
import de.steinwedel.messagebox.MessageBoxListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 03-12-2013
 */
public class ReminderView extends VerticalLayout implements IReminderView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Only the presenter registers one listener... */
    private List<IReminderListener> listeners =
            new ArrayList<IReminderListener>();
    private MessageBoxListener mbListener = null;

	public ReminderView () {
		
	}
	
	@Override
	public void showReminder(String medicationName) {
			
		MessageBox mb = MessageBox.showPlain(
				Icon.INFO, 
				"Medication", "Please Take Medication " + medicationName,
				mbListener, ButtonId.NO, ButtonId.IGNORE, ButtonId.YES).setWidth("300px");
		mb.setButtonWidth("90px");
		mb.setButtonAlignment(Alignment.BOTTOM_CENTER);
		MyVaadinUI.getCurrent().push();

	}

    @Override
    public void showNotification(String message) {
        Notification.show(message);
    }

    @Override
	public void addListener(IReminderListener l) {
		this.listeners.add(l);
	}

	@Override
	public void setReminderAnswerListener(MessageBoxListener l) {
		this.mbListener = l;
	}
}
