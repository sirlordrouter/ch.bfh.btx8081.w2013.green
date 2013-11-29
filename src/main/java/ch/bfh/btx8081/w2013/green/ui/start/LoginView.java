package ch.bfh.btx8081.w2013.green.ui.start;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {

	private static final long serialVersionUID = 2033204732401987887L;
	private Label title = new Label("My Mental Health");
	private Button btnLogin = new Button("Login");
    private TextField login = new TextField ("Username");
    private PasswordField password = new PasswordField ( "Password");
    private VerticalLayout vertical = new VerticalLayout();
    
	public LoginView() {
		setWidth("240px");
		setHeight("420px");
		addStyleName("sidebar");
		
		btnLogin.addClickListener ( new Button.ClickListener()
        {
			private static final long serialVersionUID = -3802341930269958858L;

			public void buttonClick ( Button.ClickEvent event )
            {
                try
                {
                    ((MyVaadinUI)MyVaadinUI.getCurrent())
                    	.authenticate((String)login.getValue (), (String)password.getValue ());     
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
		
		vertical.addComponents( title, login, password, btnLogin );
		vertical.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
		vertical.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
		vertical.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
		vertical.setComponentAlignment(btnLogin, Alignment.MIDDLE_CENTER);
		addComponent(vertical);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		Notification.show("Welcome to the Mental Health App\nPlease log in!");
	}

	
}
