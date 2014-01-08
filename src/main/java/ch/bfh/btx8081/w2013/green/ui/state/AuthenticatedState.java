package ch.bfh.btx8081.w2013.green.ui.state;

import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.*;
import ch.bfh.btx8081.w2013.green.ui.help.HelpPresenter;
import ch.bfh.btx8081.w2013.green.ui.help.HelpSetPresenter;
import ch.bfh.btx8081.w2013.green.ui.help.HelpSetView;
import ch.bfh.btx8081.w2013.green.ui.help.HelpView;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationPresenter;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationSettingsPresenter;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationSettingsView;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationView;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsView;
import ch.bfh.btx8081.w2013.green.ui.start.*;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br> Modul 8081, HS2013</br>
 * 
 * <p>
 * Class that describes the authenticated state of the Application.
 * </p>
 * 
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 07-12-2013
 */
public class AuthenticatedState extends AuthenticationState {

	/**
	 * Global accessible Reference for the Startview name as it is stored in the
	 * navigator.
	 */
	public static final String START_VIEW = "";

	/**
	 * Global accessible Reference for the Helpview name as it is stored in the
	 * navigator.
	 */
	public static final String HELP_VIEW = "help";

	/**
	 * Global accessible Reference for the Skillview name as it is stored in the
	 * navigator.
	 */
	public static final String SKILL_VIEW = "skill";

	/**
	 * Global accessible Reference for the Medicationview name as it is stored
	 * in the navigator.
	 */
	public static final String MEDIC_VIEW = "medic";

	/**
	 * Global accessible Reference for the Startview name as it is stored in the
	 * navigator.
	 */
	public static final String START_SETTINGS_VIEW = "";

	/**
	 * Global accessible Reference for the Skillview name as it is stored in the
	 * navigator.
	 */

	public static final String HELP_SET_VIEW = "helpSet";

	/**
	 * Global accessible Reference for the Medicationview name as it is stored
	 * in the navigator.
	 */
	public static final String MEDIC_SET_VIEW = "medicSet";

    private SettingsModel settingsModel = null;
    private ISettingsDataAccess dataAccess = null;

    /**
	 * Constructor for this state implementation.
	 * 
	 * @param ui
	 *            the UI as context for the state pattern.
	 */
	public AuthenticatedState(MyVaadinUI ui) {
		super(ui);
	}

	/**
	 * loads global used components for both, patient and care staff when
	 * entering the authenticated state.
	 */
	@Override
	protected void entryState() {

		if (super.context.getCurrentUser().getIsPatient()) {
			this.loadProtectedUserResources();
		} else {
			this.loadProtectedSettingsResources();
		}
	}

	/**
	 * Remove everything on exiting the authenticated state.
	 */
	@Override
	protected void exitState() {

        if (!super.context.getCurrentUser().getIsPatient()) {
            this.storeDataPersistent();
        }

	}

    /**
	 * handles the correct logout and moves to the unauthenticated state.
	 */
	@Override
	public void handleLogout() {
		super.context.setState(new UnauthenticatedState(super.context));
	}

	/**
	 * loads patient specific data and views.
	 */
	private void loadProtectedUserResources() {

		Model userModel = new Model();
		ReminderComponent reminderComponent = new ReminderComponent();

        //TODO: Handle what happens if some data is null

        //TODO: Bind right DataAccess
		IDataAccess userDataAccess = new FileDataAccess(); //FakeDataAccess();
		userModel.setContacts(userDataAccess.getContacts(super.context.getCurrentUser().getId()));
		userModel.setMedications(userDataAccess.getMedications(super.context.getCurrentUser().getId()));
        //userModel.setSkills(userDataAccess.getSkills(super.context.getCurrentUser().getId()));

		StartView startView = new StartView();
        new StartPresenter(super.navigator, startView);
		super.navigator.addView(START_VIEW, startView);
		super.navigator.navigateTo(START_VIEW);
		super.navigator.setErrorView(StartView.class);

		SkillsView skillsView = new SkillsView();
		new SkillsPresenter(skillsView, userModel, super.navigator);
		super.navigator.addView(SKILL_VIEW, skillsView);

		HelpView helpView = new HelpView();
		new HelpPresenter(helpView, userModel, super.navigator);
		super.navigator.addView(HELP_VIEW, helpView);

		MedicationView medView = new MedicationView();
		new MedicationPresenter(medView, userModel, super.navigator, reminderComponent);
		super.navigator.addView(MEDIC_VIEW, medView);

	}

	/**
	 * loads staff specific data and views.
	 */
	private void loadProtectedSettingsResources() {

        //TODO: Bind right DataAccess
        this.dataAccess = new FileDataAccess(); //FakeDataAccess();

        this.settingsModel = new SettingsModel();

        this.settingsModel.setPatients(this.dataAccess.getPatients());
        this.settingsModel.setContacts(this.dataAccess.getContacts());
        this.settingsModel.setMedications(this.dataAccess.getMedications());
        //this.settingsModel.setSkills(dataAccess.getSkills());

        StartSettingsView startSettingsView = new StartSettingsView();
        StartSettingsPresenter startSettingsPresenter = new StartSettingsPresenter(this.settingsModel,super.navigator, startSettingsView);
		super.navigator.addView(START_SETTINGS_VIEW, startSettingsView);
		super.navigator.setErrorView(StartSettingsView.class);
		super.navigator.navigateTo(START_SETTINGS_VIEW);

		HelpSetView helpSetView = new HelpSetView();
		HelpSetPresenter helpSetPresenter =  new HelpSetPresenter(helpSetView, this.settingsModel, super.navigator);
        startSettingsPresenter.addPatientChangedListener(helpSetPresenter);
		super.navigator.addView(HELP_SET_VIEW, helpSetView);

		MedicationSettingsView medSetView = new MedicationSettingsView();
        MedicationSettingsPresenter medicationSettingsPresenter =  new MedicationSettingsPresenter(this.settingsModel, super.navigator, medSetView);
        startSettingsPresenter.addPatientChangedListener(medicationSettingsPresenter);
		super.navigator.addView(MEDIC_SET_VIEW, medSetView);

	}

    private void storeDataPersistent() {

        this.dataAccess.setPatients(this.settingsModel.getPatients());

    }
}
