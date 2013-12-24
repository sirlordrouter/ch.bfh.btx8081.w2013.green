package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

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
    private VerticalLayout vertical = null;

    public HelpSetView() {

		this.setWidth(MyVaadinUI.APP_WIDTH);
		this.setHeight(MyVaadinUI.APP_HIGHT);

		this.vertical = new VerticalLayout();

		vertical.addComponent(new TextField("Profession"));
		vertical.addComponent(new TextField("Name"));
		vertical.addComponent(new TextField("First Name"));
		vertical.addComponent(new TextField("Phone nb. (office)"));
		vertical.addComponent(new TextField("Phone nb. (home)"));

        createButtons();

        addComponent(vertical);
	}

    private void createButtons() {
        // buttonLayout
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addComponent(new Button(BUTTON_BACK,
                new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void buttonClick(
                            Button.ClickEvent event) {
                        presenter.navigateBack();
                    }
                }));
        vertical.addComponent(buttonLayout);
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

