package ch.bfh.btx8081.w2013.green;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {

	private static final long serialVersionUID = 2033204732401987887L;
	private Button btnLogin = new Button("Login");
    private TextField login = new TextField ("Username");
    private PasswordField password = new PasswordField ( "Password");
    private VerticalLayout vertical = new VerticalLayout();
    
	public LoginView() {
		setWidth("240px");
		setHeight("420px");
		
		btnLogin.addClickListener ( new Button.ClickListener()
        {
			private static final long serialVersionUID = -3802341930269958858L;

			public void buttonClick ( Button.ClickEvent event )
            {
                try
                {
                    ((MyVaadinUI)MyVaadinUI.getCurrent()).authenticate((String)login.getValue (), (String)password.getValue ());
                    
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
		vertical.addComponent ( new Label("Please Log in!") );
		vertical.addComponent ( new Label() );
		vertical.addComponent ( login );
		vertical.addComponent ( password );
		vertical.addComponent ( btnLogin );
		addComponent(vertical);
	}
	
	

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	
}
