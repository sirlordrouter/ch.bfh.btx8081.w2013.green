package ch.bfh.btx8081.w2013.green.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>
 * Describes a Medication with its name and dosage.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 *
 * @version 04-12-2013
 */
@Entity
public class Medication implements Serializable, Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int medicationID = -1;
	private String medicationName = null;
	private int[] dueTimes = new int[3];
	
	/**
	 * Constructor initializes a Medication with the needed settings.
     *
	 * @param medicationName
     *      a name for the medication
	 * @param dueTimes
     *      a dosage in the 111 format (breakfast, lunch , dinner)
	 */
	public Medication(String medicationName, int[] dueTimes, int id) {

		this.setMedicationName(medicationName);
		this.setDueTimes(dueTimes);

        this.medicationID = id;
	}

    /**
     * getter for the id of the medication
     *
     * @return
     *      id of this medication
     */
    public int getMedicationID() {
        return this.medicationID;
    }

	/**
     * getter for the medication name
     *
	 * @return the medicationName
	 */
	public String getMedicationName() {
		return this.medicationName;
	}

	/**
     * setter for the medication name
     *
	 * @param medicationName the medicationName to set
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	/**
     * getter for the times to take the medication
     *
	 * @return the dueTimes
	 */
	public int[] getDueTimes() {
		return this.dueTimes;
	}

	/**
     * setter for the times to take the medication
     *
	 * @param dueTimes the dueTimes to set
	 */
	public void setDueTimes(int[] dueTimes) {
		this.dueTimes = dueTimes;
	}

    /**
     * Formats the medication information in a human-readable format.
     *
     * @return
     *      medication information
     */
    @Override
    public String toString() {
        return this.getMedicationName() + "\n"
                +"Dosage: ?\n"
                +"taking:  \n"
                +"Breakfast :" + (this.getDueTimes()[0] == 1 ? "Yes" : "No") +"\n"
                +"Lunch :" + (this.getDueTimes()[1] == 1 ? "Yes" : "No")+ "\n"
                +"Dinner :" + (this.getDueTimes()[2] == 1 ? "Yes" : "No")+ "\n";
    }


    @Override
    public int compareTo(Object o) {
        Medication m = (Medication) o;
        return this.getMedicationName().compareTo(m.getMedicationName());
    }
}
