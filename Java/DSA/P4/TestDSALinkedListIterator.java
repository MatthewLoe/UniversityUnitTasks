/*Matthew Loe
  Student ID: 19452425
  Date Created: 24/8/2018
  Date Last Modified: 24/8/2018 */

import java.util.*;
import java.io.*;

public class TestDSALinkedListIterator
{
    public void main(String [] args)
    {
        //Test Counters
        int numPass = 0;
        int numTest = 0;
        
        //Test Variables
        DSALinkedList<Double> theList = new DSALinkedList<Double>();
        Iterator iter;
        Object obj;
        Double node = new Double(5);
        
        //Testing
        try
        {
            System.out.println("Testing Iterator Construction");
            numTest++;
            iter = theList.iterator();
            numPass++;
            System.out.println("Pass");

            System.out.println("Testing remove method");
            numTest++;
            try
            {
                iter.remove();
                System.out.println("Failed");
            }
            catch(UnsupportedOperationException e)
            {
                System.out.println("Pass");
                numPass++;
            }
            //END TRY-CATCH 

            System.out.println("Testing hasNext - False");
            numTest++;

            if (iter.hasNext())
            {
                System.out.println("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
            //END IF

            System.out.println("Testing next - Empty");
            numTest++;

            if (iter.next() == null)
            {
                numPass++;
                System.out.println("Pass");
            }
            else
            {
                System.out.println("Fail");
            }

            System.out.println("Testing hasNext - True");
            numTest++;
            theList.insertFirst(node);
            iter = theList.iterator();

            if (iter.hasNext())
            {
                numPass++;
                System.out.println("Pass");
            }
            else
            {
                System.out.println("Fail");
            }
            //END IF

            System.out.println("Testing next - Not Empty");
            numTest++;

            if (iter.next() == null)
            {
                System.out.println("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal Argument: "+e.getMessage());
        }
        catch(UnsupportedOperationException e)
        {
            System.out.println("Unsupported Operation: "+e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }
        //END TRY-CATCH
    }

}




