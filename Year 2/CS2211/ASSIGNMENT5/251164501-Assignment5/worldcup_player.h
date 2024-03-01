#ifndef WORLDCUP_PLAYER_H
#define WORLDCUP_PLAYER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "worldcup_player.h"
#define MAX_NAME 49
#define NULL_PLAYER -1

/* FUNCTION DECLARATIONS*/
void readString49(char string[]);
struct player *insertP(struct player *list);
void printP(struct player *list);
void searchP(struct player *list);
struct player *searchPlayerCode(struct player *list, int code);
struct player *deleteP(struct player *list);
void restorePlayer(struct player *player, int code, char name[], char club[], int age, struct player *next);
struct player *updateP(struct player *list);


/* Structure: Player
Age: 17-99
Code: 0-infinity, unique 
Name and Club of Player: 49 characters or less, not unique
Next: Pointer to next player in linked list */
struct player {
    int code, age;
    char name[MAX_NAME+1];
    char club[MAX_NAME+1];
    struct player *next;
};



#endif 