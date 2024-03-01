/*
CS2211 Assignment 3
Author: Ria Haque 251164501 
Purpose: The program takes in a certain  number of integers specified by the user and does various operations with them
and their order. */



#include <stdio.h>


/* Part 1 - print array*/
void printArray(int nums[], int length) {
    printf("Your array is: ");
    for (int i = 0; i < length - 1; i++) {
        printf("[%d] = %d, ", i, nums[i]);
    }
    printf("[%d] = %d\n", length - 1, nums[length - 1]); /* Print last elem without comma and with newline*/
}

/* Part 2 - print largest value*/
int largest(int nums[], int length) {
    int max = nums[0]; /* if number is larger, new max found*/
    for (int j = 0; j < length ; j++) {
        int current = nums[j];
        if (current > max) {
            max = current;
        }
    }
    return max;
}

/* Part 3 -- print values in reverse order*/
void printReverse(int nums[], int length) {
    printf("Your array in reverse is: ");
    for (int i = length - 1; i >= 0; i--) {
        printf("%d ", nums[i]);
    }
}

/* Part 4 - print sum of values */
int sumArray(int nums[], int length) {
    int sum = 0;
        for (int i = 0; i < length; i++) { /* add all values together*/
            sum += nums[i];
    }
    return sum;
}

/* Part 5 - print array in decreasing order of values */
void printOrdered(int nums[], int length) {
    /* Create a copy of the array*/
    int copy[length]; 
    for (int i = 0; i < length; i++) { 
        copy[i] = nums[i];
    }

    /* Sort the copy */
    for (int i = 0; i <  length - 1; ++i) { /* Compare each array element to all the others*/
        for (int j = 0; j < length - i - 1; ++j) {
            int next = j + 1;
            if (copy[j] < copy[next]) { /* if a larger number is found */ 
                int val = copy[j];
                copy[j] = copy[next]; /* Move larger number up */
                copy[next] = val; /* move current number  back */
            }
        }
    }

    /* Print sorted copy array*/
    printf("Your array sorted in descending order is: ");
    for (int i = 0; i < length; i++) { /* Copy array*/
        printf("%d ", copy[i]);
    }


}

/* Part 6 -- print array with first/last swapped*/
void printSwap(int nums[], int length) {
        int copy[length]; /* make copy of array */
        for (int i = 0; i < length; i++) { 
            copy[i] = nums[i];
        }

        /* Swap frist and last elements*/
        copy[0] = nums[length -1];
        copy[length -1] = nums[0];

        /* Print swapped copy*/
        printf("Your array with first and last element swapped is: ");
        for (int i = 0; i < length; i++) { 
            printf("%d ", copy[i]);
        }
    }





int main(void) {
    int ints, mainLength;

    /* Get how many integers user  will provide*/
    printf("Enter how many integers you will provide (5 - 12): ");
    scanf(" %d", &ints);
    while ((ints < 5) || (ints > 12)) {
        printf("Please pick a number 5 - 12: ");
        scanf(" %d", &ints);
    }
    /*Create arrau with that specified length*/
    int mainArray[ints];

    /* Get the integers of the array*/
    printf("There is enough room in your array for %d integers (%d bytes)\n", ints, (int) sizeof(mainArray));
    printf("Please enter your integers separated by spaces: ");
    for (int i = 0; i < ints; i++) {
        scanf(" %d", &mainArray[i]);
    }

    /*Store the length of the array to be used in functions*/
    mainLength = (int) sizeof(mainArray) / sizeof (mainArray[0]);


    /* Part 1 */
    printf("Part 1: \n");
    printArray(mainArray, mainLength);
    /* Part 2*/
    printf("Part 2: \n");
    printf("The largest value in your array is %d\n", largest(mainArray, mainLength));
    /* Part 3*/
    printf("Part 3: \n");
    printReverse(mainArray, mainLength);
    /* Part 4 */
    printf("\nPart 4: \n");
    printf("The sum of all the values in your array is: %d", sumArray(mainArray, mainLength));
    /* Part 5*/
    printf("\n Part 5\n");
    printOrdered(mainArray, mainLength);
    /*Part 6*/
    printf("\nPart 6: \n");
    printSwap(mainArray, mainLength);
    

    return 0;

}