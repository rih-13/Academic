
package com.cs2212.campus_nav_group10;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdullahahmad
 */
public class Regular_UserTest {
    Regular_User user;
    public Regular_UserTest() {
    }
    
    @BeforeEach
    public void setUp() {
        user = new Regular_User();
    }
    
    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    public void testUserFavInputter() throws Exception {
        try {
            
            FileWriter fw = new FileWriter("test.csv");
            PrintWriter pw = new PrintWriter(fw);
            pw.write("Classroom 1");
            pw.write("\n");
            pw.write("Classroom 2");
            pw.write("\n");
            pw.write("Classroom 3");
            pw.write("\n");
            
            LinkedList<String> favs = new LinkedList<String>();
            user.userFavInputter("test",favs);
            assertEquals(favs.get(0),"Classroom 1");
            assertEquals(favs.get(1),"Classroom 2");
            assertEquals(favs.get(2),"Classroom 3");
            
            
        } catch (Exception e) {
            System.out.print("userFavInputter Test Failed due to exception\n,  " + e);
        }
    }

    @Test
    public void testUserFavOutputter() throws Exception {
        try {
            LinkedList<String> favs = new LinkedList<String>();
            favs.add("Classroom 1");
            favs.add("Classroom 2");
            favs.add("Classroom 3");
                             
            user.userFavOutputter("test",favs);
            
            Scanner sc = new Scanner(new File("src/resources/data/test_FAV.csv"));
            LinkedList<String> csvOutput = new LinkedList<String>();
            while (sc.hasNextLine()) {
                csvOutput.add(sc.nextLine());
                
            }
            
            assertEquals(csvOutput.get(0),"Classroom 1");
            assertEquals(csvOutput.get(1),"Classroom 2");
            assertEquals(csvOutput.get(2),"Classroom 3");
           
        } catch (Exception e) {
            System.out.print("userFavOutputter Test Failed due to exception\n,  " + e);
        }
    }
    

}
    

