package ch.bfh.btx8081.w2013.green.data;

import java.util.List;

/**
 * Created by Johannes on 11.12.13.
 */
public interface IProfessionalDataAccess extends IDataAccess {

    List<Patient> getPatients();
}
