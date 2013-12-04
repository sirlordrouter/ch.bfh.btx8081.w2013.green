/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * 
 *<p>Class Description</p>
 *
 * @author group_green
 * @version 29-11-2013
 */
package ch.bfh.btx8081.w2013.green.ui.skills;

import java.util.List;

public interface ISkillView {

	public void setSkills(List<String> skills);
	public void addListener(ISkillViewListener l);
	
	interface ISkillViewListener {
		void buttonClick(char operation);
	}
}
