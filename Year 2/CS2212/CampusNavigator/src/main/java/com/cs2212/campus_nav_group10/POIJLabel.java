package com.cs2212.campus_nav_group10;

/**
 * Class for creating and handling POIJLabels, the object used to represent a POI and its 
 * label/icon on the map view. 
 * The constructor {@link POIJLabel()} creates a POIJLabel, adding the property that clicking
 * on the label will create the POI information frame with various options. It is connected
 * to a POI using the {@link connectPOI} method.
 * @author Ria Haque
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;

public class POIJLabel extends JLabel {
    
    /** The POI object it represents */
    private POI associatedPOI;
    /** Size of label icon */
    final int DIMENSION = 40;
    /** if POI is favourite */
    boolean isFavourite;
    /** if POI is displayed */
    boolean display;
    /** POi category */
    int POICategory;
    /** POI name */
    String POIName;
    /** POI room number */
    String POIRoomNum;
    /** POI description */
    String POIDescription;
    /** POI building */
    String POIBuilding;
    /** POI floor number */
    int POIFloor;
    /** POI x and y coordinate */
    int xCoordinate;
    int yCoordinate;
    /** if pOI is selected */
    boolean isSelected;
    /** WindowAdapter for the information frame */
    WindowAdapter editWindowAdapter;
    /** Labels original color */
    Color originalColor;
    /** Information window about pOI */
    JFrame poiInfoFrame;
    /** Change location button */
    JButton changeLocButton = new JButton("Change Location");
    /** Delete button */
    JButton deleteButton = new JButton("Delete");
    /** Save button */
    JButton saveButton = new JButton("Save");
    /** Edit Button */
    JButton editButton = new JButton("Edit");
    /** box to select POI category */
    private String[] categories = {"Classrooms", "Bathrooms", "Restaurants", "Labs", "Accessibility", "Computer Science"};
    JComboBox<String> categoryBox = new JComboBox<>(categories);
    /** Favourite check box */
    JCheckBox favouriteBox = new JCheckBox("Favourite");
    /** New x and y coordinates if user changes them */
    int newX;
    int newY;

    
    /**
     * POIJLabel constructor, creates a visual representation of POI on map view 
     * When label is clicked on, an information frame will pop up with Edit button. The edit button
     * enables save button.
     */
    public POIJLabel() {
        
        //if (this.associatedPOI != null) {
            this.setEnabled(true); 
            MouseListener labelClickListener = new MouseAdapter() { //if label clicked open info window
            public void mouseClicked(MouseEvent e) {
                JLabel clickedLabel = (JLabel) e.getSource();
                originalColor = clickedLabel.getBackground();
                clickedLabel.setOpaque(true);
                clickedLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                clickedLabel.setBackground(Color.yellow);
  
                // Create info frame
                poiInfoFrame = new JFrame("POI Information");
                JPanel poiInfoPanel = new JPanel(new GridLayout(0,2));
                
                
                
                JLabel poiName = new JLabel("Name: ");
                JTextField nameField = new JTextField(POIName);
                JLabel poiRoomNum = new JLabel("Room Number: ");
                JTextField roomNumField = new JTextField(POIRoomNum);
                JLabel poiDesc = new JLabel("Description: ");
                JTextArea descField = new JTextArea(POIDescription);
                //descField.setBackground(new Color(177, 216, 242));
                descField.setLineWrap(true);
                descField.setWrapStyleWord(true);
                
                nameField.setEditable(false);
                roomNumField.setEditable(false);
                descField.setEditable(false);
                nameField.setBackground(poiInfoPanel.getBackground());
                roomNumField.setBackground(poiInfoPanel.getBackground());
                descField.setBackground(poiInfoPanel.getBackground());
                poiInfoPanel.add(poiName);
                poiInfoPanel.add(nameField);
                poiInfoPanel.add(poiRoomNum);
                poiInfoPanel.add(roomNumField);
                poiInfoPanel.add(poiDesc);
                poiInfoPanel.add(descField);
                poiInfoFrame.add(poiInfoPanel);
                
                // When window closes unhighlight icon
                poiInfoFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        clickedLabel.setOpaque(false);
                        clickedLabel.setBorder(null);
                        clickedLabel.setBackground(null);
                    }
                });

                
                
                
                // Add favourite checkbox a
                poiInfoPanel.add(favouriteBox);
                
                
                // Add edit button and save button
                editButton.setBackground(new Color(177, 216, 242));
                editButton.setOpaque(false);
                editButton.setEnabled(true);
                poiInfoPanel.add(editButton);
                saveButton.setEnabled(false);
                poiInfoPanel.add(saveButton);
                
                // Add invisble change location and delete button
                poiInfoPanel.add(changeLocButton);
                deleteButton.setBackground(new Color(237, 133, 133));
                deleteButton.setOpaque(true);
                poiInfoPanel.add(deleteButton);
                changeLocButton.setVisible(false);
                deleteButton.setVisible(false);
                
                // Add category box
                categoryBox.setSelectedItem(getAssociatedPOI().getCategory());
                categoryBox.setVisible(false);
                categoryBox.setEnabled(false);
                poiInfoPanel.add(categoryBox);

                
                
                // If edit button clicked
                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        editButton.setOpaque(true);
                        nameField.setBackground(Color.WHITE);
                        roomNumField.setBackground(Color.WHITE);
                        nameField.setBackground(Color.WHITE);
                        descField.setBackground(Color.WHITE);
                        nameField.setEditable(true);
                        roomNumField.setEditable(true);
                        descField.setEditable(true);
                        editButton.setEnabled(false);
                        saveButton.setEnabled(true);
                        
                        
                        // Change location, category, and delete button appear
                        changeLocButton.setVisible(true);
                        deleteButton.setVisible(true);
                        categoryBox.setVisible(true);
                        categoryBox.setEnabled(true);
                        
                        
                        // User unable to close without error message
                        poiInfoFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
                        editWindowAdapter = new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                int choice = JOptionPane.showConfirmDialog(POIJLabel.this,
                            "Are you sure you want to exit? All unsaved changes will be lost.",
                            "Confirm Exit",
                            JOptionPane.YES_NO_OPTION);
                                if (choice == JOptionPane.YES_OPTION) {
                                   poiInfoFrame.dispose();
                                   clickedLabel.setOpaque(false);
                                   clickedLabel.setBorder(null);
                            
                                }
                                else {
                                    // keep frame up and icon highlighted
                                    poiInfoFrame.setVisible(true);
                                    clickedLabel.setOpaque(true);
                                    clickedLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                                    clickedLabel.setBackground(Color.yellow);
                                }
                            }
                        };
                        poiInfoFrame.addWindowListener(editWindowAdapter);
                    }
                });
                
                // Save button
                saveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String name = nameField.getText(); // Get the text from the field
                        String roomNum = roomNumField.getText(); 
                        String desc = descField.getText();
                        Boolean isFavourite = favouriteBox.isSelected();
                        int category = categoryBox.getSelectedIndex();
                        
                        POI editPOI = getAssociatedPOI();
                        editPOI.setName(name);
                        editPOI.setRoomNum(roomNum);
                        editPOI.setDesc(desc);
                        editPOI.setFavourite(isFavourite);
                        editPOI.setCategory(category);

                    

                        nameField.setEditable(false); 
                        nameField.setBackground(poiInfoPanel.getBackground());
                        roomNumField.setEditable(false);
                        roomNumField.setBackground(poiInfoPanel.getBackground());
                        descField.setEditable(false);
                        descField.setBackground(poiInfoPanel.getBackground());
                        editButton.setEnabled(true); // Enable the Edit button
                        editButton.setOpaque(false);
                        saveButton.setEnabled(false); // Disable the Save button
                        changeLocButton.setVisible(false); // change loc and delete button disappear
                        deleteButton.setVisible(false);
                        categoryBox.setVisible(false);
                        categoryBox.setEnabled(false);
                        poiInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        poiInfoFrame.removeWindowListener(editWindowAdapter);
                    }
                });
                
                

                
                poiInfoFrame.setPreferredSize(new Dimension(400, 500));
                poiInfoFrame.pack();
                Point locationOnScreen = clickedLabel.getLocationOnScreen();
                poiInfoFrame.setLocation(locationOnScreen.x + 50, locationOnScreen.y - (poiInfoFrame.getHeight() / 2));
                
                poiInfoFrame.setVisible(true);
                
                
                

            }
        };

        // add the mouse listener 
        this.addMouseListener(labelClickListener);

        
    }
    
    /**
     * Connects a created POIJlabel object with a POI object, so POI object information is
     * stored within POIJLabel
     * @param connectedPOI the POI whose information is to be saved
     */
    public void connectPOI(POI connectedPOI) {
        
        this.associatedPOI = connectedPOI; 
        this.isFavourite = connectedPOI.isFavourite();
        this.display = connectedPOI.isDisplayed();
        this.POICategory = connectedPOI.getCategory();
        this.POIName = connectedPOI.getName();
        this.POIRoomNum = connectedPOI.getRoomNum();
        this.POIDescription = connectedPOI.getDesc();
        this.POIFloor = connectedPOI.getFloor();
        this.xCoordinate = connectedPOI.getxCoordinate();
        this.yCoordinate = connectedPOI.getyCoordinate();
        this.isSelected = false;
    }
    
    /**
     * Returns POI object that POIJLabel represents 
     * @return POI object associated with POIJLabel 
     */
    public POI getAssociatedPOI() {
        return this.associatedPOI;
    }
    
}
