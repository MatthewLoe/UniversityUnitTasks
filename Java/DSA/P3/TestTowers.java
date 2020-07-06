/*Matthew Loe
  Student ID: 19452425
  Date Created: 19/8/2018
  Date Last Modified: 19/8/2018 */

import java.util.*;

public class TestTowers
{

    public static void main(String [] args)
    {
        //Test Counters
        int numPass = 0;
        int numTests = 0;

        //Test Constants
        int SRC = 1;
        int DEST = 3;

        //Test Variables
        int n = 0;
        int x = 0;

        try
        {
            //Testing Normal Conditions
            System.out.println("Testing Normal Conditions");
    
            numTests++;
            n = 3;
            Towers.towers(n, SRC, DEST);
            numPass++;

            //Testing Base Case
            System.out.print("Testing Base Case");
            
            numTests++;
            n = 1;
            Towers.towers(n, SRC, DEST);
            numPass++;

            //Testing when tmp less than 6
            System.out.println("Testing When Tmp Less Than 6");
    
            numTests++;
            n = 3;
            Towers.towers(n, 1, 7);
            numPass++;
           
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal argument");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }
        //END TRY-CATCH

    }

}



