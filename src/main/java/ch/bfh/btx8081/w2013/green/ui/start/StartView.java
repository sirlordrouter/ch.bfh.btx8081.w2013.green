package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.ui.BaseView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;

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

        super.setLayouts(0.35f, 0.65f,0,0);

	}

    private void createButtons() {

        Button buttonHelp = new Button("", new Button.ClickListener() {
            private static final long serialVersionUID = -3742574718530257633L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                presenter.navigateToHelp();
            }
        });
        buttonHelp.setWidth(BUTTON_WIDTH);
        buttonHelp.setHeight(BUTTON_HEIGHT);
        //Resource icon = new ThemeResource("img/contact.png");
        buttonHelp.setIcon(new ThemeResource("img/contact.png"), BUTTON_HELP);
        super.content.addComponent(buttonHelp);
        super.content.setComponentAlignment(buttonHelp, Alignment.MIDDLE_CENTER);


        Button buttonSkills = new Button("", new Button.ClickListener() {
                    private static final long serialVersionUID = -7539174022613115079L;

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                            presenter.navigateToSkills();
                    }
                });
        buttonSkills.setWidth(BUTTON_WIDTH);
        buttonSkills.setHeight(BUTTON_HEIGHT);
        buttonSkills.setIcon(new ThemeResource("img/skill2-icon.png"), BUTTON_SKILLS);
        super.content.addComponent(buttonSkills);
        super.content.setComponentAlignment(buttonSkills, Alignment.MIDDLE_CENTER);


        Button buttonMedic = new Button("",
                new Button.ClickListener() {
                    private static final long serialVersionUID = -5170311461467440566L;

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
presenter.navigateToMedic();
                    }
                });
        buttonMedic.setWidth(BUTTON_WIDTH);
        buttonMedic.setHeight(BUTTON_HEIGHT);
        buttonMedic.setIcon(new ThemeResource("img/medicine-icon.png"), BUTTON_MEDICATION);
        super.content. addComponent(buttonMedic);
        super.content.setComponentAlignment(buttonMedic, Alignment.MIDDLE_CENTER);


        Button buttonLogout = new Button("",
                new Button.ClickListener() {
                    private static final long serialVersionUID = -1096188732209266611L;

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
presenter.navigateBack();
                    }
                });
        buttonLogout.setWidth(BUTTON_WIDTH);
        buttonLogout.setHeight(BUTTON_HEIGHT);
        buttonLogout.setIcon(new ThemeResource("img/logout.png"), BUTTON_LOGOUT);
        buttonLogout.addStyleName("default");
        super.content.addComponent(buttonLogout);
        super.content.setComponentAlignment(buttonLogout, Alignment.MIDDLE_CENTER);
    }

    @Override
	public void enter(ViewChangeEvent event) {

	}

    @Override
    public void addStartViewPresenter(IStartViewPresenter p) {
        this.presenter = p;
    }
}
