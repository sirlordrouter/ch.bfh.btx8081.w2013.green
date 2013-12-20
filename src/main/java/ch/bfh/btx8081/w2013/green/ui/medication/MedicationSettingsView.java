package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.SettingsModel;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.ui.start.IStartSettingsView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

public class MedicationSettingsView extends VerticalLayout implements View, IStartSettingsView.ISettingsPresenter.IPatientChangedListener {

	private OptionGroup optionGroup = null;
    private BeanItemContainer<Medication> medications = null;
    private Patient selectedPatient = null;
	
	public MedicationSettingsView(final Navigator navigator, SettingsModel settingsModel) {
		
    	medications = new BeanItemContainer<Medication>(Medication.class);
    	medications.addItem(new Medication("medic1", new int[]{}, 1));
    	medications.addItem(new Medication("medic2", new int[]{}, 2));
    	medications.addItem(new Medication("medic3", new int[]{}, 3));
    	medications.addItem(new Medication("medic4", new int[]{}, 4));
    	
    	 this.setWidth(MyVaadinUI.APP_WIDTH);
         this.setHeight(MyVaadinUI.APP_HIGHT);

         VerticalLayout vertical = new VerticalLayout ();
        
         
         optionGroup = new OptionGroup("Patient name", medications);//(selectedPatient.getName());	       
         optionGroup.setItemCaptionPropertyId("medicationName");
 		optionGroup.setMultiSelect(true);


        optionGroup.addValueChangeListener(
                new Property.ValueChangeListener() {
                    @Override
                    public void valueChange(ValueChangeEvent event) {
                        Object item = event.getProperty().getValue();

                    }
                }
        );

 		// optionGroup add listener 
 		vertical.addComponent(optionGroup);
 		
        vertical.addComponent(new Button("Back", new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
                navigator.navigateTo(AuthenticatedState.START_SETTINGS_VIEW);
            }
        }));

        addComponent(vertical);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedPatient(Patient p) {
		selectedPatient = p;
		if (p != null) {
			optionGroup.setCaption("Patient: " + p.getName() + ", " + p.getForename());
			this.markAsDirtyRecursive();
		}
		
	}
}
