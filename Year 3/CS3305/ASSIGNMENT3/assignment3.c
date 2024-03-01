
#include <stdio.h>
#include <stdlib.h>     /* atoi */
#include <unistd.h>  /* getpid */
#include <pthread.h>

void *sum(void *thread_id);
void *even_odd(void *thread_id);
void *multiplication(void *thread_id);
void *reverse_num(void *thread_id);

int input_array[4];



int main(int argc, char **argv) {
    
    int X = atoi(argv[1]);
    int Y = atoi(argv[2]);
    pthread_t thread_1, thread_2, thread_3;


    printf("parent (PID %d) receives X = %d and Y = %d from the user\n", getpid(), X, Y);
    printf("parent (PID %d) writes X = %d and Y = %d to input_array[]\n", getpid(), X, Y);
    input_array[0] = X;
    input_array[1] = Y;

    pthread_create(&thread_1, NULL, sum, (void *)pthread_self()); 
    pthread_join(thread_1, NULL); 

    pthread_create(&thread_2, NULL, even_odd, (void *)pthread_self()); 
    pthread_join(thread_2, NULL); 

    pthread_create(&thread_2, NULL, multiplication, (void *)pthread_self()); 
    pthread_join(thread_2, NULL); 

    pthread_create(&thread_3, NULL, reverse_num, (void *)pthread_self()); 
    pthread_join(thread_3, NULL); 

}

void *sum(void *thread_id) {
    int x = input_array[0]; 
    int y = input_array[1];
    printf("thread_1 (TID %ld) reads X = %d and Y = %d from input_array[]\n", (long)thread_id, x, y);

    int sum = x + y;
    input_array[2] = sum;
    printf("thread_1 (TID %ld) writes X + Y = %d to the input_array[2]\n", (long)thread_id, sum);
    pthread_exit(NULL);
}

void *even_odd(void *thread_id) {
    int sum = input_array[2];
    printf("thread_2 (TID %ld) reads %d from the input_array[2]\n", (long)thread_id, sum);

    if (sum % 2 == 0) { //even 
        printf("thread_2 (TID %ld) identifies that %d is an even number\n", (long)thread_id, sum);
    }
    else { //odd 
        printf("thread_2 (TID %ld) identifies that %d is an odd number\n", (long)thread_id, sum);
    }

    pthread_exit(NULL);
}

void *multiplication(void *thread_id) {
    int x = input_array[0]; 
    int y = input_array[1];
    int multiply = x * y;
    input_array[3] = multiply;

    printf("thread_2 (TID %ld) reads X = %d and Y = %d from input_array[], writes X * Y = %d to inputarray[3]\n", (long)thread_id, x, y, multiply);
    pthread_exit(NULL);
}

void *reverse_num(void *thread_id) {
    int x = input_array[3];
    printf("thread_3 (TID %ld) reads %d from input_array[3]\n", (long)thread_id, x);

    int reversed = 0;
    int i = x;
    while (i != 0) {
        int digit = i% 10;  
        reversed = reversed * 10 + digit;  
        i /= 10; 
    }
    
    printf("thread_3 (TID %ld) reverses the number %d to %d\n", (long)thread_id, x, reversed);

    pthread_exit(NULL);

}