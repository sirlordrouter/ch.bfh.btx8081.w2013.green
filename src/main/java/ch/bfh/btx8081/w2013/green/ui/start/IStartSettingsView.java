package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.IStartPresenter;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for the main page of the settings. Used for callback with a presenter.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 08-01-2014
 */
public interface IStartSettingsView {
	
    void addSettingsPresenter(IStartSettingsPresenter l);
    void addPatients(List<Patient> patientList);


    public interface IStartSettingsPresenter extends IStartPresenter {

        void patientChanged(Patient p);
	    void addPatientChangedListener(IPatientChangedListener l);
        public interface IPatientChangedListener {

            void setSelectedPatient(Patient p);
        }
    }

}
