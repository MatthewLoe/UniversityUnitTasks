/*Matthew Loe
  Student ID: 19452425
  Date Created: 7/9/2018
  Date Last Modified: 7/9/2018 */

import java.util.*;
import java.lang.*;

public class TestDSABinarySearchTree
{
    public static void main(String [] args)
    {
      //Test Counters
        int numPass = 0;
        int numTest = 0;

      //Test Variables
        DSABinarySearchTree<String> tree;
        String[] array = {"i","g","s","k","o","x","a","d","h",
                          "i","a","e","j","l","n","p","c"};
        String[] ordArr = {"a","c","d","e","g","h","i","j",
                           "k","l","n","o","p","s","x"};
        String[] preArr = {"i","g","a","d","c","e","h","s",
                           "k","j","o","l","n","p","x"};
        String[] postArr = {"c","e","d","a","h","g","j","n",
                            "l","p","o","k","x","s","i"};
        DSAQueue<String> queue;
        String obj = "Hello";
        int ii = 0;

        //Test Start
        System.out.println("Testing DSABinarySearchTree");

        try
        {
            try
            {
                numTest++;
                System.out.println("Testing Constructor");
                tree = new DSABinarySearchTree<String>();
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
                throw new Exception();
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Insert - Tests multiplitcity");
                for (int count = 0; count < array.length; count++)
                {
                    tree.insert(array[count], obj);
                }
                //END FOR
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
                throw new Exception();
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Find - Exists");
                if (!((tree.find("h")).equals(obj)))
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Find - Doesn't Exist");
                if (tree.find("b") != null)
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                numTest++; 
                System.out.println("Min");
                if (!((tree.min()).equals("a")))
                {
                    throw new Exception();
                }
                //END IF
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Height");
                if (tree.height() != 5)
                {
                    throw new Exception();
                }
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                ii = 0;
                numTest++;
                System.out.println("Inorder Traversal");
                queue = tree.inOrder();
                while (queue.peek() != null)
                {
                    if (!((queue.dequeue()).equals(ordArr[ii])))
                    {
                        throw new Exception();
                    }
                    //END IF
                    ii++;
                }
                //END WHILE
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                ii = 0;
                numTest++;
                System.out.println("Preoder Traversal");
                queue = tree.preOrder();
                while (queue.peek() != null)
                {
                    if (!((queue.dequeue()).equals(preArr[ii])))
                    {
                        throw new Exception();
                    }
                    //END IF
                    ii++;
                }
                //END WHILE
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                ii = 0;
                numTest++;
                System.out.println("Postorder Traversal");
                queue = tree.postOrder();
                while (queue.peek() != null)
                {
                    if (!((queue.dequeue()).equals(postArr[ii])))
                    {
                        throw new Exception();
                    }
                    //END IF
                    ii++;
               }
                //END WHILE
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH
        
            try
            {
                numTest++;
                System.out.println("Delete - No children");
                tree.delete("e");
                if(tree.find("e") != null)
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Delete - 1 child left");
                tree.delete("d");
                if(tree.find("d") != null && tree.find("c") == null)
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Delete - 1 child right");
                tree.delete("l");
                if(tree.find("l") != null && tree.find("n") == null)
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            try
            {
                numTest++;
                System.out.println("Delete - 2 children");
                tree.delete("k");
                if(tree.find("k") != null && (tree.find("p") == null ||
                                              tree.find("j") == null))
                {
                    System.out.println("Fail");
                }
                else
                {
                    numPass++;
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH
        }
        catch(Exception e)
        {
            System.out.println("Fail - Cannot continue testing");
        }
        //END TRY-CATCH
    }
}



