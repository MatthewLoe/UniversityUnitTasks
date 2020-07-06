/*Matthew Loe
  Student ID: 19452425
  Date Created: 14/9/2018
  Date Last Modified: 29/9/2018 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class FileIO
{
  /*Sub Module: readFile
    I: file (String), vertices (DSALinkedList<String>)
    E: None */
    public static void readFile(String file, DSALinkedList<String> vertices}
    {
        FileReader rdr;
        BufferedReader bufRdr;
        StringTokenizer strTok;
        String node, line;

        try
        {
            rdr = new FileReader(file);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
        
            while (line != null)   //Read in vertices
            {
                    vertices.insertLast(line);
                    line = bufRdr.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println("Error while reading file: "+e.getMessage());
        }
        //END TRY-CATCH    
        
    }

}



