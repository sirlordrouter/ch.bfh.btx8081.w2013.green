package ch.bfh.btx8081.w2013.green.ui.skills;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for implementing the MVP-Pattern. Describes the Methods that
 * the SkillsView must provide. </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 09-12-2013
 */
public interface ISkillView {

	public void setSkills(List<String> skills);
	public void addListener(ISkillViewListener l);

    /**
     * The callback interface that must be implemented by the Presenter class
     * to handle the user actions from the view.
     */
	interface ISkillViewListener {
		void buttonClick(char operation);
	}
}
