package ch.bfh.btx8081.w2013.green.ui.help;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br> Modul 8081, HS2013</br>
 * 
 * <p>
 * Class Description
 * </p>
 * 
 * @author Vinzenz Messerli, messv1@bfh.ch
 * @version 10-12-2013
 */

public interface IHelpSetView {

	void addListener(IHelpViewSetListener listener);

	void setMedicationList();

	interface IHelpViewSetListener {
		void buttonClick(char caption);
	}
}