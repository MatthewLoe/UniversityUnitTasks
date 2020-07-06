/*Matthew Loe
Student ID: 19452425
Date Created: 15/3/2018
Date Last Modified: 7/5/2018   */

import java.io.*;
import java.util.*;
public class ShapeCalculator
{
   public static void main(String [] args)
   {
      runShapeCalculator();
   }

/* SUB MODULE runShapeCaclculator
   I:None
   E:None  */
   public static void runShapeCalculator()
   {
      int selected, index, diameter, numLines;
      double width, length, base, height;
      String fileName;
      boolean loopExit = true;
      char[] arrayShape;
      double[] arrayArea;
      double[][] arrayDimension;
      do   //Loops code so user can continue to resuse till they wish to exit
      {
         selected = chooseShape(1,5);
         switch (selected)   //Case statement allowing for multiple possibilities to occur
         {
            case 1:
            {
               System.out.println("Circle"); 
               diameter = inputInteger("Enter diameter in centimeters as an integer.",0); 
               circleCalc(diameter);
               break;
            }
            case 2:
            {
               System.out.println("Rectangle"); 
               width = inputDouble("Enter width in centimeters as a real number.",0);
               length = inputDouble("Enter length in centimeters as a real number.",0);
               rectangleCalc(width,length);
               break;
            }
            case 3:
            {
               System.out.println("Triangle");
               base = inputDouble("Enter base in milimeters as a real number.",0.0);
               height = inputDouble("Enter height in milimeters as a real number.",0.0); 
               triangleCalc(base,height);
               break;
            }
            case 4:
            {
               fileName = inputString("Enter file name.");
               numLines = getNumLines(fileName);
               arrayShape = new  char [numLines];
               arrayDimension = new double [numLines][2];
               readFile(fileName, arrayShape, arrayDimension);
               index = 0;
               arrayArea = new double [numLines];
               do
               {
                  switch(arrayShape[index])
                  {
                     case 'C':
                     {
                        arrayArea[index] = calcAreaCircle((int)(arrayDimension[index][0]));
                        break;
                     }
                     case 'R':
                     {
                        arrayArea[index] = calcAreaRectangle(arrayDimension[index][0], arrayDimension[index][1]);
                        break;
                     }
                     case 'T':
                     {
                        arrayArea[index] = calcAreaTriangle(arrayDimension[index][0], arrayDimension[index][1]);
                        break;
                     }
                  }
                  // END CASE
                  index = index + 1;
               }
               while(index < numLines);
               // END DO-WHILE
               System.out.println("Finished Processing Areas.");
               writeFile(arrayShape, arrayArea, numLines);
               System.out.println("Finished Writing to File.");
               break;
            }
            case 5:
            {
               loopExit = false; //Changes boolean so the loop will exit
               System.out.println("Exiting program.");
               break;
            }
         }
         // END CASE
      }
      while (loopExit);
      // END DO-WHILE
   }

/* SUB MODULE chooseShape
   I: min (Integer), max (Integer)
   E: selected(Integer) */
   public static int chooseShape(int min, int max)
   {
      int selected=0;
      String error = "";
      Scanner sc = new Scanner(System.in);
      do       //Allows user to keep trying to enter the correct input
      {
         try                           //Prevents input of wrong data type
         {
            System.out.println(error);
            System.out.println("Available options Circle(1), Rectangle(2), Triangle(3), Input from File(4) and Exit(5).");
            System.out.println("Please enter the corresponding integer for your chosen option.");
            selected = sc.nextInt();
            error = "Option not in range.";
         }    
         catch (InputMismatchException e)   //Prevents input mismatch
         {
            String flush = sc.nextLine(); 
            error = "Selected option must be integer.";
         }
      }
      while ((selected < min) || (selected > max));
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
    I: diameter(Integer)
    E: None */
    public static void circleCalc(int diameter)
    {
       double areaCircle;
       areaCircle = calcAreaCircle(diameter);
       splitAndOutput(areaCircle,"Circle");
    } 

 /* Sub Module: rectangleCalc
    I: width(Real), length(Real)
    E: None */
    public static void rectangleCalc(double width, double length)
    {
       double areaRectangle;
       areaRectangle = calcAreaRectangle(width, length);
       splitAndOutput(areaRectangle,"Rectangle");
    }

 /* Sub Module: triangleCalc
    I: base(Real), height(Real)
    E: None */
    public static void triangleCalc(double base, double height)
    {
       double areaTriangle;
       /*Conversion of triangle input from milimetres to centimetres */
       base = base / 10;           
       height = height / 10;
       areaTriangle = calcAreaTriangle(base, height);
       splitAndOutput(areaTriangle, "Triangle");
    }

 /* Sub Module: inputInteger
    I:type (String), min (Integer)
    E:num (Integer) */
    public static int inputInteger(String type, int min)
    {
       int num = min;
       Scanner sc = new Scanner(System.in);
       String error = "";
       do             //Allows user to try entering the correct input
       {
          try                           //Prevents input of wrong data type
          {
             System.out.println(error);
             System.out.println(type);
             num = sc.nextInt();
             error = "Input not in valid range.";
          }
          catch (InputMismatchException e)
          {
             String flush = sc.nextLine();
             error = "Input must be integer.";
          }
       }
       while (num <= 0);
       return num;
    } 

 /* Sub Module: inputDouble
    I:type (String), min(Real)
    E:num (Real) */
    public static double inputDouble(String type, double min)
    {
       double num = min;
       String error = "";
       Scanner sc = new Scanner(System.in);
       do
       {
          try                           //Prevents input of wrong data type
          {
             System.out.println(error);
             System.out.println(type);
             num = sc.nextDouble();
             error = "Input not in valid range.";
          }
          catch (InputMismatchException e)
          {
             String flush = sc.nextLine();
             error = "Input must be real.";
          }
       }
       while (num <= 0.0);
       return num;
    }

//Sub Module getNumLines
//I: fileName (String)
//E: num (Integer)
//Assertion: Get number of lines in file
   public static int getNumLines(String fileName)
   {
      int num = 0;
      FileInputStream fileStrm = null;
      InputStreamReader rdr;
      BufferedReader bufRdr;
      String line;
      try
      {
         fileStrm = new FileInputStream(fileName);
         rdr = new InputStreamReader(fileStrm);
         bufRdr = new BufferedReader(rdr);
         line = bufRdr.readLine();
         while (line != null)
         {
            num = num + 1;
            line = bufRdr.readLine();
         }
         // ENDWHILE
         fileStrm.close();
      }

      catch(IOException e)
      {
         if(fileStrm != null)
         {
            try
            {
               fileStrm.close();
            }
            catch(IOException ex2)
            {
            }
         }
         System.out.println("Error in file processing: " + e.getMessage());   
      }

      return num;
   }

//Sub Module readFile
//I: fileName(String), arrayShape(Array of Character), arrayDimension(Array of Real)
//E: None 
//Assertion: Reads the file
   public static void readFile(String fileName, char[] arrayShape, double[][] arrayDimension)
   {
      FileInputStream fileStrm = null;
      InputStreamReader rdr;
      BufferedReader bufRdr;
      int lineNum = 0;
      String line;
      String[] text = new String [3]; 
      try
      {
         fileStrm = new FileInputStream(fileName);
         rdr = new InputStreamReader(fileStrm);
         bufRdr = new BufferedReader(rdr);
         line = bufRdr.readLine();         
         while (line != null)
         {
            text = processLine(line);
            arrayShape[lineNum] = text[0].charAt(0);
            if ((text[0].equals("R")) || (text[0].equals("T")))
            {
               if (validDimension(Double.parseDouble(text[1])) &&  validDimension(Double.parseDouble(text[2])))
               {
                  arrayDimension[lineNum][0] = Double.parseDouble(text[1]);
                  arrayDimension[lineNum][1] = Double.parseDouble(text[2]);
               }
               else
               {
                  throw new IllegalArgumentException();
               }
            }
            else if (text[0].equals("C"))
            {
               if (validDimension(Double.parseDouble(text[1])))
               {
                  arrayDimension[lineNum][0] = Double.parseDouble(text[1]);
               }
               else
               {
                  throw new IllegalArgumentException();
               }
            }
            else
            {
               throw new IllegalArgumentException();
            }
            lineNum = lineNum + 1;
            line = bufRdr.readLine(); 
         }
         // END WHILE
         fileStrm.close();
      }
      catch(IllegalArgumentException e)
      {
         if(fileStrm != null)
         {
            try
            {
               fileStrm.close();
            }
            catch(IOException ex2)
            {
            }
         }
         System.out.println("Invalid Shape or dimensions.");
      }
      catch(IOException e)
      {
         if(fileStrm != null)
         {
            try
            {
               fileStrm.close();
            }
            catch(IOException ex2)
            {
            }
         }
         System.out.println("Error while processing.");
      }
      //END TRY-CATCH
   }

//Sub Module processLine
//I: line(String)
//E: text(Array of String)
//Assertion: Process line of file
   public static String[] processLine(String line)
   {
      String[] text;
      text = line.split(",");
      return text;
   }

//Sub Module inputString
//I:prompt(String)
//E:text(String)
//Assertion:Gets user input of String
   public static String inputString(String prompt)
   {
      String text;
      Scanner sc = new Scanner(System.in);
      System.out.println(prompt);
      text = sc.nextLine();
      return text;
   }

//Sub Module writeFile
//I:arrayShape(Array of Character), arrayArea (Array of Real), numLines (Integer)
//E:None
//Assertion: Writes calculated output to a file
   public static void writeFile(char[] arrayShape, double[] arrayArea, int numLines)
   {
      FileOutputStream fileStrm = null;
      PrintWriter pw;
      try
      {
         fileStrm = new FileOutputStream("output.csv");
         pw = new PrintWriter(fileStrm);
         for (int count = 0; count < numLines; count++)
         {
            pw.println(arrayShape[count] +","+arrayArea);
         }
         // END FOR
         pw.close();
         fileStrm.close();
      }
      catch(IOException e)
      {
         if (fileStrm != null)
         {
            try
            {
               fileStrm.close();
            }
            catch(IOException ex2)
            {
            }
         }
         System.out.println("Error in writing to file.");
      }
   }

//Sub Module validDimension
//I:num (Real)
//E:valid(Boolean)
//Assertion:Validates the data
   public static boolean validDimension(double num)
   {
      boolean valid;
      if (num > 0.0)
      {
         valid = true;
      }
      else
      {
         valid = false;
      }
      return valid;
   }

}
