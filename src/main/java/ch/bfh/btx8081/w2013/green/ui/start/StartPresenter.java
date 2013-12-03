package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.navigator.ViewChangeListener;

import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.IReminderView;
import ch.bfh.btx8081.w2013.green.ui.ReminderPresenter;

public class StartPresenter extends ReminderPresenter implements ViewChangeListener {

	public StartPresenter(IReminderView v, Model m, ReminderComponent rm) {
		super(v, m, rm);
	}

	@Override
	public void afterViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		
		if (event.getOldView() instanceof StartView) {
			reminder.removeListener(this);
		} else if (event.getNewView() instanceof StartView) {
			reminder.addListener(this);
		}
		
		return true;
	}

}
