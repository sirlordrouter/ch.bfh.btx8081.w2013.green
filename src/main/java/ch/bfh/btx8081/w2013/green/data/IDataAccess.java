package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for Data for the patient view. The implementing class must provide three Methods
 * to provide the three needed Entities.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 08-01-2014
 */
public interface IDataAccess {

    List<Medication> getMedications(int PatientId);
    List<Skill> getSkills(int PatientId);
    List<Contact> getContacts(int PatientId);
}
