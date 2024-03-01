#ifndef WORLDCUP_TEAM_H
#define WORLDCUP_TEAM_H

#define MAX_TNAME 24
#define NULL_COLOUR '\0'
#define NULL_CODE -1

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

struct team {
    int code;
    char name[MAX_TNAME+1];
    char seed[3];
    char colour;
    struct team *next;

};

/* FUNCTION DECLARATIONS*/
struct team *insertT(struct team *list);
struct team *searchTeamCode(struct team *list, int code);
void readString24(char string[]);
struct team *searchTeamSeed(struct team *list, char seed[]);
struct team *searchTeamName(struct team *list, char name[]);
void printT(struct team *list);
void searchT(struct team *list);
struct team *deleteT(struct team *list);
struct team *updateT(struct team *list);
void restoreTeam(struct team *team, int code, char name[], char seed[], char colour, struct team *next);


#endif 