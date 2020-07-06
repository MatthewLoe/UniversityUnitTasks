/*Matthew Loe
  Student ID: 19452425
  Date Created: 26/10/2018
  Date Last Modified: 26/10/2018 */

#include "Prac9.h"

int main(void)
{
    int time;
    int length = 10;
    int ii;
    int* ptrInt;
    void* ptr;
    void** array = (void**)malloc(sizeof(void*)*10);

    /*Testing Question 1 */
    printf("Testing wait function.\nEnter number of secs to sleep: ");
    scanf("%d",&time);            
    wait(time);

    /*Testing Question 2 */
    srand(10);

    for (ii = 0; ii < length; ii++)
    {
        ptrInt = (int*)malloc(sizeof(int));
        *ptrInt = ii;
        ptr = ptrInt;
        array[ii] = ptr;
    }
    /*END FOR */
    printf("\nExpected value is 5.");

    ptr = randomEle(array,length);
    
    printf("\nValue: %d\n", *((int*)ptr));


    /*Memory free */
    for (ii = 0; ii < length; ii++)
    {
        free(array[ii]);
        array[ii] = NULL;
    }
    /*END FOR */

    free(array);
    array = NULL;

    return 0;
}

