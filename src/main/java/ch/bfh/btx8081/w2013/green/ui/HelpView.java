package ch.bfh.btx8081.w2013.green.ui;


import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * 
 *<p>Class Description</p>
 *
 * @author group_green
 * @version 29-11-2013
 */
public class HelpView extends ReminderView implements View {

	private static final long serialVersionUID = 1L;
    private Navigator navigator;

	public HelpView(Navigator nav) {
		super();

        this.navigator = nav;
	
		setWidth(MyVaadinUI.APPWIDTH);
		setHeight(MyVaadinUI.APPHIGHT);
		
		VerticalLayout vertical = new VerticalLayout ();
		TextArea area = new TextArea();
		area.setWidth(MyVaadinUI.APPWIDTH);
		area.setHeight("380px");
		vertical.addComponent(area);
		
		vertical.addComponent(
			new Button("Back", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
navigator.navigateTo(AuthenticatedState.STARTVIEW);
			}
		}));

		addComponent(vertical);
	
	}

	@Override
	public void enter(ViewChangeEvent event) {

		View view = event.getNewView();
	}

}
