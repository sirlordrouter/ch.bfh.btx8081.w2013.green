package ch.bfh.btx8081.w2013.green.ui.start;

import ch.bfh.btx8081.w2013.green.ui.IStartPresenter;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Interface for the main page for the patients view. </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 23-12-2013
 */
public interface IStartView {

    void addStartViewPresenter(IStartViewPresenter p);

    /**
     * Berner Fachhochschule</br>
     * Medizininformatik BSc</br>
     * Modul 8081, HS2013</br>
     *
     *<p>callback for the user input of the main page.</p>
     *
     * @author Johannes Gnaegi, gnaegj1@bfh.ch
     * @version 23-12-2013
     */
    public interface IStartViewPresenter extends IStartPresenter {
    }
}
