package ch.bfh.btx8081.w2013.green;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/** Main view with a menu */
public class MainView extends VerticalLayout implements View {

	
	private static final long serialVersionUID = 1L;
	private Panel panel;

    // Menu navigation button listener
    class ButtonListener implements com.vaadin.ui.Button.ClickListener {


		private static final long serialVersionUID = 1L;
		private String menuitem;
		
        public ButtonListener(String menuitem) {
            this.menuitem = menuitem;
        }

        @Override
        public void buttonClick(ClickEvent event) {
            // Navigate to a specific state
        	MyVaadinUI.navigator.navigateTo(MyVaadinUI.HELPVIEW + "/" + menuitem);
        }
    }

    public MainView() {
        setSizeFull();
        
        // Layout with menu on left and view area on right
        HorizontalLayout hLayout = new HorizontalLayout();
        hLayout.setSizeFull();

        // Have a menu on the left side of the screen
        Panel menu = new Panel("List of Equals");
        menu.setHeight("100%");
        menu.setWidth(null);
        VerticalLayout menuContent = new VerticalLayout();
        menuContent.addComponent(new com.vaadin.ui.Button("Pig",
                  new ButtonListener("pig")));
        menuContent.addComponent(new com.vaadin.ui.Button("Cat",
                  new ButtonListener("cat")));
        menuContent.addComponent(new com.vaadin.ui.Button("Dog",      
                  new ButtonListener("dog")));
        menuContent.addComponent(new com.vaadin.ui.Button("Reindeer",
                  new ButtonListener("reindeer")));
        menuContent.addComponent(new com.vaadin.ui.Button("Penguin",
                  new ButtonListener("penguin")));
        menuContent.addComponent(new com.vaadin.ui.Button("Sheep",
                  new ButtonListener("sheep")));
        menuContent.setWidth(null);
        menuContent.setMargin(true);
        menu.setContent(menuContent);
        hLayout.addComponent(menu);

        // A panel that contains a content area on right
        panel = new Panel("An Equal");
        panel.setSizeFull();
        hLayout.addComponent(panel);
        hLayout.setExpandRatio(panel, 1.0f);

        addComponent(hLayout);
        setExpandRatio(hLayout, 1.0f);
        
        com.vaadin.ui.Button logout = new Button("Logout", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				// TODO Auto-generated method stub
				MyVaadinUI.navigator.navigateTo("");
			}
		});
        
        
        addComponent(logout);
    }        
    
    
    @Override
    public void enter(ViewChangeEvent event) {
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);
        panel.setContent(panelContent); // Also clears

        if (event.getParameters() == null
            || event.getParameters().isEmpty()) {
            panelContent.addComponent(
                new Label("Nothing to see here, " +
                          "just pass along."));
            return;
        }

        // Display the fragment parameters
        Label watching = new Label(
            "You are currently watching a " +
            event.getParameters());
        watching.setSizeUndefined();
        panelContent.addComponent(watching);
        panelContent.setComponentAlignment(watching,
            Alignment.MIDDLE_CENTER);
        
//        // Some other content
//        Embedded pic = new Embedded(null,
//            new ThemeResource("img/" + event.getParameters() +
//                              "-128px.png"));
//        panelContent.addComponent(pic);
//        panelContent.setExpandRatio(pic, 1.0f);
//        panelContent.setComponentAlignment(pic,
//                Alignment.MIDDLE_CENTER);

        Label back = new Label("And the " +
            event.getParameters() + " is watching you");
        back.setSizeUndefined();
        panelContent.addComponent(back);
        panelContent.setComponentAlignment(back,
            Alignment.MIDDLE_CENTER);
    }
}
