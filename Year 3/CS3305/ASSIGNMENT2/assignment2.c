#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <signal.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/stat.h>

int summation(int start, int end)
{
	int sum = 0;
	if (start < end)
	{
		sum = ((end * (end + 1)) - (start * (start - 1))) / 2;
	}
	return sum;
}

int ith_part_start(int i, int N, int M)
{
	int part_size = N / M;
	int start = i * part_size;
	return start;
}
int ith_part_end(int i, int N, int M)
{
	int part_size = N / M;
	int end = (i < M - 1) ? ((i + 1) * part_size - 1) : N;
	return end;
}



int main(int argc, char **argv)
{
	pid_t parent, pid_child1;
    printf("parent(PID %d): process started\n\n", getpid());
    printf("parent(PID %d): forking child_1\n", getpid());
    pid_child1 = fork();

    // PARENT
    if (pid_child1 > 0) {
        printf("parent(PID %d): fork successful for child_1(PID %d)\n", getpid(), pid_child1);
        printf("parent(PID %d): waiting for child_1(PID %d) to complete\n\n", getpid(), pid_child1);
        wait(NULL);
        printf("parent(PID %d): parent completed\n", getpid());
    }

    //CHILD 1
    if (pid_child1 == 0) {
        printf("child_1(PID %d): process started from parent(PID %d)\n", getpid(), getppid());
        int M = atoi(argv[2]);
        int N = atoi(argv[1]);
        int port[2];
        pipe(port);
        wait(NULL);

        //Start loop to create M children, starting from 1 (child1.1)
        printf("child_1(PID %d): forking child1.1....child_1.%d\n\n", getpid(), M);
        for (int count = 0; count < M; count++) {
            pid_t pid_childM = fork();


            //Children - CHILD_M
            if (pid_childM == 0) {
                int start, end, sum, child_num;
                child_num = count + 1;
                start = ith_part_start(count, N, M);
                end = ith_part_end(count, N, M);
                sum = summation(start, end);
                printf("child_1.%d(PID %d): fork() successful\n", child_num, getpid());
                printf("child_1.%d(PID %d): partial sum[%d - %d]: = %d\n\n", child_num, getpid(), start, end, sum);
                write(port[1], &sum, sizeof(sum));
                exit(0);
            }
        }

        //CHILD 1
        for (int count = 0; count < M; count++) {
            wait(NULL); //wait for M child processes to finish 
        }


        // Read from pipe and sum 
        int total_sum = 0;
        int partial_sum;

        for (int count = 0; count < M; count++) {
            read(port[0], &partial_sum, sizeof(int));
            total_sum += partial_sum;
        }
        
        printf("child_1(PID %d): total sum = %d\n", getpid(), total_sum);
        printf("child_1(PID %d): child_1 completed\n\n", getpid());


    }



}