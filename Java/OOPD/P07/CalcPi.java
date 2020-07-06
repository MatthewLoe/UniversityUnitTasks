/*Matthew Loe
  Student ID:19452425
  Date Created:20/4/2018
  Date Last Modified:20/4/2018 */

import java.util.*;
public class CalcPi
{
   public static void main(String [] args)
   {
      int numTerms, index;
      double[] array;
      numTerms = inputInt("Enter number of terms.", 20, 100);
      array = new double[numTerms+2];
      index = 0;
      do
      {
         array[index] = calcTerm(index);
         index = index + 1;
      }
      while (index <= numTerms);
      //END DO-WHILE
      array[array.length-1] = calcFinalValue(array);
      for (int count = 0; (count < array.length); count++)
      {
         if (count == (array.length -1))
         {
            System.out.println("The final value is "+array[count]);
         }
         else
         {
            System.out.println("The "+(count)+"th term is "+array[count]);
         }
       //END IF 
      }
    //END FOR 
   }
 //END Main

/*Sub Module inputInt
  I:prompt(String), min(Integer), max(Integer)
  E:num(Integer)
  Assertion:Gets input of integer datatype */
   public static int inputInt(String prompt, int min, int max)
   {
      int num;
      String error = "";
      num = min - 1;
      Scanner sc = new Scanner(System.in);
      do
      {
         try
         {
            System.out.println(error);
            System.out.println(prompt);
            num = sc.nextInt();
            error = "Invalid input, outside of range ("+min+"-"+max+").";
        } 
        catch (InputMismatchException e)
        {
            String flush = sc.nextLine();
            error = "Invalid input, wrong datatype.";
        }
      //END TRY-CATCH
      }
      while ((num < min) || (num > max));
    //END DO-WHILE
      return num;
   }

/*Sub Module calcTerm
  I:index(Integer)
  E:num(Real)
  Assertion:Calculates the value of the term */
  public static double calcTerm(int index)
  {
     double num;
     num = (double)(Math.pow(-1,index));
     num = (double)(num / (((2 * index) + 1) * Math.pow(3,index)));
     return num;
  }

/*Sub Module calcFinalValue
  I:array(Array of Real)
  E:num(Real)
  Assertion:Calculates the final value of Pi  */
   public static double calcFinalValue(double[] array)
   {
      double num = 0;
      for (int index = 0; index < array.length; index++)
      {
         num = num + array[index];
      }
    //END FOR
      num = num * Math.sqrt(12);
      return num;
   }

}
//END Class
