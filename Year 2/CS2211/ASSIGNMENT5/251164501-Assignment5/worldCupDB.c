#include "worldCupDB.h"




int main(void) {

     /* Two linked list of player/team structures*/
    struct player *firstP;
    struct team *firstT;
    firstP = NULL;
    firstT = NULL;
    



    char operation;
    printf("2211 WORLD CUP\n");
    printf("Please enter a command: h for help, p to control players, t to control teams (q to quit): ");
    scanf(" %c", &operation);
    operation = tolower(operation);



    
    while (operation != 'q') {
        switch (operation) {

            case 'p': printf("Enter i to insert player, s to search for player, u to update player, d to delete player, or p to print all players: ");
                    char playerOp;
                    scanf(" %c", &playerOp);
                    operation = tolower(playerOp);
                    switch(playerOp) {
                        case 'i': firstP = insertP(firstP);
                                    break;
                        case 'p': printP(firstP);
                                    break;
                        case 's': searchP(firstP);
                                    break;
                        case 'd':   firstP = deleteP(firstP);
                                    break;
                        case 'u': firstP = updateP(firstP);
                                        break;
                        default: printf("Please enter a valid operation code\n");
                                break;
                    }
            break;







            case 't': printf("Enter i to insert team, s to search for team, u to update team, d to delete team, or p to print all teams: ");
                    char teamOp;
                    scanf(" %c", &teamOp);
                    operation = tolower(teamOp);
                    switch(teamOp) {
                        case 'i': firstT = insertT(firstT);
                                    break;
                        case 'p': printT(firstT);
                                    break;
                        case 's': searchT(firstT);
                                        break;
                        case 'd': firstT = deleteT(firstT);
                                        break;
                        case 'u': firstT = updateT(firstT);
                                        break;
                        default: printf("Please enter a valid operation code\n");
                                break;
                    
                    }
            break;

            case 'h': printf("Welcome to the 2211 World Cup Database. From the main menu select: help menu, p to make changes to player data, t to make changes to team data, \nor q to quit. You may add, delete, update, or search for and print a specific team or player by code. You may also print out all teams and \nplayers.\n\n");
                break;



            default: printf("Please enter a valid operation code.\n");
                    break;
        }

         printf("Please enter a command: h for help, p to control players, t to control teams (q to quit): ");
         scanf(" %c", &operation);
         operation = tolower(operation);


    }





    return 0;
}