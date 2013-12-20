package ch.bfh.btx8081.w2013.green.data;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Johannes on 19.12.13.
 */
public class SettingsDataAccessTest {

   SettingsDataAccess sda = null;


    @Test
    public void testGetPatients() throws Exception {

        assert  (sda.getPatients() == null);
    }

    @Before
    public void setUp() throws Exception {

        sda = new SettingsDataAccess();

    }
}
