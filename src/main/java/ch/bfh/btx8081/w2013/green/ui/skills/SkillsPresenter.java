package ch.bfh.btx8081.w2013.green.ui.skills;

import ch.bfh.btx8081.w2013.green.data.Model;
import ch.bfh.btx8081.w2013.green.ui.state.AuthenticatedState;
import com.vaadin.navigator.Navigator;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Describes the Presenter class for the Presenter view.
 * This class handles all user interaction from the view and binds no data to
 * the view. It implements the
 * {@link ch.bfh.btx8081.w2013.green.ui.skills.ISkillView.ISkillViewPresenter ISkillViewPresenter }
 * Interface to get the user interaction from the view. The different Button-Actions must
 * be handled by switch.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 09-12-2013
 */
public class SkillsPresenter implements ISkillView.ISkillViewPresenter {

	private SkillsView view = null;
	private Model model = null;
    private Navigator navigator = null;

    /**
     *
     * @param v
     *      a view to listen to
     * @param m
     *      a model to get data from
     * @param n
     *      a navigator to handle view switch actions
     */
	public SkillsPresenter(SkillsView v, Model m, Navigator n) {
	
		this.view = v;
		this.model = m;
        this.navigator = n;
		
		view.addPresenter(this);
		view.setSkills(model.getSkills());
	}

    /**
     * Handles the user interactions from the view.
     * @param operation
     *      the first char of the caption from the button clicked
     */
	@Override
	public void buttonClick(char operation) {

        switch (operation) {
            case 'B' :
                navigator.navigateTo(AuthenticatedState.START_VIEW);
                break;
            default:
                break;
        }
	}


    @Override
    public void navigateBack() {
        this.navigator.navigateTo(AuthenticatedState.START_VIEW);
    }
}
