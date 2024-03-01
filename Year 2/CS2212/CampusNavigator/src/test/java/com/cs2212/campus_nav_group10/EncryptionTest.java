
package com.cs2212.campus_nav_group10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */
public class EncryptionTest {
    Encryption key;
    String word;
    
    public EncryptionTest() {
    }
    
    @BeforeEach
    public void setUp() {
        key = new Encryption();
        word = "United States of America";        
    }
    
    @AfterEach
    public void tearDown() {
        key = null;
        word = null;
    }

    @Test
    public void testEncrypt() {
        String encrypted = key.encrypt(word);
        assertNotEquals(encrypted,word);
    }

    @Test
    public void testDecryptPassword() {
        //corresponds to password 
        String encrypted ="a0Fsa2swa2paMXJwc3c5U1ZsbVBacHVZL1hZNVhRT0o=";
        assertEquals(key.decryptPassword(encrypted),"password");
    }
    
}
