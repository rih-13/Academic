
package com.cs2212.campus_nav_group10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JFrame;

/**
 * The Systems Class consists of the main class of the overall program
 * Getter/Setter Methods are used to retrieve miscellaneous items
 * startup(), loggedIn(), loggedOff(), exit() are used to startup and shut down the application and store data in .csv's
 * UpdateCSV Methods transfer data from LL to CSV
 * Init methods initialize the respective data structure with default values
 * Search Method searches for a POI
 * 
 * @author Ria Haque, Ben Haller, Abdullah Ahmad, Sergio Rangel
 */


/**
  * Constructs a Systems object with default values. 
 */
public class Systems {
    
    private int currBuildingNum;
    private int currFloorNum;
    
    private Boolean doingTask;
    private Boolean developerMode = null;

    private String metadataFile;
    private String currUsername = null;

    private Building buildings[] = new Building[3];
    LinkedList<POI> metapois = new LinkedList<POI>();
    LinkedList<POI> userpois = new LinkedList<POI>();
    LinkedList<String> userfavs = new LinkedList<String>();
    LinkedList<POI> userFavPOIs = new LinkedList<POI>();
    
    /**
     * Constructs a Systems object with default values. 
    */
    public Systems() {
        
    }
    /**
     * Sets the current building number to the specified value.
     * @param currBuildingNum the new value of the current building number
    */
    public void setBuildingNum(int currBuildingNum) {
        
        this.currBuildingNum = currBuildingNum;
    }
 
    /**
     * Returns the current building number.
     * @return the current building number
    */    
    public int getCurrBuildingNum() {
        
        return this.currBuildingNum;
    }
    
    /**
     * Sets the current floor number to the specified value.
     * @param currFloorNum the new value of the current floor number
    */    
    public void setFloorNum(int currFloorNum) {
        
        this.currFloorNum = currFloorNum;
    }

    /**
     *  Returns the current floor number.
     * @return the current floor number
    */    
    public int getCurrFloorNum() {
        
        return this.currFloorNum;
    }
    
    /**
     * Returns the array of buildings.
     * @return the array of buildings
    */    
    public Building[] getBuildingsArray() {
        
        return this.buildings;
    }
    
    /**
     * Sets the current username to the specified value.
     * @param username the new value of the current username
    */    
    public void setcurrUsername(String username) {
        
        this.currUsername = username;
    }
    
    /**
     * Checks the value of DeveloperMode variable
     * @return true/false depending on whether user is a developer
     */
    public Boolean getIsDeveloper() {
        return developerMode;
    } 
            
    /**
     * Checks the value of currUsername to see who is logged in
     * @return String which consists of a username
     */        
    public String getcurrUsername() {
        return this.currUsername;
    }
    
    /**
     * Sets the developer mode to the specified value.
     * @param isDeveloper the new value of the developer mode
    */ 
    public void setDeveloperMode(boolean isDeveloper){
        this.developerMode = isDeveloper;

    }

    /**
     * Returns the developer mode.
     * @return the developer mode
    */    
    public Boolean getDeveloperMode() {
        
        return this.developerMode;
    }
    
    
    
     /**
    Starts up the application by initializing the graphical user interface (GUI).
    */
    public void startUp() {

        initGUI();
    }

    /**
     * Performs operations when a user has logged in, such as initializing linked lists of meta and user POI information and
     initializing buildings.
    */
    public void loggedIn() {

        try {
            getMetaPOIs();
            getUserPOIs();
            getUserFavs();
            InitializeFavs();

        } catch (Exception e) {
            System.out.println("Error logging in.");
        }

        initBuildings();
    }

    /**
     * Performs operations when a user has logged off, such as writing updated linked lists of meta and user POI information back
     to csv files.
    */  
    public void loggedOff() {
        
        if (this.currUsername != null) {

            // Write updated linked lists of meta and user POI information back to csv files
            try {
                updateUserCSV();
                updateMetaCSV();
                updateUserFavsCSV();
            }
            catch (Exception e) {
                System.out.println("Error logging off.");
            }
        }
    }

    /**
     * Exits the program.
     * If the program is in developer mode, this method calls the loggedOff() method.
     * If the program is doing a task, this method calls the exitError() method.
    */
    public void exit() {
        if (this.developerMode != null) {
            
            loggedOff();
        }
    if (doingTask) exitError();
    }
    
