/*Matthew Loe
  Student ID: 19452425
  Date Created: 27/9/2018
  Date Last Modified: 29/9/2018 */

import java.lang.*;
import java.util.*;

public class TestGraph
{
    public static void main(String args[])
    {
        //Test Counters
        int numTests = 0;
        int numPass = 0;

        //Test Variables
        DSAGraph graph;
        DSALinkedList<String> list;        
        Iterator<String> iter;
        String vector;
        int count;

        String[] graphADepth = {"(A,B)","(B,E)","(E,F)","(F,D)",
                                "(D,C)","(F,G)"};
        String[] graphABreadth = {"(A,B)","(A,E)","(A,D)","(A,C)",
                                   "(E,F)","(E,G)"};
        String[] graphBDepth = {"(A,B)","(B,E)","(E,D)","(D,F)","(F,C)",
                                "(F,I)","(I,H)","(H,G)","(G,J)"};
        String[] graphBBreadth = {"(A,B)","(A,C)","(A,D)","(B,E)","(C,F)",
                                  "(D,H)","(E,G)","(F,I)","(H,J)"};

        //Test Constructors
        try
        {
            System.out.println("Testing Default Constructor.");
            
            numTests++;
            graph = new DSAGraph();
            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH
        
        try
        {
            System.out.println("Testing Alternate Constructor.");
            System.out.println("Additional Testing addVertex and addLink methods.");
            
            numTests++;
            graph = new DSAGraph("prac6_1.al");
            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        graph = new DSAGraph("prac6_1.al");

        System.out.println("Supplied Input 1");

        try
        {
            System.out.println("Testing Adjacency List.");
            
            numTests++;
            graph.displayList();
            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {
            System.out.println("Testing Adjacency Matrix.");
            
            numTests++;
            graph.displayMatrix();
            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        graph = new DSAGraph("prac6_2.al");

        System.out.println("Supplied Input 2");

        try
        {
            System.out.println("Testing Adjacency List.");
            
            numTests++;
            graph.displayList();
            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {
            System.out.println("Testing Adjacency Matrix.");
            
            numTests++;
            graph.displayMatrix();
            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        graph = new DSAGraph("prac6_1.al");

        System.out.println("Activity 4 Graph A");

        try
        { 
            System.out.println("Testing Breadth Search.");

            numTests++;
            list = graph.breadthFirstSearch();
            iter = list.iterator();
            count = 0;

            while (iter.hasNext())
            {
                vector = iter.next();
                System.out.print(vector);
        
                if (!vector.equals(graphABreadth[count]))
                {
                    throw new Exception();
                }
                //END IF
                count++;
            }
            //END WHILE
            
            System.out.print("\n");

            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {
            System.out.println("Testing Depth Search.");

            numTests++;
            list = graph.depthFirstSearch();
            iter = list.iterator();
            count = 0;

            while(iter.hasNext())
            {
                vector = iter.next();
                System.out.print(vector);
        
                if (!vector.equals(graphADepth[count]))
                {
                    throw new Exception();
                }
                //END IF
                count++;
            }
            //END WHILE
            
            System.out.print("\n");

            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        graph = new DSAGraph("Act4b.txt");

        System.out.println("Activity 4 Graph B");

        try
        { 
            System.out.println("Testing Breadth Search.");

            numTests++;
            list = graph.breadthFirstSearch();
            iter = list.iterator();
            count = 0;

            while (iter.hasNext())
            {
                vector = iter.next();
                System.out.print(vector);
        
                if (!vector.equals(graphBBreadth[count]))
                {
                    throw new Exception();
                }
                //END IF
                count++;
            }
            //END WHILE
        
            System.out.print("\n");

            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {
            System.out.println("Testing Depth Search.");

            list = graph.depthFirstSearch();
            iter = list.iterator();
            count = 0;

            while(iter.hasNext())
            {
                vector = iter.next();
                System.out.print(vector);
        
                if (!vector.equals(graphBDepth[count]))
                {
                    throw new Exception();
                }
                //END IF
                count++;
            }
            //END WHILE

            System.out.print("\n");

            numPass++;
        }
        catch (Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH
    }
}


