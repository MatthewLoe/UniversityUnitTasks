/*Matthew Loe
  Student ID: 19452425
  Date Created: 23/8/2018
  Date Last Modified: 26/8/2018 */

import java.util.*;

public class DSALinkedList<E> implements Iterable<E>
{
    //Class Fields
    private DSAListNode<E> head;
    private DSAListNode<E> tail;

    //Default
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    //Iterator
    public Iterator<E> iterator()
    {
        return new DSALinkedListIterator<E>(this);
    }

  //Getters
  /*Sub Module: isEmpty
    I: None
    E: empty (Boolean) */
    public boolean isEmpty()
    {
        boolean empty;
        
        empty = (head == null);
        
        return empty;
    }

  /*Sub Module: peekFirst
    I: None
    E: nodeValue (E) */
    public E peekFirst()
    {
        E nodeValue;

        if (isEmpty())
        {
            throw new IllegalArgumentException("List Empty");
        }
        else
        {
            nodeValue = head.getValue();
        }
        //END IF
        
        return nodeValue;
    }

  /*Sub Module: peekLast
    I: None
    E: nodeValue (E) */
    public E peekLast()
    {
        E nodeValue;

        if (isEmpty())
        {
            throw new IllegalArgumentException("List Empty");
        }
        else
        {
            nodeValue = tail.getValue();
        }
       //END IF

        return nodeValue;
    }


  //Mutators
  /*Sub Module: insertFirst
    I: newValue (E)
    E: None */
    public void insertFirst(E newValue)
    {
        DSAListNode<E> newNode = new DSAListNode<E>(newValue,null);
        
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        //END IF
    }

  /*Sub Module: insertLast
    I: newValue (E)
    E: None */
    public void insertLast(E newValue)
    {
        DSAListNode<E> newNode = new DSAListNode<E>(newValue,null);

        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        //END IF
    }

  /*Sub Module: removeFirst
    I: None
    E: nodeValue (E) */
    public E removeFirst()
    {
        E nodeValue;
        
        if (isEmpty())
        {
            throw new IllegalArgumentException("Empty list");
        }
        else if (head == tail)   //Checks if last node
        {
            nodeValue = head.getValue();
            head = head.getNext();
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
            head.setPrev(null);
        }
        //END IF        

        return nodeValue;
    }


  /*Sub Module: removeLast
    I: None
    E: nodeValue (E) */
    public E removeLast()
    {
        E nodeValue;
        
        if (isEmpty())
        {
            throw new IllegalArgumentException("Empty list");
        }
        else if (head == tail)  //Checks if last node
        {
            nodeValue = tail.getValue();
            tail = tail.getPrev();
        }
        else
        {
            nodeValue = tail.getValue();
            tail = tail.getPrev();
            tail.setNext(null);
        }
        //END IF

        return nodeValue; 
    }

    //DSAListNode Inner Class
    private class DSAListNode<E>
    {
        //Class Fields
        private E value;
        private DSAListNode<E> next;
        private DSAListNode<E> prev;
        
        //Alternate
        public DSAListNode(E inValue, DSAListNode<E> inPrev)
        {
            value = inValue;
            next = null;
            prev = inPrev;
        }

     //Getters
      /*Sub Module: getValue
        I: None
        E: value (E) */
        public E getValue()
        {
            return value;
        }

      /*Sub Module: getNext
        I: None
        E: node (DSAListNode<E>) */       
        public DSAListNode<E> getNext()
        {
            return next;
        }

      /*Sub Module: getPrev
        I: None
        E: node (DSAListNode<E>) */       
        public DSAListNode<E> getPrev()
        {
            return prev;
        }

      //Setters
      /*Sub Module: setValue
        I: inValue (E)
        E: None */       
        public void setValue(E inValue)
        {
            value = inValue;
        }

      /*Sub Module: setNext
        I: node (DSAListNode<E>)
        E: None */       
        public void setNext(DSAListNode<E> node)
        {
            next = node;
        }

      /*Sub Module: setPrev
        I: node (DSAListNode<E>)
        E: None */       
        public void setPrev(DSAListNode<E> node)
        {
            prev = node;
        }

    }
    //END Inner Class

    //DSALinkedIterator
    private class DSALinkedListIterator<E> implements Iterator<E>
    {
        //Class Fields
        private DSALinkedList<E>.DSAListNode<E> iterNext;

        //Alternate
        public DSALinkedListIterator(DSALinkedList<E> inList)
        {
            iterNext = inList.head;
        }

      /*Sub Module: hasNext
        I: None
        E: Boolean */
        public boolean hasNext()
        {
            return (iterNext != null);
        }

      /*Sub Module: next
        I: None
        E: value (E) */
        public E next()
        {
            E value;
            
            if (iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            //END IF
            
            return value;
        }

      /*Sub Module: remove
        I: None
        E: None */
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }

    }
    //END Inner Class
}



