/**
A class representing a point of interest (POI) in the campus navigation system.
Each POI has a name, room number, description, building, floor number, x and y coordinates,
and a category that indicates what type of POI it is (e.g. classroom, washroom, food services, etc.).
POI objects also have a JLabel associated with them for display on the GUI.
* @author Sergio Rangel
*/
package com.cs2212.campus_nav_group10;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class POI {
            //POI attributes
            private final int DIMENSION = 40;
            private boolean favourite;
            private boolean display;
            private int category;
            private String name;
            private String roomNum;
            private String desc;
            private String building;
            private int floor;
            private int xCoordinate;
            private int yCoordinate;
            private boolean isSelected;
            private JLabel jlabel;
            
            /**
            * Default constructor for POI.
            * Initializes all POI attributes to default values.
            */
            public POI() {
                    this.favourite = false;
                    this.display = false;
                    this.category = 0;
                    this.name = "";
                    this.roomNum = "";
                    this.desc = "";
                    this.building = "";
                    this.floor = 0;
                    this.xCoordinate = 0;
                    this.yCoordinate = 0;
                    this.isSelected = false;
            }
            
            /**
            * Constructor for POI with parameters.
            * Initializes all POI attributes with specified values.
            * Also sets the POI's JLabel with an icon image.
            * 
            * @param favourite whether the POI is a favourite or not
            * @param display whether the POI should be displayed or not
            * @param category the category of the POI
            * @param name the name of the POI
            * @param roomNum the room number of the POI
            * @param desc the description of the POI
            * @param building the building that the POI is located in
            * @param floor the floor number that the POI is located on
            * @param xCoordinate the x-coordinate of the POI's location
            * @param yCoordinate the y-coordinate of the POI's location
            * @param isSelected whether the POI is currently selected or not
            */
            public POI(boolean favourite,boolean display,  int category, String name, 
                    String roomNum, String desc, String building, int floor, int xCoordinate, int yCoordinate, boolean isSelected) {
                    this.favourite = favourite;
                    this.display = display;
                    this.category = category;
                    this.name = name;
                    this.roomNum = roomNum;
                    this.desc = desc;
                    this.building = building;
                    this.floor = floor;
                    this.xCoordinate = xCoordinate;
                    this.yCoordinate = yCoordinate;
                    this.isSelected = isSelected;
                    // Set POI JLabel with icon image
                    JLabel POILabel = new JLabel();
                    try {
                        POILabel.setIcon(new ImageIcon(ImageIO.read(GUI.class.getClassLoader().getResource("imgs/poi.png"))));
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    POILabel.setBounds(this.xCoordinate,this.yCoordinate,40,40);
                    
                    this.jlabel = POILabel;
            }
	
            // Getters and setters for POI attributes
            public void setFavourite(boolean favourite) {
                    this.favourite = favourite;
            }

            public boolean isFavourite() {
                    return favourite;
            }

            public boolean isDisplayed() {
                    return display;
            }

            public void displayPOI() {
                    this.display = true;
            }

            public void hidePOI() {
                    this.display = false;
            }

            public void setCategory(int category) {
                    this.category = category;
            }

            public int getCategory() {
                    return category;
            }
            
            public JLabel getJLabel(){
                return jlabel;
            }

            public void setName(String name) {
                    this.name = name;
            }

            public String getName() {
                    return name;
            }

            public void setRoomNum(String roomNum) {
                    this.roomNum = roomNum;
            }

            public String getRoomNum() {
                    return roomNum;
            }

            public void setDesc(String desc) {
                    this.desc = desc;
            }

            public String getDesc() {
                    return desc;
            }

            public void setBuilding(String building) {
                    this.building = building;
            }

            public String getBuilding() {
                    return building;
            }

            public void setFloor(int floor) {
                    this.floor = floor;
            }

            public int getFloor() {
                    return floor;
            }

            public void setxCoordinate(int xCoordinate) {
                    this.xCoordinate = xCoordinate;
            }

            public int getxCoordinate() {
                    return xCoordinate;
            }

            public void setyCoordinate(int yCoordinate) {
                    this.yCoordinate = yCoordinate;
            }

            public int getyCoordinate() {
                    return yCoordinate;
            }

            public void selectPOI() {
                    this.isSelected = true;
            }

            public void deselectPOI() {
                    this.isSelected = false;
            }
            
            public boolean isSelected() {
                
                return this.isSelected;
            }
            
            public void testPrintPOI() {
                
                System.out.println("Name: " + this.getName() + ", Category: " + this.getCategory() + ", RoomNumber: " + this.getRoomNum() + ", Description: " + this.getDesc() + ", Floor: " + this.getFloor() + ", x: " + this.getxCoordinate() + ", y: " + this.getyCoordinate() + ", Building: " + this.getBuilding());
            }
        }