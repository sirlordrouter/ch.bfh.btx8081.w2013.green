package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class MedicationSettingsView
        extends
            VerticalLayout
        implements
            View,
            IMedicationSettingsView {

	private OptionGroup optionGroup = null;
    private BeanItemContainer<Medication> medications = null;
    private IMedicationSettingsPresenter presenter = null;
    private VerticalLayout vertical = null;
	
	public MedicationSettingsView() {

    	this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);

        this.vertical = new VerticalLayout ();

        createMockupMedication();

        this.optionGroup = new OptionGroup("Patient name", medications);//(selectedPatient.getName());
        this.optionGroup.setItemCaptionPropertyId("medicationName");
        this.optionGroup.setMultiSelect(true);


        this.optionGroup.addValueChangeListener(
                new Property.ValueChangeListener() {
                    @Override
                    public void valueChange(ValueChangeEvent event) {
                        Object item = event.getProperty().getValue();

                    }
                }
        );

 		// optionGroup add listener 
        this.vertical.addComponent(optionGroup);

        createButtons();

        addComponent(vertical);
	}

    private void createButtons() {
        this.vertical.addComponent(new Button("Back", new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                presenter.navigateBack();
            }
        }));
    }

    private void createMockupMedication() {
        this.medications = new BeanItemContainer<Medication>(Medication.class);
        this.medications.addItem(new Medication("medic1", new int[]{}, 1));
        this.medications.addItem(new Medication("medic2", new int[]{}, 2));
        this.medications.addItem(new Medication("medic3", new int[]{}, 3));
        this.medications.addItem(new Medication("medic4", new int[]{}, 4));
    }


    @Override
	public void enter(ViewChangeEvent event) {
	}

    @Override
    public void addPresenter(IMedicationSettingsPresenter presenter) {

        this.presenter = presenter;

    }

    @Override
    public void setCurrentPatientName(String currentPatientName) {

        this.optionGroup.setCaption("Patient: " + currentPatientName);
        this.markAsDirtyRecursive();
    }


    @Override
    public void setCurrentPatientMedication(List<Medication> medicationList) {

        this.medications.removeAllItems();
        this.medications.addAll(medicationList);

    }
}
