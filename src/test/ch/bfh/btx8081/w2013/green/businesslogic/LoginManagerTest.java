package ch.bfh.btx8081.w2013.green.businesslogic;

import org.junit.Test;

/**
 * Created by Johannes on 19.12.13.
 */
public class LoginManagerTest {
    @Test
    public void testGetUserDB() throws Exception {

    }

    @Test
    public void testGetLoginManager() throws Exception {

        assert (LoginManager.getLoginManager() != null);
    }

    @Test
    public void testGetUserAttribute() throws Exception {

    }

    @Test
    public void testAuthenticateUserAccess() throws Exception {
        assert (LoginManager.getLoginManager().authenticateUserAccess("a","a") );
        assert (LoginManager.getLoginManager().authenticateUserAccess("p","p"));
        assert (!LoginManager.getLoginManager().authenticateUserAccess("wrong","wrong"));
    }
}
