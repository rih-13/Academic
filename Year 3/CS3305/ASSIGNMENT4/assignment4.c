#include <stdio.h>
#include <ctype.h> // ispace
#include <stdlib.h>     /* atoi */
#include <string.h> //tokens
#include <stdbool.h> //bools

#define MAX_LINE_LENGTH 100
#define MAX_PROCESSES 20




struct process {
    int id;
    int arrival;
    int burst;
    int start;
    int completion;
    int wait;
    int turnaround;
    int arrivalPrinted;
};

void schedule(struct process *processes, int numProcesses);




int main() {
    FILE *file;

    file = fopen("sjf_input.txt", "r");

    // Check if the file opened successfully
    if (file == NULL) {
        printf("Error opening file\n");
        return 1; 
    }



    char line [MAX_LINE_LENGTH];

    // Process each line (ie each test case)
    int testNum = 1;
    while(fgets(line, sizeof(line), file)!= NULL) {
        printf("Test case #%d: %s\n", testNum, line);

        struct process testCase[MAX_PROCESSES]; //create an array of MAX-PROCESSES processes 
        char *token;
        char *delimiter = " p\t\n"; // space,p, newline, and tab ignored
        token = strtok(line, delimiter); // get the first token

        int processNum = 0;
        /* Create a new process*/
        while (token != NULL) {
            struct process newProcess;

             
            size_t token_start = strspn(token, delimiter); // Skip leading white spaces and p
            token += token_start;

            // Save variables 
            if (token != NULL) {
                newProcess.id = atoi(token);
                token = strtok(NULL, delimiter); // Get the next token

                newProcess.arrival = atoi(token); 
                token = strtok(NULL, delimiter); // Get the next token

                newProcess.burst = atoi(token);
                token = strtok(NULL, delimiter); // Get the next token

                newProcess.arrivalPrinted = 0;
                
                testCase[processNum] = newProcess;
                processNum ++; 
            }



        }

        
        printf("Number of Processes: %d\n", processNum);
        printf("Process Scheduling Started\n");
        schedule(testCase, processNum);
        testNum++; //loop to next line/testcase

    }

    fclose(file);
}

void schedule(struct process *processes, int numProcesses) {
    int currentTime = 0;
    int processNum = numProcesses;
    int processCompleted = 0;
    float sumWait = 0;
    float sumTurnaround = 0;

    while (processNum > 0) {

        /* Find shortest job */
        int shortestIndex= -1;
        for (int i = 0; i < processNum; i++) {
            if (processes[i].arrival <= currentTime && 
            (shortestIndex == -1 || processes[i].burst < processes[shortestIndex].burst)) {
                shortestIndex = i;
            }
        }

        if (shortestIndex != -1) {
            struct process currentProcess = processes[shortestIndex];
            currentProcess.start = currentTime;
            processCompleted = 0;

            for (int i = 0; i <= currentProcess.burst; i++) {
                printf("CPU Time %d: ", currentTime);
                for (int i = 0; i < numProcesses; i++) {
                    if (processes[i].arrival == currentTime && processes[i].arrivalPrinted == 0) {
                        processes[i].arrivalPrinted = 1;
                        printf("[P%d arrived] ", processes[i].id);
                    }
                }
                printf("P%d [%d/%d]\n", currentProcess.id, i, currentProcess.burst);
                currentTime ++;
            }
            
            currentTime = currentTime - 1; //undo last increment of currentTime
            currentProcess.completion = currentTime;
            currentProcess.turnaround = currentProcess.completion - currentProcess.arrival;
            currentProcess.wait = currentProcess.start - currentProcess.arrival;
            sumWait += currentProcess.wait;
            sumTurnaround += currentProcess.turnaround;

            printf("Process P%d completed with Turnaround Time: %d, Waiting Time: %d\n", currentProcess.id, currentProcess.turnaround, currentProcess.wait);
            

            // Remove the completed process
            for (int i = shortestIndex; i < processNum; i++) {
            processes[i] = processes[i + 1];
            }
            processNum--;
        }
        else {
            printf("CPU Time %d: None\n", currentTime);
            currentTime++;
        }
    }

    float avgWait = sumWait/numProcesses;
    float avgTurnaround = sumTurnaround/numProcesses;
    printf("Process scheduling completed with Average Turnaround Time: %.2f, Average Waiting Time: %.2f\n\n", avgTurnaround, avgWait);
}


