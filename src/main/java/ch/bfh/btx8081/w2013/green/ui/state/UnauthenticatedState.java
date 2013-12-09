package ch.bfh.btx8081.w2013.green.ui.state;

import ch.bfh.btx8081.w2013.green.ui.start.LoginView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class describes the unathenticated State of the Application</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 07-12-2013
 */
public class UnauthenticatedState extends AuthenticationState {

    /**
     * Constructor for this state implementation.
     * @param ui the UI as context for the state pattern.
     */
    public UnauthenticatedState(MyVaadinUI ui) {
        super(ui);
    }

    /**
     * Login View ist configured on entering the Unauthenticated state.
     * To prevent Error-View when manipulation url, the login view
     * is set as Error-View.
     */
    @Override
    public void entryState() {
        super.navigator.addView("", new LoginView());
        super.navigator.setErrorView(LoginView.class);
        super.navigator.navigateTo("");
    }

    /**
     * When leaving the unauthenticated state, the {@link ch.bfh.btx8081.w2013.green.ui.start.LoginView}
     * is removed from the {@link com.vaadin.navigator.Navigator} to prevent navigating
     * to this view when authenticated.
     */
    @Override
    public void exitState() {
        super.navigator.removeView("");
    }

    /**
     * handles the correct login and moves to the authenticated state.
     */
    @Override
    public void handleLogin() {
        super.context.setState(new AuthenticatedState(context));
    }
}
