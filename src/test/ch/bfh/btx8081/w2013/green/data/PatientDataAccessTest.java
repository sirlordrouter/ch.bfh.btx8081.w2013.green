package ch.bfh.btx8081.w2013.green.data;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Johannes on 19.12.13.
 */
public class PatientDataAccessTest {

    PatientDataAccess pda = null;

    @Before
    public void setUp() throws Exception {

        pda = new PatientDataAccess();
    }

    @Test
    public void testGetMedications() throws Exception {
        assert(pda.getMedications() == null);
    }

    @Test
    public void testGetSkills() throws Exception {
        assert(pda.getSkills() == null);
    }

    @Test
    public void testGetContacts() throws Exception {
        assert(pda.getContacts() == null);
    }
}
