package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Patient;

import java.util.List;

/**
 * Created by Johannes on 11.12.13.
 */
public interface ISettingsDataAccess extends IDataAccess {

    List<Patient> getPatients();
}
