package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.IPresenter;

import java.util.List;

public interface IStartSettingsView {
	
    void addSettingsPresenter(ISettingsPresenter l);
    void addPatients(List<Patient> patientList);


    public interface ISettingsPresenter extends IPresenter {

        void navigateToHelpSettings();
        void navigateToSkillSettings();
        void navigateToMedicSettings();

        void patientChanged(Patient p);
	    void addPatientChangedListener(IPatientChangedListener l);
        public interface IPatientChangedListener {

            void setSelectedPatient(Patient p);
        }
    }

}
