
package com.cs2212.campus_nav_group10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */
public class UserLoginTest {
    UserLogin userLogin;
    
    public UserLoginTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
    try {
        userLogin = new UserLogin();
    } catch (Exception e) {
        System.out.print(e);
    }
  
    }
   
    
    @AfterEach
    public void tearDown() {
        userLogin = null;
    }
    


    @Test
    public void testIsValidWithValidCredentials() {
        String result = userLogin.isValid("Ben", "password");
        assertNotNull(result);
        assertEquals("Ben", result);
    }

    @Test
    public void testIsValidWithInvalidCredentials() {
        String result = userLogin.isValid("Ben", "wrong_password");
        assertNull(result);
    }

    @Test
    public void testIsDevWithDevUser() {
        boolean result = userLogin.isDev("Abdullah");
        assertTrue(result);
    }

    @Test
    public void testIsDevWithNonDevUser() {
        boolean result = userLogin.isDev("John");
        assertFalse(result);
    }

    @Test
    public void testIsUserWithExistingUser() {
        String result = userLogin.isUser("General");
        assertNotNull(result);
        assertEquals("General", result);
    }

    @Test
    public void testIsUserWithNonExistingUser() {
        String result = userLogin.isUser("NonExistingUser");
        assertNull(result);
    }

    @Test
    public void testIsDeveloperWithDevUser() {
        boolean result = userLogin.isDeveloper("Sergio");
        assertTrue(result);
    }

    @Test
    public void testIsDeveloperWithNonDevUser() {
        boolean result = userLogin.isDeveloper("John");
        assertFalse(result);
    }


    
}
