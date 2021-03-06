package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;

import java.util.Collections;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Shows the Medications for a specific Patient.</p>
 *
 * @author Johannes Gnaegi, gnagj1@bfh.ch
 * @version 09-12-2013
 */
public class MedicationView extends ReminderView implements IMedicationView, View {

	private IMedicationPresenter presenter = null;
	private TextArea area = null;
    
    public MedicationView(){
    	super();
        super.setTitle("MEDICS");

        this.createContent();
        this.createButtons();

        super.setLayouts(0.2f, 0.7f, 0.1f, 0);
    }

    private void createContent() {
        this.area = new TextArea();
        this.area.setWidth("100%");
        this.area.setHeight("270px");
        this.area.setStyleName("dashboard-textarea");
        super.content.addComponent(this.area);
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
        Collections.sort(medications);
        String medlist = "";

        for(Medication m : medications) {
            medlist += m.toString() + "\n\n";
        }

        this.area.setValue(medlist);

        this.area.setReadOnly(true);
		
	}
}
