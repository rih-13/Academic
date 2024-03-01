
/* Program: intToEnglish.c
Function: The program takes integers in numerical format, from 1 to 999 inclusive, and prints them
in English text. It can can convert multiple integers in one run until it is told to quit.
Author: Ria Haque - 251164501
Date: Oct 10/22*/


#include <stdio.h>


int main(void) {
    int input; /* The integer the user wants to convert to English, can be 1-999 inclusive
    Must be integer type in order for division results to be truncated and accurately calculate digits*/
    int hundred; /* The number in the hundreds digit of the input*/
    int ten; /*The number in the tens digit of the input*/
    int one; /*The number in the ones digit of the input*/

    /* Print instructions and record user response, ignoring whitespace*/
    printf("Enter a number 1-999 (0 to quit): ");
    scanf(" %d", &input);

    /* Quit if 0, otherwise process number*/
    while (input != 0) {


         /* Use division to find out which numbers are in each digits place
        All are ints so results automatically rounded down, so remainders are disregarded*/
        hundred = input/100;
        ten = (input - (hundred * 100))/10;
        one = (input - (hundred * 100) - (ten * 10));

        printf("You entered the number ");
        
         /* If there is a number in the hundreds digit (ie not 0), print it*/
        switch (hundred) {
            case 1: printf("one hundred "); break;
            case 2: printf("two hundred "); break;
            case 3: printf("three hundred "); break;
            case 4: printf("four hundred "); break;
            case 5: printf("five hundred "); break;
            case 6: printf("six hundred "); break;
            case 7: printf("seven hundred "); break;
            case 8: printf("eight hundred "); break;
            case 9: printf("nine hundred "); break;
        }
    
        /* If hundreds digit exists and another digit follows, print and*/
        if ((hundred != 0) && ((ten != 0) || (one != 0))) {printf("and ");}


        /* If there is a number other than 0 in tens digit, print it
        Processing of numbers from 10-19 also occurs here*/
        switch (ten) {
            case 1: switch (one) {
                        case 0: printf("ten"); break;
                        case 1: printf("eleven"); break;
                        case 2: printf("twelve"); break;
                        case 3: printf("thirteen"); break;
                        case 4: printf("fourteen"); break;
                        case 5: printf("fifteen"); break;
                        case 6: printf("sixteen"); break;
                        case 7: printf("seventeen"); break;
                        case 8: printf("eighteen"); break;
                        case 9: printf("nineteen"); break;}
                        break;
            case 2: printf("twenty"); break;
            case 3: printf("thirty"); break;
            case 4: printf("forty"); break;
            case 5: printf("fifty"); break;
            case 6: printf("sixty"); break;
            case 7: printf("seventy"); break;
            case 8: printf("eighty"); break;
            case 9: printf("ninety"); break;
            }

        /* If tens digit higher than twenty and another digit follows, print hyphen*/
        if ((ten > 1) && (one != 0)) { printf("-");}


        /* For printing the ones digit of numbers excluding those with 10-19*/
        if (ten != 1) { 
            switch (one) {
                case 1: printf("one"); break;
                case 2: printf("two"); break;
                case 3: printf("three"); break;
                case 4: printf("four"); break;
                case 5: printf("five"); break;
                case 6: printf("six"); break;
                case 7: printf("seven"); break;
                case 8: printf("eight"); break;
                case 9: printf("nine"); break;
            }
        }


        /*Reprompt user for new number or 0 to quit
        Read input, ignoring whitespace*/
        printf("\n");
        printf("Enter a number 1-999 (0 to quit): ");
        scanf(" %d", &input);

    }

    
    return 0;
}