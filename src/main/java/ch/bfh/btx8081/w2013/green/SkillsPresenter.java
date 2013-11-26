package ch.bfh.btx8081.w2013.green;

import ch.bfh.btx8081.w2013.green.ISkillView.ISkillViewListener;

public class SkillsPresenter implements ISkillViewListener {

	private SkillsView view;
	private Model model; 
	
	public SkillsPresenter(SkillsView v, Model m) {
	
		this.view = v;
		this.model = m;
		
		view.addListener(this);
		view.setSkills(model.getSkills());
	}

	@Override
	public void buttonClick(char operation) {
		view.setSkills(model.getSkills());
	}
	
	
}
