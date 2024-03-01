
package com.cs2212.campus_nav_group10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */
public class POITest {
    POI poi;
    public POITest() {
    }
    
    @BeforeEach
    public void setUp() {
        poi = new POI(true,true,1,"Washroom","MC-11","Mens washroom","MC",2,230,111,true);
    }
    
    @AfterEach
    public void tearDown() {
        poi = null;
    }

    @Test
    public void testSetFavourite() {
        poi.setFavourite(false);
        assertEquals(poi.isFavourite(),false);
    }

    @Test
    public void testIsFavourite() {
        assertEquals(poi.isFavourite(),true);
    }

    @Test
    public void testIsDisplayed() {
        assertEquals(poi.isDisplayed(),true);
    }


    @Test
    public void testHidePOI() {
        poi.hidePOI();
        assertEquals(poi.isDisplayed(),false);
    }

    @Test
    public void testSetCategory() {
        poi.setCategory(2);
        assertEquals(poi.getCategory(),2);
    }

    @Test
    public void testGetCategory() {
        assertEquals(poi.getCategory(),1);
    }

    @Test
    public void testSetName() {
        poi.setName("Hello");
        assertEquals(poi.getName(),"Hello");
    }

    @Test
    public void testGetName() {
        assertEquals(poi.getName(),"Washroom");
    }

    @Test
    public void testSetRoomNum() {
        poi.setRoomNum("MC-122");
        assertEquals(poi.getRoomNum(),"MC-122");
    }

    @Test
    public void testGetRoomNum() {
        assertEquals(poi.getRoomNum(),"MC-11");
    }

    @Test
    public void testSetDesc() {
        poi.setDesc("Womens washroom");
        assertEquals(poi.getDesc(),"Womens washroom");        
    }

    @Test
    public void testGetDesc() {
        assertEquals(poi.getDesc(),"Mens washroom");  
    }


    @Test
    public void testSetxCoordinate() {
        poi.setxCoordinate(1212);
        assertEquals(poi.getxCoordinate(),1212);            
    }

    @Test
    public void testGetxCoordinate() {
        assertEquals(poi.getxCoordinate(),230);  
    }

    @Test
    public void testSetyCoordinate() {
        poi.setyCoordinate(800);
        assertEquals(poi.getyCoordinate(),800);              
    }

    @Test
    public void testGetyCoordinate() {
                assertEquals(poi.getyCoordinate(),111);   
    }

    @Test
    public void testDeselectPOI() {
        poi.deselectPOI();
        assertEquals(poi.isSelected(),false);
    }

    @Test
    public void testIsSelected() {
                assertEquals(poi.isSelected(),true);
        
    }

    
}
