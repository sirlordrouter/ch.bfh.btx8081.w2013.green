package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

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
public class HelpPresenter implements IHelpView.IHelpPresenter{

    private Navigator navigator = null;

    public HelpPresenter(HelpView v, Model m, Navigator n) {

        this.navigator = n;

        v.addPresenter(this);
        v.setContactsList(m.getContacts());
    }


    @Override
    public void buttonClick(String caption) {

    }

    @Override
    public void navigateBack() {
        this.navigator.navigateTo(AuthenticatedState.START_VIEW);
    }
}
