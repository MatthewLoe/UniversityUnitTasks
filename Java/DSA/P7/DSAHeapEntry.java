/*Matthew Loe
  Student ID: 19452425
  Date Created: 10/10/2018
  Date Last Modified: 10/10/2018 */


import java.lang.*;
import java.util.*;

public class DSAHeapEntry
{
  //Class Fields
    public int priority;
    public Object value;

  //Alternate
    public DSAHeapEntry(int inPriority, Object inValue)
    {
        if (!checkInt(inPriority))
        {
            throw new IllegalArgumentException("Invalid priority.");
        }
        //END IF

        priority = inPriority;
        value = inValue;
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

