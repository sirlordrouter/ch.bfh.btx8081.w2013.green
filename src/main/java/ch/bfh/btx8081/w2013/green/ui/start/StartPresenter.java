package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.navigator.ViewChangeListener;

import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.IReminderView;
import ch.bfh.btx8081.w2013.green.ui.ReminderPresenter;

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
public class StartPresenter implements ViewChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Model model;
	//TODO: add Interface for View
	private StartView view;
	
	public StartPresenter(StartView v, Model m) {
		this.model = m;
		this.view = v;
	}
	
	@Override
	public void afterViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	//TODO: ViewChangeEvent in ReminderPresenter auslagern wenn möglich so, dass der Benutzer nichts tun muss
	
	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		
		return true;
	}

}
