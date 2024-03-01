
package com.cs2212.campus_nav_group10;


/**
 * Class used to get current weather information and organize data. 
 * API request to OpenWeather is made with {@link getWeather} method and errors in retrieving data, such as 
 * a loss of internet connection, are handled by the {@link weatherError} method. 
 * 
 * @version: 1.4
 * @author: Ria Haque}
 */



import java.net.*;
import org.json.simple.JSONObject; //google JSON dependency
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser; //google JSON dependency
import java.util.Scanner;

public class Weather {
    
    /** The API endpoint, a link that can be accessed online. DO NOT CHANGE. */
    private final String apiEndPoint= "https://api.openweathermap.org/data/2.5/weather?q=London,CA&units=metric&appid=b735d16ff9d963473ec6eb885d22d4c9";
    /** The API key, a private key from our OpenWeather account used to access data. DO NOT SHARE OR CHANGE */
    private final String apiKey="b735d16ff9d963473ec6eb885d22d4c9"; 
    /** The temperature, to be stored as a double */
    private double temp; 
    /** The current weather code, which corresponds to an image */
    private String code;
    /** The weather description */
    private String desc;
    /** The HTTP connect response code, should be 200 for successful connection */
    private int responseCode;
    
    /**
     * Weather constructor. Creates a new Weather object and retrieves and stores data.
     */
    public Weather() {
        getWeather();
    }
    
    /**
     * Retrieve and organize data. Makes API request and parses information returned, stores in Weather variables.
     */
    private void getWeather() {
        try {  
            //Make API call
            URL url = new URL(apiEndPoint);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            
            //Check response code
            responseCode = con.getResponseCode();
            if (responseCode != 200) {
                weatherError();
                return;
            }
            
            // Get response and save as string 
            StringBuilder dataBuilder = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                dataBuilder.append(scanner.nextLine());
            }
            scanner.close();
            String dataString = dataBuilder.toString();
            
            // Parse 
            JSONParser parser = new JSONParser();
            JSONObject dataObject = (JSONObject) parser.parse(dataString);
            JSONObject coordinates = (JSONObject) dataObject.get("coord");
            
            //get weather array and get weathercode from there
            JSONArray weatherArray = (JSONArray) dataObject.get("weather");
            JSONObject desc = (JSONObject) weatherArray.get(0);
            code = desc.get("icon").toString();
            this.desc = desc.get("description").toString();
            
            //get main object and get temp from there
            JSONObject mainObject = (JSONObject) dataObject.get("main");
            Number tempNum = (Number) mainObject.get("temp");
            temp = tempNum.doubleValue();
            //temp = (Double) mainObject.get("temp");
         
            
        }
        catch (Exception e){
            weatherError(); 
            System.out.println("Error in fetching weather API");
        }
    }
    
    
    /** 
     * Handles errors in getting weather data (ex. bad internet connection). 
     * Sets temperature to 0, text to "unable to connect", and icon to error image icon
     */
    private void weatherError() {
        this.desc = "Unable to connect";
        this.temp = 0;
        this.code = "error";
    }
    

    /**
     * Returns the weather description
     * @return description of current weather 
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * Returns the temperature in double format
     * @return current temperature
     */
    public double getTemp() {
        return this.temp;
    }
    
    /**
     * Returns the weather code in String format, can be matched to image file
     * @return current weather code, for icon type
     */
    public String getCode() {
        return this.code;
    }
    
}  
 


