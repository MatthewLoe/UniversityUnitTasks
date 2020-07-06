/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 17/8/2018 */

import java.util.*;

public class DSAQueue
{
  //Class Fields
    private Object[] queue;
    private int count;

  //Class Constants
    public static final int DEFAULTCAP = 100;

  //Default
    public DSAQueue()
    {
        queue = new Object[DEFAULTCAP];
        count = 0;
    }

  //Alternate Constructor
    public DSAQueue(int inCapacity)
    {
        queue = new Object[inCapacity];
        count = 0;
    }

  //Getters
  /*Sub Module: getCount
    I: None
    E: count (Integer) */
    public int getCount()
    {
        return count;
    }

  /*Sub Module: isEmpty
    I: None
    E: check (Boolean) */
    public boolean isEmpty()
    {
        boolean check = false;
        
        if (count == 0)
        {
            check = true;
        }
        //END IF

        return check;
    }

  /*Sub Module: isFull
    I: None
    E: check (Boolean) */
    public boolean isFull()
    {
        boolean check = false;
        if (count == queue.length)
        {
            check = true;        
        }
        //END IF

        return check;
    }

  /*Sub Module: peek
    I: None
    E: topObj (Object) */
    public Object peek()
    {
        Object firObj;

        if (isEmpty())
        {
            throw new IllegalArgumentException("Queue empty");
        }
        else
        {
            firObj = queue[0];
        }
        //END IF

        return firObj;
    }

  //Mutators
  /*Sub Module: enqueue
    I: inObj (Object)
    E: None */
    public void enqueue(Object inObj)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Stack full.");
        }
        else
        {
            queue[count] = inObj;
            count = count + 1;
        }
        //END IF
    }

  /*Sub Module: dequeue
    I: None
    E: topObj (Object) */
    public Object dequeue()
    {
        Object firObj;
        
        firObj = peek();

        for (int ii = 1; ii < count; ii++)
        {
            queue[ii-1] = queue[ii];
        }
        //END FOR

        count = count - 1;
        
        return firObj;
    }

}



