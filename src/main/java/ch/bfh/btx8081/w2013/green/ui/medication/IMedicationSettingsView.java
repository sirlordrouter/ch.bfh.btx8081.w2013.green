package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.ui.IPresenter;

import java.util.List;
import java.util.Set;

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
public interface IMedicationSettingsView  {

    void addPresenter(IMedicationSettingsPresenter presenter);

    void setCurrentPatientName(String currentPatientName);
    void setCurrentPatientMedication(List<Medication> medicationList, List<Medication> customMedicationList);

    public interface IMedicationSettingsPresenter extends IPresenter {

        void setPatientsMedication(Set medications);

    }

}
