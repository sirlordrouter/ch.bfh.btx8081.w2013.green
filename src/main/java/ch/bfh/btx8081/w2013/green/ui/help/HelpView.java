package ch.bfh.btx8081.w2013.green.ui.help;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

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
	private final List<IHelpViewListener> listeners = new ArrayList<IHelpViewListener>();

	public HelpView(Navigator nav) {
		this.navigator = nav;

		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);

		VerticalLayout vertical = new VerticalLayout();

		String contacts = "";

		for (int i = 0; i <= 10; i++) {

			Label l = new Label();
			l.setContentMode(ContentMode.HTML);
			l.setWidth("100px");
			l.setValue("Physicologist\n"
					+ "<a href=\"tel:5551234567\">Tel: (555)123-4567</a>\n"
					+ "<a href=\"tel:5551234567\">Home: (555)123-4567</a>\n\n\n");

			vertical.addComponent(l);
		}

		vertical.addComponent(new Button("Back", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				navigator.navigateTo(AuthenticatedState.START_VIEW);
			}
		}));

		addComponent(vertical);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		View view = event.getNewView();
	}

	@Override
	public void addListener(IHelpViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void setMedicationList() {

	}
}
