/* Program: converter.c
Function: The program lets users convert back and forth between kilograms/pounds, miles/kilometres, litres/gallons,
and hectares/acres. The program can perform multiple conversions in one run.
Author: Ria Haque -- 251164501
Date: Oct 10/22*/

#include <stdio.h> 
#include <ctype.h>


int main(void) {
    int conversion; // Represents which two units the user want to convert between or quit
    char direction; // Represents which direction the user wants to convert (forward/backward), converted to lowercase 
    float input; // Represents the value the user wants to convert
    float result; //Represents the answer of the conversion 
    char ch; // Used to skip white space

        /* Print menu and options */
        printf("Please select the conversion you would like. \n");
        printf("1 for kilograms and pounds \n"); 
        printf("2 for hectares and acres \n");
        printf("3 for litres and gallons \n");
        printf("4 for kilometres and miles \n");
        printf("5 to quit \n");
        
        /* Record response, ignore whitespace */
        scanf(" %d", &conversion);
        
        /* If response invalid (any other integer), keep prompting until valid */
        while ((conversion < 1) || (conversion > 5)) {
            printf("Invalid input. Please try again: ");
            scanf(" %d", &conversion);
        }

        

    /* If user enters 5 to quit, quit
    If user enters another number, process the conversion */
    while (conversion != 5) {



        /* Use user's choice of conversion*/
        switch (conversion) {
            case 1: printf("Enter K for kilograms to pounds or P for pounds to kilograms: ");
                    scanf(" %c", &direction); //ignore whitespace
                    direction = tolower(direction);  // lowercase
                    /* If user does not enter k or p, reprompt until they do*/
                    while ((direction != 'k') && (direction != 'p')) {
                        printf("Invalid input. Please try again: ");
                        scanf(" %c", &direction);
                        direction = tolower(direction);
                        }
                    printf("Enter a number: ");
                    scanf(" %f", &input); // ignore whitespace
                    if (direction == 'k') {
                        result = input * 2.20462;
                        printf("Your result is %f lbs\n", result);
                    }
                    else {
                        result = input/2.20462;
                        printf("Your result is %f kg\n", result);

                    }
                    break;

            case 2: printf("Enter H for hectares to acres or A for acres to hectares: ");
                    scanf(" %c", &direction); //ignore whitespace
                    direction = tolower(direction); //lowercase
                    /* If user does not enter h or a, reprompt until they do*/
                    while ((direction != 'h') && (direction != 'a')) {
                        printf("Invalid input. Please try again: ");
                        scanf(" %c", &direction);
                        direction = tolower(direction);
                        }
                    printf("Enter a number: ");
                    scanf(" %f", &input); //ignore whitespace
                    if (direction == 'h') {
                        result = input * 2.47105;
                        printf("Your result is %f acres\n", result);
                    }
                    else {
                        result = input/2.47105;
                        printf("Your result is %f hectares\n", result);

                    }
                    break;

            case 3: printf("Enter L for litres to gallons or G for gallons to litres: ");
                    scanf(" %c", &direction); //ignore whitespcae
                    direction = tolower(direction); //lowercase
                    /* If user does not enter l or g, reprompt until they do*/
                    while ((direction != 'l') && (direction != 'g')) {
                        printf("Invalid input. Please try again: ");
                        scanf(" %c", &direction);
                        direction = tolower(direction);
                        }
                    printf("Enter a number: ");
                    scanf(" %f", &input); //ignore whitespace
                    if (direction == 'l') {
                        result = input * 0.264172;
                        printf("Your result is %f gallons\n", result);
                    }
                    else {
                        result = input/0.264172;
                        printf("Your result is %f litres\n", result);

                    }
                    break;

            case 4: printf("Enter K for kilometres to miles or M for miles to kilometres: ");
                    scanf(" %c", &direction); //ignore whitespace
                    direction = tolower(direction); //lowercase
                    /* If user does not enter k or m, reprompt until they do*/
                    while ((direction != 'k') && (direction != 'm')) {
                        printf("Invalid input. Please try again: ");
                        scanf(" %c", &direction);
                        direction = tolower(direction);
                        }
                    printf("Enter a number: ");
                    scanf(" %f", &input); //ignore whitespace
                    if (direction == 'k') {
                        result = input * 0.621371;
                        printf("Your result is %f miles\n", result);
                    }
                    else {
                        result = input/0.621371;
                        printf("Your result is %f kilometres\n", result);

                    }
                    break;
        }

        
        /* Print menu and options again for another conversion or to quit*/
        printf("\nPlease select the conversion you would like. \n");
        printf("1 for kilograms and pounds \n"); 
        printf("2 for hectares and acres \n");
        printf("3 for litres and gallons \n");
        printf("4 for kilometres and miles \n");
        printf("5 to quit \n");
        
        /* Record response. ignore whitespace*/
        scanf(" %d", &conversion);

         /* If response invalid, keep prompting until valid */
        while ((conversion < 1) || (conversion > 5)) {
            printf("Invalid input. Please try again: ");
            scanf(" %d", &conversion);
        }


    } 




    return 0;
}



    
