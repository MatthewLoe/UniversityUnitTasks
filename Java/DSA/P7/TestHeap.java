/*Matthew Loe
  Student ID: 19452425
  Date Created: 5/10/2018
  Date Last Modified: 5/10/2018 */

import java.util.*;
import java.lang.*;

public class TestHeap
{
    public static void main(String[] args)
    {
        //Test Counters
        int numPass = 0;
        int numTests = 0;

        //Test Variables
        String[] list = {"Hillary Tall","Jessie Mayville","Kelly Cheatam",
                         "Chandra Trowell","Harriett Curatolo","Max Levario",
                         "Jamie Upson","Guy Loredo","Tanisha Coppin",
                         "Jessie Leandro","Penelope Gayman","Edwina Esters",
                         "Javier Swint","Elinor Raco","Nannie Mcgown",
                         "Jamie Shake","Allie Ulland","Harriett Zollinger",
                         "Ashlee Capellan","Cody Russom","Fernando Mccardell",
                         "Clayton Ricard","Dollie Dignan","Amie Delcambre",
                         "Gay Ascencio","Carmella Sheffey","Earnestine Croswell",
                         "Christian Verde","Max Plain","Guy Vanalstyne",
                         "Tania Mogensen","Mathew Eslick","Tabatha Walworth",
                         "Jerri Mayr","Darren Southwood","Rae Furby",
                         "Nelson Valderrama","Cody Mcmartin","Elnora Aberle",
                         "Esmeralda Radovich","Jessie Dosch","Christian Klemm",
                         "Mathew Mercedes","Pearlie Bernat","Katy Tressler",
                         "Loraine Kimberly","Malinda Dodgen","Ted Tallmadge",
                         "Ted Makuch","Erik Deady","Lance Goodpaster","Guy Kadel",
                         "Christian Mullarkey","Sofia Bonfiglio","Guy Snipe",
                         "Lenore Decola","Karina Rossin","Tyrone Seevers",
                         "Elinor Greig","Edwina Fedor","Hillary Jun",
                         "Kenya Seidman","Sofia Kelling","Darren Hadaway",
                         "Mathew Milian","Max Heffelfinger","Jamie Seager",
                         "Kathrine Lainez","Melisa Mckeel","Pearlie Storie",
                         "Clayton Salls","Maricela Landreneau","Althea Warring",
                         "Darryl Triche","Dona Mcinnes","Dollie Westbury",
                         "Javier Kratochvil","Tyrone Sturman","Guy Fagundes",
                         "Christian Durall","Clinton Blumer","Katy Vacek",
                         "Liza Guyette","Carmella Calandra","Ted Enlow",
                         "Nelson Tooker","Katy Callier","Emilia Ruddell",
                         "Dollie Dodrill","Sharron Cournoyer","Clinton Fehrenbach",
                         "Carmella Rondon","Max Madamba","Lance Buono",
                         "Sofia Parente","Neil Brabant","Earnestine Maddock",
                         "Selena Hoose","Julio Degroat","Christian Busbee"};

        String file = "test.csv";
        DSAHeap heap;
        DSAHeapEntry[] array;
        Object value;
        int count = 99;

        try
        {
            numTests++;
            System.out.println("Testing Default Constructor");
            heap = new DSAHeap();
            numPass++;
        }
        catch(Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {
            numTests++;
            System.out.println("Testing Alternate Constructor");
            heap = new DSAHeap(10);
            numPass++;
        }
        catch(Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {        
            numTests++;
            System.out.println("Testing FileIO and add");
            heap = FileIO.readFile(file);
            numPass++;
        }
        catch(Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH

        try
        {
            numTests++;
            count = 99;
            System.out.println("Testing Remove");
            heap = FileIO.readFile(file);
            value = heap.remove();
            
            while (value != null)
            {
                if (!list[count].equals((String)(value)))
                {
                    throw new IllegalArgumentException();
                }
                //END IF
                value = heap.remove();
                count--;
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
            numTests++;
            count = 99;
            System.out.println("Testing Heap Sort");
            heap = new DSAHeap();
            array = FileIO.arrayHeapEntry(file);
            heap.heapSort(array);
            value = heap.remove();
            while (value != null)
            {
                if (!list[count].equals((String)(value)))
                {
                    throw new IllegalArgumentException();
                }
                //END IF
                value = heap.remove();
                count--;
            }
            //END WHILE
            numPass++;
        }
        catch(Exception e)
        {
            System.out.println("Fail");
        }
        //END TRY-CATCH
    }

}


