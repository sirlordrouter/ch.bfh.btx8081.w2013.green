package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.event.ShortcutListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
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
	private Label title = new Label("My Mental Health");
	private Button btnLogin = new Button("Login");
    private TextField login = new TextField ("Username");
    private PasswordField password = new PasswordField ( "Password");
    private VerticalLayout vertical = new VerticalLayout();
    private VerticalLayout loginLayout = null;
    
    //TODO: How is Login handled in multiple user Sessions???
    
	public LoginView() {
		setWidth(MyVaadinUI.APP_WIDTH);
		setHeight(MyVaadinUI.APP_HIGHT);
		addStyleName("sidebar");
		
		this.btnLogin.addClickListener ( new Button.ClickListener()
        {
			private static final long serialVersionUID = -3802341930269958858L;

			public void buttonClick ( Button.ClickEvent event )
            {
                try
                {
                    ((MyVaadinUI)MyVaadinUI.getCurrent())
                    	.authenticate(login.getValue(), (String)password.getValue());     
                }
                catch ( Exception e )
                {
                    Notification.show(e.getMessage());
                }
            }
        });
		
		this.initLogin();
	}
    
	private void initLogin() {
		addStyleName("login");

        this.loginLayout = new VerticalLayout();
        this.loginLayout.setSizeFull();
        this.loginLayout.addStyleName("login-layout");
        addComponent(loginLayout);

        final CssLayout loginPanel = new CssLayout();
        loginPanel.addStyleName("login-panel");
        loginPanel.setWidth("210px");

        HorizontalLayout labels = new HorizontalLayout();
        labels.setWidth("210px");
        labels.setMargin(true);
        labels.addStyleName("labels");
        loginPanel.addComponent(labels);

        Label title = new Label("My Mental Health");
        title.setSizeUndefined();
        title.addStyleName("h2");
        title.addStyleName("light");
        labels.addComponent(title);
        labels.setComponentAlignment(title, Alignment.MIDDLE_LEFT);

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

        this.loginLayout.addComponent(loginPanel);
        this.loginLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
		
		addComponent(this.loginLayout);
		
		
		
//		vertical.addComponents( title, login, password, btnLogin );
//		vertical.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
//		vertical.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
//		vertical.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
//		vertical.setComponentAlignment(btnLogin, Alignment.MIDDLE_CENTER);
//		addComponent(vertical);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {

		Notification.show("Welcome to the Mental Health App\nPlease log in!");
	}

	
}
