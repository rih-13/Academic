/**
 * The user login class is used to sign a user into the application and makes us of the encryption class
 * The user login class checks if a username, password is valid, whether the user is a developer and creates a username
 * @author Sergio Rangel
 *
*/

package com.cs2212.campus_nav_group10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class UserLogin {
    
    private static Encryption encryption;
    private static String[] usernames = new String[10];
    private static String[] passwords = new String[10];
    private static boolean[] developers = new boolean[10];
    
    /**
     * Checks if account is valid and uses encryption class to decrypt
     * @param username 
     * @param password
     * @return username if account valid, or null if account invalid
     */
    public String isValid(String username, String password) {
        String enteredUser = username;
        String enteredPassword = password;
        
        for (int i = 0; i < usernames.length; i++) {
            if ((enteredUser.equals(usernames[i]) && enteredPassword.equals(encryption.decryptPassword(passwords[i])))) {
                return username;
            }
        }
        return null;
    }
    /**
     * Checks if a user is a developer by searching for it in the developers array
     * @param username
     * @return true if developer, false if not
     */
    public boolean isDev(String username) {
        String enteredUser = username;
        
        for (int i = 0; i < usernames.length; i++) {
            if ((enteredUser.equals(usernames[i]) && true == developers[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if a username corresponds to an actual user by searching for it in the usernames array
     * @param username
     * @return username if actual user, null if not
     */
    public String isUser(String username) {
        String enteredUser = username;
        
        for (int i = 0; i < usernames.length; i++) {
            if ((enteredUser.equals(usernames[i]))) {
                return username;
            }
        }
        return null;
    }
    /**
     * Represents a user login system that reads user data from a CSV file and stores it in arrays
     * @throws FileNotFoundException
     * @throws ArrayIndexOutOfBoundsException
     * @throws IOException 
     */
    public UserLogin() throws FileNotFoundException, ArrayIndexOutOfBoundsException, IOException{
        String fileName = new String("src/resources/data/USER.csv");
        encryption = new Encryption();
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String[] values;
            String[] names;
            String temp = "";
            int counter = 0;
            while ((line = br.readLine()) != null) {
                //split line 
                values = line.split("[,]",0);
                //handle first line
                if(counter == 0){
                    for(int i  = 0; i < values[0].length(); i++){
                        if(i != 0){
                            temp += values[0].charAt(i);
                        }
                }
                }
                //handle subsequent lines
                if(temp.length() < 1){
                    developers[counter] = Boolean.parseBoolean(values[0]);
                }
                else{
                    developers[counter] = Boolean.parseBoolean(temp);
                }
                //store username is respective array
                usernames[counter] = values[1];
                passwords[counter] = values[2];
                //reset temp variable and increment 
                temp = "";
                counter++;
            }    
        br.close();
    }
        catch(FileNotFoundException e){
            System.out.println("USERS file not found.");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("USERS file out of bounds error.");
        }
        catch(IOException e){
            System.out.println("Error with USERS file.");
        }
    }
    /**
     * Creates a newUser, assumes its not a developer
     * Stores new account in .csv and encrypts password
     * @param username 
     * @param password
     * @throws IOException 
     */
    public  static void newUser(String username, String password) throws IOException{

            File file = new File("src/resources/data/USER.csv");//"src/resources/data/USER.csv"
            FileWriter fr = null;

            try {
                    // Below constructor argument decides whether to append or override
                    fr = new FileWriter(file, true);
                    fr.write("false");
                    fr.write(",");
                    fr.write(username);
                    fr.write(",");
                    fr.write(encryption.encrypt(password));
                    fr.write("\n");

            } catch (IOException e) {
                    e.printStackTrace();
            } finally {
                    try {
                            fr.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
        
        }
    /**
     * Checks if a user is a developer
     * @param username
     * @return true if so, false if not
     */
    public boolean isDeveloper(String username) {
        String currUser = username;
        for (int i = 0; i < usernames.length - 1; i++) {
            if (currUser.equals(usernames[i])) {
                return developers[i];
            }
        }
        
        return false;
    }


    
}
