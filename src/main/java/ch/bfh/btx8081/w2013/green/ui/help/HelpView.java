package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.BaseView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.dd.HorizontalDropLocation;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import sun.awt.HorizBagLayout;

import java.util.List;

/**
 * Berner Fachhochschule</br> Medizininformatik BSc</br>
 * 
 * <p>
 * Class for Displaying Contacts which a Patient can call in difficult Situations.
 * </p>
 * 
 * @author group_green
 * @version 29-11-2013
 */
public class HelpView extends BaseView implements View, IHelpView {

	private static final long serialVersionUID = 1L;
	private IHelpPresenter presenter = null;

	public HelpView() {

        super();
        super.setTitle("Contacts");

        createButtons();

        super.setLayouts(0.3f,0.6f,0.1f,0);
	}

    private void createButtons() {

        final Button buttonBack = new Button("Back", new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                presenter.navigateBack();
            }
        });

        buttonBack.addStyleName("icon-dashboard");
        buttonBack.addStyleName("default");
        super.navigation.addComponent(buttonBack);
        super.navigation.setComponentAlignment(buttonBack, Alignment.MIDDLE_CENTER);
    }

    @Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void addPresenter(IHelpPresenter listener) {
		this.presenter = listener;
	}

    @Override
    public void setContactsList(List<Contact> contactsList) {

        for (Contact c : contactsList) {

            CssLayout contactLayout = new CssLayout();
            Label name = new Label(c.getName());
            Label phone = new Label(c.getPhoneNumber());
            contactLayout.addComponent(name);
            contactLayout.addComponent(phone);

            //TODO: HTML Output Phone

            super.content.addComponent(contactLayout);
            super.content.setComponentAlignment(contactLayout, Alignment.TOP_CENTER);
        }

    }
}
