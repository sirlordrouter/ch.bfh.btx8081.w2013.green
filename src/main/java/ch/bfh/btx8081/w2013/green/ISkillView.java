package ch.bfh.btx8081.w2013.green;

import java.util.List;

public interface ISkillView {

	public void setSkills(List<String> skills);
	public void addListener(ISkillViewListener l);
	
	interface ISkillViewListener {
		void buttonClick(char operation);
	}
}
