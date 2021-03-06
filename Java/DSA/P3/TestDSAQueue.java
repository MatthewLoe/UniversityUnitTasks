/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 17/8/2018 */

import java.util.*;
import java.io.*;

public class TestDSAQueue
{
    
    public static void main(String [] args)
    {
        //Test Counters
        int numPass = 0;
        int numTests = 0;

        //Test Variables
        int count;
        Calendar cal = Calendar.getInstance();
        Calendar cal2;
        DSAQueue queue;

        System.out.println("\nTesting Normal Conditions - Constructor\n");

        try
        {
            numTests++;
            System.out.println("Testing Creation of Default DSAQueue");

            queue = new DSAQueue();

            numPass++;
            System.out.println("Pass");

            numTests++;
            System.out.println("Testing Creation of Alternate DSAQueue");

            count = 1;
            queue = new DSAQueue(count);

            numPass++;
            System.out.println("Pass");

            numTests++;
            System.out.println("Testing Queue Count");

            if (queue.getCount() != 0)
            {
                throw new IllegalArgumentException("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
            //END IF

            numTests++;
            System.out.println("Testing Empty");            

            if (!(queue.isEmpty()))
            {
                throw new IllegalArgumentException("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
            //END IF

            numTests++;
            System.out.println("Testing Push and Top");            

            queue.enqueue(cal);

            if (!(cal.equals((Calendar)(queue.peek()))))
            {
                throw new IllegalArgumentException("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
            //END IF

            numTests++;
            System.out.println("Testing Full");            

            if (!(queue.isFull()))
            {
                throw new IllegalArgumentException("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
            //END IF

            numTests++;
            System.out.println("Testing Pop");        

            cal2 = (Calendar)(queue.dequeue());
            
            if (!(cal2.equals(cal)))
            {
                throw new IllegalArgumentException("Fail");
            }
            else
            {
                numPass++;
                System.out.println("Pass");
            }
            //END IF

        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal argument: "+e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Failed");            
        }
        //END TRY-CATCH

        System.out.println("Testing Error Conditions");

        queue = new DSAQueue();
        
        try
        {
            numTests++;
            System.out.println("Testing peek with empty queue");
            cal2 = (Calendar)(queue.peek());
            System.out.println("Fail");
        }
        catch(Exception e)
        {
            numPass++;
            System.out.println("Pass");
        }
        //END TRY-CATCH

        try
        {
            numTests++;
            System.out.println("Testing dequeue empty queue");
            cal2 = (Calendar)(queue.dequeue());
            System.out.println("Fail");
        }
        catch(Exception e)
        {
            numPass++;
            System.out.println("Pass");
        }
        //END TRY-CATCH

        queue = new DSAQueue(1);

        try
        {
            numTests++;
            System.out.println("Testing enqueue on full queue");
            queue.enqueue(cal);
            queue.enqueue(cal);
            System.out.println("Fail");
        }
        catch(Exception e)
        {
            numPass++;
            System.out.println("Pass");
        }
        //END TRY-CATCH
    }

}


