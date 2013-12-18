package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;

public interface IStartSettingsView {
	
	void addPatientChangedListener(IPatientChangedListener l);
	
	public interface IPatientChangedListener {
		
		void setSelectedPatient(Patient p);
	}

}
