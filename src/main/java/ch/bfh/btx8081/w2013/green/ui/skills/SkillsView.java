package ch.bfh.btx8081.w2013.green.ui.skills;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;

public class SkillsView extends CustomComponent 
	implements View, ISkillView,
	ClickListener {

	private static final long serialVersionUID = 1L;
	private ListSelect listSelectSkills;
	
	/* Only the presenter registers one listener... */
    List<ISkillViewListener> listeners =
            new ArrayList<ISkillViewListener>();

	public SkillsView () {	
		
		setWidth("240px");
		setHeight("420px");

		VerticalLayout vertical = new VerticalLayout();
		// listSelectSkills
		listSelectSkills = new ListSelect();
		
		listSelectSkills.setWidth("240px");
		listSelectSkills.setHeight("380px");
		vertical.addComponent(listSelectSkills);
		
		// buttonBack
		vertical.addComponent(new Button("Back", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

				MyVaadinUI.navigator.navigateTo("Start");
			}
		}));
	
		//addComponent(vertical);
		setCompositionRoot(vertical);
	}

	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buttonClick(ClickEvent event) {
		for (ISkillViewListener listener : listeners) {
			listener.buttonClick(event.getButton().getCaption().charAt(0));
		}
		
	}

	@Override
	public void setSkills(List<String> skills) {
		for (String skill : skills) {
			listSelectSkills.addItem(skill);
		}
		
	}

	@Override
	public void addListener(ISkillViewListener l) {
		listeners.add(l);
	}




}
