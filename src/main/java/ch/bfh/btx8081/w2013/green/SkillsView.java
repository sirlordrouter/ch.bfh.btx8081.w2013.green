package ch.bfh.btx8081.w2013.green;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;

public class SkillsView extends VerticalLayout 
	implements View, com.vaadin.event.Action.Listener {

	private static final long serialVersionUID = 1L;
	private ListSelect listSelectSkills;
	private Model model;
	private SkillsController c;
	

	public SkillsView () {	
		
		model = new Model();
		c = new SkillsController(this, model);
		
		setWidth("240px");
		setHeight("420px");

		VerticalLayout vertical = new VerticalLayout();
		// listSelectSkills
		listSelectSkills = new ListSelect();
		
		for (int j = 0; j < 10; j++) {
			listSelectSkills.addItem("Skill " + j);
		}
		
		listSelectSkills.setWidth("240px");
		listSelectSkills.setHeight("380px");
		vertical.addComponent(listSelectSkills);
		
		// buttonBack
		vertical.addComponent(new Button("Back", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				// TODO Auto-generated method stub
				MyVaadinUI.navigator.navigateTo("");
			}
		}));
	
		addComponent(vertical);
		
	}

	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleAction(Object sender, Object target) {
		// TODO Auto-generated method stub
		
	}

}
