/*Matthew Loe
Student ID: 19452425
Date Created: 15/3/2018
Date Last Modified: 30/3/2018   */

import java.util.*;
public class ShapeCalculator
{
   public static void main(String [] args)
   {
      int value;
      do               //do while loop allows user to use program multiple times
      {
         value = runShapeCalculator();
      }
      while (value != 0);
   }

/* SUB MODULE runShapeCaclculator
   I:None
   E:value (Integer) */
   public static int runShapeCalculator()
   {
      int selected, value;
      selected = chooseShape();
      value = 1;
      switch (selected)   //Case statement allowing for multiple possibilities to occur
      {
         case 1:
         {
            circleCalc();
            break;
         }
         case 2:
         {
            rectangleCalc();
            break;
         }
         case 3:
         {
            triangleCalc();
            break;
         }
         case 4:
         {
            value = 0;
            System.out.println("Exiting program.");
            break;
         }
         default:
         {
            System.out.println("Invalid option.Please choose again.");
            break;
         }
      }
      return value;
   }

/* SUB MODULE chooseShape
   I: None
   E: selected(Integer) */
   public static int chooseShape()
   {
      int selected;
      Scanner sc = new Scanner(System.in);
      try                           //Prevents input of wrong data type
      {
         System.out.println("Available options Circle(1), Rectangle(2), Triangle(3) and Exit(4).");
         System.out.println("Please enter the corresponding integer for your chosen option.");
         selected = sc.nextInt();
      }    
      catch (InputMismatchException e)
      {
         String flush = sc.nextLine();
         System.out.println("Selected option must be integer. Using default option 1 (Circle)");
         selected = 1;
      }
      return selected;
   }

 /* Sub Module: calcAreaCircle
    I:diameter(Integer)
    E:area(Real)*/
    public static double calcAreaCircle(int diameter)
    {
       double radius, area;
       radius = (double)(diameter) / 2;
       return area = Math.PI * (Math.pow(radius,2));
    }

 /* Sub Module: calcAreaRectangle
    I:length(Real), width(Real)
    E:area(Real)*/    
    public static double calcAreaRectangle(double width, double length)
    {
       double area;      
       return area = width * length;
    }

 /* Sub Module: calcAreaTriangle
    I:base(Real), height(Real)
    E:area(Real)*/
    public static double calcAreaTriangle(double base, double height)
    {
       double area;
       return area = (base * height) / 2;
    }

 /* Sub Module: splitAndOutput
    I:area(Real), shape(String)
    E:None */
    public static void splitAndOutput(double area, String shape)
    { 
       int meter,cent;
       double mili;
       meter = (int)(area) / 10000;
       cent = (int)(area) % 10000;
       mili =  (double)(area - (int)(area));
       mili = (double)((int)(mili * 10000))/100;
       System.out.println("Area of "+shape+" is "+meter+"m^2, "+cent+"cm^2, "+mili+"mm^2.");
    }
    
 /* Sub Module: circleCalc
    I: None
    E: None */
    public static void circleCalc()
    {
       int diameter;
       double areaCircle;
       System.out.println("Circle"); 
       diameter = inputInteger("Enter diameter in centimeters as an integer."); 
       areaCircle = calcAreaCircle(diameter);
       splitAndOutput(areaCircle,"Circle");
    } 

 /* Sub Module: rectangleCalc
    I: None
    E: None */
    public static void rectangleCalc()
    {
       double width, length, areaRectangle;
       System.out.println("Rectangle"); 
       width = inputDouble("Enter width in centimeters as a real number.");
       length = inputDouble("Enter length in centimeters as a real number.");
       areaRectangle = calcAreaRectangle(width, length);
       splitAndOutput(areaRectangle,"Rectangle");
    }

 /* Sub Module: triangleCalc
    I: None
    E: None */
    public static void triangleCalc()
    {
       double base, height, areaTriangle;
       System.out.println("Triangle");
       base = inputDouble("Enter base in milimeters as a real number.");
       height = inputDouble("Enter height in milimeters as a real number."); 
       /*Conversion of triangle input from milimetres to centimetres */
       base = base / 10;           
       height = height / 10;
       areaTriangle = calcAreaTriangle(base, height);
       splitAndOutput(areaTriangle, "Triangle");
    }

 /* Sub Module: inputInteger
    I:type (String)
    E:num (Integer) */
    public static int inputInteger(String type)
    {
       int num;
       Scanner sc = new Scanner(System.in);
       try                           //Prevents input of wrong data type
       {
          System.out.println(type);
          num = sc.nextInt();
       }
       catch (InputMismatchException e)
       {
          String flush = sc.nextLine();
          System.out.println("Input must be integer. Using default value of 25");
          num = 25;
       }
       return num;
    } 

 /* Sub Module: inputDouble
    I:type (String)
    E:num (Real) */
    public static double inputDouble(String type)
    {
       double num;
       Scanner sc = new Scanner(System.in);
       try                           //Prevents input of wrong data type
       {
          System.out.println(type);
          num = sc.nextDouble();
       }
       catch (InputMismatchException e)
       {
          String flush = sc.nextLine();
          System.out.println("Input must be real. Using default value of 25.0");
          num = 25.0;
       }
       return num;
    }
}
