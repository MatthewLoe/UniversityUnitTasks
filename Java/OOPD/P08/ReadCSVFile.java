/*Matthew Loe
  Student ID:19452425
  Date Created: 4/5/2018
  Date Last Modified: 5/5/2018  */

import java.io.*;
import java.util.*;
public class ReadCSVFile
{
   public static void main(String [] args)
   {
      boolean loopExit = true;
      char choice;
      String fileName;
      int numLines = 0;
      double [] studentMarks;
      String [] studentName;
      int [] indexArray;
      fileName = inputString("Enter file name.");
      numLines = getNumLines(fileName);
      if (!(numLines == 0))
      {
         studentName = new String [numLines];
         studentMarks = new double [numLines];
         readFile(fileName, studentName, studentMarks);
         do
         {
         choice = inputChar("Select an option: (D)isplay mark, (E)xit");
            switch (choice)
            {
               case 'D':
               {
                  indexArray = new int [numLines+1];
                  findStudent(studentName,indexArray);
                  if (!(indexArray[indexArray.length-1] == 0))
                  {
                     displayMark(studentName, studentMarks, indexArray);
                  }
                  else
                  {
                     System.out.println("Invalid name/does not exist.");
                  }
                  break;
               }
               case 'E':
               {
                  loopExit = false;
                  break;
               }
               default:
               {
                  System.out.println("Invalid Option.");
               }
            } //End Case 
         }
         while(loopExit);
         // End Do-While
      }
      else
      {
         System.out.println("Invalid file.\nExiting program.");
      }
   }
   //End Main

//Sub Module inputString
//I: prompt(String)
//E: text (String)
//Assertion: Gets string user input
   public static String inputString(String prompt)
   {
      String text;
      Scanner sc = new Scanner(System.in);
      System.out.println(prompt);
      text = sc.nextLine();
      return text;
   }

//Sub Module inputChar
//I: prompt(String)
//E: character(Character)
//Assertion:Gets character user input
   public static char inputChar(String prompt)
   {
      char character;   
      Scanner sc = new Scanner(System.in);
      try
      {
         System.out.println(prompt);
         character = sc.next().charAt(0);
      }
      catch(InputMismatchException e)
      {
         character = '1';
         System.out.println("Invalid data type.");
      }
      return character;
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
//I: fileName(String), studentName(Array of String), studentMarks(Array of Real)
//E: None 
//Assertion: Reads the file
   public static void readFile(String fileName, String [] studentName, double [] studentMarks)
   {
      FileInputStream fileStrm = null;
      InputStreamReader rdr;
      BufferedReader bufRdr;
      int lineNum = 0;
      String line;
      String[] text;
      
      try
      {
         fileStrm = new FileInputStream(fileName);
         rdr = new InputStreamReader(fileStrm);
         bufRdr = new BufferedReader(rdr);
         line = bufRdr.readLine();
         while (line != null)
         {
            text = processLine(line);
            studentName[lineNum] = text[0];
            studentMarks[lineNum] = Double.parseDouble(text[1]);
            lineNum = lineNum + 1;
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

//Sub Module findStudent
//I:studentName(Array of String), indexArray(Array of Integer)
//E:None
//Assertion:Finds student name, returning if it exists
   public static void findStudent(String[] studentName, int[] indexArray)
   {
      String name = inputString("Enter a name.");
      int count = 0;
      int index = 0;
      do
      {
         if (studentName[index].equals(name))
         {
            indexArray[count] = index;
            count = count + 1;
         }
         index = index + 1;   
      }
      while (index < studentName.length);
      indexArray[indexArray.length-1] = count;
   }

//Sub Module displayMark
//I: studentName(Array of String), studentMarks(Array of Real), indexArray(Array of Integer)
//E: None
//Assertion: Displays the mark
   public static void displayMark(String[] studentName, double[] studentMarks, int[] indexArray)
   {
      for (int count = 0; count <  indexArray[indexArray.length-1]; count++)
      {
         System.out.println("Student name: "+studentName[indexArray[count]]);
         System.out.println("Student mark: "+studentMarks[indexArray[count]]);
      }
   }

}
//End Class
