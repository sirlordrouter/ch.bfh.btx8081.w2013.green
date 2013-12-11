package ch.bfh.btx8081.w2013.green.data;

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
public class ProfessionalModel extends Model {

    private List<Patient> patients = new ArrayList<Patient>();


    public ProfessionalModel() {

    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
