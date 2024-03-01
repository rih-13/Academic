/* Program: worldCupDB
Purpose: Databse of world cup teams, which users can view and update 
Author: Ria Haque 251164501*/


#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define UNFILLED_TEAM -1
#define MAX_NAME 24
#define MAX_TEAMS 32

/* Structure: Team
Contains members code, name, colour, and seed array(which has letter and number) */
struct team {
    int team_code;
    char name[MAX_NAME+1];
    char seed[3];
    char colour;
    } ;


/* FUNCTIONS */
void insert(struct team database[], int *num_teams);
void print(struct team database[], int *num_teams);
int search(struct team database[]);
void update(struct team database[], int *num_teams);


/* Repeatedly asks users what operation they want to do and then completes it*/
int main(void) {
    
    /* Array of up to 32 team structures, initialize all team codes to signify no team data is stored there yet */
    struct team database[MAX_TEAMS-1];
    for (int i = 0; i < MAX_TEAMS; i++) {
        database[i].team_code = UNFILLED_TEAM;
    } 

    /* Stores current number of teams stored */
    int num_teams = 0;


    char operation;
    printf("2211 WORLD CUP\n");
    printf("Please enter a command: i for insert, s for search, u for update, or p for print (q to quit): ");
    scanf(" %c", &operation);
    operation = tolower(operation);



    
    while (operation != 'q') {
        switch (operation) {
            case 'i': insert(database, &num_teams); 
                    break;
            case 's': search(database); 
                        break;
            case 'u': update(database, &num_teams); 
                        break;
            case 'p': print(database, &num_teams); 
                        break;
            default: printf("Please enter a valid operation code.\n");
                    break;
        }

        printf("Please enter a command: i for insert, s for search, u for update, or p for print (q to quit): ");
        scanf(" %c", &operation);
        operation = tolower(operation);


    }
    
    return 0;
}


/* Function: insert
Inserts new team into database if there are no conflicting team codes/names and information is valid 
Parameters team database (array) and int pointer number of teams, returns void*/
void insert(struct team database[], int *num_teams) {

    /* Saves team code*/
    int code;
    printf("Enter a team code (0-31): ");
    scanf(" %d", &code);
    /* Checks for errors: if max number of teams reached, code is invalid, or code is already iin use*/
    if (*num_teams == MAX_TEAMS) {
        printf("Error: Maximum amount of teams reached.\n");
        return;
    }
    if ((code < 0) || (code > 31)) {
        printf("Error: Team code not 0-31.\n");
        return;
    }
    for (int i = 0; i < MAX_TEAMS; i++) {
        if (   database[i].team_code == code) {
            printf("Error: Team code already in use.\n");
            return;
        }
    } 


    /* Creates team name array, team names must be unique*/
    char name[MAX_NAME];
    char ch;
    printf("Please enter a team name (max 24 char): ");
    while ((ch = getchar()) == ' ') {
        ;
    }
    int i = 0;
    for (; i < MAX_NAME; i++) {
        ch = getchar();
        if ( (int) ch == 10) break;
        name[i] = ch;
    }
    name[i] = '\0';
    for (int i = 0; i < MAX_TEAMS; i++) {
        if ( strcmp(database[i].name, name) == 0) {
            printf("Error: Team name already in use.\n");
            return;
        }
    } 

    /* Saves seed if both seed values are valid and the seed is unused */
    char seed_letter;
    printf("Enter a seed letter (A-H): ");
    scanf(" %c", &seed_letter);
    seed_letter = toupper(seed_letter);
    if (seed_letter < 'A' || seed_letter > 'H') {
        printf("Error: Invalid seed letter\n");
        return;
    }
    char seed_number;
    printf("Enter a seed number (1-4): ");
    scanf(" %c", &seed_number);
    if (seed_number< '1' || seed_number > '4') {
        printf("Error: Invalid seed number\n");
        return;
    }
    char seed[3];
    seed[0]= seed_letter;
    seed[1] = seed_number;
    seed[2] = '\0';
    for (int i = 0; i < MAX_TEAMS; i++) {
        if ( strcmp(database[i].seed, seed) == 0) {
            printf("Error: Team seed already in use.\n");
            return;
        }
    } 

    /* Saves kit colour initial if initial is valid */
    char colour;
    printf("Enter a kit colour (R, O, Y, G, B, I, or V): ");
    scanf(" %c", &colour);
    colour = toupper(colour);
    if ( (colour == 'R') || (colour == 'O') || (colour == 'Y') || (colour == 'G') || (colour == 'B')|| (colour == 'I') || (colour == 'V') ) {
        ;
    }
    else {
        printf("Error: Invalid kit colour initial \n");
        return;
    }



    /* If no errors have been run into yet, create new database entry with valid information*/
    /* Increment num_teams if operation successful*/
    database[code - 1].team_code = code; // adds team code
    strcpy(database[code -1].name, name); // adds team name
    strcpy(database[code -1].seed, seed); // adds seed
    database[code - 1].colour = colour; // adds team colour
    (*num_teams)++;

}


