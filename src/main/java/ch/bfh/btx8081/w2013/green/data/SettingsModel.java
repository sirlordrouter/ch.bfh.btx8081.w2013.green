package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 *
 * @version 11-12-2013
 */
public class SettingsModel extends Model {

    private List<Patient> patients = new ArrayList<Patient>();

    public SettingsModel() {

    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
