
package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.businesslogic.LoginManager;
import ch.bfh.btx8081.w2013.green.data.entities.User;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticationState;
import ch.bfh.btx8081.w2013.green.ui.state.UnauthenticatedState;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * 
 *<p>Class Description</p>
 *
 * @author group_green, Johannes Gnaegi
 * @version 29-11-2013
 */
@Theme("dashboard")
@SuppressWarnings("serial")
@Push(PushMode.MANUAL)
public class MyVaadinUI extends UI
{
    public static final String APP_WIDTH = "320px";
    public static final String APP_HIGHT = "480px";
    
    //Different States of Authentication implemented using the State Pattern
    private AuthenticationState state = null;
    private User currentUser = null;
    private LoginManager loginManager = null;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false,
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.ui.AppWidgetSet")
   
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        getPage().setTitle("MyMentalHealth");
		setWidth(APP_WIDTH);
		setHeight(APP_HIGHT);

        setState(new UnauthenticatedState(this));
    }

    public void setState(AuthenticationState state) {
        this.state = state;
        this.state.entry();
    }

    public void authenticate(String username, String password) throws Exception
    {
    	
    	boolean isAuthenticated = false;
    	
        loginManager = LoginManager.getLoginManager();
        isAuthenticated = loginManager.authenticateUserAccess(username,password);

        if (isAuthenticated) {
        	currentUser = loginManager.getUserAttribute();
        	
            this.state.exit();
            this.state.handleLogin();
        }
        else {
            throw new Exception("Login failed!");
        }
    }
    
 

	public void logout() {
        this.state.exit();
    	this.state.handleLogout();
    	Notification.show("You have been logged out!");
    }
	
	public User getCurrentUser(){
		return currentUser;
	}

    
    

}
