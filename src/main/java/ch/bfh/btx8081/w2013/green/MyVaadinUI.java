package ch.bfh.btx8081.w2013.green;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2013.green.ui.HelpView;
import ch.bfh.btx8081.w2013.green.ui.LoginView;
import ch.bfh.btx8081.w2013.green.ui.StartView;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
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
	
	public static Navigator navigator;
    public static final String HELPVIEW = "help";
    public static final String SKILLVIEW = "skill";
    public static final String MEDICVIEW = "medic";
    public static final String SETTINGSVIEW = "sett";

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, 
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
    	
    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);      
        navigator.addView("", new LoginView());
    } 

    public void authenticate( String login, String password) throws Exception
    {
        if (  "pat".equals(login) && "pat".equals(password)) 
        {
            loadProtectedResources();
            return;
        }
       
       throw new Exception("Login failed!");

    }

    private void loadProtectedResources()
    {
    	navigator.addView("Start", new StartView());
    	
        Model model = new Model();
        SkillsView skillsView = new SkillsView();
        new SkillsPresenter(skillsView, model);
    	
        navigator.addView(HELPVIEW, new HelpView());
        navigator.addView(SKILLVIEW, skillsView);
        
        navigator.navigateTo("Start");
    }

}
