
package ch.bfh.btx8081.w2013.green.ui.start;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2013.green.businesslogic.LoginManager;
import ch.bfh.btx8081.w2013.green.businesslogic.Medication;
import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.businesslogic.IReminderComponent.IReminderComponentListener;
import ch.bfh.btx8081.w2013.green.businesslogic.UserDataManager;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.data.User;
import ch.bfh.btx8081.w2013.green.ui.HelpView;
import ch.bfh.btx8081.w2013.green.ui.ReminderPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsPresenter;
import ch.bfh.btx8081.w2013.green.ui.skills.SkillsView;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

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
public class MyVaadinUI extends UI implements IReminderComponentListener
{
	public static Navigator navigator;
	public static final String STARTVIEW = "start";
    public static final String HELPVIEW = "help";
    public static final String SKILLVIEW = "skill";
    public static final String MEDICVIEW = "medic";
    public static final String SETTINGSVIEW = "sett";
    
    private Model model;

    
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, 
    	ui = MyVaadinUI.class, widgetset = "ch.bfh.btx8081.w2013.green.ui.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
    	
    @Override
    protected void init(VaadinRequest request) {
    	
        getPage().setTitle("MyMentalHealth");
		setWidth("240px");
		setHeight("420px");
        
        navigator = new Navigator(this, this);   
        navigator.addView("", new LoginView());
        navigator.setErrorView(LoginView.class);
    } 

    public void authenticate( String login, String password) throws Exception
    {
    	
    	User currentUser = new User(login, password);
    	LoginManager loginManager 
    		= new LoginManager(currentUser);
    	   	
        if (loginManager.getCurrentUser().getHasAccess()) 
        {     	
            loadProtectedResources(currentUser);
            return;
        }
       
       throw new Exception("Login failed!");
       
    }

	public void logout() {
    	destroyProtectedResources();
    	
    	Notification.show("You have been logged out!");
    }

    private void loadProtectedResources(User currentUser)
    {
    	UserDataManager.getSingleton().setCurrentUser(currentUser);
    	
    	
    	navigator.addView("Start", new StartView());
        model = new Model();
        ReminderComponent mc = new ReminderComponent();
        
        for (Medication medication : model.getMedications()) {
			mc.addNormalTimer(medication);
		}
        
//    	if (loginManager.getCurrentUser().isPatient()) {
			loadProtectedUserResources();
//		} else {
			loadProtectedStaffResources();
//		}
//
			
		StartView startView = new StartView();
		StartPresenter sp = new StartPresenter(startView, model, mc);
		navigator.addView(STARTVIEW, startView);
			
        SkillsView skillsView = new SkillsView();
        new SkillsPresenter(skillsView, model);
        navigator.addView(SKILLVIEW, skillsView);
        
        HelpView helpView = new HelpView();
        new ReminderPresenter(helpView, model, mc);
        navigator.addView(HELPVIEW, new HelpView());
        
        navigator.navigateTo("Start");
        navigator.addViewChangeListener(sp);
    }
    
	private void loadProtectedUserResources() {
		// TODO Auto-generated method stub
		
	}
	
    private void loadProtectedStaffResources() {
		// TODO Auto-generated method stub
		
	}
    
    /**
     * The views must be removed due to security issues. Otherwise
     * information is accessible through the url. 
     */
    private void destroyProtectedResources() {
    	navigator.removeView("Start");
    	navigator.removeView(SKILLVIEW);
    	navigator.removeView(HELPVIEW);
    	navigator.removeView(MEDICVIEW);
    }

	@Override
	public void showAlert(String medicationName) {
		synchronized (this) {
			this.model.setDueMedication(new Medication(medicationName, new int[]{0,0,0}));
		}
		
	}

    
    

}
