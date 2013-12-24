package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.IPresenter;

import java.util.List;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br> Modul 8081, HS2013</br>
 * 
 * <p>
 * Class Description
 * </p>
 * 
 * @author Vinzenz Messerli, messv1@bfh.ch
 * @version 10-12-2013
 */

public interface IHelpSetView {

	void addPresenter(IHelpViewSetPresenter presenter);

	void setContactsList(List<Contact> contactsList);

	interface IHelpViewSetPresenter extends IPresenter {
		void buttonClick(char caption);
	}
}
