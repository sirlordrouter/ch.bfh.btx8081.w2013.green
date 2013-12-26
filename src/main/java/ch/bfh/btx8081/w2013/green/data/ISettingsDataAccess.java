package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 26-12-2013
 */
public interface ISettingsDataAccess extends IDataAccess {

    List<Patient> getPatients();

    void setPatients(List<Patient> patientList);

    //void setContacts(List<Contact> contactList);
}
