/*Matthew Loe
  Student ID: 19452425
  Date Created: 26/10/2018
  Date Last Modified: 26/10/2018 */

#include "Prac9.h"

/* Question 1
   Sub Module: randomEle
   I: array (Array of Void Pointers), length (Integer)
   E: element (Void Pointer) */
void* randomEle(void* array[], int length)
{
    int idx;
    void* element;
    int randNum = rand();

    idx = randNum % length; /*Makes idx within the array size */
    element = array[idx];

    return element;
}

/* Question 2
   Sub Module: wait
   I: secs (Integer)
   E: None */
void wait(int secs)
{
    time_t startTime = time(NULL);
    time_t endTime = startTime + (time_t)(secs);

    printf("Sleeping");

    while (time(NULL) < endTime)
    {
    }
    /*END WHILE */

    printf("\nWaking up.\n");
}

