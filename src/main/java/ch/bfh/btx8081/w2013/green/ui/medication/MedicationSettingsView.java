package ch.bfh.btx8081.w2013.green.ui.medication;


import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.ui.BaseView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;

import java.util.Collection;
import java.util.List;

public class MedicationSettingsView
        extends
            BaseView
        implements
            View,
            IMedicationSettingsView {

	private OptionGroup optionGroup = null;
    private BeanItemContainer<Medication> medications = null;
    private IMedicationSettingsPresenter presenter = null;
    private MedicationChangedListener medicationChangedListener = new MedicationChangedListener();

	public MedicationSettingsView() {

        super();
        super.setTitle("Medic Settings");

        this.setContent();
        this.createButtons();

        super.setLayouts(0.3f,0.6f,0.1f);
	}

    private void setContent() {
        this.medications = new BeanItemContainer<>(Medication.class);

        this.optionGroup = new OptionGroup("Patient name", medications);//(selectedPatient.getName());
        this.optionGroup.setItemCaptionPropertyId("medicationName");
        this.optionGroup.setMultiSelect(true);
        this.optionGroup.setImmediate(true);

        super.content.addComponent(optionGroup);
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
    public void setCurrentPatientMedication(List<Medication> medicationList, List<Medication> customMedicationList) {

        this.optionGroup.removeValueChangeListener(medicationChangedListener);

        this.medications.removeAllItems();

        for (Medication medication : medicationList) {
           medications.addItem(medication);
           this.optionGroup.unselect(medication);
            for (Medication customMedication : customMedicationList) {
                if (medication.getMedicationID() == customMedication.getMedicationID()) {
                    this.optionGroup.select(medication);
                }
            }
        }

        this.optionGroup.setImmediate(true);

        this.optionGroup.addValueChangeListener(medicationChangedListener);
        this.markAsDirtyRecursive();

    }

    private class MedicationChangedListener implements Property.ValueChangeListener {
        @Override
        public void valueChange(ValueChangeEvent event) {
            Object item = event.getProperty().getValue();
            Collection<Medication> selectdItems = (Collection<Medication>) item;
            presenter.setPatientsMedication(selectdItems);
        }
    }
}
