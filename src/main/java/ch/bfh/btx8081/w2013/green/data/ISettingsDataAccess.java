package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *</p>
 * Interface for the Data Providing class for the Settings View.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 26-12-2013
 */
public interface ISettingsDataAccess {

    List<Patient> getPatients();
    List<Medication> getMedications();
    List<Skill> getSkills();
    List<Contact> getContacts();

    void setPatients(List<Patient> patientList);
}