/* Function: print
Prints all current database entries 
Parameters of team database and int pointer number of teams, returns void*/
void print(struct team database[], int *num_teams) {

    printf("%-12s %-24s %-20s %-12s", "Team Code", "Team Name", "Group Seeding", "Primary Kit Colour\n");
    for (int i = 0; i < MAX_NAME; i++) {
        if (database[i].team_code != UNFILLED_TEAM) {
            printf("%-12d %-24s %-20s %-12c\n", database[i].team_code, database[i].name, database[i].seed, database[i].colour);

        }
    }

}

/* Function: search
Searches parameter databse for team code number, if found prints and returns 1
If not found or given code is invalid, returns -1*/
int search(struct team database[]) {
    int code;
    printf("Please enter the team code: ");
    scanf(" %d",&code);
    if (code < 1 || code > 32) {
        printf("Error: Invalid team code.\n");
        return -1;
    }
    if (database[code - 1].team_code == UNFILLED_TEAM) {
        printf("Error: No team found with this team code.\n");
        return -1;
    }
    else {
        printf("%-12s %-24s %-20s %-12s", "Team Code", "Team Name", "Group Seeding", "Primary Kit Colour\n");
        int i = code - 1;
        printf("%-12d %-24s %-20s %-12c\n", database[i].team_code, database[i].name, database[i].seed, database[i].colour);
        return 1;
    }

}

/* Function: update
Updates a team according to its team code number, as long as code is valid and is already stored in database
Parameter team array database, returns void*/
void update(struct team database[], int *num_teams) {
    int code;
    printf("Enter the team code: ");
    scanf(" %d", &code);

    /* If code not found or code invalid, print error and return*/
    if (code < 1 || code > 32) {
        printf("Error: Invalid team code.\n");
        return;
    }
    if (database[code - 1].team_code == UNFILLED_TEAM) {
        printf("Error: No team found with this team code.\n");
        return;
    }


    /* Creates team name array, team names must be unique (except for current entry)*/
    char name[MAX_NAME];
    char ch;
    printf("Please enter a team name (max 24 char): ");
    while ((ch = getchar()) == ' ') {
        ;
    }
    int i = 0;
    for (; i < MAX_NAME; i++) {
        ch = getchar();
        if ( (int) ch == 10) break;
        name[i] = ch;
    }
    name[i] = '\0';
    for (int i = 0; i < MAX_TEAMS; i++) {
        if (i == (code - 1)) { //if it is the current database entry, skip
            ;
        }
        else if ( strcmp(database[i].name, name) == 0) {
            printf("Error: Team name already in use.\n");
            return;
        }
    } 

    /* Saves seed if both seed values are valid and the seed is unused */
    char seed_letter;
    printf("Enter a seed letter (A-H): ");
    scanf(" %c", &seed_letter);
    seed_letter = toupper(seed_letter);
    if (seed_letter < 'A' || seed_letter > 'H') {
        printf("Error: Invalid seed letter\n");
        return;
    }
    char seed_number;
    printf("Enter a seed number (1-4): ");
    scanf(" %c", &seed_number);
    if (seed_number< '1' || seed_number > '4') {
        printf("Error: Invalid seed number\n");
        return;
    }
    char seed[3];
    seed[0]= seed_letter;
    seed[1] = seed_number;
    seed[2] = '\0';
    for (int i = 0; i < MAX_TEAMS; i++) {
        if (i == (code - 1)) { //if it is the current database entry, skip
            ;
        }
        else if ( strcmp(database[i].seed, seed) == 0) {
            printf("Error: Team seed already in use.\n");
            return;
        }
    } 


    

    /* Saves kit colour initial if initial is valid */
    char colour;
    printf("Enter a kit colour (R, O, Y, G, B, I, or V): ");
    scanf(" %c", &colour);
    colour = toupper(colour);
    if ( (colour == 'R') || (colour == 'O') || (colour == 'Y') || (colour == 'G') || (colour == 'B')|| (colour == 'I') || (colour == 'V') ) {
        ;
    }
    else {
        printf("Error: Invalid kit colour initial \n");
        return;
    }


    /* If no errors have been run into yet, update database entry with valid information*/
    database[code - 1].team_code = code; // adds team code
    strcpy(database[code -1].name, name); // adds team name
    strcpy(database[code -1].seed, seed); // adds seed
    database[code - 1].colour = colour; // adds team colour

}