/* WORLDCUP_TEAM
Includes team structure, and functions for adding, deleting, serching, updating, and printing the teams along with other functions*/


#include "worldcup_team.h"




/* INSERT
Param: struct team *list to insert into
Return: none, inserts based on user input*/
struct team *insertT(struct team *list) {
    /* Create new node */
    struct team *new;
    struct team *p; // used for traversing lists 
    p = malloc(sizeof(struct team));
    new = malloc(sizeof(struct team));
    new->next = list;

    if (new == NULL) {
        printf("Error in adding team: Memory limit reached\n");
        return list;
    }

    /* Ask user for team code] and verify it is correct/available, exit function if not*/
    printf("Enter a team code (>=0): ");
    int newCode;
    scanf(" %d", &newCode);
    if (newCode < 0) {
        printf("Error in adding team: Invalid team code\n");
        return list;
    }
    if (searchTeamCode(list, newCode) != NULL) {
        printf("Error in adding team: Team code already in use\n");
        return list;
    }
  
    /* Ask user for team name and store up to 24 characters*/
    printf("Enter team name (max 24 char): ");
    char newName[MAX_TNAME+1];
    readString24(newName); // reads user input up to 24 chars into newName
    if (searchTeamName(list, newName) != NULL) {
        printf("Error in adding team: team name already in use\n");
        return list;
    }

    /* ask for seed */
    char seed_letter;
    printf("Enter a seed letter (A-H): ");
    scanf(" %c", &seed_letter);
    seed_letter = toupper(seed_letter);
    if (seed_letter < 'A' || seed_letter > 'H') {
        printf("Error in adding team: Invalid seed letter\n");
        return list;
    }
    char seed_number;
    printf("Enter a seed number (1-4): ");
    scanf(" %c", &seed_number);
    if (seed_number< '1' || seed_number > '4') {
        printf("Error in adding team: Invalid seed number\n");
        return list;
    }
    char seed[3]; //create seed string
    seed[0]= seed_letter;
    seed[1] = seed_number;
    seed[2] = '\0';
    if (searchTeamSeed(list, seed) != NULL) {
        printf("Error in adding team: seed already in use\n");
        return list;
    }


    /* Saves kit colour initial if initial is valid */
    char newColour;
    printf("Enter a kit colour (R, O, Y, G, B, I, or V): ");
    scanf(" %c", &newColour);
    newColour = toupper(newColour);
    if ( (newColour == 'R') || (newColour == 'O') || (newColour == 'Y') || (newColour == 'G') || (newColour == 'B')|| (newColour == 'I') || (newColour == 'V') ) {
        ;
    }
    else {
        printf("Error adding team: Invalid kit colour initial \n");
        return list;
    }
    
    new->code = newCode;
    strcpy(new->name, newName);
    strcpy(new->seed, seed);
    new->colour = newColour;
    new->next = list;
    printf("Added team #%d %s to database\n", new->code, new->name);
    return new;

}

/* PRINT
Param: struct team *list to print from
Return: none, prints all teams in list*/
void printT(struct team *list) {

    printf("TEAM CODE    NAME                           SEED    COLOUR\n");
    for (; list != NULL; list = list->next) {
        printf("%-13d %-31s %-7s %-7c\n", list->code, list->name, list->seed, list->colour);
    }

}

/* SEARCHTEAMCODE
Param: struct team list pointer to search, int code to search for
Return: pointer to struct teamwith code, NULL if not found*/
struct team *searchTeamCode(struct team *list, int code) {
    for (; list != NULL; list = list->next) {
        if (list->code == code) {
            return list;
        }
    }
    return NULL;
}

/* STRINGREAD24
Param: pointer to char array (string)
Return: void, reads user input up to MAX_NAME characters and stores into the given string param
Adds null char to end*/
void readString24(char string[]) {
    char ch;
    while ((ch = getchar()) == ' ') {
        ;
    }
    int i = 0;
    for (; i < MAX_TNAME; i++) {
        ch = getchar();
        if ( (int) ch == 10) break;
        (string[i]) = ch;
    }
    (string[i]) = '\0';

}

/* SEARCHTEAMSEED
Param: struct team *list to search, char seed[] to search for 
Return: struct team *list if it exists, else null*/
struct team *searchTeamSeed(struct team *list, char seed[]) {
     for (; list != NULL; list = list->next) {
        if (strcmp(list->seed, seed) == 0) {
            return list;
        }
    }
    return NULL;
}

/* SEARCHTEAMNAME
Param: struct team *list to search, char name] to search for 
Return: struct team *list if it exists, else null*/
struct team *searchTeamName(struct team *list, char name[]) {
     for (; list != NULL; list = list->next) {
        if (strcmp(list->name, name) == 0) {
            return list;
        }
    }
    return NULL;
}

/* SEARCH
Param: struct team *list to search in
Return: none, searches and prints info based on user input*/
void searchT(struct team *list) {

    printf("Enter teamcode: ");
    int searchcode;
    scanf(" %d", &searchcode);
   
    for (; list != NULL; list = list->next) {
        if (list->code == searchcode) {
            printf("TEAM CODE    NAME                           SEED    COLOUR\n");
            printf("%-13d %-31s %-7s %-7c\n", list->code, list->name, list->seed, list->colour);
            return;
        }
    }
    printf("Not found.\n");
}

