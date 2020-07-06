/*Matthew Loe
  Student ID: 19452425
  Date Created: 8/9/2018
  Date Last Modified: 8/9/2018 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main(String [] args)
    {
        DSAQueue<String> queue;
        DSABinarySearchTree<String> tree = new DSABinarySearchTree<String>();
        String file;
        int choice;
        boolean flag;
        
        flag = true;
    
        do
        {
            System.out.println("Menu Options");
            System.out.println(" 1: Read CSV File.\n 2: Read Serialized File");
            System.out.println(" 3: Display Tree\n 4: Write CSV File");
            System.out.println(" 5: Write Serialized File\n 6: Exit");
            choice = inputInteger("Select menu option 1-6: ");

            switch(choice)
            {
                case 1:
                {
                    file = inputString("Enter input file name: ");
                    tree = FileIO.readFile(file);
                    System.out.println("File read in.");
                    break;
                }
                case 2:
                {
                    file = inputString("Enter input file name: "); 
                    tree = DSABinarySearchTree.deserialize(file);
                    System.out.println("Tree deserialized.");
                    break;
                }
                case 3:
                {
                    try
                    {
                        displayTree(tree);
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    //END TRY-CATCH
                    break;
                }
                case 4:
                {
                    if (tree.min() == null)
                    {
                        System.out.println("No tree has been read in.");
                    }
                    else
                    {
                        file = inputString("Enter output file name: ");
                        FileIO.writeFileMain(file,tree);
                        System.out.println("Tree written to file.");
                    }
                    //END IF
                    break;
                }
                case 5:
                {
                    if (tree.min() == null)
                    {
                        System.out.println("No tree has been read in.");
                    }
                    else
                    {
                        file = inputString("Enter output file name: ");
                        DSABinarySearchTree.serialize(file,tree);
                        System.out.println("Tree serialized.");
                    }
                    //END IF
                    break;
                }
                case 6:
                {
                    System.out.println("Exiting program.");
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Invalid option.");
                    break;
                }
            }
            //END CASE
        }
        while (flag);
        //END DO-WHILE
    }


  /*Sub Moduel: displayTree
    I: tree (DSABinarySearchTree<String>)
    E: None */
    private static void displayTree(DSABinarySearchTree<String> tree)
    {
        DSAQueue<String> queue;
        int choice; 

        if (tree == null)
        {
            throw new IllegalArgumentException("No tree to display.");
        }
        else
        {
            System.out.println("\nDisplay Options");
            System.out.println(" 1: In-order\n 2: Pre-order\n 3: Post-order");
            System.out.println(" 4: Exit\n");
            choice = inputInteger("Select display option 1-4: ");

            switch(choice)
            {
                case 1:
                {
                    queue = tree.inOrder();
                    outputQueue(queue,tree);
                    break;
                }
                case 2:
                {
                    queue = tree.preOrder();
                    outputQueue(queue,tree);               
                    break;
                }
                case 3:
                {
                    queue = tree.postOrder();
                    outputQueue(queue,tree);
                    break;
                }
                case 4:
                {
                    System.out.println("Returning to main menu."); 
                    break;
                }
                default:
                {
                    System.out.println("Invalid display option.");
                    System.out.println("Returning to main menu.");
                    break;
                }
            }
            //END CASE
        }
        //END IF
    }

  /*Sub Module: outputQueue
    I: queue (DSAQueue<String>), tree (DSABinarySearchTree<String>)
    E: None */
    public static void outputQueue(DSAQueue<String> queue,
                                   DSABinarySearchTree<String> tree)
    {
        String key;

        while (queue.peek() != null)
        {
            key = queue.dequeue();
            System.out.println(key +","+ tree.find(key));
        }
        //END WHILE
    }

  /*Sub Module: inputInteger
    I: prompt (String)
    E: num (Integer) */
    public static int inputInteger(String prompt)
    {
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.println(prompt);
        num = sc.nextInt();

        return num;
    }

  /*Sub Module: inputString
    I: prompt (String)
    E: text (String) */
    public static String inputString(String prompt)
    {
        String text;
        Scanner sc = new Scanner(System.in);

        System.out.println(prompt);
        text = sc.next();

        return text;
    }

}




