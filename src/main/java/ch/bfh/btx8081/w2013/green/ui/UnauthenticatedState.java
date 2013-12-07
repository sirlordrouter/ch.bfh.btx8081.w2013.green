package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.ui.start.LoginView;
import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 07-12-2013
 */
public class UnauthenticatedState extends AuthenticationState {

    public UnauthenticatedState(MyVaadinUI ui) {
        super(ui);
    }

    @Override
    public void entryState() {
        super.navigator.addView("", new LoginView());
        super.navigator.setErrorView(LoginView.class);
        super.navigator.navigateTo("");
    }

    @Override
    public void exitState() {
        super.navigator.removeView("");
    }

    @Override
    public void handleLogin() {
        super.context.setState(new AuthenticatedState(context));
    }
}
