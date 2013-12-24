package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.ui.IPresenter;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 09-12-2013
 */
public interface IMedicationView {

    void addListener(IMedicationPresenter presenter);
    void setMedicationList(List<Medication> medications);

    interface IMedicationPresenter extends IPresenter {
        void buttonClick(String c);
    }
}
