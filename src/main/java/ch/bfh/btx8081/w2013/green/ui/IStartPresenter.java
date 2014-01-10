package ch.bfh.btx8081.w2013.green.ui;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Every main view presenter must provide the methods to navigate to a specific entity view.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 23-12-2013
 */
public interface IStartPresenter extends IPresenter {

    void navigateToHelp();
    void navigateToSkills();
    void navigateToMedic();

}
