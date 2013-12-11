package ch.bfh.btx8081.w2013.green.ui.help;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

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
public class HelpSetView extends VerticalLayout implements View {

	private static final long serialVersionUID = 4973052160411552997L;
	private Navigator navigator = null;

	public HelpSetView(Navigator nav) {
		this.navigator = nav;

		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);

		VerticalLayout vertical = new VerticalLayout();

		Label l = new Label();
		l.setContentMode(ContentMode.HTML);
		l.setWidth("100px");
		l.setValue("Physicologist\n"
				+ "<a href=\"tel:5551234567\">Tel: (555)123-4567</a>\n"
				+ "<a href=\"tel:5551234567\">Home: (555)123-4567</a>\n\n\n");

		addComponent(vertical);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
