/**

The Floor class represents a floor in a building and contains a collection of categorized POIs.
It can be used to search for a POI on the floor by name.
* @author Nick Sidoruk, Ben Haller
*/
package com.cs2212.campus_nav_group10;

import java.util.LinkedList;

public class Floor {
    /**
    * The floor number
    */
    int floor_no;
    /**
    * The building that the floor is a member of
    */
    String currBuilding;
    /**
    * The unsorted metadata POI linked list
    */
    private LinkedList<POI> metaPOIs = new LinkedList<>();
    /**
    * The unsorted user POI linked list
    */
    private LinkedList<POI> userPOIs = new LinkedList<>();
    /**
    * The linked list of POIs categorized as bathrooms
    */
    private LinkedList<POI> bathrooms = new LinkedList<>();
    /**
    * The linked list of POIs categorized as restaurants
    */
    private LinkedList<POI> restaurants = new LinkedList<>();
    /**
    * The linked list of POIs categorized as classrooms
    */
    private LinkedList<POI> classrooms = new LinkedList<>();
    /**
    * The linked list of POIs categorized as labs
    */
    private LinkedList<POI> labs = new LinkedList<>();
    /**
    * The linked list of POIs categorized as accessibility
    */
    private LinkedList<POI> accessibility = new LinkedList<>();
    /**
    * The linked list of POIs categorized as computer science
    */
    private LinkedList<POI> compsci = new LinkedList<>();
    /**
    * The linked list of custom POIs added by the user
    */
    private LinkedList<POI> custom = new LinkedList<>();


    /**
     * This constructor sorts the master POI linked list into categorized linked lists
     * @param floor_no
     * @param metaPOIs this is the unsorted metadata POI linked list
     * @param userPOIs this is the unsorted user POI linked list
     * @param building this is a String representing the building that the current floor is a member of
     */
    public Floor(int floor_no, LinkedList<POI> metaPOIs, LinkedList<POI> userPOIs, String building) {
        
        this.floor_no = floor_no;
        this.metaPOIs = metaPOIs;
        this.currBuilding = building;

        // unique linked list for each type of POI
        bathrooms = new LinkedList<>();
        restaurants = new LinkedList<>();
        classrooms = new LinkedList<>();
        labs = new LinkedList<>();
        accessibility = new LinkedList<>();
        compsci = new LinkedList<>();
        custom = new LinkedList<>();

        for (POI poi : metaPOIs) {
                        
            if (poi.getBuilding().equals(this.currBuilding)) {

                if (poi.getCategory() == 0) {
                    classrooms.add(poi);
                } else if (poi.getCategory() == 1) {
                    bathrooms.add(poi);
                } else if (poi.getCategory() == 2) {
                    restaurants.add(poi);
                } else if (poi.getCategory() == 3) {
                    labs.add(poi);
                } else if (poi.getCategory() == 4) {
                    accessibility.add(poi);
                } else if (poi.getCategory() == 5) {
                    compsci.add(poi);
                } else {
                    custom.add(poi);
                }
            }
        }
        
        for (POI poi : userPOIs) {
                        
            if (poi.getBuilding().equals(this.currBuilding)) {

                if (poi.getCategory() == 0) {
                    classrooms.add(poi);
                } else if (poi.getCategory() == 1) {
                    bathrooms.add(poi);
                } else if (poi.getCategory() == 2) {
                    restaurants.add(poi);
                } else if (poi.getCategory() == 3) {
                    labs.add(poi);
                } else if (poi.getCategory() == 4) {
                    accessibility.add(poi);
                } else if (poi.getCategory() == 5) {
                    compsci.add(poi);
                } else {
                    custom.add(poi);
                }
            }
        }
    }

    /**
    * Returns a linked list of all the classrooms on the map.
    * @return a linked list of all the classrooms on the map
    */
    public LinkedList<POI> getClassrooms() {
        return classrooms;
    }

