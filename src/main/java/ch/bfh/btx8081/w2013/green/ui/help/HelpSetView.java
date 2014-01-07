package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br>
 * 
 * <p>
 * Class Description
 * </p>
 * 
 * @author Vinzenz Messerli, messv1@bfh.ch
 * @version 29-11-2013
 */
public class HelpSetView extends VerticalLayout implements View, IHelpSetView {

	private static final long serialVersionUID = 4973052160411552997L;
	public static final String BUTTON_BACK = "Back";

	/* Only the presenter registers one listener... */
	private IHelpViewSetPresenter presenter = null;

    private VerticalLayout header = new VerticalLayout();
    private VerticalLayout contacts = new VerticalLayout();
    private HorizontalLayout navigation = new HorizontalLayout();

    public HelpSetView() {

        this.setStyles();
        this.setTitle();
        this.setContent();
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
        Label titleLiabel = new Label("CONTACT SETTINGS");
        titleLiabel.setStyleName("h1");
        titleLiabel.setHeight("30px");
        this.header.addComponent(titleLiabel);
        this.header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);
    }

    private void setContent() {
        this.contacts.addComponent(new TextField("Profession"));
        this.contacts.addComponent(new TextField("Name"));
        this.contacts.addComponent(new TextField("First Name"));
        this.contacts.addComponent(new TextField("Phone nb. (office)"));
        this.contacts.addComponent(new TextField("Phone nb. (home)"));
    }


    private void createButtons() {
        // buttonLayout
        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button buttonBack = new Button(BUTTON_BACK,
                new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void buttonClick(
                            Button.ClickEvent event) {
                        presenter.navigateBack();
                    }
                });

        buttonBack.addStyleName("icon-dashboard");
        buttonBack.addStyleName("default");
        buttonLayout.addComponent(buttonBack);

        this.navigation.addComponent(buttonLayout);
    }

    private void setLayouts() {
        this.contacts.setMargin(true);
        this.contacts.setSpacing(true);
        this.addComponent(header);
        this.addComponent(contacts);
        this.addComponent(navigation);
        this.setExpandRatio(header, 0.3f);
        this.setExpandRatio(contacts, 0.6f);
        this.setExpandRatio(navigation, 0.1f);
    }

    @Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void addPresenter(IHelpViewSetPresenter l) {
		this.presenter = l;
	}

    @Override
    public void setContactsList(List<Contact> contactsList) {

    }


}

