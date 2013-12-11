package ch.bfh.btx8081.w2013.green.ui.skills;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;

import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Describes the Skill View. Displays all the Skills for a Patient.
 * On chose one specific and clicking the detail Button, a Messagebox with Instructions
 * is shown. </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 09-12-2013
 */
public class SkillsView extends CustomComponent 
	implements View, ISkillView {

    private static final long serialVersionUID = 1L;

    public static final String BUTTON_BACK = "Back";

	private ListSelect listSelectSkills = null;
	
	/* Only the presenter registers one listener... */
    private List<ISkillViewListener> listeners =
            new ArrayList<ISkillViewListener>();

	public SkillsView () {
		
		this.setWidth(MyVaadinUI.APP_WIDTH);
		this.setHeight(MyVaadinUI.APP_HIGHT);

		VerticalLayout vertical = new VerticalLayout();
		// listSelectSkills
		this.listSelectSkills = new ListSelect();
		
		this.listSelectSkills.setWidth("340px");
		listSelectSkills.setHeight("400px");
		vertical.addComponent(listSelectSkills);
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.addComponent(
			new Button(BUTTON_BACK, new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
                for (ISkillViewListener listener : listeners) {
                    listener.buttonClick(event.getButton().getCaption().charAt(0));
                }
			}
		}));
		
		buttonLayout.addComponent(
				new Button("Detail", new Button.ClickListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

					MessageBox mb = MessageBox.showPlain(
							Icon.NONE, 
							"Skill Description",
							"Sit on the floor and get your \n"+
							"Phone out of your pocket.\n" +
							"Awwwww wait you have it already in you Hands\n" +
							"Don't you?", 
							ButtonId.YES).setWidth("300px");
					mb.setButtonWidth("150px");
					mb.setButtonAlignment(Alignment.BOTTOM_CENTER);
					
				}
			}));
	
		vertical.addComponent(buttonLayout);

		setCompositionRoot(vertical);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSkills(List<String> skills) {
		for (String skill : skills) {
			this.listSelectSkills.addItem(skill);
		}
	}

	@Override
	public void addListener(ISkillViewListener l) {
		this.listeners.add(l);
	}

}
