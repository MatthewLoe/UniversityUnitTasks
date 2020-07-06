/*Matthew Loe
  Student ID:19452425
  Date Created:28/3/2018
  Date Last Modified: 30/3/2018 */

import java.util.*;
public class Calculate
{
    public static void main(String[] args)
    {
        char choice;
        int length, width;
        double area;

        length = inputInteger("Input the length");
        width = inputInteger("Input the width");

        choice = inputCharacter("Enter the units, Input M for Metres, or C for Centimetres");

        area = calcArea(length, width);

        switch (choice) /*Case statement that matches the character input from above to correct units for the outputted area */
        {
            case 'M':
                System.out.println("The area is " + area + " m^2");
                break;
            case 'C':
                System.out.println("The area is " + area + " cm^2.");
                break;
            default:
                System.out.println("You have entered a wrong letter!");
                break;
        }
    }
    
    /*Sub Module inputCharacter
      I:prompt (String)
      E:character (Character) */ 
    public static char inputCharacter(String prompt)  /*Gets user input of data type character */
    {
        char character;
        Scanner sc = new Scanner(System.in);
        try
        {  
            System.out.println(prompt);
            character = sc.next().charAt(0);
        }
        catch (InputMismatchException e)
        {
            String flush = sc.nextLine();
            System.out.println("Invalid option. Using default option centimetres.");
            character = 'C';
        }
        return character;
    }

    /*Sub Module inputInteger
      I:prompt (String)
      E:integer (Integer) */
    public static int inputInteger(String prompt) /*Gets users input of data type integer */
    {
        int integer;
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println(prompt);
            integer = sc.nextInt();
        }
        catch (InputMismatchException e)
        {
            String flush = sc.nextLine();
            System.out.println("Invalid input. Using default value of 25.");
            integer = 25;
        }
        return integer;
    }

    /*Sub Module calcArea
      I:length (Integer), width( Integer)
      E:area (double) */
    public static double calcArea(int length, int width) /*Calculates the area of a rectangle using length and width */
    {
        double area;
        area = (double)length * (double) width; /*Typecasts the length and width to make area of data type double */
        return area;
    }


}
