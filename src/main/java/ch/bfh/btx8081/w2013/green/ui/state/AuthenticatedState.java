package ch.bfh.btx8081.w2013.green.ui.state;

import ch.bfh.btx8081.w2013.green.businesslogic.Medication;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.help.HelpPresenter;
import ch.bfh.btx8081.w2013.green.ui.help.HelpView;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationPresenter;
import ch.bfh.btx8081.w2013.green.ui.medication.MedicationView;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import ch.bfh.btx8081.w2013.green.ui.start.StartView;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * Class that describes the authenticated state of the Application.
 * </p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 07-12-2013
 */
public class AuthenticatedState extends AuthenticationState {

    /**
     * Global accessible Reference for the Startview name as it is stored in
     * the navigator.
     */
    public static final String START_VIEW = "";
    /**
     * Global accessible Reference for the Helpview name as it is stored in
     * the navigator.
     */
    public static final String HELP_VIEW = "help";
    /**
     * Global accessible Reference for the Skillview name as it is stored in
     * the navigator.
     */
    public static final String SKILL_VIEW = "skill";
    /**
     * Global accessible Reference for the Medicationview name as it is stored in
     * the navigator.
     */
    public static final String MEDIC_VIEW = "medic";
    /**
     * Global accessible Reference for the Settingsview name as it is stored in
     * the navigator.
     */
    public static final String SETTINGS_VIEW = "sett";

    private Model model = null;
    private ReminderComponent mc = null;

    /**
     * Constructor for this state implementation.
     * @param ui the UI as context for the state pattern.
     */
    public AuthenticatedState(MyVaadinUI ui) {
        super(ui);
    }

    /**
     * loads global used components for both, patient and care staff when entering
     * the authenticated state.
     */
    @Override
    protected void entryState() {

        super.navigator.addView(START_VIEW, new StartView(navigator));
        super.navigator.setErrorView(StartView.class);

        this.model = new Model();
        this.mc = new ReminderComponent();

        //TODO: Remove to Generator
        for (Medication medication : this.model.getMedications()) {
            this.mc.addNormalTimer(medication);
        }

//    	if (loginManager.getCurrentUser().isPatient()) {
        loadProtectedUserResources();
//		} else {
        loadProtectedStaffResources();
//		}
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

        StartView startView = new StartView(navigator);
        super.navigator.addView(START_VIEW, startView);
        super.navigator.navigateTo(START_VIEW);

        SkillsView skillsView = new SkillsView();
        new SkillsPresenter(skillsView, model, navigator);
        super.navigator.addView(SKILL_VIEW, skillsView);

        HelpView helpView = new HelpView(navigator);
        new HelpPresenter(helpView, model, navigator);
        super.navigator.addView(HELP_VIEW, helpView);

        MedicationView medView = new MedicationView();
        new MedicationPresenter(medView, model, navigator, mc);
        super.navigator.addView(MEDIC_VIEW, medView);

    }

    /**
     * loads staff specific data and views.
     */
    private void loadProtectedStaffResources() {
        // TODO Auto-generated method stub
    }

    /**
     * The views must be removed due to security issues. Otherwise
     * information is accessible through url.
     */
    private void cleanProtectedResources() {
        super.navigator.removeView(START_VIEW);
        super.navigator.removeView(SKILL_VIEW);
        super.navigator.removeView(HELP_VIEW);
        super.navigator.removeView(MEDIC_VIEW);
    }
}