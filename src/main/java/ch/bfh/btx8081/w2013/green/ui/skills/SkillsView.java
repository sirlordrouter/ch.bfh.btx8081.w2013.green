package ch.bfh.btx8081.w2013.green.ui.skills;

import ch.bfh.btx8081.w2013.green.data.entities.Skill;
import ch.bfh.btx8081.w2013.green.ui.BaseView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;

import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Describes the Skill View. Displays all the Skills for a Patient.
 * On chose one specific and clicking the detail Button, a Messagebox with Instructions
 * is shown. </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 09-12-2013
 */
public class SkillsView extends BaseView
	implements View, ISkillView {

    private static final long serialVersionUID = 1L;
    private static final String BUTTON_BACK = "Back";

	private ListSelect listSelectSkills = null;
    private ISkillViewPresenter presenter = null;

	public SkillsView () {

        super();
        super.setTitle("Skills");

        this.setContent();
        this.setButtons();

        super.setLayouts(0.2f, 0.7f, 0.1f,0);

	}

    private void setContent() {
        this.listSelectSkills = new ListSelect();

        this.listSelectSkills.setWidth("100%");
        this.listSelectSkills.setHeight("270px");
        super.content.addComponent(this.listSelectSkills);
    }

    private void setButtons() {
        final Button buttonBack = new Button(BUTTON_BACK, new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {

                presenter.navigateBack();

            }
        });

        buttonBack.addStyleName("icon-dashboard");
        buttonBack.addStyleName("default");

        super.navigation.addComponent(buttonBack);

        final Button buttonDetail = new Button("Detail", new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {

                MessageBox mb = MessageBox.showPlain(
                        Icon.NONE,
                        "Skill Description",
                        "Sit on the floor and get your \n" +
                                "Phone out of your pocket.\n" +
                                "Awwwww wait you have it already in you Hands\n" +
                                "Don't you?",
                        ButtonId.YES).setWidth("300px");
                mb.setButtonWidth("150px");
                mb.setButtonAlignment(Alignment.BOTTOM_CENTER);

            }
        });

        super.navigation.addComponent(buttonDetail);
    }

    @Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void setSkills(List<Skill> skills) {
		for (Skill skill : skills) {
			this.listSelectSkills.addItem(skill.getName());
		}
	}

	@Override
	public void addPresenter(ISkillViewPresenter p) {
		this.presenter = p;
	}

}
