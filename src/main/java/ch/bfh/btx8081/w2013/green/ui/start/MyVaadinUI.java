
package ch.bfh.btx8081.w2013.green.ui.start;

import javax.servlet.annotation.WebServlet;

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

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 *
 *<p>The MyVaadinUI is a needed Vaadin Element that interconnects different parts of the Application
 * at a high hierarchy point. Here the LoginManager is connected as well as the Authentication handling of the 
 * Application, to decide whom is granted what level of access.
 *
 * The MyVaadinUI extends the Vaadin UI its original purpose:
 * Is the topmost component in any component hierarchy. 
 * There is one UI for every Vaadin instance in a browser window.
 * The UI is the server side entry point for various client side features</p>

 * @editor group_green, Corina von Kaenel
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

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false,
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.ui.AppWidgetSet")
   
    public static class Servlet extends VaadinServlet {
    }

    /* 
     * @param VaadinRequest
     * sets the Titel and the hight and with of the App, as well as the UnauthenticatedState
     */
    
    protected void init(VaadinRequest request) {

        getPage().setTitle("MyMentalHealth");
		setWidth(APP_WIDTH);
		setHeight(APP_HIGHT);

        setState(new UnauthenticatedState(this));
    }

    /**
     * Sets a new State to the application.
     *
     * @param state = new State of the application to be set
     */
    public void setState(AuthenticationState state) {
        this.state = state;
        this.state.entry();
    }

    /**
     * @param username: the entered username by the user
     * @param password: the entered password by the user
     * Verifies if the user entered a correct username and password pair. 
     * If correct the corresponding Authentication view is set to present the corresponding views for the logged in user
     */
    public void authenticate(String username, String password) throws Exception
    {
    	// the boolean is only true if the entered username and password exist in the DB
    	boolean isAuthenticated = false;

        LoginManager loginManager = LoginManager.getLoginManager();
        isAuthenticated = loginManager.authenticateUserAccess(username, password);

        if (isAuthenticated) {
            this.currentUser = loginManager.getUserAttribute();
        	
            this.state.exit();
            this.state.handleLogin();
        }
        else {
            throw new Exception("Login failed!");
        }
    }

    /*
     * at the end of a session the user can logout properly and receives an infomation about the successful logout
     */
	public void logout() {
        this.state.exit();
    	this.state.handleLogout();
    	Notification.show("You have been logged out!");
    }

    /**
     * Gets the user which is authenticated.
     *
     * @return
     *  current User
     */
	public User getCurrentUser(){
		return this.currentUser;
	}

    
    

}
