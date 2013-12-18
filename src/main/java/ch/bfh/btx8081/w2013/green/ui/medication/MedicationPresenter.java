package ch.bfh.btx8081.w2013.green.ui.medication;

import ch.bfh.btx8081.w2013.green.businesslogic.ReminderComponent;
import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

/**
* Berner Fachhochschule</br>
* Medizininformatik BSc</br>
* Modul 8081, HS2013</br>
*
*<p>Class Description</p>
*
* @author Johannes Gnaegi, gnagj1@bfh.ch
* @version 09-12-2013
        */
public class MedicationPresenter extends ReminderPresenter implements IMedicationView.IMedicationViewListener {

    private Navigator navigator = null;
    private IMedicationView view = null;

    public MedicationPresenter (ReminderView v, Model m, Navigator n, ReminderComponent rc) {

        super(v,m,rc);

        this.navigator = n;
        this.view = (IMedicationView) v;

        this.view.addListener(this);
        this.view.setMedicationList(model.getMedications());
    }


    @Override
    public void buttonClick(char c) {

        switch (c) {
            case 'B' :
                this.navigator.navigateTo(AuthenticatedState.START_VIEW);
                break;
            default:
                break;
        }
    }


}
