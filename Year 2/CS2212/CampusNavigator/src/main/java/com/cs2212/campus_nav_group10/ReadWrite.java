/**
The ReadWrite class provides static methods for reading and writing data from CSV files, and modifying and updating the
data in memory using LinkedLists of POI objects.
@author Sergio, Ben
*/
package com.cs2212.campus_nav_group10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadWrite {

    public ReadWrite() {
        
    }

    /**
    * This method reads data from a CSV file and creates POI objects based on the data. The POI objects are stored in a 
    * LinkedList. Each row in the CSV file represents one POI object.
    * 
    * @param rawFileName the name of the CSV file (without .csv extension) to read from.
    * @param pois a LinkedList of POI objects to store the data read from the CSV file.
    * @throws Exception if the file does not exist or if there is an error reading the file.
    */
    public static void inputter(String rawFileName, LinkedList<POI> pois) throws Exception {
        String fileName = new String("src/resources/data/" + rawFileName + ".csv");
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(",");
        int poiNum = 0;
        String[] build = null;
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

            
            if (line.length > 8) {
                build = line[8].split("\\s");
                poi.setBuilding(build[0]);
            }
            pois.add(poi);
            poiNum++;
        }
        sc.close();
    }
    
    /**
    * This method updates the favourite status of POI objects in a LinkedList based on a list of room numbers read from a file.
    * 
    * @param fileName the name of the file that contains a list of room numbers to update as favourite.
    * @param pois a LinkedList of POI objects to update the favourite status based on the room numbers.
    * @throws Exception if the file does not exist or if there is an error reading the file.
    */
    public static void favourite(String fileName, LinkedList<POI> pois) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        
        while ((line = br.readLine()) != null) {
            for (POI poi : pois) {
                if (line.strip().equals(poi.getRoomNum().strip())) {
                    poi.setFavourite(true);
                    break;
                }
            }
        }
        
        br.close();
    }
    
    /**
    * Writes POI data to a CSV file.
    * 
    * @param rawFileName The name of the file to be written to.
    * @param pois A linked list of POI objects.
    * @throws IOException if an error occurs while writing to the file.
    */
    public static void outputter(String rawFileName, LinkedList<POI> pois) throws IOException {
        
        String fileName = new String("src/resources/data/" + rawFileName + ".csv");
        
        FileWriter fw = new FileWriter(fileName);
        PrintWriter pw = new PrintWriter(fw);
        
        for (POI poi : pois) {
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
        
        pw.close();
        fw.close();
    }
    
    /**

    This method writes a list of POIs to a file with the given filename.

    Each POI is written as a single line in the file, with its name, category,

    favourite status, room number, description, floor number, x and y coordinates,

    and building name separated by commas.

    @param fileName the name of the file to write the POIs to

    @param pois the list of POIs to write to the file

    @throws IOException if there is an error writing to the file
    */
    public static void addPOI(String fileName, LinkedList<POI> pois) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        PrintWriter pw = new PrintWriter(fw);
        
        for (POI poi : pois) {
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
        
        pw.close();
        fw.close();
    }
}
