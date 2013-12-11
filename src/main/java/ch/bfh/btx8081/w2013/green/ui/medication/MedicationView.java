package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

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

    private List<IMedicationViewListener> listeners = new ArrayList<IMedicationViewListener>();
    private OptionGroup optionGroup;
    
    public MedicationView() {

        super();

        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);

        VerticalLayout vertical = new VerticalLayout ();
//        TextArea area = new TextArea();
//        area.setWidth(MyVaadinUI.APP_WIDTH);
//        area.setHeight("380px");
//        vertical.addComponent(area);
       
       // add  optionGroup---
        optionGroup = new OptionGroup("MyMedication");		
        
        optionGroup.addItem("medic");
        optionGroup.addItem("medic 1");
        optionGroup.addItem("medic 2");
        optionGroup.addItem("medic 3");
		optionGroup.setMultiSelect(true);
		vertical.addComponent(optionGroup);

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
}
