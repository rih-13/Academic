
package com.cs2212.campus_nav_group10;
/**
 * The GUIResources class provides resources for the GUI, including map names and files, and POI names and locations.
 * It consists of different getter methods, used to access the different POI categories and their respective locations
 * @author Ben Haller
*/

public class GUIResources {
    
    // String arrays are created containing the different floor map names
    // These names are as they will appear within the app
    // The arrays are split up by each building, as all floors from one building's array will be listed at the same time
    private String[] MCMapNames = {"MC Floor 0", "MC Floor 1", "MC Floor 2", "MC Floor 3", "MC Floor 4" };   
    private String[] NSMapNames = {"NS Floor 0", "NS Floor 1", "NS Floor 2"};
    private String[] PABMapNames = {"PAB Floor 0", "PAB Floor 1", "PAB Floor 2", "PAB Floor 3"};
    
    //Location of map files, corresponding to the map name arrays shown above
    //Important! These file paths must be on your class path.
    private String[] MCMapFiles = {"maps/mc0.png", "maps/mc1.png", "maps/mc2.png", "maps/mc3.png", "maps/mc4.png"};
    private String[] NSMapFiles = {"maps/ns0.png", "maps/ns1.png", "maps/ns2.png"};
    private String[] PABMapFiles = {"maps/pab0.png", "maps/pab1.png", "maps/pab2.png", "maps/pab3.png"};
    
    /**
    * Returns an array of map names for the specified building.
    * @param buildingName the name of the building
    * @return an array of map names, or null if the building name is not recognized
    */
    public String[] getMapNames(String buildingName) {
        
        if (buildingName.equals("MiddlesexCollege")) return MCMapNames;
        else if (buildingName.equals("NaturalScience")) return NSMapNames;
        else if (buildingName.equals("PhysicsAstronomy")) return PABMapNames;
        else return null;
    }
    
    /**
    * Returns an array of map names for the specified building.
    *
    * @param buildingName the name of the building
    * @return an array of map files, or null if the building name is not recognized
    */
    public String[] getMapFiles(String buildingName) {
        
        if (buildingName.equals("MiddlesexCollege")) return MCMapFiles;
        else if (buildingName.equals("NaturalScience")) return NSMapFiles;
        else if (buildingName.equals("PhysicsAstronomy")) return PABMapFiles;
        else return null;
    }

}
