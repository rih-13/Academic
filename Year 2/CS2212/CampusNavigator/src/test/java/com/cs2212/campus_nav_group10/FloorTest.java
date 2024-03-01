/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
public class FloorTest {
    LinkedList<POI> temp;
    Floor floor;
    
    public FloorTest() {
    }
    
    @BeforeEach
    public void setUp() {
        temp = new LinkedList<POI>();
        floor = new Floor(1,temp,temp,"Social Science");
    }
    
    @AfterEach
    public void tearDown() {
        temp = null;
        floor = null;
    }
    
    @Test
    public void testGetFloorNo() {
        assertEquals(floor.getFloorNo(),1);
    }

    
}
