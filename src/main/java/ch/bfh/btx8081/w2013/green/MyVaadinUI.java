package ch.bfh.btx8081.w2013.green;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, 
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
    	

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        
        Button btnHelp = new Button("HELP");
        btnHelp.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        
        Button btnSkills = new Button("SKILLS");
        btnSkills.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        
        Button btnMedication = new Button("MEDICATION");
        btnMedication.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                Notification.show("You shoud now take your Medication XY");
            }
        });
        
        Button btnSettings = new Button("SETTINGS");
        btnSettings.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        
        layout.addComponent(btnHelp);
        layout.addComponent(btnSkills);
        layout.addComponent(btnMedication);
        layout.addComponent(btnSettings);
    }

}
