/*Matthew Loe
Student ID: 19452425
Date Created: 8/3/2018
Date Last Modified: 14/3/2018   */

import java.util.*;
public class CalcAreaShapes
{
   /*Main Method*/
   public static void main (String [] args)
   {
      int diameter;
      double width, length, base, height,areaCircle, areaRectangle, areaTriangle, meter, cent, mili;
      
      Scanner sc = new Scanner(System.in);
      /*Input*/
      System.out.println("Circle"); 
      System.out.println("Enter the diameter as an integer and in centimetres.");
      diameter = sc.nextInt(); 
      System.out.println("Rectangle"); 
      System.out.println("Enter the width as a real and in centimetres.");
      width = sc.nextDouble(); 
      System.out.println("Enter the length as a real and in centimetres.");
      length = sc.nextDouble();
      System.out.println("Triangle");
      System.out.println("Enter the base as a real and in milimeters.");
      base = sc.nextDouble(); 
      System.out.println("Enter the height as a real and in milimeters.");
      height = sc.nextDouble(); 

      /*Conversion of triangle input from milimetres to centimetres */
      base = base / 10;           
      height = height / 10;
      
      /*Calling of Submodules*/
      /*Calculates Area of Shape*/
      areaCircle = calcAreaCircle(diameter);
      areaRectangle = calcAreaRectangle(width, length);
      areaTriangle = calcAreaTriangle(base, height);
      
      /*Splits Area into Various Area Sizes and Outputs*/
      meter = splitMeter(areaCircle);
      cent = splitCent(areaCircle);
      mili = splitMili(areaCircle);
      System.out.println("Area of a circle is "+meter+"m^2, "+cent+"cm^2, "+mili+"mm^2.");

      meter = splitMeter(areaRectangle);
      cent = splitCent(areaRectangle);
      mili = splitMili(areaRectangle);
      System.out.println("Area of a rectangle is "+meter+"m^2, "+cent+"cm^2, "+mili+"mm^2.");

      meter = splitMeter(areaTriangle);
      cent = splitCent(areaTriangle);
      mili = splitMili(areaTriangle);
      System.out.println("Area of a triangle is "+meter+"m^2, "+cent+"cm^2, "+mili+"mm^2.");
   }

 /*Sub Module: calcAreaCircle
   I:diameter(Integer)
   E:area(Real)*/
   public static double calcAreaCircle(int diameter)
   {
    double radius, area;
    radius = (double)(diameter) / 2;
    return area = Math.PI * (Math.pow(radius,2));
   }

 /*Sub Module: calcAreaRectangle
   I:length(Real), width(Real)
   E:area(Real)*/    
   public static double calcAreaRectangle(double width, double length)
   {
    double area;      
    return area = width * length;
   }

 /*Sub Module: calcAreaTriangle
   I:base(Real), height(Real)
   E:area(Real)*/
   public static double calcAreaTriangle(double base, double height)
   {
    double area;
    return area = (base * height) / 2;
   }

 /*Sub Module: splitMeter
   I:area(Real)
   E:meter(Real)*/
   public static int splitMeter(double area)
   {
    int meter;
    return meter = (int)(area) / 10000;
   }

 /*Sub Module: splitCent
   I:area(Real)
   E:cent(Real)*/
   public static int splitCent(double area)
   {
    int cent;
    return (cent) = (int)(area) % 10000;
   }
 /*Sub Module: splitMili
   I:area(Real)
   E:mili(Real)*/
   public static int splitMili(double area)
   {
    double mili;
    mili =  (double)(area - (int)(area));
    return mili = mili * 100;
   }
}
