package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.IStartPresenter;

import java.util.List;

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
