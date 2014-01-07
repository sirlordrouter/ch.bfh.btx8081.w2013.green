package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.ui.BaseView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;

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
public class StartView extends BaseView implements View, IStartView {

	private static final long serialVersionUID = -1105303206323973784L;

	private static final String BUTTON_HELP = "HELP";

	private static final String BUTTON_SKILLS = "SKILLS";

	private static final String BUTTON_MEDICATION = "MEDICATION";

	private static final String BUTTON_LOGOUT = "LOGOUT";

	private static final String BUTTON_WIDTH = "160px";
    private static final String BUTTON_HEIGHT = "50px";
	
	private static final String PATIENT = "PATIENT";

    private IStartViewPresenter presenter = null;

	public StartView() {

        super();
        super.setTitle("Home Screen");

        this.createButtons();

        super.setLayouts(0.35f, 0,0,0.65f);

	}

    private void createButtons() {

        Button buttonHelp = new Button(BUTTON_HELP, new Button.ClickListener() {
            private static final long serialVersionUID = -3742574718530257633L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
presenter.navigateToHelp();
            }
        });
        buttonHelp.setWidth(BUTTON_WIDTH);
        buttonHelp.setHeight(BUTTON_HEIGHT);
        buttonHelp.addStyleName("icon-cog");
        super.verticalNavigation.addComponent(buttonHelp);
        super.verticalNavigation.setComponentAlignment(buttonHelp, Alignment.MIDDLE_CENTER);


        Button buttonSkills = new Button(BUTTON_SKILLS, new Button.ClickListener() {
                    private static final long serialVersionUID = -7539174022613115079L;

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
presenter.navigateToSkills();
                    }
                });
        buttonSkills.setWidth(BUTTON_WIDTH);
        buttonSkills.setHeight(BUTTON_HEIGHT);
        buttonSkills.addStyleName("icon-cog");
        super.verticalNavigation.addComponent(buttonSkills);
        super.verticalNavigation.setComponentAlignment(buttonSkills, Alignment.MIDDLE_CENTER);


        Button buttonMedic = new Button(BUTTON_MEDICATION,
                new Button.ClickListener() {
                    private static final long serialVersionUID = -5170311461467440566L;

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
presenter.navigateToMedic();
                    }
                });
        buttonMedic.setWidth(BUTTON_WIDTH);
        buttonMedic.setHeight(BUTTON_HEIGHT);
        buttonMedic.addStyleName("icon-cog");
        super.verticalNavigation. addComponent(buttonMedic);
        super.verticalNavigation.setComponentAlignment(buttonMedic, Alignment.MIDDLE_CENTER);


        Button buttonLogout = new Button(BUTTON_LOGOUT,
                new Button.ClickListener() {
                    private static final long serialVersionUID = -1096188732209266611L;

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
presenter.navigateBack();
                    }
                });
        buttonLogout.setWidth(BUTTON_WIDTH);
        buttonLogout.setHeight(BUTTON_HEIGHT);
        buttonLogout.addStyleName("icon-cancel");
        buttonLogout.addStyleName("default");
        super.verticalNavigation.addComponent(buttonLogout);
        super.verticalNavigation.setComponentAlignment(buttonLogout, Alignment.MIDDLE_CENTER);
    }

    @Override
	public void enter(ViewChangeEvent event) {

	}

    @Override
    public void addStartViewPresenter(IStartViewPresenter p) {
        presenter = p;
    }
}
