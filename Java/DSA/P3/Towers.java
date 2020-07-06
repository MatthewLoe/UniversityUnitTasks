/*Matthew Loe
  Student ID: 19452425
  Date Created: 19/8/2018
  Date Last Modified: 19/8/2018 */

import java.util.*;

public class Towers
{

  /*Sub Module: towers
    I: n (Integer), src (Integer), dest (Integer)
    E: None */
    public static void towers(int n, int src, int dest)
    {
        int tmp;
        
        if (n == 1)
        {
            moveDisk(src,dest);
        }
        else
        {
            tmp = 6 - src - dest;
            towers(n-1, src,tmp);
            
            moveDisk(src,dest);
            towers(n-1, tmp, dest);
        }
        //END IF
    }

  /*Sub Module: moveDisk
    I: src (Integer), dest (Integer)
    E: None */
    private static void moveDisk(int src, int dest)
    {
        System.out.println("Moving top disk from peg "+src+" to peg "+dest+".");
    }

}



