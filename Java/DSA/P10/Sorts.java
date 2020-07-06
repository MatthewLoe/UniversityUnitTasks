/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts   //Coded from psuedocode of DSA lecture 2 on sorting
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
        int temp, pass;
        boolean sorted;
        
        pass = 0;    
    
        do //Loop to completely sort the array
        {
            sorted = true;
            for (int ii = 0; ii < (A.length - 1 - pass); ii++) //Loop allows
            {                                                //sorting of value
                                                             //to correct place
                if (A[ii] > A[ii+1]) 
                {
                    temp = A[ii];     //Swaps larger A[ii]
                    A[ii] = A[ii+1];  //with smaller A[ii+1]
                    A[ii+1] = temp;
                    sorted = false;
                }
                //END IF 
            }
            //END FOR
            pass = pass + 1; //Counter records number of sorted values
        }
        while (!sorted);
        //END DO-WHILE

    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int minIdx, temp;

        for (int nn = 0; nn < A.length; nn++) 
        {
            minIdx = nn;

            for(int jj = nn + 1; jj < A.length; jj++) //Loops through excluding
            {                                         //A[0]
                if (A[jj] < A[minIdx])
                {
                    minIdx = jj; //Stores index of smallest value
                }
                //END IF
            }
            //END FOR
            
            temp = A[minIdx];   //Swaps found smallest value with A[minIdx] 
            A[minIdx] = A[nn];
            A[nn] = temp;
        }
        //END FOR

    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int temp, ii;
    
        for (int nn = 1; nn < A.length; nn++) 
        {
            ii = nn;
            temp = A[ii]; //Records last value

            while (ii > 0 && A[ii-1] > temp) //Checks value against sorted values
            {
                A[ii] = A[ii-1];  //Shuffle until correct location
                ii = ii - 1;
            }
            //END WHILE
            A[ii] = temp; 
        }
        //END FOR

    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    
        mergeSortRecurse(A, 0, A.length-1);
 
    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int midIdx;

        if (leftIdx < rightIdx) //Checks larger than one element
        {
            midIdx = (leftIdx + rightIdx) / 2; //Gets middle index

            mergeSortRecurse(A, leftIdx, midIdx);            
            mergeSortRecurse(A, midIdx + 1, rightIdx);
 
            merge(A, leftIdx, midIdx, rightIdx);
        }
        //END IF
 
    }//mergeSortRecurse()

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int[] tempArr = new int[(rightIdx - leftIdx + 1)];
        int ii = leftIdx; 
        int jj = midIdx + 1; 
        int kk = 0;

        while (ii <= midIdx && jj <= rightIdx)
        {
            if (A[ii] <= A[jj])  //Checks which value of sub arrays is smaller
            {
                tempArr[kk] = A[ii]; //Assign from left
                ii = ii + 1;
            }
            else
            {
                tempArr[kk] = A[jj]; //Assign from right
                jj = jj + 1;
            }
            //END IF

            kk = kk + 1;
        }
        //END WHILE

        for (ii = ii; ii <= midIdx; ii++)  //Sorts in rest of left array
        {
            tempArr[kk] = A[ii];
            kk = kk + 1;
        }
        //END FOR

        for (jj = jj; jj <= rightIdx; jj++) //Sorts in rest of right array
        {
            tempArr[kk] = A[jj];
            kk = kk + 1;
        }
        //END FOR

        for (kk = leftIdx; kk <= rightIdx; kk++) //Copies sorted array to orignal
        {                                        //array
            A[kk] = tempArr[kk - leftIdx];
        }
        //END FOR

    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {

        quickSortRecurse(A, 0, A.length - 1);

    }//quickSort()

    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx, newPivotIdx;
       
        if(rightIdx > leftIdx)  //Checks array is larger than one
        {
            pivotIdx = (leftIdx + rightIdx) / 2;  
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

            quickSortRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRecurse(A, newPivotIdx + 1, rightIdx);
        }
        //END IF

    }//quickSortRecurse()

    private static int doPartitioning(int[] A, int leftIdx, int rightIdx,
                                      int pivotIdx)
    {
        int pivotVal, newPivotIdx, temp, currIdx;

        pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx]; //Swap pivot value with rightmost value
        A[rightIdx] = pivotVal;

        currIdx = leftIdx;

        for (int ii = leftIdx; ii < rightIdx; ii++) //Loops through array
        {
            if(A[ii] < pivotVal) //Checks if smaller than pivot
            {
                temp = A[ii];
                A[ii] = A[currIdx];  //Places value in left side of array
                A[currIdx] = temp;
                currIdx = currIdx + 1;
            }
            //END IF
        }
        //END For

        newPivotIdx = currIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;

		return newPivotIdx;
    }//doPartitioning


    //Shell Sort
    public static void shellSort(int[] A)
    {
        int interval = 1;
        int inner = 0;
        int value;

        while (interval < A.length / 3) //Calculates largest interval
        {
            interval = interval * 3 + 1;
        }
        //END WHILE

        while (interval > 0)
        {

            for (int outer = interval; outer < A.length; outer++)
            {
                value = A[outer];
                inner = outer;
                while (inner > interval - 1 && A[inner - interval] >= value)
                {
                    A[inner] = A[inner - interval];
                    inner = inner - interval;
                }
                //END WHILE

                A[inner] = value;
            }
            //END FOR

            interval = (interval - 1) / 3;
        }
        //END WHILE

    }//END SHELL SORT

    //Count sort
    public static void countSort(int[] A)
    {
        int[] count = new int[A.length+1];
        int[] idx = new int[A.length+1];
        int counter = 0;
        int kk = 0;

        for (int ii = 0; ii < A.length+1; ii++)
        {
            idx[ii] = ii;
            count[ii] = 0;
        }
        //END FOR

        for (int ii = 0; ii < A.length; ii++)
        {
            count[A[ii]]++;
        }
        //END FOR

        do
        {
            if (count[counter] != 0)
            {
                A[kk] = idx[counter];
                count[counter]--;
                kk++;
            }
            else
            {
                counter++;
            }
            //END IF
        }
        while (kk < A.length);
        //END DO-WHILE

    }//END COUNT SORT

    //Radix Sort LSD
    public static void radixSort(int[] A)
    {
        int largest = getMax(A);

        for (int exp = 1; largest/exp > 0; exp= exp*10)
        {
            countSortRadix(A,exp);
        }
        //END FOR

    }//END RADIX SORT LSD

    //getMax
    private static int getMax(int[] A)
    {
        int max = A[0];

        for (int ii = 1; ii < A.length; ii++)
        {
            if (max < A[ii])
            {
                max = A[ii];
            }
            //END IF
        }
        //END FOR
        return max;
    }//END getMax

    //Count sort radix
    private static void countSortRadix(int[] A, int exp)
    {
        int[] count = new int[A.length+1];
        int[] idx = new int[A.length+1];
        int counter = 0;
        int kk = 0;

        for (int ii = 0; ii < A.length+1; ii++)
        {
            idx[ii] = ii;
            count[ii] = 0;
        }
        //END FOR

        for (int ii = 0; ii < A.length; ii++)
        {
            count[(A[ii]/exp%10)]++;
        }
        //END FOR

        do
        {
            if (count[counter] != 0)
            {
                A[kk] = idx[counter];
                count[counter]--;
                kk++;
            }
            else
            {
                counter++;
            }
            //END IF
        }
        while (kk < A.length);
        //END DO-WHILE

    }//END COUNT SORT RADIX

}//end Sorts calss
