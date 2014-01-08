package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * 
 *<p>First View of the Application presented to User to enter his credentials</p>
 *
 * @author group_green, Johannes Gnaegi
 * @version 29-11-2013
 */
public class LoginView extends VerticalLayout implements View {

	private static final long serialVersionUID = 2033204732401987887L;

	public LoginView() {
        this.addStyleName("root");

		this.setWidth(MyVaadinUI.APP_WIDTH);
		this.setHeight(MyVaadinUI.APP_HIGHT);
		
		this.initLogin();
	}
    
	private void initLogin() {
		this.addStyleName("login");

        VerticalLayout loginLayout = new VerticalLayout();
        loginLayout.setSizeFull();
        loginLayout.addStyleName("login-layout");
        this.addComponent(loginLayout);

        final CssLayout loginPanel = new CssLayout();
        loginPanel.addStyleName("login-panel");
        loginPanel.setWidth("210px");

        HorizontalLayout labels = new HorizontalLayout();
        labels.setWidth("210px");
        labels.setMargin(true);
        labels.addStyleName("labels");
        loginPanel.addComponent(labels);

        /*
        Header with icon and title
         */

        VerticalLayout header = new VerticalLayout();

        Resource icon = new ThemeResource("img/icon_start3.png");
        Image image = new Image(null, icon);
        image.setWidth("70px");
        header.addComponent(image);
        header.setComponentAlignment(image, Alignment.BOTTOM_LEFT);

        Label title = new Label("My Mental Health");
        title.setSizeUndefined();
        title.addStyleName("h2");
        title.addStyleName("light");
        header.addComponent(title);
        header.setComponentAlignment(title, Alignment.TOP_LEFT);

        labels.addComponent(header);
        labels.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        /*
        Labels and Textboxes for Logindata
         */
        VerticalLayout fields = new VerticalLayout();
        fields.setWidth("200px");
        fields.setSpacing(true);
        fields.setMargin(true);
        fields.addStyleName("fields");

        final TextField username = new TextField("Username");
        username.focus();
        fields.addComponent(username);

        final PasswordField password = new PasswordField("Password");
        fields.addComponent(password);

        final Button signin = new Button("Sign In");
        signin.addStyleName("default");
        fields.addComponent(signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

        final ShortcutListener enter = new ShortcutListener("Sign In",
                KeyCode.ENTER, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                signin.click();
            }
        };

        signin.addClickListener(new ClickListener() {
        	private static final long serialVersionUID = -3802341930269958858L;

			public void buttonClick ( Button.ClickEvent event )
            {
                try
                {
                    ((MyVaadinUI)MyVaadinUI.getCurrent())
                    	.authenticate((String)username.getValue(), (String)password.getValue());     
                }
                catch ( Exception e )
                {
                    Notification.show(e.getMessage());
                }
            }
        });

        signin.addShortcutListener(enter);

        loginPanel.addComponent(fields);

        loginLayout.addComponent(loginPanel);
        loginLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
		
		this.addComponent(loginLayout);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {

		Notification.show("Welcome to the Mental Health App\nPlease log in!");
	}

	
}
