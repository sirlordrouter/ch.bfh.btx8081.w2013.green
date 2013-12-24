package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.start.IStartSettingsView;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

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
public class HelpSetPresenter implements
        IHelpSetView.IHelpViewSetPresenter,
        IStartSettingsView.IStartSettingsPresenter.IPatientChangedListener {

	private HelpSetView view = null;
	private Model model = null;
	private Navigator navigator = null;

	public HelpSetPresenter(HelpSetView v, Model m, Navigator n) {

		this.view = v;
		this.model = m;
		this.navigator = n;
	}

    @Override
    public void buttonClick(char caption) {

    }

    @Override
    public void navigateBack() {
        this.navigator.navigateTo(AuthenticatedState.START_SETTINGS_VIEW);
    }

    @Override
    public void setSelectedPatient(Patient p) {

    }
}
