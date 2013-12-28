package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.SettingsModel;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.start.IStartSettingsView;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 24-12-2013
 */
public class MedicationSettingsPresenter implements
        IStartSettingsView.IStartSettingsPresenter.IPatientChangedListener,
        IMedicationSettingsView.IMedicationSettingsPresenter {

    private final SettingsModel model;
    private final Navigator navigator;
    private final MedicationSettingsView view;

    private Patient currentPatient = null;

    public MedicationSettingsPresenter(SettingsModel model, Navigator navigator, MedicationSettingsView view) {

        this.model = model;
        this.navigator = navigator;
        this.view = view;

        this.view.addPresenter(this);
    }

    @Override
    public void setSelectedPatient(Patient p) {
        this.currentPatient = p;

        this.view.setCurrentPatientName(p.getPatientName());
        this.view.setCurrentPatientMedication(model.getMedications(), p.getCustomMedications());

        //TODO: Add patientspecific data to view

    }

    @Override
    public void navigateBack() {

        this.navigator.navigateTo(AuthenticatedState.START_SETTINGS_VIEW);

    }


    @Override
    /**
     * Replaces the medications of the current selected Patient with the given list.
     */
    public void setPatientsMedication(Collection<Medication> medications) {

        this.currentPatient.getCustomMedications().clear();
        this.currentPatient.setCustomMedications(new ArrayList<>(medications));
    }
}
