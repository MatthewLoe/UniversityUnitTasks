/*Matthew Loe
  Student ID:19452425
  Date Created:29/3/2018
  Date Last Modified:29/3/2018 */

import java.util.*;

public class DivisionChecker
{
   public static void main(String [] args)
   {
      divisionChecker();
   }

/* Sub Module divisionChecker
   I:None
   E:None
   Assertion: Runs program division checker */
   public static void divisionChecker()
   {
      int num1, num2, hold;
      boolean largest, result;
      num1 = inputInteger("Enter the first number.");
      num2 = inputInteger("Enter the second number.");
      System.out.println("Larger number will be divided by smaller number.");
      if ((num1 == 0) || (num2 == 0))  //Checks if entered numbers are 0
      {                               //Prevents giving a arithmetic error
         result = false;
      }
      else
      {
         largest = checkLarger(num1,num2);  //Checks if second number is larger than first
         if (largest)
         {                           //Switches the values of num1 and num2 around
            hold = num1;
            num1 = num2;
            num2 = hold;
         } 
         result = checkDivisible(num1,num2);
      }
      extractOutput(result,num1,num2);
   }

/* Sub Module inputInteger
   I:message (String)
   E:num (Integer)   
   Assertion: Gets user input for integers */
   public static int inputInteger(String message)
   {
      int num;
      Scanner sc = new Scanner(System.in);
      try                                 //Prevents wrong data type input errors
      {
         System.out.println(message);
         num = sc.nextInt();
      }
      catch (InputMismatchException e)
      {
         String flush = sc.nextLine();
         System.out.println("Input must be integer. Using default value of 5");
         num = 5;
      }
      return num;
   } 
 /* Sub Module checkLarger
    I:num1 (Integer), num2 (Integer)
    E:result (Boolean)   
    Assertion: Checks if num2 is larger than num1 */
    public static boolean checkLarger(int num1, int num2)
    {
       boolean result;
       if (num2 > num1)
       {
          result = true;
       }
       else
       {
          result = false;
       }
       return result;
    }
 
/* Sub Module checkDivisible
   I:num1 (Integer), num2 (Integer)
   E:result (Boolean)   
   Assertion: Checks if num1 is divisible by num2 */
   public static boolean checkDivisible(int num1, int num2)
   {
      boolean result;
      if (num1%num2 == 0)                   //Determines if divisible
      {
         result = true;
      }
      else
      {
         result = false;
      }
      return result;
   }
 
/* Sub Module extractOutput
   I:result (Boolean), num1 (Integer), num2 (Integer)
   E:None
   Assertion: Displays the out */
   public static void extractOutput(boolean result, int num1, int num2)
   {
      if (result)
      {
         System.out.println(num1+" is divisible by "+num2);
      }
      else
      {
         System.out.println(num1+" is not divisible by "+num2);
      }
   }
}
