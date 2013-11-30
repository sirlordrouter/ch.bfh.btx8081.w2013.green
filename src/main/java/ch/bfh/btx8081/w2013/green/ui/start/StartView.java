package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/** A start view for navigating to the other views */
public class StartView extends VerticalLayout implements View {
   
	private static final String buttonWidth = "120px";

	private static final long serialVersionUID = -1105303206323973784L;

	public StartView() {
		setWidth("240px");
		setHeight("420px");

        
        Button buttonHelp = new Button("HELP",
                new Button.ClickListener() {
					private static final long serialVersionUID = -3742574718530257633L;

					@Override
					public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				       MyVaadinUI.navigator.navigateTo(MyVaadinUI.HELPVIEW);	
					}
				}
        );
        buttonHelp.setWidth(buttonWidth);
        addComponent(buttonHelp);
        setComponentAlignment(buttonHelp, Alignment.MIDDLE_CENTER);
        
        
        Button buttonSkills = new Button("SKILLS",
                new Button.ClickListener() {
					private static final long serialVersionUID = -7539174022613115079L;

					@Override
					public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				       MyVaadinUI.navigator.navigateTo(MyVaadinUI.SKILLVIEW);	
					}
				}
        );
        buttonSkills.setWidth(buttonWidth);
        addComponent(buttonSkills);
        setComponentAlignment(buttonSkills, Alignment.MIDDLE_CENTER);
        
        Button buttonMedic = new Button("MEDICATION",
                new Button.ClickListener() {
					private static final long serialVersionUID = -5170311461467440566L;

					@Override
					public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				       MyVaadinUI.navigator.navigateTo(MyVaadinUI.MEDICVIEW);	
					}
				}
        );
        buttonMedic.setWidth(buttonWidth);
        addComponent(buttonMedic);
        setComponentAlignment(buttonMedic, Alignment.MIDDLE_CENTER);
                      
        Button buttonSettings = new Button("SETTINGS",
                new Button.ClickListener() {
					private static final long serialVersionUID = -1096188732209266611L;

					@Override
					public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				       MyVaadinUI.navigator.navigateTo(MyVaadinUI.SETTINGSVIEW);	
					}
				}
        );
        buttonSettings.setWidth(buttonWidth);
        addComponent(buttonSettings);
        setComponentAlignment(buttonSettings, Alignment.MIDDLE_CENTER);
        
        Button buttonLogout = new Button("Logout",
                new Button.ClickListener() {
					private static final long serialVersionUID = -1096188732209266611L;

					@Override
					public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				       MyVaadinUI.navigator.navigateTo("");	
				       ((MyVaadinUI)MyVaadinUI.getCurrent()).logout();
					}
				}
        );
        buttonLogout.setWidth(buttonWidth);
        addComponent(buttonLogout);
        setComponentAlignment(buttonLogout, Alignment.MIDDLE_CENTER);
          
    }        
        
    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Welcome");
    }
}