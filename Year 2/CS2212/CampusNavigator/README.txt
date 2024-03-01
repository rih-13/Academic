Software Description:
This Java project contains the Campus Navigation project made by group 10 for CS2212 in the Winter 2023 term.
The Campus Navigation software allows users to view multiple buildings and corresponding floors at Western university, each of which
having built in Points of Interest (POI) that display information about specific locations on each floor. Users are also able to create, 
edit and delete their own custom POIs, which are only visible by that user. The application also allows for searches of points of interest,
determining matches based on the room number of POIs. Users are also able to set favourite POIs, which can be viewed in a unique screen.
In order to make adding POIs visible to all users easier, the app's developers can enter developer editing mode in which metadata POIs can 
be created and seen by all users in subsequent uses of the app.
New users are able to sign up and join the application as desired.


Libraries and Third-Party Tools:
- 'httpclient' by org.apache.httpcomponents version 4.5.12
- 'json' by org.json version 20220924
- 'jasypt' by org.jasypt version 1.9.3
- 'commons-codec'by commons-codec version 1.15
- 'json-simple' by com.googlecode.json-simple version 1.1
- 'junit-jupiter-api' by org.junit.jupiter version 5.6.0
- 'junit-jupiter-params' by org.junit.jupiter version 5.6.0
- 'junit-jupiter'engine' by org.junit.jupiter version 5.6.0
- 'junit-platform-surefire-provider' by org.junit.platform version 1.1.0

- Utilized OpenWeather API in order to implement a live weather API into the application
- Utilize Jasypt encryption library to encrypt and decrypt user passwords before passing to .csv file


Building the software from source code:
- Within the terminal, navigate to the 'project-March29 2' folder within the project directory
- Then, within this folder, run the command "mvn clean install"
- After this, the target folder should be created and within that folder the jar file should be created
- From this point the application should be ran using the instructions shown below


Running the already build software (using a jar file):
- Within terminal, navigate to the 'project-March29 2' folder within the project directory
- Then, within this folder, run the command "java -jar target/[*full file name of the jar file containing "build with dependencies"*]"
- For example, "java -jar target/Campus_Nav_Group10-1.0-SNAPSHOT-jar-with-dependencies.jar" (though this may not be the exact name of your jar file depending on how many times the project has been built with cleaning)


User guide:
- In order to run application, follow steps for building software from source code and then running the build software (shown above)
- Having ran the application, a new account can be created by inserting your desired username and password in the respective text fields
  then clicking the 'create new user button'
- Further information about using the entire app can be found through the 'Help' menu once the application is successfully opened


Accounts/Passwords:
- The software comes built in with developer-mode accounts for all software developers (Ben, Ria, Abdullah, Sergio, Nick) with usernames
  identical to the developer's first name and password "password"
- A general user-type account also exists with the username "General" and password "password"
- Further user-type accounts can be created with the create new user button


Accessing developer editing mode:
- By logging into the system with any of the five provided software developer's accounts (shown above), the system will be within editing mode
- In this mode, the application's user can edit metadata POIs using the "Create Meta POI" button under the "Create POIs" tab, 
  these POIs will appear for all users in future uses of the applicatoin
- In this mode, the application's user is also able to change (edit/delete) information for any POI within the app
- If an edited/deleted POI is a metadata one, these changes will appear for all users in subsequent uses of the application


Additional tips:
- A full list of all metadata POIs can be found in the "metadata.csv" file
- A full list of booleans for whether or not a user is a developer, usernames and (encrypted) passwords can be found in "USER.csv"
- A user's custom POIs can be found in their respective "[username].csv" file
- A list of the room numbers of a user's favourite POIs can be found in their respective "[username]_FAV.csv" file
