package ch.bfh.btx8081.w2013.green.ui;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 10-12-2013
 */
public interface IHelpView {

    void addListener(IHelpViewListener listener);
    void setMedicationList();

    interface IHelpViewListener {
        void buttonClick(String caption);
    }
}
