/*Matthew Loe
  Student ID: 19452425
  Date Created: 12/10/2018
  Date Last Modified: 18/10/2018 */

import java.util.*;
import java.lang.*;

public class DSAHashTable
{
    //Class Constants
    public static final double LF = 0.6;

    //Class Fields
    private DSAHashEntry[] hashTable;
    private int numItems;

    //Alternate
    public DSAHashTable(int maxSize)
    {
        if (maxSize < 1)
        {
            throw new IllegalArgumentException("Invalid size.");
        }
        //END IF

        maxSize = nextPrime(maxSize);

        hashTable = new DSAHashEntry[maxSize];

        for (int ii = 0; ii < maxSize; ii++)
        {
            hashTable[ii] = new DSAHashEntry();
        }
        //END FOR

        numItems = 0;
    }

  /*Sub Module: put
    I: key (String), value (Object)
    E: None */
    public void put(String key, Object value)
    {
        DSAHashEntry entry = new DSAHashEntry(key,value);
 
        if (LF < ((double)(numItems)/(double)(hashTable.length)))
        {
            reSize(hashTable.length);
        }
        //END IF

        put(entry);
    }

  /*Sub Module: put
    I: entry (DSAHashEntry)
    E: None */
    private void put(DSAHashEntry entry)
    {
        String key = entry.getKey();
        int idx;
        boolean entered = true;

        idx = hash(key);
        do
        {        
            if (hashTable[idx].getState() == 0)
            {
                hashTable[idx] = entry;
                numItems++;
                entered = false;
            }
            else
            {
                if (idx == hashTable.length-1)
                {
                    idx = 0;
                }
                else
                {
                    idx++;
                }
                //END IF
            }
            //END IF
        }
        while (entered);
        //END DO-WHILE
    }

  /*Sub Module: get
    I: key (String)
    E: value (Object) 
    Note: needs try-catch for if not found in place of call*/
    public Object get(String key)
    {
        int idx;

        idx = find(key);

        return hashTable[idx].getValue();
    }

  /*Sub Module: remove
    I: key (String)
    E: value (Object)
    Note: needs try-catch for if not found in place of call*/
    public Object remove(String key)
    {
        int idx;
        Object value;

        if (LF < ((double)(numItems)/(double)(hashTable.length)))
        {
            reSize(hashTable.length);
        }
        //END IF

        idx = find(key);

        value = hashTable[idx].getValue();
        hashTable[idx].setState(-1);
        numItems--;

        return value;
    }

  /*Sub Module: containsKey
    I: key (String)
    E: check (Boolean) */
    public boolean containsKey(String key)
    {
        int idx;
        boolean check = false;

        try
        {
            idx = find(key);
            check = true;
        }
        catch(IllegalArgumentException e)
        {
            check = false;
        }
        //END TRY-CATCH
        
        return check;
    }

  /*Sub Module: find
    I: key (String)
    E: idx (Integer) */
    private int find(String key)
    {
        int idx, orgIdx;
        boolean found = false;
        boolean giveUp = false;

        idx = hash(key);
        orgIdx = idx - 1;
        
        do
        {
            if (hashTable[idx].getState() == 0)
            {
                giveUp = true;
            }
            else if (key.equals(hashTable[idx].getKey()))
            {
                found = true;
            }
            else
            {
                if (idx == orgIdx)
                {
                    giveUp = true;
                }
                else if (idx == hashTable.length-1)
                {
                    idx = 0;
                }
                else
                {
                    idx++;
                }
                //END IF
            }
            //END IF
        }
        while (!found && !giveUp);
        //END DO-WHILE

        if (!found)
        {
            throw new IllegalArgumentException("Invalid key.");
        }
        //END IF

        return idx;
    }

  /*Sub Module: reSize
    I: size (Integer)
    E: None */
    private void reSize(int size)
    {
        DSAHashEntry[] temp = hashTable;

        size = nextPrime(size * 2);

        hashTable = new DSAHashEntry[size];

        for (int ii = 0; ii < size; ii++)
        {
            hashTable[ii] = new DSAHashEntry();
        }
        //END FOR

        for (int ii = 0; ii < temp.length; ii++)
        {
            if (temp[ii].getState() == 1)
            {
                put(temp[ii].getKey(),temp[ii].getValue());
            }
            //END IF
        }
        //END FOR
    }

  /*Sub Module: hash
    I: key (String)
    E: idx (Integer) */
    private int hash(String key)
    {
        int idx = 0;

        for (int ii = 0; ii < key.length(); ii++)
        {
            idx = (11 * idx) + key.charAt(ii);
        }
        //END FOR

        return idx % hashTable.length;
    }

  /*Sub Module: nextPrime
    I: num (Integer)
    E: prime (Intger) */
    private int nextPrime(int num)
    {
        int prime, root, ii;
        boolean isPrime = false;

        if (num % 2 == 0)
        {
            prime = num + 1;
        }
        else
        {
            prime = num;
        }
        //END IF

        do
        {
            prime = prime + 2;
            ii = 3;
            isPrime = true;
            root =  (int)(Math.sqrt((double)(prime)));
            do
            {
                if (prime % ii == 0)
                {
                    isPrime = false;
                }
                else
                {
                    ii = ii + 2;
                }
                //END IF
            }
            while (ii <= root && isPrime);
            //END DO-WHILE
        }
        while (!isPrime);
        //END DO-WHILE
        
        return prime;
    }

    //INNER Class
    private class DSAHashEntry
    {
        //Class Fields
        private String key;
        private Object value;
        private int state;   //0=never used, 1=used, -1=formerly used

        //Default
        public DSAHashEntry()
        {
            key = "";
            value = null;
            state = 0;
        }

        //Alternate
        public DSAHashEntry(String inKey, Object inValue)
        {
            key = inKey;
            value = inValue;
            state = 1;
        }

      /*Sub Module: getKey
        I: None
        E: key (String) */
        public String getKey()
        {
            return key;
        }        
 
      /*Sub Module: getValue
        I: None
        E: value (Object) */
        public Object getValue()
        {
            return value;
        }               

      /*Sub Module: getState
        I: None
        E: state (Integer)*/
        public int getState()
        {
            return state;
        }        

      /*Sub Module: setState
        I: num (Integer)
        E: None */
        public void setState(int num)
        {
            state = num;
        }        
    }
    //END INNER Class
}

