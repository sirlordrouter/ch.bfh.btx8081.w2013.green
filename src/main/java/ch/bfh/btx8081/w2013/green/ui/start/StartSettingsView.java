package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.FakeDataAccess;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.util.ArrayList;
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
	private static final String BUTTON_LOGOUT = "LOGOUT";
	private static final String BUTTON_SKILL_SETTINGS = "Skill Settings";
	private static final String BUTTON_HELP_SETTINGS = "Help Settings";
	private static final String BUTTON_MEDIC_SETTINGS = "Medic Settings";
	private static final String BUTTON_WIDTH = "120px";

    private IStartSettingsPresenter settingsPresenter = null;

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

		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);

        createPatientsComboBox();

        createButtons();

	}

    private void createPatientsComboBox() {
        //Creating a fake Patientlist
        FakeDataAccess fda = new FakeDataAccess();
        ArrayList<Patient> patientList = new ArrayList<Patient>(fda.getPatients());

        //Combobox for selecting a patient.
        final ComboBox patientComboBox = new ComboBox("Select Patient");
        patientComboBox.setImmediate(true);

        BeanItemContainer<Patient> patientContainer = new BeanItemContainer<Patient>(Patient.class);

        // Create a selection component bound to the container
        ComboBox selectPatient = new ComboBox("Patients", patientContainer);
        // from the 'name' property of the bean
        selectPatient.setItemCaptionPropertyId("patientName");
        selectPatient.setImmediate(true);
        selectPatient.addValueChangeListener(new PatientListener());


        //Putting the patients from the patientlist in the combobox.
        for (Patient p : patientList) {
			patientContainer.addItem(p);
        }

        selectPatient.setWidth("200px");
        addComponent(selectPatient);
        setComponentAlignment(selectPatient, Alignment.MIDDLE_CENTER);
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

        Button skillSettingsButton = new Button(BUTTON_SKILL_SETTINGS,
                new Button.ClickListener() {
                    private static final long serialVersionUID = 7147554466396214893L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        settingsPresenter.navigateToSkills();
                    }
                });

        Button medicSettingsButton = new Button(BUTTON_MEDIC_SETTINGS,
                new Button.ClickListener() {
                    private static final long serialVersionUID = 7147554466396214893L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        settingsPresenter.navigateToMedic();
                    }
                });

        Button logoutButton = new Button(BUTTON_LOGOUT,
                new Button.ClickListener() {
                    private static final long serialVersionUID = -1096188732209266611L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                            settingsPresenter.navigateBack();
                    }
                });


        // Adding and aligning the 3 Buttons.
        //Setting a Description for the buttons which is displayed when flying over the button
        addComponent(helpSettingsButton);
        setComponentAlignment(helpSettingsButton, Alignment.MIDDLE_CENTER);
        helpSettingsButton.setDescription("Set the Help options for the Patient");
        helpSettingsButton.setWidth(BUTTON_WIDTH);

        addComponent(medicSettingsButton);
        setComponentAlignment(medicSettingsButton, Alignment.MIDDLE_CENTER);
        medicSettingsButton.setDescription("Set the Medication options for the Patient");
        medicSettingsButton.setWidth(BUTTON_WIDTH);

        addComponent(skillSettingsButton);
        setComponentAlignment(skillSettingsButton, Alignment.MIDDLE_CENTER);
        skillSettingsButton.setDescription("Set the Skill options for the Patient");
        skillSettingsButton.setWidth(BUTTON_WIDTH);


        logoutButton.setWidth(BUTTON_WIDTH);
        addComponent(logoutButton);
        setComponentAlignment(logoutButton, Alignment.MIDDLE_CENTER);
        logoutButton.setDescription("You will be logged out");
        logoutButton.setWidth(BUTTON_WIDTH);
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
        List<Patient> patientList1 = patientList;
    }

}
