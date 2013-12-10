package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.data.Model;
import com.vaadin.navigator.Navigator;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 10-12-2013
 */
public class HelpPresenter {

    private HelpView view;
    private Model model;
    private Navigator navigator;

    public HelpPresenter(HelpView v, Model m, Navigator n) {

        this.view = v;
        this.model = m;
        this.navigator = n;
    }
}
