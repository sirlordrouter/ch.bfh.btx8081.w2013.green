package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * Tests the Model for correct Handling of given Data.
 * The Model must provide empty lists
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 06-01-2014
 */
public class ModelTest {

    private Model patientModel = null;

    @Before
    public void setUp() throws Exception {

        patientModel = new Model();

        FakeDataAccess fda = new FakeDataAccess();

        patientModel.setSkills(fda.getSkills());
        patientModel.setMedications(fda.getMedications());
        patientModel.setContacts(fda.getContacts());
    }

    @Test
    public void testGetSkills() throws Exception {
        assert patientModel.getSkills() != null;
        assert patientModel.getSkills().size() == 0;
    }

    @Test
    public void testSetSkills() throws Exception {
        patientModel.setSkills(new ArrayList<Skill>());
        assert patientModel.getSkills().size() == 0;
    }

    @Test
    public void testGetMedications() throws Exception {
        assert patientModel.getMedications() != null;
        assert patientModel.getMedications().size() == 4;
    }

    @Test
    public void testSetMedications() throws Exception {
        patientModel.setMedications(new ArrayList<Medication>());
        assert patientModel.getMedications().size() == 0;
    }

    @Test
    public void testGetContacts() throws Exception {
        assert patientModel.getContacts() != null;
        assert patientModel.getContacts().size() == 4;
    }

    @Test
    public void testSetContacts() throws Exception {
        patientModel.setContacts(new ArrayList<Contact>());
        assert patientModel.getContacts().size() == 0;
    }
}
