package ch.bfh.btx8081.w2013.green.businesslogic;

import ch.bfh.btx8081.w2013.green.data.IDataAccess;
import ch.bfh.btx8081.w2013.green.data.User;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 11-12-2013
 */
public class ProfessionalUserDataManager extends UserDataManager {

    public ProfessionalUserDataManager (User currentUser, IDataAccess dataAccess) {
        super(currentUser, dataAccess);
    }
}
