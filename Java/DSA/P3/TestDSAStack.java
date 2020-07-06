/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 17/8/2018 */

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
        DSAStack stack;

        System.out.println("\nTesting Normal Conditions - Constructor\n");

        try
        {
            numTests++;
            System.out.println("Testing Creation of Default DSAStack");

            stack = new DSAStack();

            numPass++;
            System.out.println("Pass");

            numTests++;
            System.out.println("Testing Creation of Alternate DSAStack");

            count = 1;
            stack = new DSAStack(count);

            numPass++;
            System.out.println("Pass");

            numTests++;
            System.out.println("Testing Stack Count");

            if (stack.getCount() != 0)
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

            if (!(cal.equals((Calendar)(stack.top()))))
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

            if (!(stack.isFull()))
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

            cal2 = (Calendar)(stack.pop());
            
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

        stack = new DSAStack();
        
        try
        {
            numTests++;
            System.out.println("Testing top with empty stack");
            cal2 = (Calendar)(stack.top());
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
            cal2 = (Calendar)(stack.pop());
            System.out.println("Fail");
        }
        catch(Exception e)
        {
            numPass++;
            System.out.println("Pass");
        }
        //END TRY-CATCH

        stack = new DSAStack(1);

        try
        {
            numTests++;
            System.out.println("Testing push on full stack");
            stack.push(cal);
            stack.push(cal);
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


