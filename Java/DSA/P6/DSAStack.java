/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 27/8/2018 */

import java.util.*;

public class DSAStack<E> implements Iterable<E>
{
  //Class Fields
    private DSALinkedList<E> stack;

  //Default
    public DSAStack()
    {
        stack = new DSALinkedList<E>();
    }

  /*Sub Module: isEmpty
    I: None
    E: check (Boolean) */
    public boolean isEmpty()
    {
        boolean check = false;
        
        check = stack.isEmpty();
        
        return check;
    }

  /*Sub Module: top
    I: None
    E: topObj (E) */
    public E top()
    {
        E topObj;

        topObj = stack.peekFirst();
        
        return topObj;
    }

  //Mutators
  /*Sub Module: push
    I: inObj (E)
    E: None */
    public void push(E inObj)
    {
        stack.insertFirst(inObj);
    }

  /*Sub Module: pop
    I: None
    E: topObj (E) */
    public E pop()
    {
        E topObj;
        
        topObj = stack.peekFirst();
        
        stack.removeFirst();
        
        return topObj;
    }

  /*Sub Module: iterator
    I: None
    E: iter (Iterator <E>) */
    public Iterator<E> iterator()
    {
        Iterator<E> iter;

        iter = stack.iterator();

        return iter;
    }

}



