package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 * @author Jan Wiebe van der Sluis,
 *
 * @version 23-12-2013
 */
public class StartSettingsView extends VerticalLayout implements View, IStartSettingsView {

	private static final long serialVersionUID = 1L;
	private static final String BUTTON_LOGOUT = "Logout";
	private static final String BUTTON_SKILL_SETTINGS = "Skills";
	private static final String BUTTON_HELP_SETTINGS = "Contacts";
	private static final String BUTTON_MEDIC_SETTINGS = "Medication";
	private static final String BUTTON_WIDTH = "160px";
    private static final String BUTTON_HEIGHT = "50px";

    private IStartSettingsPresenter settingsPresenter = null;
    private BeanItemContainer<Patient> patientContainer = null;

    private VerticalLayout header = new VerticalLayout();
    private VerticalLayout patient = new VerticalLayout();
    private VerticalLayout buttons = new VerticalLayout();

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
	public StartSettingsView() {

        this.setStyles();
        this.createPatientsComboBox();
        this.createButtons();
        setLayouts();

	}


    private void setStyles() {

        this.addStyleName("dashboard-view");
        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);
        this.setMargin(true);
        this.setSpacing(true);
    }

    private void createPatientsComboBox() {

        Label titleLiabel = new Label("SETTINGS");
        titleLiabel.setStyleName("h1");
        titleLiabel.setHeight("30px");
        this.header.addComponent(titleLiabel);
        this.header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);

        this.patientContainer = new BeanItemContainer<Patient>(Patient.class);

        // Create a selection component bound to the container
        ComboBox selectPatient = new ComboBox("Select Patient:", patientContainer);
        // from the 'name' property of the bean
        selectPatient.setItemCaptionPropertyId("patientName");
        selectPatient.setImmediate(true);
        selectPatient.addValueChangeListener(new PatientListener());

        selectPatient.setWidth("200px");
        this.patient.addComponent(selectPatient);
        this.patient.setComponentAlignment(selectPatient, Alignment.MIDDLE_CENTER);
    }

    private void createButtons() {

        // Creating the 3 Buttons (Help Settings, Skill Settings and Logout)
        // with a Navigator which should navigate to the corresponding view.
        Button helpSettingsButton = new Button(BUTTON_HELP_SETTINGS,
                new Button.ClickListener() {
                    private static final long serialVersionUID = -5797923866320649518L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        settingsPresenter.navigateToHelp();
                    }
                });
        helpSettingsButton.addStyleName("icon-cog");

//        Button skillSettingsButton = new Button(BUTTON_SKILL_SETTINGS,
//                new Button.ClickListener() {
//                    private static final long serialVersionUID = 7147554466396214893L;
//
//                    @Override
//                    public void buttonClick(ClickEvent event) {
//                        settingsPresenter.navigateToSkills();
//                    }
//                });
//        skillSettingsButton.addStyleName("icon-cog");

        Button medicSettingsButton = new Button(BUTTON_MEDIC_SETTINGS,
                new Button.ClickListener() {
                    private static final long serialVersionUID = 7147554466396214893L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        settingsPresenter.navigateToMedic();
                    }
                });
        medicSettingsButton.addStyleName("icon-cog");


        Button logoutButton = new Button(BUTTON_LOGOUT,
                new Button.ClickListener() {
                    private static final long serialVersionUID = -1096188732209266611L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                            settingsPresenter.navigateBack();
                    }
                });
        logoutButton.addStyleName("icon-cancel");
        logoutButton.addStyleName("default");

        // Adding and aligning the 3 Buttons.
        //Setting a Description for the buttons which is displayed when flying over the button
        this.buttons.addComponent(helpSettingsButton);
        this.buttons.setComponentAlignment(helpSettingsButton, Alignment.MIDDLE_CENTER);
        helpSettingsButton.setDescription("Set the Help options for the Patient");
        helpSettingsButton.setWidth(BUTTON_WIDTH);
        helpSettingsButton.setHeight(BUTTON_HEIGHT);

        this.buttons.addComponent(medicSettingsButton);
        this.buttons.setComponentAlignment(medicSettingsButton, Alignment.MIDDLE_CENTER);
        medicSettingsButton.setDescription("Set the Medication options for the Patient");
        medicSettingsButton.setWidth(BUTTON_WIDTH);
        medicSettingsButton.setHeight(BUTTON_HEIGHT);

//        addComponent(skillSettingsButton);
//        setComponentAlignment(skillSettingsButton, Alignment.MIDDLE_CENTER);
//        skillSettingsButton.setDescription("Set the Skill options for the Patient");
//        skillSettingsButton.setWidth(BUTTON_WIDTH);
//        skillSettingsButton.setHeight(BUTTON_HEIGHT);

        logoutButton.setWidth(BUTTON_WIDTH);
        this.buttons.addComponent(logoutButton);
        this.buttons.setComponentAlignment(logoutButton, Alignment.MIDDLE_CENTER);
        logoutButton.setDescription("You will be logged out");
        logoutButton.setWidth(BUTTON_WIDTH);
        logoutButton.setHeight(BUTTON_HEIGHT);

        //addComponent(buttonLayout);
        //setComponentAlignment(buttonLayout,Alignment.MIDDLE_CENTER);
    }

    private void setLayouts() {
        this.buttons.setMargin(true);
        this.buttons.setSpacing(true);
        this.addComponent(header);
        this.addComponent(patient);
        this.addComponent(buttons);
        this.setExpandRatio(header, 0.2f);
        this.setExpandRatio(patient, 0.2f);
        this.setExpandRatio(buttons, 0.6f);
    }

    @Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome to the settings homescreen!");
	}

    //Done by Esma
	private class PatientListener implements Property.ValueChangeListener{

		@Override
		public void valueChange(ValueChangeEvent event) {
			Object result = ((ComboBox) event.getProperty()).getValue();
            Patient selectedPatient = (Patient) result;

			settingsPresenter.patientChanged(selectedPatient);
		}

	}

    @Override
    public void addSettingsPresenter(IStartSettingsPresenter p) {
        this.settingsPresenter = p;
    }

    @Override
    public void addPatients(List<Patient> patientList) {
        patientContainer.addAll(patientList);
    }

}
