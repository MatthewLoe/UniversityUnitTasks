/*Matthew Loe
  Student ID: 19452425
  Date Created: 17/8/2018
  Date Last Modified: 27/8/2018 */

import java.util.*;

public class DSAQueue<E> implements Iterable<E>
{
  //Class Fields
    private DSALinkedList<E> queue;

  //Default
    public DSAQueue()
    {
        queue = new DSALinkedList<E>();
    }

  /*Sub Module: isEmpty
    I: None
    E: check (Boolean) */
    public boolean isEmpty()
    {
        boolean check = false;
        
        check = queue.isEmpty();

        return check;
    }

  /*Sub Module: peek
    I: None
    E: topObj (E) */
    public E peek()
    {
        E firObj;

        firObj = queue.peekFirst();

        return firObj;
    }

  //Mutators
  /*Sub Module: enqueue
    I: inObj (E)
    E: None */
    public void enqueue(E inObj)
    {
        queue.insertLast(inObj);
    }

  /*Sub Module: dequeue
    I: None
    E: topObj (E) */
    public E dequeue()
    {
        E firObj;
        
        firObj = queue.peekFirst();

        queue.removeFirst();
        
        return firObj;
    }

  /*Sub Module: iterator
    I: None
    E: iter (Iterator <E>) */
    public Iterator<E> iterator()
    {
        Iterator<E> iter;
        
        iter = queue.iterator();
        
        return iter;
    }
}



