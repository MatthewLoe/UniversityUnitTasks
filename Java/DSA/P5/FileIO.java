/*Matthew Loe
  Student ID: 19452425
  Date Created: 8/9/2018
  Date Last Modified: 8/9/2018 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class FileIO
{
  /*Sub Module: readFile
    I: file (String)
    E: tree (DSABinarySearchTree<String>) */
    public static DSABinarySearchTree<String> readFile(String file)
    {
        FileReader rdr;
        BufferedReader bufRdr;
        DSABinarySearchTree<String> tree = new DSABinarySearchTree<String>();
        StringTokenizer strTok;
        String line, token;
        
        try
        {
            rdr = new FileReader(file);
            bufRdr = new BufferedReader(rdr);
        
            line = bufRdr.readLine();

            while (line != null)
            {
                try
                {
                    strTok = new StringTokenizer(line,",");
                    token = strTok.nextToken();
                    tree.insert(token,strTok.nextToken());
                }
                catch(NoSuchElementException e)
                {
                }
                //END TRY-CATCH
                
                line = bufRdr.readLine();
            }
            //END WHILE
            
            bufRdr.close();
        }
        catch(IOException e)
        {
            System.out.println("Error while reading file: "+e.getMessage());
        }    
        //END TRY-CATCH

        return tree;
    }

  /*Sub Module: writeFileMain
    I: file (String), tree (DSABinarySearchTree<String>)
    E: None */
    public static void writeFileMain(String file,
                                     DSABinarySearchTree<String> tree)
    {
        DSAQueue<String> queue;
        int choice;

        System.out.println("\nWrite Options");
        System.out.println(" 1: In-order\n 2: Pre-order\n 3: Post-order");
        System.out.println(" 4: Exit\n");
        choice = Main.inputInteger("Select write option 1-4: ");

        switch(choice)
        {
            case 1:
            {
                queue = tree.inOrder();
                writeFile(file,queue,tree);
                break;
            }
            case 2:
            {
                queue = tree.preOrder();
                writeFile(file,queue,tree);               
                break;
            }
            case 3:
            {
                queue = tree.postOrder();
                writeFile(file,queue,tree);
                break;
            }
            case 4:
            {
                System.out.println("Returning to main menu."); 
                break;
            }
            default:
            {
                System.out.println("Invalid write option.");
                System.out.println("Returning to main menu.");
                break;
            }
        }
        //END CASE
    }

  /*Sub Module: writeFile
    I: file(String), queue(DSAQueue<String>), tree(DSABinarySearchTree<String>)
    E: None */
    private static void writeFile(String file, DSAQueue<String> queue,
                                  DSABinarySearchTree<String> tree)
    {
        FileWriter wtr;
        String key;

        try
        {
            wtr = new FileWriter(file);
            
            while (queue.peek() != null)
            {
                key = queue.dequeue();
                wtr.write(key+","+tree.find(key)+"\n");
            }
            //END WHILE

            wtr.close();
        }
        catch(IOException e)
        {
            System.out.println("Error in writing to file: "+e.getMessage());
        }
        //END TRY-CATCH
    }

}



