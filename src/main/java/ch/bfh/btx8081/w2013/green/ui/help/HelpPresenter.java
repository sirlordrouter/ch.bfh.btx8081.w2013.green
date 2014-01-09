package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Describes the Presenter class for the Presenter view.
 * This class handles all user interaction from the view and binds no data to
 * the view. It implements the IHelpPresenter
 * Interface to get the user interaction from the view. The different Button-Actions must
 * be handled by switch.</p>
 *
 * @author Messerli Vinzenz, messv1@bfh.ch
 * @version 09-12-2013
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

    /**
     * Handles the user interactions from the view.
     */
    @Override
    public void navigateBack() {
        this.navigator.navigateTo(AuthenticatedState.START_VIEW);
    }


}
