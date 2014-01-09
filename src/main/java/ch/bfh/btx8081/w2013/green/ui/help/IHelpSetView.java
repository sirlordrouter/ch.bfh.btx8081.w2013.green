package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.IPresenter;

import java.util.List;

/**
<<<<<<< HEAD
 * Berner Fachhochschule</br> Medizininformatik BSc</br> Modul 8081, HS2013</br>
 * 
 * <p>
 * Interface for the View holding the contact persons.
 * </p>
 * 
=======
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for implementing the MVP-Pattern. Describes the Methods that
 * the HelpSetView must provide. </p>
 *
>>>>>>> 3365481b7b739ae2af9d5b81a5f4cafef7c94ff3
 * @author Vinzenz Messerli, messv1@bfh.ch
 * @version 08-01-2014
 */

public interface IHelpSetView {

	void addPresenter(IHelpViewSetPresenter presenter);

	void setContactsList(List<Contact> contactsList);

	 /**
     * The callback interface that must be implemented by the Presenter class
     * to handle the user actions from the view.
     */
	interface IHelpViewSetPresenter extends IPresenter {

		void buttonClick(char caption);
	}
}