    /**
     * Displays an error message in a popup window.
    */
    public void exitError() {
        JFrame frame = new JFrame("Popup Window");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }
    /**
     * Reads in metaPOIs from a file and stores it in a LinkedList.
     * @throws FileNotFoundException if the specified file is not found.
    */
    public void getMetaPOIs() throws FileNotFoundException {
        ReadWrite reader = new ReadWrite();
        try {
            reader.inputter("metadata", metapois);
        }
        catch (Exception e) {
            System.out.println("Error with ReadWrite inputter method");
        }
    }
    
    /**
     * Reads in USERPOIs for a specific user from a file and stores them in a LinkedList.
     * @throws FileNotFoundException if the specified file is not found.
    */
    public void getUserPOIs() throws FileNotFoundException {
        Regular_User userReader = new Regular_User();
        try {
            userReader.userInputter(this.currUsername, userpois);
        }
        catch (Exception e) {
            System.out.println("Error reading in user POIs.");
        }
    }
    
    /**
     *Reads in favourite POIs for a specific user from a file and stores them in a LinkedList 
     * @throws FileNotFoundException if the specified file is not found.
    */
    public void getUserFavs() throws FileNotFoundException {
        Regular_User userFav = new Regular_User();
        try {
            userFav.userFavInputter(this.currUsername, userfavs);
        }
        catch (Exception e) {
            System.out.println("Error reading in user favourited POIs.");
        }
    }
    
    /**
     * Updates user csv based on data from LL userpois
     * @throws FileNotFoundException 
     */
    public void updateUserCSV() throws FileNotFoundException {
        Regular_User userWriter = new Regular_User();
        try {
            userWriter.userOutputter(this.currUsername, userpois);
        }
        catch (Exception e) {
            System.out.println("Error with Regular_User outputter method");
        }
    }
    
    /**
     * Updates meta csv based on data from LL metapois
     * @throws FileNotFoundException 
     */
    public void updateMetaCSV() throws FileNotFoundException {
        ReadWrite writer = new ReadWrite();
        try {
            writer.outputter("metadata", metapois);
        }
        catch (Exception e) {
            System.out.println("Error with ReadWrite outputter method");
        }
    }
    /**
     * Updates user favourites csv based on data from LL userfavs
     * @throws FileNotFoundException 
     */
    public void updateUserFavsCSV() throws FileNotFoundException {
        Regular_User userFavsWriter = new Regular_User();
        try {
            userFavsWriter.userFavOutputter(this.currUsername, userfavs);
        }
        catch (Exception e) {
            System.out.println("Error with Regular_User favourite outputter method");
        }
    }
    /**
     * Sets all meta and user pois as non-favourite initially
     * Based on userfavs LL, pois set as favourite
     */
    public void InitializeFavs() {
        for (POI poi : metapois) poi.setFavourite(false);
        for (POI poi : userpois) poi.setFavourite(false);
        
        for (String roomNum: userfavs) {
            Boolean found = false;       
            for (POI poi : metapois) {
                if (poi.getRoomNum().equals(roomNum)) {
                    poi.setFavourite(true);
                    
                    found = true;
                }
            }
            if (!found) {
                for (POI poi : userpois) {
                    if (poi.getRoomNum().equals(roomNum)) {                       
                        poi.setFavourite(true);
                    }  
                }
            }
        }
    }
     
  
    /**
     * Initializes buildings and supplies buildings with respective POIs and  no.floors
     */
    public void initBuildings() {
        buildings[0] = new Building("MC", 5, metapois, userpois);  //MC
        buildings[1] = new Building("PAB", 4, metapois, userpois);  //PAB
        buildings[2] = new Building("NS", 3, metapois, userpois);  //NS
    }

    /**
     * GUI displayed to user
     */
    public void initGUI() {
        
        new GUI().setVisible(true);
    } 
    
    // Test
    
    public static void main (String[] args) {
        Systems mainSystem = new Systems();
        
        
        try {
            mainSystem.getMetaPOIs();
            LinkedList<POI> domesticAnimals = mainSystem.metapois;

        } catch (Exception e) {
            System.out.println("Error reading in metadata POIs.");
            return;
        }
        
        mainSystem.initBuildings();
        
        mainSystem.initGUI();
        
    }

    /**
     * Searches for a poi based on roomNumber supplied
     * @param roomNumber used to search for the POI
     * @return POI object if found, otherwise return null
     */
    public POI search(String roomNumber) {
        
        for (POI poi : metapois) {
            
            if (poi.getRoomNum().equals(roomNumber)) {
                
                return poi;
            }
        }
        
        for (POI poi: userpois) {
            
            if (poi.getRoomNum().equals(roomNumber)) {
                
                return poi;
            }
        }
        
        return null;
    }
    
}   