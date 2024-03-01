/* WORLDCUP_PLAYER.C
Contains pPlayer structure and related function definitions 
Builds linked list of player stsructures */
/* Commentl*/

#include "worldcup_player.h"




/* INSERT
Param: struct player* list, pointer to linked list to insert player into
Does not insert if run out of memory, user input is incorrect(already in used)
Return: newly created node with user information and next pointing to given list*/
struct player *insertP(struct player *list) {
    /* Create new node */
    struct player *new;
    struct player *p; // used for traversing lists 
    p = malloc(sizeof(struct player));
    new = malloc(sizeof(struct player));
    new->next = list;
    if (new == NULL) {
        printf("Error in adding player: Memory limit reached\n");
        return list;
    }

    /* Ask user for player code] and verify it is correct/available, exit function if not*/
    printf("Enter a player code (>=0): ");
    int newCode;
    scanf(" %d", &newCode);
    if (newCode < 0) {
        printf("Error in adding player: Invalid player code\n");
        return list;
    }
    if (searchPlayerCode(list, newCode) != NULL) {
        printf("Error in adding player: Player code already in use\n");
        return list;
    }
  
    /* Ask user for player name and store up to 49 characters*/
    printf("Enter player name (max 49 char): ");
    char newName[MAX_NAME+1];
    readString49(newName); // reads user input up to 49 chars into newName

    /* ask for age*/
    printf("Enter a player age (17-99): ");
    int newAge;
    scanf(" %d", &newAge);
    if ((newAge < 17) || (newAge > 99)){
        printf("Error in adding player: Invalid player age\n");
        return list;
    }

    /* ask for club name, up to 49 characters stored*/
    printf("Enter player club name (max 49 char): ");
    char newClub[MAX_NAME+1];
    readString49(newClub);


     /* If no errors have been run into 
      Save user input into the new node and add it to the linked list*/
    new->code = newCode;
    strcpy(new->name, newName);
    new->age = newAge;
    strcpy(new->club, newClub);
    //if (new->next == NULL) printf("inserton error next is null\n");
    return new;


}

/* PRINTP
Param: pointer to struct player - first node in linked list
Return: none, prints values of all nodes in list*/
void printP(struct player *list) {

    printf("PLAYER CODE    NAME                           AGE    CLUB\n");
    for (; list != NULL; list = list->next) {
        printf("%-13d %-31s %-7d %-49s\n", list->code, list->name, list->age, list->club);
    }

}

/* STRINGREAD49
Param: pointer to char array (string)
Return: void, reads user input up to MAX_NAME characters and stores into the given string param
NOTE: adds null char at the end*/
void readString49(char string[]) {
    char ch;
    while ((ch = getchar()) == ' ') {
        ;
    }
    int i = 0;
    for (; i < MAX_NAME; i++) {
        ch = getchar();
        if ( (int) ch == 10) break;
        (string[i]) = ch;
    }
    (string[i]) = '\0';

}


/* SEARCHP
Param: struct player *list to search
Return: none, prints info of user specified player if found*/
void searchP(struct player *list) {

    printf("Enter player code: ");
    int searchcode;
    scanf(" %d", &searchcode);

    printf("PLAYER CODE    NAME                           AGE    CLUB\n");
    for (; list != NULL; list = list->next) {
        if (list->code == searchcode) {
            printf("%-13d %-31s %-7d %-49s\n", list->code, list->name, list->age, list->club);
            return;
        }
    }
    printf("Not found.\n");
}


/* SEARCHPLAYERCODE
Param: struct player list pointer, int code
Return: struct player *list if found, else NULL*/
struct player *searchPlayerCode(struct player *list, int code) {
    for (; list != NULL; list = list->next) {
        if (list->code == code) {
            return list;
        }
    }
    return NULL;
}

/* DELETE
Delete player from list
Param: pointer to struct node, first of linked list
Reutrn: none*/
struct player *deleteP(struct player *list) {


/* Create nodes for searching */
    struct player *cur;
    struct player *p; // used for prev 
    cur = list;
    p = NULL;
   

    /* Get team code */
    printf("Enter teamcode: ");
    int code;
    scanf(" %d", &code);


    /* If not found or list empty*/

    if (list == NULL) {
        printf("Error in deleting player: no players in databse\n");
        return list;
    }

    else if (searchPlayerCode(list, code) == NULL) {
        printf("Error in deleting player: player #%d not found\n", code);
        return list;
    }
    
    else {

        for (cur = list; cur != NULL && cur->code != code; p = cur, cur = cur->next) {
            if (cur->code == code) {
                printf("found player %d", cur->code);
            }
        }
        /*
        if (cur == NULL) {
            printf("cur is null");
        }
        else printf("cur is %d", cur->code);
        if (p != NULL) {
            printf("p is %d", p->code);
        }   
        else printf("p is null"); */

        if (cur == NULL) {
            printf("Error in deleting player: player %d not found\n", code);
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

/* RESTOREPLAYER
Param: struct team *player to restore, along with all its members (code, name, age, club, next)\) 
Return: none, restores team with given data */
void restorePlayer(struct player *player, int code, char name[], char club[], int age, struct player *next) {
    player->code= code;
    strcpy(player->name, name);
    player->age = age;
    player->next = next;
    strcpy(player->club, club);


}

    /* UPDATE
Param: struct team *list 
Return: none, updates specific team based o user input*/
struct player *updateP(struct player *list) {
    printf("Enter player code: ");
    int code;
    scanf(" %d", &code);

    struct player *update = searchPlayerCode(list, code);
    if (update== NULL) {
        printf("Error in updating player: player not found\n");
        return list;
    }

    /* STORE CURRENT INFO*/
    int oldCode = update->code;
    char oldName[MAX_NAME+1];
    strcpy(oldName, update->name);
    int oldAge = update->age;
    char oldClub[MAX_NAME+1];
    strcpy(oldClub, update->club);
    struct player *oldNext = update->next;


    /* CLEAR THIS NODE INFO, keep next*/
    update->code = NULL_PLAYER;
    strcpy(update->name, "      ");
    strcpy(update->club, "  ");
    update->age = NULL_PLAYER;

    /* Ask user for tplayercode] and verify it is correct/available, exit function if not*/
    printf("Enter a player code (>=0): ");
    int newCode;
    scanf(" %d", &newCode);
    if (newCode < 0) {
        printf("Error in updating player: Invalid player code\n");
        restorePlayer(update, oldCode, oldName, oldClub, oldAge, oldNext);
        return list;
    }
    if (searchPlayerCode(list, newCode) != NULL) {
        printf("Error in updating player: Player code already in use\n");
        restorePlayer(update, oldCode, oldName, oldClub, oldAge, oldNext);
        return list;
    }


      /* Ask user for player name and store up to 49 characters*/
    printf("Enter player name (max 49 char): ");
    char newName[MAX_NAME+1];
    readString49(newName); // reads user input up to 49 chars into newName

    /* ask for age*/
    printf("Enter a player age (17-99): ");
    int newAge;
    scanf(" %d", &newAge);
    if ((newAge < 17) || (newAge > 99)){
        printf("Error in adding player: Invalid player age\n");
        return list;
    }

    /* ask for club name, up to 49 characters stored*/
    printf("Enter player club name (max 49 char): ");
    char newClub[MAX_NAME+1];
    readString49(newClub);


     /* If no errors have been run into 
      Save user input into the new node and add it to the linked list*/
    update->code = newCode;
    strcpy(update->name, newName);
    update->age = newAge;
    strcpy(update->club, newClub);
    return list;



}