package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.BaseView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br>
 * 
 * <p>
 * Class that displays settings for different help-contacts. It provides a list
 * to select Contacts for a specific patient.
 * </p>
 * 
 * @author Vinzenz Messerli, messv1@bfh.ch
 * @version 29-11-2013
 */
public class HelpSetView extends BaseView implements View, IHelpSetView {

	private static final long serialVersionUID = 4973052160411552997L;
	public static final String BUTTON_BACK = "Back";

	/* Only the presenter registers one listener... */
	private IHelpViewSetPresenter presenter = null;

    public HelpSetView() {

        super();
        super.setTitle("CONTACT SETTINGS");

        this.setContent();
        this.createButtons();

        super.setLayouts(0.3f,0.6f,0.1f,0f);
	}


    private void setContent() {
        super.content.addComponent(new TextField("Profession"));
        super.content.addComponent(new TextField("Name"));
        super.content.addComponent(new TextField("First Name"));
        super.content.addComponent(new TextField("Phone nb. (office)"));
        super.content.addComponent(new TextField("Phone nb. (home)"));
    }


    private void createButtons() {
        // buttonLayout
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

        super.navigation.addComponent(buttonBack);
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

