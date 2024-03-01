
#include<stdio.h>
#define N 5

int getThree(void){
    double d = 3.5;
    return d;
}
int main(void) {


    int a[3] = {0, 1, 2};
    int *p;
    p = a;

    if (p[0] == a[0]) printf("1");
    if (p == a[0]) printf("2");
    if (p == &a[0]) printf("3");
    if (*p == a[0]) printf("4");
    
    
    

}