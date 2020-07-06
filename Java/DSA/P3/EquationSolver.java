/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 20/8/2018 */

import java.util.*;

public class EquationSolver
{

    //Class Constants
    public final static int PLUSMIN = 1;
    public final static int MULTDIV = 2;
    
    public static double solve(String equation)
    {
        DSAQueue postfixEqu;
        double result;

        postfixEqu = parseInfixToPostfix(equation);
        result = evaluatePostfix(postfixEqu);        

        return result;
    }

    private static DSAQueue parseInfixToPostfix(String equation)
    {
        DSAQueue queue = new DSAQueue(equation.length());
        DSAStack stack = new DSAStack();
        String term;
        StringTokenizer strTok = new StringTokenizer(equation,"()+-*/", true);

        while (strTok.hasMoreTokens())
        {
            term = strTok.nextToken();
 
            if (term.equals("("))
            {
                stack.push((Character)('('));
            }
            else if (term.equals(")"))
            {
                while (!(((Character)(stack.top())).charValue() == '('))
                {
                    queue.enqueue((Character)(stack.pop()));
                }
                //END WHILE
                stack.pop();
            }
            else if ((term.equals("+")) || (term.equals("-")) ||
                     (term.equals("/")) || (term.equals("*")))
            {
                while(!(stack.isEmpty()) && 
                      (((Character)(stack.top())).charValue() == '(') && 
                      (precedenceOf(((Character)(stack.top())).charValue())
                      >= precedenceOf(term.charAt(0))))
                {
                    queue.enqueue((Character)(stack.pop()));
                }
                //END WHILE
                stack.push((Character)(term.charAt(0)));
            }
            else
            {
                queue.enqueue(Double.valueOf(term));
            }
            //END IF
        }
        //END WHILE

        while (!(stack.isEmpty()))
        {
            queue.enqueue((Character)(stack.pop()));
        }
        //END WHILE

        return queue;
    }
    
    private static double evaluatePostfix(DSAQueue postfixQueue)
    {
        double result, num1, num2;
        char oper;
        DSAStack stack = new DSAStack();;
        Object obj;
        Double doubObj;

        while (!(postfixQueue.isEmpty()))
        {
            obj = postfixQueue.dequeue();

            if (obj instanceof Double)
            {
                stack.push((Double)(obj));
            }
            else if (obj instanceof Character)
            {
                oper = ((Character)(obj)).charValue();

                doubObj = (Double)(stack.pop());
                num1 = doubObj.doubleValue();
                
                doubObj = (Double)(stack.pop());
                num2 = doubObj.doubleValue();

                result = executeOperation(oper, num2, num1);
                stack.push((Double)(result));
            }
            //END IF
        }   
        //END WHILE
        
        result = ((Double)(stack.pop())).doubleValue();

        return result;
    }

    private static int precedenceOf(char oper)
    {
        int precedence = 0;

        if ((oper == '*') || (oper == '/'))
        {
            precedence = MULTDIV;
        }
        else if ((oper == '+') || (oper == '-'))
        {
            precedence = PLUSMIN;
        }
        //END IF

        return precedence;
    }

    private static double executeOperation(char op, double op1, double op2)
    {
        double result = 0.0;

        if (op == '*')
        {
            result = op1 * op2;
        }
        else if (op == '/')
        {
            result = op1 / op2;
        }
        else if (op == '+')
        {
            result = op1 + op2;        
        }
        else if (op == '-')
        {
            result = op1 - op2;
        }
        //END IF

        return result;
    }

}


