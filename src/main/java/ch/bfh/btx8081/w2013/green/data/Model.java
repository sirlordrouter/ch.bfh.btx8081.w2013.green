
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
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 02-12-2013
 */
public abstract class Model{

    protected List<Contact> contacts = new ArrayList<Contact>();
	protected List<Skill> skills = new ArrayList<Skill>();
	protected List<Medication> medications = new ArrayList<Medication>();
	
	
	protected Model() {
		this.skills = new ArrayList<Skill>();
		
		for (int i = 0; i < 10; i++) {
			this.skills.add( new Skill(i, "My own Skill " + i, "DO this for " + i + "Times"));
		}

		//medications.add(new Medication("Dafalgan", new int[]{1,1,0}));
		this.medications.add(new Medication("Psychopharmaka 1", new int[]{0,0,1}, 1));
		//medications.add(new Medication("Anti-Bipolar", new int[]{0,1,0}));
	}

	public final List<Skill> getSkills() {
		return skills;
	}

    public final void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * @return the medications
	 */
    public final List<Medication> getMedications() {
		return this.medications;
	}

	/**
	 * @param medications the medications to set
	 */
    public final void setMedications(List<Medication> medications) {
		this.medications = medications;
	}


    /**
     * getter for contacts
     *
     * @return
     *      a list of contacts
     */
    public final List<Contact> getContacts() {
        return contacts;
    }

    /**
     * setter for contacts
     *
     * @param contacts
     *  a list of contacts
     */
    public final void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
