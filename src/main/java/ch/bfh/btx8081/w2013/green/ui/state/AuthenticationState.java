package ch.bfh.btx8081.w2013.green.ui.state;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.navigator.Navigator;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * Describes an abstract class for the different Authentication states the Application goes through.
 * The class is the base class for implementing the State Pattern.
 * The States context is the {@link ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI} User Interface, whose content
 * differs for an authenticated User or an unauthenticated User.
 *
 * For the states have different <code>Views</code> that can change, the
 * class provides an {@link com.vaadin.navigator.Navigator} reference.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 07-12-2013
 */
public abstract class AuthenticationState {

    /**
     * Context for the different states.
     */
    protected MyVaadinUI context;
    protected Navigator navigator;

    protected AuthenticationState(MyVaadinUI ui) {
        this.context = ui;
        this.navigator = new Navigator(ui, ui);
    }

    /**
     * Provides an entry point for the specific state.
     */
    public final void entry() {
        entryState();
    }

    /**
     * Provides an exit point for the specific state.
     */
    public final void exit() {
        exitState();
    }

    /**
     * Provide the custom implementation on entering the specific state.
     */
    protected void entryState() {}

    /**
     * Provide the custom implementation on exit the specific state.
     */
    protected void exitState() {}

    public void handleLogin() {}
    public void handleLogout() {}
    /**
     * Handle other Buttons which result in a change of State.
     */
}
