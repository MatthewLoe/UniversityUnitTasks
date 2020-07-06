/*Matthew Loe
  Student ID: 19452425
  Date Created: 12/10/2018
  Date Last Modified: 1/11/2018 */

import java.util.*;
import java.lang.*;

public class TestHash
{
    public static void main(String[] args)
    {
        //Test Counters
        int numPass = 0;
        int numTests = 0;
    
        //Test Variables
        HashMap<String,String> hash;
        String[] arrayKey = {"1","3","5","7","9","11","13","15","17","1","3"};
        String[] arrayValue = {"A","B","C","D","E","F","G","H","I","J","K"};
        String str;
        int size = 10;
        int idx = 0;

        //Testing Alternate Constructor
        try
        {
            numTests++;
            System.out.println("Test alternate constructor");
            hash = new HashMap<String,String>(size);
            numPass++;
    
            //Testing Put
            try
            {
                numTests++;
                System.out.println("Test put");
                hash.put(arrayKey[idx],arrayValue[idx]);
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH
    
            //Testing Remove
            try
            {
                numTests++;
                System.out.println("Test remove");
                str = hash.remove(arrayKey[idx]);
                if (str.equals("A"))
                {
                    numPass++;
                }
                else
                {
                    System.out.println("Fail");
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH
    
            //Testing Remove - When Empty
            try
            {
                numTests++;
                hash = new HashMap<String,String>(10);
                System.out.println("Test remove - when empty");
                str = hash.remove(arrayKey[idx]);
                
                if (str == null)
                {
                    numPass++;
                }
                else
                {
                    System.out.println("Fail");
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH
    
            //Testing ContainsKey - True
            try
            {
                numTests++;
                System.out.println("Test containsKey - true");
                for (int ii = 0; ii < 3; ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR
    
                if (!hash.containsKey(arrayKey[1]))
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
    
            //Testing ContainsKey - False
            try
            {   
                numTests++;
                System.out.println("Test containsKey - false");
                for (int ii = 0; ii < 3; ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR

                if (hash.containsKey(arrayKey[4]))
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

            //Testing Get - Exists
            try
            {
                numTests++;
                System.out.println("Test get - exists");
                hash = new HashMap<String,String>(10);
                for (int ii = 0; ii < 3; ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR
    
                str = hash.get(arrayKey[idx]);
                if (str.equals("A"))
                {
                    numPass++;
                }
                else
                {
                    System.out.println("Fail");
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            //Testing Get - Doesn't Exist
            try
            {
                numTests++;
                System.out.println("Test get - Doesn't exist");
                hash = new HashMap<String,String>(10);
                for (int ii = 0; ii < 3; ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR
                
                str = hash.get(arrayKey[4]);
                if (str == null)
                {
                    numPass++;
                }
                else
                {
                    System.out.println("Fail");
                }
                //END IF
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            //Testing reSize
            try
            {
                numTests++;
                System.out.println("Test resize");
                hash = new HashMap<String,String>(10);
                for (int ii = 0; ii < 8;ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR
                numPass++;
            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH
            
            //Testing Duplicates
            try
            {
                numTests++;
                System.out.println("Test duplicates");
                hash = new HashMap<String,String>(10);
                for (int ii = 0; ii < arrayKey.length;ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR                
                numPass++;

            }
            catch(Exception e)
            {
                System.out.println("Fail");
            }
            //END TRY-CATCH

            System.out.println("\nNumTests: "+numTests);
            System.out.println("NumPass: "+numPass);
        }
        catch(Exception e)
        {
            System.out.println("Fail");
        }
        //TRY-CATCH
    }
}


