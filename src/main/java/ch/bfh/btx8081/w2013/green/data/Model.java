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
import java.util.List;

public class Model{

	private List<String> skills;
	
	
	public Model() {
		skills = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			skills.add("My own Skill " + i);
		}
		
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	
	
}