    /**
    * Returns a linked list of all the bathrooms on the map.
    * @return a linked list of all the bathrooms on the map
    */
    public LinkedList<POI> getBathrooms() {
        return bathrooms;
    }
    
    /**
    * Returns a linked list of all the restaurants on the map.
    * @return a linked list of all the restaurants on the map
    */
    public LinkedList<POI> getRestaurants() {
        return restaurants;
    }
    
    /**
    * Returns a linked list of all the labs on the map.
    * @return a linked list of all the labs on the map
    */
    public LinkedList<POI> getLabs() {
        return labs;
    }

    /**
    * Returns a linked list of all the accessibility POIs on the map.
    * @return a linked list of all the accessibility POIs on the map
    */
    public LinkedList<POI> getAccessibility() {
        return accessibility;
    }

    /**
    * Returns a linked list of all the computer science POIs on the map.
    * @return a linked list of all the computer science POIs on the map
    */
    public LinkedList<POI> getCompsci() {
        return compsci;
    }
    
    /**
    * Returns a linked list of all the custom POIs on the map.
    * @return a linked list of all the custom POIs on the map
    */
    public LinkedList<POI> getCustom() {
        return custom;
    }

    /**
    * Searches for a POI with the given name on the map.
    * @param name the name of the POI to search for
    * @return true if a POI with the given name is found on the map, false otherwise
    */
    public boolean search (String name) {
        for (POI poi : bathrooms) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }
        for (POI poi : restaurants) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }
        for (POI poi : classrooms) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }
        for (POI poi : labs) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }

        for (POI poi : accessibility) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }

        for (POI poi : compsci) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }

        for (POI poi : custom) {
            if (poi.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
    Get the number of the floor.
    @return the number of the floor.
    */
    public int getFloorNo() {
        return floor_no;
    }
    
    /**
    Get the list of automatically generated POIs.
    @return the list of automatically generated POIs.
    */
    public LinkedList<POI> getMetaPOIs() {
        return metaPOIs;
    }
    
    /**
    Get the list of user added POIs.
    @return the list of user added POIs.
    */
    public LinkedList<POI> getUserPOIs() {
        return userPOIs;
    }

    /**
    Convert a linked list of POIs to an array of POIs.
    @param linkedList the linked list of POIs.
    @return an array of POIs.
    */
    public POI[] toArray(LinkedList<POI> linkedList) {
        POI[] arrayResult = new POI[linkedList.size()];
        
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = linkedList.get(i);
        }
        
        return arrayResult;
    }

    /**
    Convert the list of bathroom POIs to an array of POIs.
    @return an array of bathroom POIs.
    */
    public POI[] bathroomsToArray() {
        POI[] arr = new POI[bathrooms.size()];
        bathrooms.toArray(arr);
        return arr;
    }

    /**
    Convert the list of restaurant POIs to an array of POIs.
    @return an array of restaurant POIs.
    */
    public POI[] restaurantsToArray() {
        POI[] arr = new POI[restaurants.size()];
        restaurants.toArray(arr);
        return arr;
    }
    
    /**
    Convert the list of classroom POIs to an array of POIs.
    @return an array of classroom POIs.
    */
    public POI[] classroomsToArray() {
        POI[] arr = new POI[classrooms.size()];
        classrooms.toArray(arr);
        return arr;
    }

    /**
    Convert the list of lab POIs to an array of POIs.
    @return an array of lab POIs.
    */
    public POI[] labsToArray() {
        POI[] arr = new POI[labs.size()];
        labs.toArray(arr);
        return arr;
    }

    /**
    Convert the list of accessibility POIs to an array of POIs.
    @return an array of accessibility POIs.
    */
        public POI[] accessibilityToArray() {
        POI[] arr = new POI[accessibility.size()];
        accessibility.toArray(arr);
        return arr;
    }

    /**
    Converts the linked list of computer science POIs to an array of POIs.
    @return an array of POIs representing computer science POIs.
    */
    public POI[] compsciToArray() {
        POI[] arr = new POI[compsci.size()];
        compsci.toArray(arr);
        return arr;
    }
    
    /**
    Converts the linked list of custom POIs to an array of POIs.
    @return an array of POIs representing custom POIs.
    */
    public POI[] customToArray() {
        POI[] arr = new POI[custom.size()];
        custom.toArray(arr);
        return arr;
    }
    
    /**
    Adds a new POI to the appropriate linked list based on its category.
    @param poi the POI object to be added.
    */
    public void addPOI(POI poi) {
        int category = poi.getCategory();
        if (category == 0) {
            classrooms.add(poi);
        } else if (category == 1) {
            bathrooms.add(poi);
        } else if (category == 2) {
            restaurants.add(poi);
        } else if (category == 3) {
            labs.add(poi);
        }
        else if (category == 4) {
            accessibility.add(poi);
        }
        else if (category == 5) {
            compsci.add(poi);
        }

        else {
            custom.add(poi);
        }
    }

    /**
    Removes a POI from its corresponding linked list.
    @param poi the POI object to be removed.
    */
    public void delete(POI poi) {
        LinkedList<POI> poiList = null;
        switch (poi.getCategory()) {
            case 0:
                poiList = classrooms;
                break;
            case 1:
                poiList = bathrooms;
                break;
            case 2:
                poiList = restaurants;
                break;
            case 3:
                poiList = labs;
                break;
            case 4:
                poiList = accessibility;
                break;
            case 5:
                poiList = compsci;
                break;
            case 6:
                poiList = custom;
                break;

            default:
                // invalid category, do nothing
                return;
        }
        poiList.remove(poi);
    }

    /**
    * Edits a POI object by changing its attributes and moving it to the appropriate LinkedList based on its category.
    * @param poi The POI object to be edited.
    * @param newName The new name for the POI object.
    * @param newRoomNum The new room number for the POI object.
    * @param newDesc The new description for the POI object.
    * @param newBuilding The new building for the POI object.
    * @param newFloor The new floor for the POI object.
    * @param newXCoordinate The new X coordinate for the POI object.
    * @param newYCoordinate The new Y coordinate for the POI object.
    */
    public void editPOI(POI poi, String newName, String newRoomNum, String newDesc, String newBuilding, int newFloor, int newXCoordinate, int newYCoordinate) {
        // Remove POI from its current linked list
        if (poi.getCategory() == 0) {
            classrooms.remove(poi);
        } else if (poi.getCategory() == 1) {
            bathrooms.remove(poi);
        } else if (poi.getCategory() == 2) {
            restaurants.remove(poi);
        } else if (poi.getCategory() == 3) {
            labs.remove(poi);
        } else if (poi.getCategory() == 4) {
            accessibility.remove(poi);
        } else if (poi.getCategory() == 5) {
            compsci.remove(poi);
        }

        else {
            custom.remove(poi);
        }

        // Update the POI object
        poi.setName(newName);
        poi.setRoomNum(newRoomNum);
        poi.setDesc(newDesc);
        poi.setBuilding(newBuilding);
        poi.setFloor(newFloor);
        poi.setxCoordinate(newXCoordinate);
        poi.setyCoordinate(newYCoordinate);

        // Add the POI back to the correct linked list
        if (poi.getCategory() == 0) {
            classrooms.add(poi);
        } else if (poi.getCategory() == 1) {
            bathrooms.add(poi);
        } else if (poi.getCategory() == 2) {
            restaurants.add(poi);
        } else if (poi.getCategory() == 3) {
            labs.add(poi);
        } else if (poi.getCategory() == 4) {
            accessibility.add(poi);
        } else if (poi.getCategory() == 5) {
            compsci.add(poi);
        }
        else {
            custom.add(poi);
        }
    }





}