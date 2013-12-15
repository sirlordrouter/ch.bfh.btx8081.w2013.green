package ch.bfh.btx8081.w2013.green.ui.start;

import java.util.List;

import ch.bfh.btx8081.w2013.green.data.Patient;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Select;
import com.vaadin.ui.VerticalLayout;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br> Modul 8081, HS2013</br>
 * 
 * <p>
 * Describes the Startview with all the Navigation Buttons to the specific views
 * in the App. For simplicity this class does not require a Presenter class, as
 * it gets to complex when implementing the MVP here. Another reason is that
 * there will be no data bound to this class.
 * </p>
 * 
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 04-12-2013
 */
public class StartView extends VerticalLayout implements View {

	private static final long serialVersionUID = -1105303206323973784L;

	private static final String BUTTON_HELP = "HELP";

	private static final String BUTTON_SKILLS = "SKILLS";

	private static final String BUTTON_MEDICATION = "MEDICATION";

	private static final String BUTTON_SETTINGS = "SETTINGS";

	private static final String BUTTON_HELP_SETTINGS = "HELP SETTINGS";

	private static final String BUTTON_LOGOUT = "LOGOUT";

	private static final String BUTTON_WIDTH = "120px";
	
	//done by Esma
	private static final String PATIENT = "PATIENT";
	private BeanItemContainer<Patient> patientContainer;
	private Select selectPatient;
	private Patient selectedPatient;

	private final Navigator navigator;

	public StartView(Navigator nav) {
		this.navigator = nav;
		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);
		
		// Done by Esma
		 // Have a bean container to put the beans in
	    patientContainer = new BeanItemContainer<Patient>(Patient.class);

	    // Put some example data in it
	    patientContainer.addItem(new Patient(1, "Garcia", "Pedro"));
	    patientContainer.addItem(new Patient(2, "Matos", "Juan"));   
	    patientContainer.addItem(new Patient(3, "Guerra", "Carlos"));
	    
	    
	    // Create a selection component bound to the container
	    selectPatient = new Select("Patients", patientContainer);
	    // from the 'name' property of the bean
	    selectPatient.setItemCaptionPropertyId("name");
	    selectPatient.addValueChangeListener(new PatientListener());		
		addComponent(selectPatient);
		setComponentAlignment(selectPatient, Alignment.MIDDLE_CENTER);
		// End

		Button buttonHelp = new Button(BUTTON_HELP, new Button.ClickListener() {
			private static final long serialVersionUID = -3742574718530257633L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				navigator.navigateTo(AuthenticatedState.HELP_VIEW);
			}
		});
		buttonHelp.setWidth(BUTTON_WIDTH);
		addComponent(buttonHelp);
		setComponentAlignment(buttonHelp, Alignment.MIDDLE_CENTER);

		Button buttonSkills = new Button(BUTTON_SKILLS,
				new Button.ClickListener() {
					private static final long serialVersionUID = -7539174022613115079L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo(AuthenticatedState.SKILL_VIEW);
					}
				});
		buttonSkills.setWidth(BUTTON_WIDTH);
		addComponent(buttonSkills);
		setComponentAlignment(buttonSkills, Alignment.MIDDLE_CENTER);

		Button buttonMedic = new Button(BUTTON_MEDICATION,
				new Button.ClickListener() {
					private static final long serialVersionUID = -5170311461467440566L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo(AuthenticatedState.MEDIC_VIEW);
					}
				});
		buttonMedic.setWidth(BUTTON_WIDTH);
		addComponent(buttonMedic);
		setComponentAlignment(buttonMedic, Alignment.MIDDLE_CENTER);

		Button buttonSettings = new Button(BUTTON_SETTINGS,
				new Button.ClickListener() {
					private static final long serialVersionUID = -1096188732209266611L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo(AuthenticatedState.SETTINGS_VIEW);
					}
				});
		buttonSettings.setWidth(BUTTON_WIDTH);
		addComponent(buttonSettings);
		setComponentAlignment(buttonSettings, Alignment.MIDDLE_CENTER);

		// //******
		Button buttonHelpSettings = new Button(BUTTON_HELP_SETTINGS,
				new Button.ClickListener() {
					private static final long serialVersionUID = -4211158082239865950L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo(AuthenticatedState.SETTINGS_VIEW); // dummy
																				// view
																				// will
																				// be
																				// replaced
					}

				});
		buttonHelpSettings.setWidth(BUTTON_WIDTH);
		addComponent(buttonHelpSettings);
		setComponentAlignment(buttonHelpSettings, Alignment.MIDDLE_CENTER);

		Button buttonLogout = new Button(BUTTON_LOGOUT,
				new Button.ClickListener() {
					private static final long serialVersionUID = -1096188732209266611L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo("");
						((MyVaadinUI) MyVaadinUI.getCurrent()).logout();
					}
				});
		buttonLogout.setWidth(BUTTON_WIDTH);
		addComponent(buttonLogout);
		setComponentAlignment(buttonLogout, Alignment.MIDDLE_CENTER);
		
		Button buttonProto = new Button("Prototype",
				new Button.ClickListener() {
					private static final long serialVersionUID = -1096188732209266611L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						navigator.navigateTo("proto");
						
					}
				});
		buttonProto.setWidth(BUTTON_WIDTH);
		addComponent(buttonProto);
		setComponentAlignment(buttonProto, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}
	
	//Done by Esma
	private class PatientListener implements Property.ValueChangeListener{

		@Override
		public void valueChange(ValueChangeEvent event) {
			selectedPatient = (Patient) selectPatient.getValue();
			System.out.println(selectedPatient.getName());
			
		}
		
	}

}
