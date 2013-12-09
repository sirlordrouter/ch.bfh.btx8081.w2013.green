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

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;

import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;

public class SkillsView extends CustomComponent 
	implements View, ISkillView,
	ClickListener {

	private static final long serialVersionUID = 1L;
	private ListSelect listSelectSkills;
    private Navigator navigator;
	
	/* Only the presenter registers one listener... */
    List<ISkillViewListener> listeners =
            new ArrayList<ISkillViewListener>();

	public SkillsView (Navigator nav) {
		
		setWidth(MyVaadinUI.APPWIDTH);
		setHeight(MyVaadinUI.APPHIGHT);

        navigator = nav;

		VerticalLayout vertical = new VerticalLayout();
		// listSelectSkills
		listSelectSkills = new ListSelect();
		
		listSelectSkills.setWidth("340px");
		listSelectSkills.setHeight("400px");
		vertical.addComponent(listSelectSkills);
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.addComponent(
			new Button("Back", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
navigator.navigateTo(AuthenticatedState.STARTVIEW);
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
							"Awwwww wait you have it already\n" +
							"Don't you?", 
							ButtonId.YES).setWidth("300px");
					mb.setButtonWidth("150px");
					mb.setButtonAlignment(Alignment.BOTTOM_CENTER);
					
				}
			}));
	
		vertical.addComponent(buttonLayout);
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
