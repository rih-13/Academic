
package com.cs2212.campus_nav_group10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */


public class SystemsTest {

    private Systems systems;

    @BeforeEach
    public void setUp() {
        systems = new Systems();
    }
    @AfterEach
    public void tearDown() {
        systems = null;
    }

    @Test
    public void testSetBuildingNum() {
        systems.setBuildingNum(1);
        assertEquals(1, systems.getCurrBuildingNum());
    }

    @Test
    public void testSetFloorNum() {
        systems.setFloorNum(3);
        assertEquals(3, systems.getCurrFloorNum());
    }

    @Test
    public void testSetCurrUsername() {
        systems.setcurrUsername("JohnDoe");
        assertEquals("JohnDoe", systems.getcurrUsername());
    }

    @Test
    public void testSetDeveloperMode() {
        systems.setDeveloperMode(true);
        assertTrue(systems.getDeveloperMode());
    }

       




 

    
}
