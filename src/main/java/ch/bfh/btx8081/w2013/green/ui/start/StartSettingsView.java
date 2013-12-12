package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class StartSettingsView extends VerticalLayout implements View {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private AbsoluteLayout mainLayout;
	private static final String BUTTON_LOGOUT = "LOGOUT";
	private static final String BUTTON_SKILLSETTINGS = "Skill Settings";
	private static final String BUTTON_HELPSETTINGS = "Help Settings";
	private static final String BUTTON_WIDTH = "120px";
	private final Navigator navigator;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 * 
	 * This settings view is meant for administrators who configure the mental
	 * health app for the patients.
	 */
	public StartSettingsView(Navigator nav) {

		this.navigator = nav;

		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);
		
		//TODO: Creating a dropdown list for selecting the patients.

		// Creating the 3 Buttons (Help Settings, Skill Settings and Logout)
		// with a Navigator which should navigate to the corresponding view.
		
		Button helpSettingsButton = new Button(BUTTON_HELPSETTINGS,
				new Button.ClickListener() {
					private static final long serialVersionUID = -5797923866320649518L;

					@Override
					public void buttonClick(ClickEvent event) {
						// TODO Should navigate to the help setting view.
						navigator.navigateTo("HELP_SET_VIEW");
					}
				});

		Button skillSettingsButton = new Button(BUTTON_SKILLSETTINGS,
				new Button.ClickListener() {
					private static final long serialVersionUID = 7147554466396214893L;

					@Override
					public void buttonClick(ClickEvent event) {
						// TODO Should navigate to the Skill Setting View.
						navigator.navigateTo("SKILLSETTINGS");

					}
				});

		Button logoutButton = new Button(BUTTON_LOGOUT,
				new Button.ClickListener() {
					private static final long serialVersionUID = -1096188732209266611L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo("");
						((MyVaadinUI) MyVaadinUI.getCurrent()).logout();
					}
				});
		
	

		// Adding and aligning the 3 Buttons.
		//Setting a Description for the buttons which is displayed when flying over the button
		addComponent(helpSettingsButton);
		setComponentAlignment(helpSettingsButton, Alignment.MIDDLE_CENTER);
		helpSettingsButton.setDescription("Set the Help options for the Patient");
		helpSettingsButton.setWidth(BUTTON_WIDTH);

		addComponent(skillSettingsButton);
		setComponentAlignment(skillSettingsButton, Alignment.MIDDLE_CENTER);
		skillSettingsButton.setDescription("Set the Skill options for the Patient");
		skillSettingsButton.setWidth(BUTTON_WIDTH);
		
		logoutButton.setWidth(BUTTON_WIDTH);
		addComponent(logoutButton);
		setComponentAlignment(logoutButton, Alignment.MIDDLE_CENTER);
		logoutButton.setDescription("You will be logged out");
		logoutButton.setWidth(BUTTON_WIDTH);
		
		// TODO add user code here
	}

	@AutoGenerated
	private void buildMainLayout() {
		// common part: create layout

		// setImmediate(true);
		// setWidth("100%");
		// setHeight("100%");
		//
		// // top-level component properties
		// setWidth("100.0%");
		// setHeight("100.0%");
		//
		// // buttonHelp
		// Button buttonHelp = new Button("Help");
		// buttonHelp.setImmediate(true);
		// buttonHelp.setDescription("The main view Helpbutton");
		// buttonHelp.setWidth("120px");
		// buttonHelp.setHeight("120px");
		// mainLayout.addComponent(buttonHelp, "top:80.0px;left:60.0px;");
		return;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome to the settings homescreen!");
		// TODO Auto-generated method stub

	}

}
