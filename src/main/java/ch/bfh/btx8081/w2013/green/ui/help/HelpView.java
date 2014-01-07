package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.BaseView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

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
    private BeanItemContainer contacts = new BeanItemContainer<>(Contact.class);

	public HelpView() {

        super();
        super.setTitle("Contacts");

        createButtons();

        super.setLayouts(0.15f,0.75f,0.1f,0);
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



        VerticalLayout contacts = new VerticalLayout();
        contacts.setMargin(true);
        contacts.setHeight("300px");
//
//        Table t = new Table("Contacts");
//        t.setWidth("300px");
//        t.setStyleName("plain");
//        t.addContainerProperty("Profession", Contact.class, null);
//        t.addContainerProperty("Name", Contact.class, null);
//        t.addContainerProperty("PhoneNumber", Contact.class, null);


        for (Contact c : contactsList) {

            CssLayout scrollPane = new CssLayout();
            scrollPane.setSizeFull();

            scrollPane.addStyleName("contacts");
            scrollPane.addStyleName("layout-panel");

            Label profession = new Label(c.getProfession());
            Label name = new Label(c.getFullName());
            Label phone = new Label(c.getPhoneNumberHtml());
            phone.setContentMode(ContentMode.HTML);

            scrollPane.addComponent(profession);
            scrollPane.addComponent(name);
            scrollPane.addComponent(phone);

            contacts.addComponent(scrollPane);
        }


        super.content.addComponent(contacts);
        super.content.setComponentAlignment(contacts, Alignment.TOP_CENTER);

    }
}
