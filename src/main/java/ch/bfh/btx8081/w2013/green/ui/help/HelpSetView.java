package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
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
	private Navigator navigator = null;
	public static final String BUTTON_BACK = "Back";

	/* Only the presenter registers one listener... */
	private final List<IHelpViewSetListener> listeners = new ArrayList<IHelpViewSetListener>();

	public HelpSetView(Navigator nav) {
		this.navigator = nav;

		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);

		VerticalLayout vertical = new VerticalLayout();
		vertical.addComponent(new TextField("Profession"));
		vertical.addComponent(new TextField("Name"));
		vertical.addComponent(new TextField("First Name"));
		vertical.addComponent(new TextField("Phone nb. (office)"));
		vertical.addComponent(new TextField("Phone nb. (home)"));

		// buttonLayout
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.addComponent(new Button(BUTTON_BACK,
				new Button.ClickListener() {
					private static final long serialVersionUID = 1L;

					@Override
					public void buttonClick(
							com.vaadin.ui.Button.ClickEvent event) {
						for (IHelpViewSetListener listener : listeners) {
							listener.buttonClick(event.getButton().getCaption()
									.charAt(0));
						}
					}
				}));
		vertical.addComponent(buttonLayout);

		addComponent(vertical);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(IHelpViewSetListener l) {
		this.listeners.add(l);

	}

	@Override
	public void setMedicationList() {
		// TODO Auto-generated method stub

	}

}
