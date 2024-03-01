package com.cs2212.campus_nav_group10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

class GUIResourcesTest {

    GUIResources guiResources;

    @BeforeEach
    public void setUp() {
        guiResources = new GUIResources();
    }
    
    @AfterEach
    public void tearDown() {
        guiResources = null;
    }

    @Test
    void testGetMapNames() {
        assertArrayEquals(new String[]{"MC Floor 0", "MC Floor 1", "MC Floor 2", "MC Floor 3", "MC Floor 4"}, guiResources.getMapNames("MiddlesexCollege"));
        assertArrayEquals(new String[]{"NS Floor 0", "NS Floor 1", "NS Floor 2"}, guiResources.getMapNames("NaturalScience"));
        assertArrayEquals(new String[]{"PAB Floor 0", "PAB Floor 1", "PAB Floor 2", "PAB Floor 3"}, guiResources.getMapNames("PhysicsAstronomy"));
        assertNull(guiResources.getMapNames("InvalidBuilding"));
    }

    @Test
    void testGetMapFiles() {
        assertArrayEquals(new String[]{"maps/mc0.png", "maps/mc1.png", "maps/mc2.png", "maps/mc3.png", "maps/mc4.png"}, guiResources.getMapFiles("MiddlesexCollege"));
        assertArrayEquals(new String[]{"maps/ns0.png", "maps/ns1.png", "maps/ns2.png"}, guiResources.getMapFiles("NaturalScience"));
        assertArrayEquals(new String[]{"maps/pab0.png", "maps/pab1.png", "maps/pab2.png", "maps/pab3.png"}, guiResources.getMapFiles("PhysicsAstronomy"));
        assertNull(guiResources.getMapFiles("InvalidBuilding"));
    }

}
