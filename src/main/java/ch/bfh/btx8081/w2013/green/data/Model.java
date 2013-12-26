
package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 02-12-2013
 */
public class Model{

    private List<Contact> contacts = new ArrayList<Contact>();
    private List<Skill> skills = new ArrayList<Skill>();
    private List<Medication> medications = new ArrayList<Medication>();
	
	
	public Model() {
		this.skills = new ArrayList<Skill>();
		
		for (int i = 0; i < 10; i++) {
			this.skills.add( new Skill(i, "My own Skill " + i, "DO this for " + i + "Times"));
		}

	}

	public List<Skill> getSkills() {
		return skills;
	}

    public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * @return the medications
	 */
    public List<Medication> getMedications() {
		return this.medications;
	}

	/**
	 * @param medications the medications to set
	 */
    public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

    /**
     * getter for contacts
     *
     * @return
     *      a list of contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * setter for contacts
     *
     * @param contacts
     *  a list of contacts
     */
    public  void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
