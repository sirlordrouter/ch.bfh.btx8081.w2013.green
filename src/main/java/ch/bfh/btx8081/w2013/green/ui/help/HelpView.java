package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
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
 * Class Description
 * </p>
 * 
 * @author group_green
 * @version 29-11-2013
 */
public class HelpView extends VerticalLayout implements View, IHelpView {

	private static final long serialVersionUID = 1L;
	private Navigator navigator = null;
	private IHelpPresenter presenter = null;

    private VerticalLayout header = new VerticalLayout();
    private VerticalLayout contacts = new VerticalLayout();
    private HorizontalLayout navigation = new HorizontalLayout();

	public HelpView() {

        addStyleName("dashboard-view");

		this.setWidth(MyVaadinUI.APP_WIDTH);
		this.setHeight(MyVaadinUI.APP_HIGHT);
        setMargin(true);
        setSpacing(true);

        Label titleLiabel = new Label("CONTACTS");
        titleLiabel.setStyleName("h1");
        titleLiabel.setHeight("30px");
        header.addComponent(titleLiabel);
        header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);

        createButtons();

        addComponent(header);
        addComponent(contacts);
        addComponent(navigation);

        setExpandRatio(header, 0.3f);
        setExpandRatio(contacts, 0.6f);
        setExpandRatio(navigation, 0.1f);
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
        navigation.addComponent(buttonBack);
        navigation.setComponentAlignment(buttonBack, Alignment.MIDDLE_CENTER);
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

//            Label l = new Label();
//            l.setContentMode(ContentMode.HTML);
//            l.setWidth("100px");
//            l.setValue(c.toString() + "\n\r\n\r");

            contacts.addComponent(contactLayout);
            contacts.setComponentAlignment(contactLayout, Alignment.TOP_CENTER);
        }

    }
}
