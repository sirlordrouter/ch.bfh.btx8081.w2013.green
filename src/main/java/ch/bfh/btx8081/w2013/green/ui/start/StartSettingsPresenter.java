package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.SettingsModel;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

import java.util.ArrayList;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 * <p>
 * Presenter for the <code>StartSettingsView</code>.
 * Takes all User input from the View and triggers the actions.
 * It sets the Patients from the Model to the View.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 20-12-2013
 */
public class StartSettingsPresenter implements IStartSettingsView.ISettingsPresenter {

    private final Navigator navigator;

    private ArrayList<IPatientChangedListener> patientChangedListeners = new ArrayList<IPatientChangedListener>();

    public StartSettingsPresenter(SettingsModel m, Navigator navigator, IStartSettingsView v) {

        this.navigator = navigator;

        v.addSettingsPresenter(this);
        v.addPatients(m.getPatients());
    }

    @Override
    public void navigateToHelpSettings() {

        // TODO Should navigate to the help setting view.
        this.navigator.navigateTo(AuthenticatedState.HELP_SET_VIEW);

    }

    @Override
    public void navigateToSkillSettings() {

        // TODO Should navigate to the Skill Setting View.
        this.navigator.navigateTo("SKILLSETTINGS");

    }

    @Override
    public void navigateToMedicSettings() {

        // TODO Should navigate to the Skill Setting View.
        this.navigator.navigateTo(AuthenticatedState.MEDIC_SET_VIEW);

    }

    @Override
    public void patientChanged(Patient p) {

        for (IPatientChangedListener patientListener : patientChangedListeners) {
            patientListener.setSelectedPatient(p);
        }

    }

    @Override
    public void addPatientChangedListener(IPatientChangedListener l) {
        this.patientChangedListeners.add(l);
    }

    @Override
    public void navigateBack() {

        this.navigator.navigateTo("");
        ((MyVaadinUI) MyVaadinUI.getCurrent()).logout();

    }
}
