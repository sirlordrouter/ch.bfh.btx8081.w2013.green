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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch.bfh.btx8081.w2013.green.businesslogic.Medication;

public class Model{

	private List<String> skills;
	private List<Medication> medications;
	private List<Medication> dueMedications;
	
	
	public Model() {
		skills = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			skills.add("My own Skill " + i);
		}
		
		
		medications = new ArrayList<Medication>();
		//medications.add(new Medication("Dafalgan", new int[]{1,1,0}));
		medications.add(new Medication("Psychopharmaka 1", new int[]{1,1,1}));
		//medications.add(new Medication("Anti-Bipolar", new int[]{0,1,0}));
		setDueMedications(new ArrayList<Medication>());
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
		return medications;
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
		return dueMedications;
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
	 * @param dueMedications the dueMedications to set
	 */
	public synchronized void clearDueMedications() {
		this.dueMedications.clear();
	}
	
}
