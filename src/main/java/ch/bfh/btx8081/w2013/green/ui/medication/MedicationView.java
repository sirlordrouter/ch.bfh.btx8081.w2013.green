package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 09-12-2013
 */
public class MedicationView extends ReminderView implements IMedicationView, View {

	private IMedicationPresenter presenter = null;
	private TextArea area = null;
    private VerticalLayout vertical = null;
    
    public MedicationView(){
    	super();

    	this.vertical = new VerticalLayout ();

        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);

        this.area = new TextArea();
        this.area.setWidth(MyVaadinUI.APP_WIDTH);
        this.area.setHeight("380px");
        this.vertical.addComponent(area);


        this.vertical.addComponent(new Button("Back", new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
                      presenter.navigateBack();
                    }
                }));

        addComponent(vertical);
    }

    @Override
    public void addListener(IMedicationPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

	@Override
	public void setMedicationList(
			List<ch.bfh.btx8081.w2013.green.data.entities.Medication> medications) {
		this.area.setReadOnly(false);

        String medlist = "";

        for(Medication m : medications) {
            medlist += m.toString() + "\n\n";
        }

        this.area.setValue(medlist);

        this.area.setReadOnly(true);
		
	}
}
