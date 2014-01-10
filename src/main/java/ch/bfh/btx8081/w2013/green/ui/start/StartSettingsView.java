package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.BaseView;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Main Page for the Settings. Allows navigating to the settings views.</p>
 *
 * @author Jan Wiebe van der Sluis,
 * @version 23-12-2013
 */
public class StartSettingsView extends BaseView implements View, IStartSettingsView {

	private static final long serialVersionUID = 1L;
	private static final String BUTTON_LOGOUT = "Logout";
	private static final String BUTTON_SKILL_SETTINGS = "Skills";
	private static final String BUTTON_HELP_SETTINGS = "Contacts";
	private static final String BUTTON_MEDIC_SETTINGS = "Medication";
	private static final String BUTTON_WIDTH = "160px";
    private static final String BUTTON_HEIGHT = "50px";

    private IStartSettingsPresenter settingsPresenter = null;
    private BeanItemContainer<Patient> patientContainer = null;

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

        super();
        super.setTitle("Settings");

        this.createPatientsComboBox();
        this.createButtons();

        super.setLayouts(0.2f, 0.2f,0,0.6f);

	}

    private void createPatientsComboBox() {

        this.patientContainer = new BeanItemContainer<Patient>(Patient.class);

        // Create a selection component bound to the container
        ComboBox selectPatient = new ComboBox("Select Patient:", patientContainer);
        // from the 'name' property of the bean
        selectPatient.setItemCaptionPropertyId("patientName");
        selectPatient.setImmediate(true);
        selectPatient.addValueChangeListener(new PatientListener());

        selectPatient.setWidth("200px");
        super.content.addComponent(selectPatient);
        super.content.setComponentAlignment(selectPatient, Alignment.MIDDLE_CENTER);
    }

    private void createButtons() {

        // Creating the 3 Buttons (Help Settings, Skill Settings and Logout)
        // with a Navigator which should navigate to the corresponding view.
        Button helpSettingsButton = new Button("",
                new Button.ClickListener() {
                    private static final long serialVersionUID = -5797923866320649518L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        settingsPresenter.navigateToHelp();
                    }
                });

//        Button skillSettingsButton = new Button("",
//                new Button.ClickListener() {
//                    private static final long serialVersionUID = 7147554466396214893L;
//
//                    @Override
//                    public void buttonClick(ClickEvent event) {
//                        settingsPresenter.navigateToSkills();
//                    }
//                });
//        skillSettingsButton.addStyleName("icon-cog");

        Button medicSettingsButton = new Button("",
                new Button.ClickListener() {
                    private static final long serialVersionUID = 7147554466396214893L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        settingsPresenter.navigateToMedic();
                    }
                });


        Button logoutButton = new Button("",
                new Button.ClickListener() {
                    private static final long serialVersionUID = -1096188732209266611L;

                    @Override
                    public void buttonClick(ClickEvent event) {
                            settingsPresenter.navigateBack();
                    }
                });
        logoutButton.addStyleName("default");

        // Adding and aligning the 3 Buttons.
        //Setting a Description for the buttons which is displayed when flying over the button
        super.verticalNavigation.addComponent(helpSettingsButton);
        super.verticalNavigation.setComponentAlignment(helpSettingsButton, Alignment.MIDDLE_CENTER);
        helpSettingsButton.setDescription("Set the Help options for the Patient");
        helpSettingsButton.setIcon(new ThemeResource("img/contacgg.png"), BUTTON_HELP_SETTINGS);
        helpSettingsButton.setWidth(BUTTON_WIDTH);
        helpSettingsButton.setHeight(BUTTON_HEIGHT);

        super.verticalNavigation.addComponent(medicSettingsButton);
        super.verticalNavigation.setComponentAlignment(medicSettingsButton, Alignment.MIDDLE_CENTER);
        medicSettingsButton.setDescription("Set the Medication options for the Patient");
        medicSettingsButton.setIcon(new ThemeResource("img/medicine-icon-cog.png"),BUTTON_MEDIC_SETTINGS);
        medicSettingsButton.setWidth(BUTTON_WIDTH);
        medicSettingsButton.setHeight(BUTTON_HEIGHT);

//        addComponent(skillSettingsButton);
//        setComponentAlignment(skillSettingsButton, Alignment.MIDDLE_CENTER);
//        skillSettingsButton.setDescription("Set the Skill options for the Patient");
//         skillSettingsButton.setIcon(new ThemeResource("img/skill2-icon-cog.png"), BUTTON_SKILL_SETTINGS);
//        skillSettingsButton.setWidth(BUTTON_WIDTH);
//        skillSettingsButton.setHeight(BUTTON_HEIGHT);

        logoutButton.setWidth(BUTTON_WIDTH);
        super.verticalNavigation.addComponent(logoutButton);
        super.verticalNavigation.setComponentAlignment(logoutButton, Alignment.MIDDLE_CENTER);
        logoutButton.setDescription("You will be logged out");
        logoutButton.setIcon(new ThemeResource("img/logout.png"), BUTTON_LOGOUT);
        logoutButton.setWidth(BUTTON_WIDTH);
        logoutButton.setHeight(BUTTON_HEIGHT);

    }

    @Override
	public void enter(ViewChangeEvent event) {

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
        this.patientContainer.addAll(patientList);
    }

}
