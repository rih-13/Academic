
package com.cs2212.campus_nav_group10;

import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */
public class BuildingTest {
    
    LinkedList<POI> temp;
    Building building;
    
    public BuildingTest() {
    }
    
    @BeforeEach
    public void setUp() {
        LinkedList<POI> temp = new LinkedList<>();
        building = new Building("Ivey Business School",5,temp,temp);
    }
    
    @AfterEach
    public void tearDown() {
        temp =  null;
        building = null;
    }

    @Test
    public void testGetBuildingName() {
        System.out.print(building.getBuildingName());
        assertEquals(building.getBuildingName(),"Ivey Business School");
    }

    @Test
    public void testGetNoFloors() {
        assertEquals(building.getNoFloors(),5);
    }

}
