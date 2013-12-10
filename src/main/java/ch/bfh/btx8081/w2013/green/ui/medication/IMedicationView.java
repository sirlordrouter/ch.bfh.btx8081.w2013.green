package ch.bfh.btx8081.w2013.green.ui.medication;

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

    void addListener(IMedicationViewListener listener);

    interface IMedicationViewListener {
        void buttonClick(char c);
    }
}
