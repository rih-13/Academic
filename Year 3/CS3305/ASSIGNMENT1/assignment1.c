#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

/** argv[1] - n (int)
 * argv[2] - m (int)
 * argv[3] - s (name)
 * argv[4] - ext1
 * argv[5] ext2
*/

int main (int argc, char *argv[]) {
    pid_t parent_pid, pid_child1, pid_child1_1, pid_child1_2, pid_child2;

    parent_pid = getpid();
    printf("parent (PID %d): process started\n\n", parent_pid);
    printf("parent (PID %d): forking child_1\n", parent_pid);
    pid_child1 = fork();

    /** {PARENT}*/
    if (pid_child1 > 0) {
        printf("parent (PID %d): fork successful for child_1 (PID %d)\n", parent_pid, pid_child1);
        printf("parent (PID %d):  waiting for child_1 (PID %d) to complete\n", parent_pid, pid_child1);
        wait(NULL); //wait for child_1 to complete

        // CHILD 2
        printf("parent (PID %d): forking child_2\n", parent_pid);
        pid_child2 = fork();

        if (pid_child2 > 0) { // Parent
            printf("parent (PID %d): fork successful for child_2 (PID %d)\n", parent_pid, pid_child2);
            wait(NULL);
        }
        if (pid_child2 == 0) { //CHILD 2
            printf("child_2 (PID %d): process started from parent (PID %d)\n", getpid(), getppid());
            printf("child_2 (PID %d): calling an external program [%s]\n\n", getpid(), argv[5]);
            int status = execl(argv[5], argv[3], NULL);
            if (status == -1) {
                printf("external program failed\n");
                exit(0);
            }

        }
        
        printf("parent (PID %d): completed parent\n", parent_pid);
    }


    /** CHILD_1*/
    if (pid_child1 == 0) {
        printf("child_1 (PID %d): process started from parent (PID %d)\n\n", getpid(), getppid());
        printf("child_1 (PID %d): forking child_1.1\n", getpid());
        pid_child1_1 = fork(); // Create CHILD1.1

        if (pid_child1_1 > 0) { // Parent - CHILD1
            wait(NULL); //wait for child1.1 to complete
            printf("child_1 (PID %d): completed child_1.1\n\n", getpid());

            printf("child_1 (PID %d): forking child_1.2\n", getpid());
            pid_child1_2 = fork(); // Create CHILD1.2
            


            if (pid_child1_2 > 0) {  // Parent - Child1
                wait(NULL);
            }
            if (pid_child1_2 == 0) { // CHILD1.2
                printf("child_1.2 (PID %d): process started from child1 (PID %d)\n", getpid(), getppid());
                printf("child_1.2 (PID %d): calling an external program [%s]\n", getpid(), argv[4]);
                int status_child1_2 = execl(argv[4], argv[2], NULL);
                if (status_child1_2 == -1) {
                    printf("external program failed\n");
                    exit(0);
            }
            }
            wait(NULL);
            printf("child_1 (PID %d): completed child_1.2\n\n", getpid());
        }

        if (pid_child1_1 == 0) { //CHILD 1.1
            printf("child_1.1 (PID %d): process started from child1 (PID %d)\n", getpid(), getppid());
            printf("child_1.1 (PID %d): calling an external program [%s]\n", getpid(), argv[4]);
            int status_child1_1 = execl(argv[4], argv[1], NULL);
            if (status_child1_1 == -1) {
                printf("external program failed\n");
                exit(0);
            }
            
        }
    }




}