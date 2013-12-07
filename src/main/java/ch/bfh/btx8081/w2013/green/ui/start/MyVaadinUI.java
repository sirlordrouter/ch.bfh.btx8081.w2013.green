
package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.businesslogic.LoginManager;
import ch.bfh.btx8081.w2013.green.businesslogic.UserDataManager;
import ch.bfh.btx8081.w2013.green.data.User;
import ch.bfh.btx8081.w2013.green.ui.AuthenticationState;
import ch.bfh.btx8081.w2013.green.ui.UnauthenticatedState;
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
@Theme("mytheme")
@SuppressWarnings("serial")
@Push(PushMode.MANUAL)
public class MyVaadinUI extends UI
{
    public static final String APPWIDTH = "320px";
    public static final String APPHIGHT = "480px";

    private AuthenticationState state;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false,
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.ui.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        getPage().setTitle("MyMentalHealth");
		setWidth(APPWIDTH);
		setHeight(APPHIGHT);

        setState(new UnauthenticatedState(this));
    }

    public void setState(AuthenticationState state) {
        this.state = state;
        this.state.entry();
    }

    public void authenticate( String login, String password) throws Exception
    {
        User currentUser     = new User(login, password);
        LoginManager  loginManager	= new LoginManager(currentUser);

        //TODO: loginManager.getCurrentUser().getHasAccess())
        if (true) {
            UserDataManager.getSingleton().setCurrentUser(currentUser);
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



    
    

}
