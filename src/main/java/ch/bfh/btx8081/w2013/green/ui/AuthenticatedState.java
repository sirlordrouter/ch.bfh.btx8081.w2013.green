package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.businesslogic.Medication;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import ch.bfh.btx8081.w2013.green.ui.start.StartPresenter;
import ch.bfh.btx8081.w2013.green.ui.start.StartView;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * Class that which holds the components for the Authenticated state.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 07-12-2013
 */
public class AuthenticatedState extends AuthenticationState {

    public static final String STARTVIEW = "";
    public static final String HELPVIEW = "help";
    public static final String SKILLVIEW = "skill";
    public static final String MEDICVIEW = "medic";
    public static final String SETTINGSVIEW = "sett";

    private Model model;
    private ReminderComponent mc;

    public AuthenticatedState(MyVaadinUI ui) {
        super(ui);
    }

    @Override
    protected void entryState() {
        loadProtectedResources();
    }

    @Override
    protected void exitState() {
        destroyProtectedResources();
    }

    @Override
    public void handleLogout() {
        super.context.setState(new UnauthenticatedState(context));
    }

    private void loadProtectedResources()
    {
        super.navigator.addView(STARTVIEW, new StartView(navigator));
        super.navigator.setErrorView(StartView.class);

        model = new Model();
        mc = new ReminderComponent();

        //TODO: Remove to Generator
        for (Medication medication : model.getMedications()) {
            mc.addNormalTimer(medication);
        }

//    	if (loginManager.getCurrentUser().isPatient()) {
        loadProtectedUserResources();
//		} else {
        loadProtectedStaffResources();
//		}
//
    }

    private void loadProtectedUserResources() {

        StartView startView = new StartView(navigator);
        StartPresenter sp = new StartPresenter(startView, model);
        super.navigator.addView(STARTVIEW, startView);
        super.navigator.addViewChangeListener(sp);
        super.navigator.navigateTo(STARTVIEW);

        SkillsView skillsView = new SkillsView(navigator);
        new SkillsPresenter(skillsView, model);
        super.navigator.addView(SKILLVIEW, skillsView);

        HelpView helpView = new HelpView(navigator);
        new ReminderPresenter(helpView, model, mc);
        super.navigator.addView(HELPVIEW, helpView);
    }

    private void loadProtectedStaffResources() {
        // TODO Auto-generated method stub
    }

    /**
     * The views must be removed due to security issues. Otherwise
     * information is accessible through the url.
     */
    private void destroyProtectedResources() {
        super.navigator.removeView("Start");
        super.navigator.removeView(SKILLVIEW);
        super.navigator.removeView(HELPVIEW);
        super.navigator.removeView(MEDICVIEW);
    }
}
