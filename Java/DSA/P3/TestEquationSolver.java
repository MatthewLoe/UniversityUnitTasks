/*Matthew Loe
  Student ID: 19452425
  Date Created: 19/8/2018
  Date Last Modified: 20/8/2018 */

import java.util.*;

public class TestEquationSolver
{
    public static void main(String [] args)
    {
        //Test Counters
        int numPass = 0;
        int numTests = 0;

        //Test Variables
        String equ;
        double result;

        //Testing Equation Solver
        System.out.println("Testing Equation Solver");

        try
        {
            equ = "1+2+3";
            numTests++;
            System.out.println("Test 1");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "2-1";
            numTests++;
            System.out.println("Test 2");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "2*3";
            numTests++;
            System.out.println("Test 3");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "6/2";
            numTests++;
            System.out.println("Test 4");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "(2+3)*4";
            numTests++;
            System.out.println("Test 5");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "2+(3*4)";
            numTests++;
            System.out.println("Test 6");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "10-(6/3)";
            numTests++;
            System.out.println("Test 7");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
            numPass++;

            equ = "(10.3*(14+3.2))/(5+2-4*3)";
            numTests++;
            System.out.println("Test 8");
            System.out.println(equ);
            result = EquationSolver.solve(equ);
            System.out.println(result);
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


