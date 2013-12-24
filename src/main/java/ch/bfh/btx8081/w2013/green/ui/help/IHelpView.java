package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.IPresenter;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 10-12-2013
 */
public interface IHelpView {

    void addPresenter(IHelpPresenter presenter);
    void setContactsList(List<Contact> contactsList);

    interface IHelpPresenter extends IPresenter {
        void buttonClick(String caption);
    }
}
