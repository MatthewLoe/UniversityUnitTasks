/*Matthew Loe
  Student ID: 19452425
  Date Created: 5/10/2018
  Date Last Modified: 5/10/2018 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class FileIO
{
  /*Sub Module: readFile
    I: file (String)
    E: heap (DSAHeap) */
    public static DSAHeap readFile(String file)
    {
        DSAHeap heap = null;
        FileReader rdr;
        BufferedReader bufRdr;
        String line;
        String[] txt;
        int numLines;

        try
        {
            try
            {
                numLines = getNumLines(file);
            }
            catch(IllegalArgumentException e)
            {
                throw new IOException();
            }
            //END TRY-CATCH
            heap = new DSAHeap(numLines);        
 
            rdr = new FileReader(file);
            bufRdr = new BufferedReader(rdr);
            
            line = bufRdr.readLine();
            
            while (line != null)
            {
                txt = line.split(",");
                
                try
                { 
                    heap.add(Integer.parseInt(txt[0]),txt[1]);
                }
                catch(NoSuchElementException e)
                {
                    System.out.println(line+" is invalid.");
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
                //END TRY-CATCH                

                line = bufRdr.readLine();

            }
            //END WHILE

        }
        catch(IOException e)
        {
            System.out.println("Error reading in file.");
        }
        //END TRY-CATCH    

        return heap;
    }

  /*Sub Module: arrayHeapEntry
    I: file (String)
    E: array (Array of DSAHeapEntry) */
    public static DSAHeapEntry[] arrayHeapEntry(String file)
    {
        FileReader rdr;
        BufferedReader bufRdr;
        DSAHeapEntry entry;
        DSAHeapEntry[] array = null;
        StringTokenizer strTok;
        int numLines;
        int count = 0;
        String line;
        String[] txt;

        try
        {
            try
            {
                numLines = getNumLines(file);
            }
            catch(IllegalArgumentException e)
            {
                throw new IOException();
            }
            //END TRY-CATCH
            array = new DSAHeapEntry[numLines];        
 
            rdr = new FileReader(file);
            bufRdr = new BufferedReader(rdr);
            
            line = bufRdr.readLine();
            
            while (line != null)
            {
                txt = line.split(",");
                
                try
                { 
                    entry = new DSAHeapEntry(Integer.parseInt(txt[0]),txt[1]);
                    array[count] = entry;
                    count ++;
                }
                catch(NoSuchElementException e)
                {
                    System.out.println(line+" is invalid.");
                }
                //END TRY-CATCH                
                
                line = bufRdr.readLine();

            }
            //END WHILE

        }
        catch(IOException e)
        {
            System.out.println("Error reading in file.");
        }
        //END TRY-CATCH    

        return array;       
    }

  /*Sub Module: getNumLines
    I: file (String)
    E: count (Integer) */
    private static int getNumLines(String file)
    {
        FileReader rdr;
        BufferedReader bufRdr;
        int count = 0;
        String line;

        try
        {
            rdr = new FileReader(file);
            bufRdr = new BufferedReader(rdr);
            
            line = bufRdr.readLine();
            
            while (line != null)
            {
                count++;
                line = bufRdr.readLine();
            }
            //END WHILE
        }
        catch(IOException e)
        {
            throw new IllegalArgumentException();
        }
        //END TRY-CATCH

        return count;
    }

}


