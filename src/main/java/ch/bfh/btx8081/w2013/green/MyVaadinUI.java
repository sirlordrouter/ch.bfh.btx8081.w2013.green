package ch.bfh.btx8081.w2013.green;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, 
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    public static Navigator navigator;
    protected static final String HELPVIEW = "help";
    protected static final String SKILLVIEW = "skill";
    protected static final String MEDICVIEW = "medic";
    protected static final String SETTINGSVIEW = "sett";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);      
        navigator.addView("", new LoginView());
    } 

    public void authenticate( String login, String password) throws Exception
    {
        if (  "user".equals ( login ) && "querty".equals( password ) ) 
        {
            loadProtectedResources();
            return;
        }
       
       throw new Exception("Login failed!");

    }

    private void loadProtectedResources ()
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
