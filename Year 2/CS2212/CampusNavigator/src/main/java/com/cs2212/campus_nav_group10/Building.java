/**

This class represents a Building in a campus navigation system. A building has a name, number of floors and a LinkedList
of floors. It also initializes a LinkedList of meta POIs (Points of Interest) and user POIs for each floor and adds them
to appropriate LinkedList based on floor number.
* @author Abdullah Ahmad, Ben Haller
*/
package com.cs2212.campus_nav_group10;

import java.util.LinkedList;

public class Building {
    /** The name of the building */
    private String name;
    /** The number of floors in the building */
    private int no_floors;
    /** The LinkedList of floors in the building */
    private LinkedList<Floor> floors = new LinkedList<>();
    
    /**
    * Constructs a new Building object with the given name, number of floors, meta POIs and user POIs.
    * Initializes a LinkedList of meta POIs and user POIs for each floor and adds them
    * to appropriate LinkedList based on floor number.
    *
    * @param name The name of the building.
    * @param no_floors The number of floors in the building.
    * @param metaPOIs The LinkedList of meta POIs for the building.
    * @param userPOIs The LinkedList of user POIs for the building.
    */
    public Building(String name, int no_floors, LinkedList<POI> metaPOIs, LinkedList<POI> userPOIs) {
        
        this.name = name;
        this.no_floors = no_floors;

        // Create a meta POI LinkedList for each floor
        LinkedList<LinkedList<POI>> floorMetaPOIs = new LinkedList<>();
        for (int i = 0; i < no_floors; i++) {
            floorMetaPOIs.add(new LinkedList<>());
        }
        // Sort metaPOIs by floor and add them to appropriate LinkedList based on floor number
        for (POI poi : metaPOIs) {
            int floor = poi.getFloor();
            for (int i = 0; i < no_floors; i++) {
                if (floor == i) floorMetaPOIs.get(floor).add(poi);
            }
        }
        
        // Create a user POI LinkedList for each floor
        LinkedList<LinkedList<POI>> floorUserPOIs = new LinkedList<>();
        for (int i = 0; i < no_floors; i++) {
            floorUserPOIs.add(new LinkedList<>());
        }
        
        // Sort userPOIs by floor and add them to appropriate LinkedList based on floor number
        for (POI poi : userPOIs) {
            int floor = poi.getFloor();
            for (int i = 0; i < no_floors; i++) {
                if (floor == i) floorUserPOIs.get(floor).add(poi);
            }
        }
        //initialize floors LL with required floors
        for (int i = 0; i < no_floors; i++) {
            // add whatever else is in floor constructor (this only contains floor number and the LL for POIs on that floor)
            floors.add(new Floor(i,floorMetaPOIs.get(i),floorUserPOIs.get(i), this.name));
        }

    }
    
    /**
    * Returns the name of the building.
    *
    * @return The name of the building.
    */
    public String getBuildingName() {
        return name;
    }
    
    /**
    * Returns the number of floors in the building.
    *
    * @return The number of floors in the building.
    */
    public int getNoFloors() {
        return no_floors;
    }
    
    /**
 * Returns the LinkedList of Floor objects representing each floor in the building.
 *
 * @return the LinkedList of Floor objects representing each floor in the building
 */
    public LinkedList<Floor> getFloors() {
        return floors;
    }
    
    /**

    Returns the Floor object at the specified floor number.
    @param floorNum the floor number of the requested floor
    @return the Floor object at the specified floor number
    */
    public Floor getFloor(int floorNum) {
        return floors.get(floorNum);
    }
}