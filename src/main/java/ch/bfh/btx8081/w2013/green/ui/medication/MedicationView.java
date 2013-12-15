package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.data.Medication;
import ch.bfh.btx8081.w2013.green.data.Patient;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.AbstractSelect.NewItemHandler;

import java.util.ArrayList;
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

	//Done by Esma
	//private Patient selectedPatient;
	private List<IMedicationViewListener> listeners = new ArrayList<IMedicationViewListener>();
    private OptionGroup optionGroup;
    private BeanItemContainer<Medication> medications;
    
    public MedicationView(){//(Patient selectedPatient) {
    	super();
    	medications = new BeanItemContainer<Medication>(Medication.class);
    	medications.addItem(new Medication("bla", new int[]{}, 1));
    	medications.addItem(new Medication("bla2", new int[]{}, 2));
    	
    //	this.selectedPatient = selectedPatient;
    	     

        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);

        VerticalLayout vertical = new VerticalLayout ();
        //TextArea area = new TextArea();
        //area.setWidth(MyVaadinUI.APP_WIDTH);
       // area.setHeight("380px");
       // vertical.addComponent(area);       
       // vertical.addComponent(new TextArea(optionGroup));
       
       
       // add  optionGroup---
        optionGroup = new OptionGroup("Patient name", medications);//(selectedPatient.getName());	       
        optionGroup.setItemCaptionPropertyId("medicationName");
		optionGroup.setMultiSelect(true);
		// optionGroup add listener 
		vertical.addComponent(optionGroup);
		//----End---

        vertical.addComponent(new Button("Back", new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
                        for (IMedicationViewListener l : listeners) {
                            l.buttonClick(event.getButton().getCaption().charAt(0));
                        }
                    }
                }));

        addComponent(vertical);
    }

    @Override
    public void addListener(IMedicationViewListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
  //Done by Esma
//  	private class PatientListener implements Property.ValueChangeListener{
//
//  		@Override
//  		public void valueChange(ValueChangeEvent event) {
//  			selectedPatient = (Patient) selectPatient.getValue();
//  			System.out.println(selectedPatient.getName());
//    
}
