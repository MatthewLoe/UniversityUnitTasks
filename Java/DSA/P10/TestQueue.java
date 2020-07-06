/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 1/11/2018 */

import java.util.*;
import java.io.*;

public class TestQueue
{
    
    public static void main(String [] args)
    {
        //Test Counters
        int numPass = 0;
        int numTests = 0;

        //Test Variables
        int count;
        Queue<String> queue;
        String str = "A";

        System.out.println("\nTesting Normal Conditions - Constructor\n");

        try
        {
            numTests++;
            System.out.println("Testing Creation of Default DSAQueue");

            queue = new LinkedList<String>();
            numPass++;

            numTests++;
            System.out.println("Testing remove when empty");            
        
            queue = new LinkedList<String>();   
            try
            {
                queue.remove();
                System.out.println("Fail");
            }
            catch(NoSuchElementException e)
            {
                numPass++;
            }
            //END TRY-CATCH 

            numTests++;
            System.out.println("Testing add and peek");            
            queue = new LinkedList<String>();

            try
            {
                queue.add("A");
                if (!str.equals(queue.peek()))
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            numTests++;
            System.out.println("Testing remove");        
            queue = new LinkedList<String>();
            queue.add("A");

            try
            {        
                if (!str.equals(queue.remove()))
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            System.out.println("\nNumTests: "+numTests);
            System.out.println("NumPass: "+numPass);
        }
        catch(Exception e)
        {
            System.out.println("Fail");            
        }
        //END TRY-CATCH
    }

}


