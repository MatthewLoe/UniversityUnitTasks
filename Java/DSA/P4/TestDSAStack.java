/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 27/8/2018 */

import java.util.*;
import java.io.*;

public class TestDSAStack
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
        DSAStack<Calendar> stack;

        System.out.println("\nTesting Normal Conditions - Constructor\n");

        try
        {
            numTests++;
            System.out.println("Testing Creation of Default DSAStack");

            stack = new DSAStack<Calendar>();

            numPass++;
            System.out.println("Pass");

            numTests++;
            System.out.println("Testing Empty");            

            if (!(stack.isEmpty()))
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

            stack.push(cal);

            if (!(cal.equals(stack.top())))
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

            cal2 = stack.pop();
            
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

        stack = new DSAStack<Calendar>();
        
        try
        {
            numTests++;
            System.out.println("Testing top with empty stack");
            cal2 = stack.top();
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
            System.out.println("Testing pop empty stack");
            cal2 = stack.pop();
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


