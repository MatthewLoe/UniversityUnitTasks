/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 17/8/2018 */

import java.util.*;

public class DSAStack
{
  //Class Fields
    private Object[] stack;
    private int count;

  //Class Constants
    public static final int DEFAULTCAP = 100;

  //Default
    public DSAStack()
    {
        stack = new Object[DEFAULTCAP];
        count = 0;
    }

  //Alternate Constructor
    public DSAStack(int inCapacity)
    {
        stack = new Object[inCapacity];
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
        if (count == stack.length)
        {
            check = true;        
        }
        //END IF

        return check;
    }

  /*Sub Module: top
    I: None
    E: topObj (Object) */
    public Object top()
    {
        Object topObj;

        if (isEmpty())
        {
            throw new IllegalArgumentException("Stack empty");
        }
        else
        {
            topObj = stack[count - 1];
        }
        //END IF

        return topObj;
    }

  //Mutators
  /*Sub Module: push
    I: inObj (Object)
    E: None */
    public void push(Object inObj)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Stack full.");
        }
        else
        {
            stack[count] = inObj;
            count = count + 1;
        }
        //END IF
    }

  /*Sub Module: pop
    I: None
    E: topObj (Object) */
    public Object pop()
    {
        Object topObj;
        
        topObj = top();
        count = count - 1;
        
        return topObj;
    }

}



