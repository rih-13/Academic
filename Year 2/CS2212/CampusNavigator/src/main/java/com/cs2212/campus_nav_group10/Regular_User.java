
package com.cs2212.campus_nav_group10;

/**
 * Class used to get write UserPOIs/favourited POIs created from a csv to a LinkedList for use in System and vice versa
 * userInputter(String userFileName, LinkedList<POI> pois) transfers UserPOIs from .csv to LL
 * userOutputter(String userFileName, LinkedList<POI> userPOIs) transfers UserPOIs from LL to .csv
 * userFavInputter(String userFileName, LinkedList<String> favourites) transfers favourited POIs from .csv to LL
 * userFavOutputter(String rawFileName, LinkedList<String> favourites) transfers favourited POIs from LL to .csv
 * 
 * @author: Abdullah Ahmad}
 */

import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;



public class Regular_User {
    
    public Regular_User() {
        
    }
    
    /**
 * This static method reads in user POI information from a .csv file of their custom POIs and populates a LinkedList of POI objects with that information.
 * 
 * @param userFileName a String representing the name of the user's .csv file of custom POIs
 * @param pois a LinkedList of POI objects to populate with user POI information
 * @throws Exception if there is an error with file input/output or if the user provides invalid data in the .csv file
 */

public static void userInputter(String userFileName, LinkedList<POI> pois) throws Exception {
    
    //Constructs a String representing the file path of the user's .csv file and creates a Scanner object to read from that file.
    String fileName = new String("src/resources/data/" + userFileName + ".csv");
    Scanner sc = new Scanner(new File(fileName));
    sc.useDelimiter(",");
    
    //Initializes variables to hold data from the .csv file.
    int poiNum = 0;
    String[] build = null;
    
    //Reads in each line of the .csv file, splits the line by commas, creates a new POI object, sets the POI's attributes to the values from the .csv file, and adds the POI to the LinkedList of POI objects.
    while (sc.hasNextLine()) {
        String[] line = sc.nextLine().split(",");
        POI poi = new POI();
        poi.setName(line[0]);
        poi.setCategory(Integer.parseInt(line[1]));
        poi.setFavourite(Boolean.parseBoolean(line[2].toLowerCase()));
        poi.setRoomNum(line[3]);
        poi.setDesc(line[4]);
        poi.setFloor(Integer.parseInt(line[5]));
        poi.setxCoordinate(Integer.parseInt(line[6]));
        poi.setyCoordinate(Integer.parseInt(line[7]));
        
        //If the .csv file contains building information, sets the POI's building attribute to the first word of the building information.
        if (line.length > 8) {
            build = line[8].split("\\s");
            poi.setBuilding(build[0]);
        }
        //add poi to LL and increment
        pois.add(poi);
        poiNum++;
    }
    sc.close();
}

      
/**
 * This static method takes an updated LinkedList of POI objects and writes the information for each POI back into the user's .csv file.
 * 
 * @param userFileName a String representing the name of the user's .csv file of custom POIs
 * @param userPOIs a LinkedList of POI objects containing updated POI information
 * @throws Exception if there is an error with file input/output or if the user provides invalid data in the .csv file
 */

public static void userOutputter(String userFileName, LinkedList<POI> userPOIs) throws Exception {
    
    //Constructs a String representing the file path of the user's .csv file and creates a FileWriter and PrintWriter objects to write to that file.
    String fileName = new String("src/resources/data/" + userFileName + ".csv");        
    FileWriter fw = new FileWriter(fileName);
    PrintWriter pw = new PrintWriter(fw);
    
    //Iterates over the LinkedList of POI objects, writes the POI's attributes to the .csv file separated by commas, and writes a newline character after each POI.
    for (POI poi :userPOIs) {
        pw.write(poi.getName() + ",");
        pw.write(poi.getCategory() + ",");
        pw.write(poi.isFavourite() + ",");
        pw.write(poi.getRoomNum() + ",");
        pw.write(poi.getDesc() + ",");
        pw.write(poi.getFloor() + ",");
        pw.write(poi.getxCoordinate() + ",");
        pw.write(poi.getyCoordinate() + ",");
        pw.write(poi.getBuilding() + "\n");
    }
    
    //Closes the PrintWriter and FileWriter objects.
    pw.close();
    fw.close();
}

    
/**
 * This static method reads in a user's favourites .csv file and stores the contents in a LinkedList of Strings.
 * 
 * @param userFileName a String representing the name of the user's favourites .csv file
 * @param favourites a LinkedList of Strings that will store the user's favourites
 * @throws Exception if there is an error with file input/output or if the user provides invalid data in the .csv file
 */

public static void userFavInputter(String userFileName, LinkedList<String> favourites) throws Exception {
    
    //Constructs a String representing the file path of the user's favourites .csv file and creates a Scanner object to read the file.
    String fileName = new String("src/resources/data/" + userFileName + "_FAV.csv");
    Scanner sc = new Scanner(new File(fileName));
    
    //Iterates over the .csv file and adds each line to the LinkedList of Strings.
    while (sc.hasNextLine()) {
        favourites.add(sc.nextLine());
    }
    
    //Closes the Scanner object.
    sc.close();
}

    
/**
 * This static method takes in a LinkedList of Strings representing a user's favourites and writes the contents to a favourites .csv file.
 * 
 * @param rawFileName a String representing the name of the user's favourites .csv file
 * @param favourites a LinkedList of Strings representing the user's favourites
 * @throws Exception if there is an error with file input/output or if the user provides invalid data to be written to the .csv file
 */

public static void userFavOutputter(String rawFileName, LinkedList<String> favourites) throws Exception {
    
    //Constructs a String representing the file path of the user's favourites .csv file and creates a PrintWriter object to write to the file.
    String userFileName = new String("src/resources/data/" + rawFileName + "_FAV.csv");
    FileWriter fw = new FileWriter(userFileName);
    PrintWriter pw = new PrintWriter(fw);
    
    //Iterates over the LinkedList of Strings and writes each String to the favourites .csv file.
    for (String str : favourites) {
        pw.write(str);
        pw.write("\n");
    }
    
    //Closes the PrintWriter object and the FileWriter object.
    pw.close();
    fw.close();
}

}