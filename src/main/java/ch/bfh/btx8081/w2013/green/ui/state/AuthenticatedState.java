package ch.bfh.btx8081.w2013.green.ui.state;

import ch.bfh.btx8081.w2013.green.businesslogic.LoginManager;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.FakeDataAccess;
import ch.bfh.btx8081.w2013.green.data.ISettingsDataAccess;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.data.SettingsDataAccess;
import ch.bfh.btx8081.w2013.green.data.SettingsModel;
import ch.bfh.btx8081.w2013.green.ui.help.HelpPresenter;
import ch.bfh.btx8081.w2013.green.ui.help.HelpSetPresenter;
import ch.bfh.btx8081.w2013.green.ui.help.HelpSetView;
import ch.bfh.btx8081.w2013.green.ui.help.HelpView;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationPresenter;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationSettingsView;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationView;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import ch.bfh.btx8081.w2013.green.ui.start.StartSettingsView;
import ch.bfh.btx8081.w2013.green.ui.start.StartView;

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
	 * Global accessible Reference for the Settingsview name as it is stored in
	 * the navigator.
	 */
	public static final String SETTINGS_VIEW = "sett";

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

		if (LoginManager.getLoginManager().getCurrentUser().isPatient()) {
			loadProtectedUserResources();
		} else {
			loadProtectedSettingsResources();
		}
	}

	/**
	 * Remove everything on exiting the authenticated state.
	 */
	@Override
	protected void exitState() {
		cleanProtectedResources();
	}

	/**
	 * handles the correct logout and moves to the unauthenticated state.
	 */
	@Override
	public void handleLogout() {
		super.context.setState(new UnauthenticatedState(context));
	}

	/**
	 * loads patient specific data and views.
	 */
	private void loadProtectedUserResources() {


		Model userModel = new Model();
		ReminderComponent mc = new ReminderComponent();

		FakeDataAccess fda = new FakeDataAccess();
		userModel.setContacts(fda.getContacts());
		userModel.setMedications(fda.getMedications());

		StartView startView = new StartView(navigator);
		super.navigator.addView(START_VIEW, startView);
		super.navigator.navigateTo(START_VIEW);
		super.navigator.setErrorView(StartView.class);

		SkillsView skillsView = new SkillsView();
		new SkillsPresenter(skillsView, userModel, navigator);
		super.navigator.addView(SKILL_VIEW, skillsView);

		HelpView helpView = new HelpView(navigator);
		new HelpPresenter(helpView, userModel, navigator);
		super.navigator.addView(HELP_VIEW, helpView);

		MedicationView medView = new MedicationView();
		new MedicationPresenter(medView, userModel, navigator, mc);
		super.navigator.addView(MEDIC_VIEW, medView);

	}

	/**
	 * loads staff specific data and views.
	 */
	private void loadProtectedSettingsResources() {

        SettingsModel settingsModel = new SettingsModel();
        ISettingsDataAccess dataAccess = new SettingsDataAccess();

        FakeDataAccess fda = new FakeDataAccess();
        settingsModel.setContacts(fda.getContacts());
        settingsModel.setMedications(fda.getMedications());

		super.navigator.addView(START_SETTINGS_VIEW, new StartSettingsView(
				navigator));
		super.navigator.setErrorView(StartSettingsView.class);
		
		super.navigator.navigateTo(START_SETTINGS_VIEW);

		HelpSetView helpSetView = new HelpSetView(navigator);
		new HelpSetPresenter(helpSetView, settingsModel, navigator);
		super.navigator.addView(HELP_SET_VIEW, helpSetView);
		
		MedicationSettingsView medSetView = new MedicationSettingsView(navigator);
		super.navigator.addView(MEDIC_SET_VIEW, medSetView);

	}

	/**
	 * The views must be removed due to security issues. Otherwise information
	 * is accessible through url.
	 */
	private void cleanProtectedResources() {
		super.navigator.removeView(START_VIEW);
		super.navigator.removeView(SKILL_VIEW);
		super.navigator.removeView(HELP_VIEW);
		super.navigator.removeView(MEDIC_VIEW);
		super.navigator.removeView(HELP_SET_VIEW);
	}
}
