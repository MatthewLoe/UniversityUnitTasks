/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/10/2018
  Date Last Modified: 17/10/2018 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class FileIO
{
  /*Sub Module: readFile
    I: file (String), list (DSALinkedList<String>)
    E: table (DSAHashTable) */
    public static DSAHashTable readFile(String file, DSALinkedList<String> list)
    {
        DSAHashTable table = new DSAHashTable(100);
        FileReader rdr;
        BufferedReader bufRdr;
        StringTokenizer strTok;
        String id;
        String name;
        String line;

        try
        {
            rdr = new FileReader(file);
            bufRdr = new BufferedReader(rdr);
            line = bufRdr.readLine();
            
            while (line != null)
            {
                strTok = new StringTokenizer(line,",");
                id = strTok.nextToken();
                name = strTok.nextToken();
                table.put(id,name);
                list.insertLast(id);
                line = bufRdr.readLine();
            }
            //END WHILE
            bufRdr.close();
        }
        catch (IOException e)
        {
            System.out.println("Error in reading file: "+e.getMessage());
        }
        //END TRY-CATCH

        return table;
    }

  /*Sub Module: writeFile
    I: file (String), table (DSAHashTable), list (DSALinkedList<String>)
    E: None */
    public static void writeFile(String file, DSAHashTable table,
                                 DSALinkedList<String> list)
    {
        FileWriter wtr;
        BufferedWriter bufWtr;
        Iterator<String> iter;
        String key;
        String str = "";

        try
        {
            wtr = new FileWriter(file);
            bufWtr = new BufferedWriter(wtr);
            iter = list.iterator();
            while (iter.hasNext())
            {
                key = iter.next();
                try
                {
                    str = String.valueOf(table.get(key));
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println("Invalid key");
                }
                //END TRY-CATCH
                bufWtr.write(key+","+str);
                str = "";
            }
            //END TRY-CATCH
            bufWtr.flush();
            bufWtr.close();
        }
        catch(IOException e)
        {
            System.out.println("Error in writing to file: "+e.getMessage());
        } 
        //END TRY-CATCH
    }
}


