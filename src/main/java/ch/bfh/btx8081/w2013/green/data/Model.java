
package ch.bfh.btx8081.w2013.green.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch.bfh.btx8081.w2013.green.businesslogic.Medication;

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

	private List<String> skills = null;
	private List<Medication> medications = null;
	private List<Medication> dueMedications = null;
	
	
	public Model() {
		this.skills = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			this.skills.add("My own Skill " + i);
		}
				
		this.medications = new ArrayList<Medication>();
		//medications.add(new Medication("Dafalgan", new int[]{1,1,0}));
		this.medications.add(new Medication("Psychopharmaka 1", new int[]{0,0,1}));
		//medications.add(new Medication("Anti-Bipolar", new int[]{0,1,0}));
		this.setDueMedications(new ArrayList<Medication>());
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
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
	 * @return the dueMedications
	 */
	public synchronized List<Medication> getDueMedications() {
		return this.dueMedications;
	}

	/**
	 * @param dueMedications the dueMedications to set
	 */
	public synchronized void setDueMedications(List<Medication> dueMedications) {
		this.dueMedications = dueMedications;
	}
	
	/**
	 * @param dueMedication the dueMedications to set
	 */
	public void setDueMedication(Medication dueMedication) {
		synchronized (Model.this) {
			this.dueMedications.add(dueMedication);
		}	
	}

	/**
	 *
	 */
	public synchronized void clearDueMedications() {
		this.dueMedications.clear();
	}
	
}
