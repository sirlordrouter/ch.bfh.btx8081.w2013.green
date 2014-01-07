package ch.bfh.btx8081.w2013.green.ui.start;

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
public class StartView extends VerticalLayout implements View, IStartView {

	private static final long serialVersionUID = -1105303206323973784L;

	private static final String BUTTON_HELP = "HELP";

	private static final String BUTTON_SKILLS = "SKILLS";

	private static final String BUTTON_MEDICATION = "MEDICATION";

	private static final String BUTTON_LOGOUT = "LOGOUT";

	private static final String BUTTON_WIDTH = "160px";
    private static final String BUTTON_HEIGHT = "50px";
	
	private static final String PATIENT = "PATIENT";

    private IStartViewPresenter presenter = null;

    private VerticalLayout header = new VerticalLayout();
    private VerticalLayout buttons = new VerticalLayout();

	public StartView() {

        this.setStyles();
        this.setTitle();
        this.createButtons();
        this.setLayouts();

	}

    private void setStyles() {
        this.addStyleName("dashboard-view");
        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);
        this.setMargin(true);
        this.setSpacing(true);
    }

    private void setTitle() {
        Label titleLiabel = new Label("HOME SCREEN");
        titleLiabel.setStyleName("h1");
        titleLiabel.setHeight("30px");
        this.header.addComponent(titleLiabel);
        this.header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);
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
        buttons.addComponent(buttonHelp);
        buttons.setComponentAlignment(buttonHelp, Alignment.MIDDLE_CENTER);


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
        buttons.addComponent(buttonSkills);
        buttons.setComponentAlignment(buttonSkills, Alignment.MIDDLE_CENTER);


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
        buttons. addComponent(buttonMedic);
        buttons.setComponentAlignment(buttonMedic, Alignment.MIDDLE_CENTER);


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
        buttons.addComponent(buttonLogout);
        buttons.setComponentAlignment(buttonLogout, Alignment.MIDDLE_CENTER);
    }

    private void setLayouts() {
        this.buttons.setMargin(true);
        this.buttons.setSpacing(true);
        this.addComponent(header);
        this.addComponent(buttons);
        this.setExpandRatio(header, 0.35f);
        this.setExpandRatio(buttons, 0.65f);
    }

    @Override
	public void enter(ViewChangeEvent event) {

	}

    @Override
    public void addStartViewPresenter(IStartViewPresenter p) {
        presenter = p;
    }
}
