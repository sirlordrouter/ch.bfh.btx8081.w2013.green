package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

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
    private VerticalLayout header = new VerticalLayout();
    private VerticalLayout medics = new VerticalLayout();
    private HorizontalLayout navigation = new HorizontalLayout();
    
    public MedicationView(){
    	super();

        this.setBaseStyle();
        this.setTitle();
        this.createContent();
        this.createButtons();

        this.addComponent(header);
        this.addComponent(medics);
        this.addComponent(navigation);

        this.setExpandRatio(header, 0.2f);
        this.setExpandRatio(medics, 0.7f);
        this.setExpandRatio(navigation, 0.1f);
    }


    private void setBaseStyle() {
        this.addStyleName("dashboard-view");
        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);
        this.setMargin(true);
        this.setSpacing(true);
    }

    private void setTitle() {
        Label titleLiabel = new Label("Medics");
        titleLiabel.setStyleName("h1");
        titleLiabel.setHeight("30px");
        this.header.addComponent(titleLiabel);
        this.header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);
    }

    private void createContent() {
        this.area = new TextArea();
        this.area.setWidth("100%");
        this.area.setHeight("270px");
        this.area.setStyleName("dashboard-textarea");
        this.medics.addComponent(area);
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

        this.navigation.addComponent(buttonBack);
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
