package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
* Berner Fachhochschule</br>
* Medizininformatik BSc</br>
* Modul 8081, HS2013</br>
*
*<p>Presenter for a patients medication. Provides the data to its corresponding view and listens
 * to user input. </p>
*
* @author Johannes Gnaegi, gnagj1@bfh.ch
* @version 09-12-2013
        */
public class MedicationPresenter extends ReminderPresenter implements IMedicationView.IMedicationPresenter {

    private Navigator navigator = null;

    public MedicationPresenter (ReminderView v, Model m, Navigator n, ReminderComponent rc) {

        super(v,m,rc);

        this.navigator = n;
        IMedicationView view = (IMedicationView) v;

        view.addListener(this);
        view.setMedicationList(this.model.getMedications());
    }


    @Override
    public void buttonClick(String c) {
        throw new NotImplementedException();
    }


    @Override
    public void navigateBack() {
        this.navigator.navigateTo(AuthenticatedState.START_VIEW);
    }
}
