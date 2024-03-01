/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.cs2212.campus_nav_group10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */
public class WeatherTest {
    Weather weather;
    public WeatherTest() {
    }
    
    @BeforeEach
    public void setUp() {
        weather = new Weather();
    }
    
    @AfterEach
    public void tearDown() {
        weather = null;
    }

    @Test
    public void testGetDesc() {
             assertNotNull(weather.getDesc());
    }

    @Test
    public void testGetTemp() {
        assertNotNull(weather.getTemp());
    }

    @Test
    public void testGetCode() {
        assertNotNull(weather.getCode());
    }
    
}
