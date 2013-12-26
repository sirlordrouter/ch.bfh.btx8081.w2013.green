package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 *
 * @version 11-12-2013
 */
public class SettingsDataAccess implements ISettingsDataAccess {

    private final static String DB_FILE = "../database/DataStorage";
    private Connection dbConnection = null;

    public SettingsDataAccess() {
    }


    @Override
    public void setPatients(List<Patient> patientList) {

        //createConnection();


    }

    private void createConnection() {
        try {

            dbConnection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:../database/DataStorage;ifexists=true;shutdown=true", "SA", "");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getPatients() {
        return null;
    }

    @Override
    public List<Medication> getMedications() {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return null;
    }

    @Override
    public List<Contact> getContacts() {
        return null;
    }
}
