package ch.bfh.btx8081.w2013.green.ui.start;

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
 * @version 23-12-2013
 */
public class StartViewPresenter implements IStartView.IStartViewPresenter {

    private Navigator navigator = null;

    public StartViewPresenter(Navigator navigator) {

        this.navigator = navigator;

    }


    @Override
    public void navigateToHelp() {

        this.navigator.navigateTo(AuthenticatedState.HELP_VIEW);

    }

    @Override
    public void navigateToSkills() {

        this.navigator.navigateTo(AuthenticatedState.SKILL_VIEW);

    }

    @Override
    public void navigateToMedic() {

        this.navigator.navigateTo(AuthenticatedState.MEDIC_VIEW);

    }

    @Override
    public void navigateBack() {

        this.navigator.navigateTo("");
        ((MyVaadinUI) MyVaadinUI.getCurrent()).logout();

    }
}
