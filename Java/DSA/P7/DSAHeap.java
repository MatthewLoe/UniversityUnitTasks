/*Matthew Loe
  Student ID: 19452425
  Date Created: 5/10/2018
  Date Last Modified: 5/10/2018 */

import java.util.*;
import java.lang.*;

public class DSAHeap
{
  //Class Fields
    private DSAHeapEntry[] heap;
    private int numItems;

  //Default
    public DSAHeap()
    {
        heap = new DSAHeapEntry[0];
        numItems = 0;
    }

  //Alternate
    public DSAHeap(int maxSize)
    {
        if (!checkInt(maxSize)) //Checks larger than 0
        {
            throw new IllegalArgumentException("Invalid size.");
        }
        //END IF        

        heap = new DSAHeapEntry[maxSize];
        numItems = 0;
    }

  /*Sub Module: add
    I: priority (Integer), value (Object)
    E: None */
    public void add(int priority, Object value)
    {
        DSAHeapEntry entry = new DSAHeapEntry(priority,value);

        if (!checkInt(priority))
        {
            throw new IllegalArgumentException("Invalid priority");
        }
        //END IF

        if (numItems < heap.length)
        {
            heap[numItems] = entry;
            trickleUp(numItems);
            numItems++;
        }
        else
        {
            System.out.println("Array filled.");
        }
        //END IF
    }

  /*Sub Module: remove
    I: None
    E: value (Object) */
    public Object remove()
    {
        DSAHeapEntry temp;
        Object value = null;

        if (numItems == 0)
        {
            System.out.println("No items.");
        }
        else
        {
            temp = heap[0];
            heap[0] = heap[numItems-1];
            numItems--;
            trickleDown(0);
            value = temp.value;
        }
        //END IF

        return value;
    }

  /*Sub Module: heapSort
    I: list (DSAHeapEntry[])
    E: None */
    public void heapSort(DSAHeapEntry[] list)
    {
        DSAHeapEntry temp;
        heap = list;
        numItems = heap.length;

        heapify();

        for (int ii = numItems - 1; ii >= 0; ii--)
        {
            temp = heap[ii];
            heap[ii] = heap[0];
            heap[0] = temp;
            trickleDown(ii);
        }
        //END FOR
    }

  /*Sub Module: heapify
    I: None
    E: None */
    private void heapify()
    {
        for (int ii = (numItems/2) - 1; ii >= 0; ii--)
        {
            trickleDown(ii); 
        }
        //END FOR
    }

  /*Sub Module: trickleUp
    I: idx (Integer)
    E: None */
    public void trickleUp(int idx)
    {
        trickleUpRecur(idx);
    }


  /*Sub Module: trickleUpRecur
    I: idx (Integer)
    E: None */
    private void trickleUpRecur(int idx)
    {
        int parentIdx;
        DSAHeapEntry temp;

        parentIdx = (idx - 1)/2;
        if (idx > 0)
        {
            if (heap[idx].priority > heap[parentIdx].priority)
            {
                temp = heap[parentIdx];
                heap[parentIdx] = heap[idx];
                heap[idx] = temp;
                trickleUpRecur(parentIdx);
            }
            //END IF
        }
        //END IF
    }

  /*Sub Module: trickleDown
    I: idx (Integer)
    E: None */
    private void trickleDown(int idx)
    {
        trickleDownRecur(idx);
    }

  /*Sub Module: trickleDownRecur
    I: idx (Integer)
    E: None */
    private void trickleDownRecur(int idx)
    {
        int leftIdx = idx * 2 + 1;
        int rightIdx = leftIdx + 1;
        int largeIdx = idx;
        DSAHeapEntry temp;

        if (leftIdx < numItems)
        {
            largeIdx = leftIdx;
            if (rightIdx < numItems)
            {
                if (heap[leftIdx].priority < heap[rightIdx].priority)
                {
                    largeIdx = rightIdx;
                }
                //END IF
            }
            //END IF
            
            if (heap[largeIdx].priority > heap[idx].priority)
            {
                temp = heap[idx];
                heap[idx] = heap[largeIdx];
                heap[largeIdx] = temp;
                trickleDownRecur(largeIdx);
            }
            //END IF
        }
        //END IF
    }

  /*Sub Module: checkInt
    I: num (Integer)
    E: check (Boolean) */
    private boolean checkInt(int num)
    {
        boolean check;

        check = (num > 0);

        return check;
    }

}

