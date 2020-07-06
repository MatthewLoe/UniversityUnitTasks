/*Matthew Loe
  Student ID: 19452425
  Date Created: 12/10/2018
  Date Last Modified: 18/10/2018 */

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
        DSAHashTable hash;
        DSALinkedList<String> list;
        String[] arrayKey = {"1","3","5","7","9","11","1","3"};
        String[] arrayValue = {"A","B","C","D","E","F","G","H"};
        Object obj;
        String str;
        int size = 10;
        int idx = 0;

        //Testing Alternate Constructor
        try
        {
            numTests++;
            System.out.println("Test alternate constructor");
            hash = new DSAHashTable(size);
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
                obj = hash.remove(arrayKey[idx]);
                if (obj instanceof String)
                {
                    str = String.valueOf(obj);
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
                hash = new DSAHashTable(10);
                System.out.println("Test remove - when empty");
                obj = hash.remove(arrayKey[idx]);
                System.out.println("Fail");
            }
            catch(IllegalArgumentException e)
            {
                numPass++;
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
                hash = new DSAHashTable(10);
                for (int ii = 0; ii < 3; ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR
    
                obj = hash.get(arrayKey[idx]);
                if (obj instanceof String)
                {
                    str = String.valueOf(obj);
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
                hash = new DSAHashTable(10);
                for (int ii = 0; ii < 3; ii++)
                {
                    hash.put(arrayKey[ii],arrayValue[ii]);
                }
                //END FOR
                
                try
                {
                    obj = hash.get(arrayKey[4]);
                    System.out.println("Fail");
                }
                catch(IllegalArgumentException e)
                {
                    numPass++;
                }
                //END TRY-CATCH
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
                hash = new DSAHashTable(10);
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
            
            //Testing read in
            try
            {
                numTests++;
                System.out.println("Test read in large dataset.");
                list = new DSALinkedList<String>();
                hash = FileIO.readFile("RandomNames7000.csv",list);
                numPass++;

                //Testing write
                try
                {
                    numTests++;
                    System.out.println("Test write large dataset.");
                    FileIO.writeFile("hashOutput.txt",hash,list);
                    numPass++;
                }
                catch(Exception e)
                {
                    System.out.println("Fail");
                }
                //END TRY-CATCH
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


