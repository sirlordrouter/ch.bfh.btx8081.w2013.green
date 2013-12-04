package ch.bfh.btx8081.w2013.green.businesslogic;

public class Medication {
	
	public enum DueTime {Morgen, Mittag, Abend};

	private String medicationName;
	private int[] dueTimes = new int[3];
	
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
