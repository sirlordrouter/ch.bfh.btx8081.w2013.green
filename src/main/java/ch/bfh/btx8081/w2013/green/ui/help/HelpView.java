package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

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
    private VerticalLayout vertical = null;

	public HelpView() {

		this.setWidth(MyVaadinUI.APP_WIDTH);
		this.setHeight(MyVaadinUI.APP_HIGHT);

		this.vertical = new VerticalLayout();
        addComponent(vertical);

        createButtons();

	}

    private void createButtons() {

        this.addComponent(new Button("Back", new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                presenter.navigateBack();
            }
        }));
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
            Label l = new Label();
            l.setContentMode(ContentMode.HTML);
            l.setWidth("100px");
            l.setValue(c.toString() + "\n\r\n\r");

            vertical.addComponent(l);
        }

    }
}