/* DELETE
Param: struct team *list to delete from
Return: none, deletes user specified node from list*/
struct team *deleteT(struct team *list) {
    /* Create nodes for searching */
    struct team *cur;
    struct team *p; // used for prev 
    struct team *p2;
    cur = list;
    p = NULL;
    p2 = NULL;

    /* Get team code */
    printf("Enter teamcode: ");
    int code;
    scanf(" %d", &code);
    //printf("FInding team %d", code);


    /* If not found or list empty*/

    if (list == NULL) {
        printf("Error in deleting team: no teams in databse\n");
        return list;
    }

    else if (searchTeamCode(list, code) == NULL) {
        printf("Error in deleting team: team #%d not found\n", code);
        return list;
    }
    
    else {

        for (cur = list; cur != NULL && cur->code != code; p = cur, cur = cur->next) {
            if (cur->code == code) {
                printf("found team %d", cur->code);
            }
        }
        
        /* if (cur == NULL) {
            printf("cur is null");
        }
        else printf("cur is %d", cur->code);
        if (p != NULL) {
            printf("p is %d", p->code);
        }   
        else printf("p is null"); */

        if (cur == NULL) {
            printf("Error in deleting team: team %d not found\n", code);
        }
        else if (p == NULL) {
            //printf("Deleting head node %d", code);
            return cur->next;
        }
        else {
            p->next = cur->next;
            free(cur);
            return list;
        }
        

        


    }

}

/* UPDATE
Param: struct team *list 
Return: none, updates specific team based o user input*/
struct team *updateT(struct team *list) {
    printf("Enter teamcode: ");
    int code;
    scanf(" %d", &code);

    struct team *update = searchTeamCode(list, code);
    if (update== NULL) {
        printf("Error in updating team: team not found\n");
        return list;
    }

    /* STORE CURRENT INFO*/
    int oldCode = update->code;
    char oldName[MAX_TNAME+1];
    strcpy(oldName, update->name);
    char oldSeed[3];
    strcpy(oldSeed, update->seed);
    char oldColour = update->colour;
    struct team *oldNext = update->next;


    /* CLEAR THIS NODE INFO, keep next*/
    update->code = NULL_CODE;
    strcpy(update->name, "                        ");
    strcpy(update->seed, "  ");
    update->colour = NULL_COLOUR;

    /* Ask user for team code] and verify it is correct/available, exit function if not*/
    printf("Enter a team code (>=0): ");
    int newCode;
    scanf(" %d", &newCode);
    if (newCode < 0) {
        printf("Error in adding team: Invalid team code\n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }
    if (searchTeamCode(list, newCode) != NULL) {
        printf("Error in adding team: Team code already in use\n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }
  
    /* Ask user for team name and store up to 24 characters*/
    printf("Enter team name (max 24 char): ");
    char newName[MAX_TNAME+1];
    readString24(newName); // reads user input up to 24 chars into newName
    if (searchTeamName(list, newName) != NULL) {
        printf("Error in adding team: team name already in use\n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }

    /* ask for seed */
    char seed_letter;
    printf("Enter a seed letter (A-H): ");
    scanf(" %c", &seed_letter);
    seed_letter = toupper(seed_letter);
    if (seed_letter < 'A' || seed_letter > 'H') {
        printf("Error in adding team: Invalid seed letter\n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }
    char seed_number;
    printf("Enter a seed number (1-4): ");
    scanf(" %c", &seed_number);
    if (seed_number< '1' || seed_number > '4') {
        printf("Error in adding team: Invalid seed number\n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }
    char seed[3]; //create seed string
    seed[0]= seed_letter;
    seed[1] = seed_number;
    seed[2] = '\0';
    if (searchTeamSeed(list, seed) != NULL) {
        printf("Error in adding team: seed already in use\n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }


    /* Saves kit colour initial if initial is valid */
    char newColour;
    printf("Enter a kit colour (R, O, Y, G, B, I, or V): ");
    scanf(" %c", &newColour);
    newColour = toupper(newColour);
    if ( (newColour == 'R') || (newColour == 'O') || (newColour == 'Y') || (newColour == 'G') || (newColour == 'B')|| (newColour == 'I') || (newColour == 'V') ) {
        ;
    }
    else {
        printf("Error adding team: Invalid kit colour initial \n");
        restoreTeam(update, oldCode, oldName, oldSeed, oldColour, oldNext);
        return list;
    }
    
    update->code = newCode;
    strcpy(update->name, newName);
    strcpy(update->seed, seed);
    update->colour = newColour;
    printf("Updated team #%d %s \n", update->code, update->name);
    return list;


    
}

/* RESTORETEAM
Param: struct team *team to restore, along with all its members (code, name, seed, colour, next) 
Return: none, restores team with given data */
void restoreTeam(struct team *team, int code, char name[], char seed[], char colour, struct team *next) {
    team->code= code;
    strcpy(team->name, name);
    team->colour = colour;
    team->next = next;
    strcpy(team->seed, seed);
}