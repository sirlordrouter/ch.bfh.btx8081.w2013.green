package ch.bfh.btx8081.w2013.green.businesslogic;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 * 
 *<p>Class describes a Medication Object. </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 04-12-2013
 */
public class Medication {
	
	private String medicationName;
	private int[] dueTimes = new int[3];
	
	/**
	 * 
	 * @param medicationName
	 * @param dueTimes
	 */
	public Medication(String medicationName, int[] dueTimes) {
		this.setMedicationName(medicationName);
		this.setDueTimes(dueTimes);
	}

	/**
	 * @return the medicationName
	 */
	public String getMedicationName() {
		return medicationName;
	}

	/**
	 * @param medicationName the medicationName to set
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	/**
	 * @return the dueTimes
	 */
	public int[] getDueTimes() {
		return dueTimes;
	}

	/**
	 * @param dueTimes the dueTimes to set
	 */
	public void setDueTimes(int[] dueTimes) {
		this.dueTimes = dueTimes;
	}
	
	
}
