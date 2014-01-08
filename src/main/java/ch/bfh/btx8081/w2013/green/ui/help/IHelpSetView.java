package ch.bfh.btx8081.w2013.green.ui.help;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for implementing the MVP-Pattern. Describes the Methods that
 * the HelpSetView must provide. </p>
 *
 * @author Vinzenz Messerli, messv1@bfh.ch
 * @version 08-01-2014
 */

public interface IHelpSetView {

	public void addListener(IHelpSetViewListener listener);

	 /**
     * The callback interface that must be implemented by the Presenter class
     * to handle the user actions from the view.
     */
	interface IHelpSetViewListener {
		void buttonClick(char caption);
	}
}
