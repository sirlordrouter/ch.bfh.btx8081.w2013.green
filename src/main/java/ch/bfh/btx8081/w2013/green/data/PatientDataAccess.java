/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * 
 *<p>Class Description</p>
 *
 * @author group_green
 * @version 29-11-2013
 */
package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.util.List;

public class PatientDataAccess implements IDataAccess {

	public PatientDataAccess() {

	}

    @Override
    public List<Medication> getMedications() {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return null;
    }

    @Override
    public List<Contact> getContacts() {
        return null;
    }
}
