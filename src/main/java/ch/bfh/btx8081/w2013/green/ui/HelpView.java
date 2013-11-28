package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.MyVaadinUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class HelpView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;


	public HelpView() {
	
		setWidth("240px");
		setHeight("420px");
		
		VerticalLayout vertical = new VerticalLayout ();
		
		TextArea area = new TextArea();
		area.setWidth("240px");
		area.setHeight("380px");
		vertical.addComponent(area);
		vertical.addComponent(
			new Button("Back", new Button.ClickListener() {
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

}
