/*Matthew Loe
  Student ID:19452425
  Date Created: 19/4/2018
  Date Last Modified: 19/4/2018 */

import java.util.*;
public class TestTwo
{

   public static void main(String [] args)
   {
      int mark;
      String grade;
      int[] array = new int[3];
      array[0]=1;
      array[1]=2;
      array[2]=2;
      questionOne(array, 2);
      mark = inputInt("Input a mark.");
      grade = questionTwo(mark);
      if (!grade.equals(""))
      {
         System.out.println("Mark of "+mark+" gives a grade of "+grade);
      }
   }

   public static void questionOne(int[] array, int value)
   {
      int index = 0;
      while (index < array.length)
      {
         if (array[index]==(value))
         {
            System.out.println("Found value at index "+index);
         }
         //END IF
         index = index + 1;
      }
      //END WHILE
   }

   public static String questionTwo(int mark)
   {
      String grade = "";
      int newMark;
      if (mark > 100 || mark < 0)
      {
         System.out.println("Invalid Input.");
      }
      else
      {
         newMark = mark / 10;
         switch (newMark)
         {
            case 10: case 9: case 8:
            {
               grade = "High Distinction";
               break;
            }
            case 7:
            {
               grade = "Distinction";
               break;
            }
            case 6:
            {
               grade = "Credit";
               break;
            } 
            case 5:
            {
               grade = "Pass";
               break;
            }
            default:
            {
               grade = "Fail";
               break;
            }
         }
         //END CASE
      }
      //END IF
      return grade;
   }

   public static int inputInt(String prompt)
   {
      int num = -1;
      String error = "";
      boolean loopExit = true;
      Scanner sc = new Scanner(System.in);
      do
      {
         try
         {
            System.out.println(error);
            System.out.println(prompt);
            num = sc.nextInt();
            loopExit = false;
         }
         //END TRY
         catch (InputMismatchException e)
         {
            String flush = sc.nextLine();
            error = "Invalid input, wrong type.";
         }
         //END CATCH
      }
      while (loopExit);
      //END DO-WHILE
      return num;
   }
}
