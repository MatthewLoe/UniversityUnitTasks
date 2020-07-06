/*Matthew Loe 
  Student ID: 19452425
  Date Created: 6/9/2018
  Date Last Modified: 8/9/2018 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class DSABinarySearchTree<E> implements Serializable
{
  //Class Fields
    private DSATreeNode<E> root;

  //Constructor
    public DSABinarySearchTree()
    {
        root = null;
    }

  /*Sub Module: find
    I: key (String)
    E: value (E) */
    public E find(String key)
    {
        E value;

        try
        {
            value = findRecursive(key, root);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            value = null;
        }
        //END TRY-CATCH

        return value;
    }


  /*Sub Module: findRecursive
    I: key (String), curr (DSATreeNode<E>)
    E: value (E) */
    private E findRecursive(String key, DSATreeNode<E> curr)
    {
        E value;
        String str

        if (curr == null) //Base case not found
        {
            throw new IllegalArgumentException("Key not found.");
        }
        else if (key.equals(curr.getKey()))
        {
            value = curr.getValue();
        }
        else if (key.length() > (curr.getKey()).length()) //Checks if keys same
        {                                                 //length for compare
            value = findRecursive(key,curr.getRight());
        }
        else if (key.compareTo(curr.getKey()) < 0) //Goes down left child
        {
            value = findRecursive(key,curr.getLeft());
        }
        else  //Goes down right child
        {
            value = findRecursive(key,curr.getRight());
        }
        //END IF

        return value;
    }

  /*Sub Module: insert
    I: key (String), value (E)
    E: None */
    public void insert(String key, E value)
    {
        try
        {
            root = insertRecursive(key,value,root);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        //END TRY-CATCH
    }

  /*Sub Module: insertRecursive
    I: key (String), value (E), curr (DSATreeNode<E>)
    E: updateNode (DSATreeNode<E>) */
    private DSATreeNode<E> insertRecursive(String key, E value,
                                           DSATreeNode<E> curr)
    {
        DSATreeNode<E> updateNode;

        updateNode = curr;

        if (curr == null) //No node exisits
        {
            updateNode = new DSATreeNode<E>(key,value); 
        }
        else if (key.equals(curr.getKey())) //Key already exists
        {
            throw new IllegalArgumentException("Key "+key+" already in tree.");
        }
        else if (key.length() > (curr.getKey()).length()) //Checks length same
        {
             curr.setRight(insertRecursive(key, value, curr.getRight();
        }
        else if (key.compareTo(curr.getKey()) < 0) //Key is smaller than current
        {
            curr.setLeft(insertRecursive(key, value, curr.getLeft()));
        }
        else  //Key is larger than current
        {
            curr.setRight(insertRecursive(key, value, curr.getRight()));
        }
        //END IF

        return updateNode;
    }

  /*Sub Module: delete
    I: key (String)
    E: None */
    public void delete(String key)
    {
        try
        {
            root = deleteRecursive(key, root);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        //END TRY-CATCH
    }

  /*Sub Module: deleteRecurisve
    I: key (String), curr (DSATreeNode<E>)
    E: updateNode (DSATreeNode<E>) */
    private DSATreeNode<E> deleteRecursive(String key, DSATreeNode<E> curr)
    {
        DSATreeNode<E> updateNode = null;

        if (curr == null) //Base case
        {
            throw new IllegalArgumentException("key does not exist.");
        }
        else if (key.equals(curr.getKey())) //Node found
        {
            updateNode = deleteNode(key,curr);
        }
        else if (key.length() > (curr.getKey()).length()) //Checks lengths same
        {
            curr.setRight(deleteRecursive(key,curr.getRight()));
        }
        else if (key.compareTo(curr.getKey()) < 0) //Checks down left child
        {
            curr.setLeft(deleteRecursive(key,curr.getLeft()));
        }
        else //Checks down right child
        {
            curr.setRight(deleteRecursive(key,curr.getRight()));
        }
        //END IF

        return updateNode;
    }

  /*Sub Module: deleteNode
    I: key (String), delNode (DSATreeNode<E>)
    E: updateNode (DSATreeNode<E>) */
    private DSATreeNode<E> deleteNode(String key, DSATreeNode<E> delNode)
    {
        DSATreeNode<E> updateNode = null;

        if (delNode.getLeft() == null && delNode.getRight() == null)
        {
            updateNode = null;  //No children
        }
        else if (delNode.getLeft() != null && delNode.getRight() == null)
        {
            updateNode = delNode.getLeft(); //One child left
        }
        else if (delNode.getLeft() == null && delNode.getRight() != null)
        {
            updateNode = delNode.getRight(); //One child right
        }
        else //Two children
        {
            updateNode = promoteSuccessor(delNode.getRight());
            
            if (updateNode != delNode.getRight()) //UpdateNode adopts right child
            {
                updateNode.setRight(delNode.getRight());
            }
            //END IF

            updateNode.setLeft(delNode.getLeft());
        }
        //END IF

        return updateNode;
    }

  /*Sub Module: promoteSuccessor
    I: curr (DSATreeNode<E>)
    E: successor (DSATreeNode<E>) */
    private DSATreeNode<E> promoteSuccessor(DSATreeNode<E> curr)
    {
        DSATreeNode<E> successor;

        successor = curr;

        if (curr.getLeft() != null)  //Checks for left child
        {
            successor = promoteSuccessor(curr.getLeft());
            
            if (successor == curr.getLeft())  //Checks if final left child
            {
                curr.setLeft(successor.getRight()); //Parent adopts right child
            }                                       //of successor
            //END IF
        }
        //END IF

        return successor;
    }

  /*Sub Module: height
    I: None
    E: height (Integer) */
    public int height()
    {
        return heightRecursive(root);
    }

  /*Sub Module: heightRecurisive
    I: curr (DSATreeNode<E>)
    E: htSoFar (Integer) */
    private int heightRecursive(DSATreeNode<E> curr)
    {
        int htSoFar, leftHt, rightHt;

        if (curr == null)
        {
            htSoFar = -1;
        }
        else
        {
            leftHt = heightRecursive(curr.getLeft());
            rightHt = heightRecursive(curr.getRight());
        
            if (leftHt > rightHt)
            {
                htSoFar = leftHt + 1;
            }
            else
            {
                htSoFar = rightHt + 1;
            }
            //END IF
        }
        //END IF

        return htSoFar;
    }

  /*Sub Module: min
    I: None
    E: minNode (String) */
    public String min()
    {
        String minNode = (minRecursive(root)).getKey();
        return minNode;
    }

  /*Sub Module: minRecursive
    I: curr (DSATreeNode<E>)
    E: minNode (DSATreeNode<E>) */
    private DSATreeNode<E> minRecursive(DSATreeNode<E> curr)
    {
        DSATreeNode<E> minNode = curr;
        
        if (curr.getLeft() != null) //Checks if reached left most node
        {
            minNode = minRecursive(curr.getLeft());
        }
        //END IF

        return minNode;
    }

  /*Sub Module inOrder
    I: None
    E: queue (DSAQueue<String>) */
    public DSAQueue<String> inOrder()
    {
        DSAQueue<String> queue = new DSAQueue<String>();

        queue = inOrderRecursive(root, queue);

        return queue;
    }

  /*Sub Module: inOrderRecursive
    I: curr (DSATreeNode<E>)
    E: queue (DSAQueue<String>) */
    private DSAQueue<String> inOrderRecursive(DSATreeNode<E> curr,
                                              DSAQueue<String> queue)
    {

        if (curr != null)
        {
            queue = inOrderRecursive(curr.getLeft(), queue);
            
            queue.enqueue(curr.getKey());
 
            queue = inOrderRecursive(curr.getRight(), queue);
        }
        //END IF
        
        return queue;
    }

  /*Sub Module: preOrder
    I: curr (DSATreeNode<E>)
    E: queue (DSAQueue<String>) */
    public DSAQueue<String> preOrder()
    {
        DSAQueue<String> queue = new DSAQueue<String>();

        queue = preOrder(root, queue);

        return queue;

    }

  /*Sub Module: preOrder
    I: curr (DSATreeNode<E>)
    E: queue (DSAQueue<String>) */
    private DSAQueue<String> preOrder(DSATreeNode<E> curr,
                                      DSAQueue<String> queue)
    {

        if (curr != null)
        {
            queue.enqueue(curr.getKey());
         
            queue = preOrder(curr.getLeft(), queue);   
 
            queue = preOrder(curr.getRight(), queue);
        }
        //END IF
        
        return queue;
    }

  /*Sub Module: postOrder
    I: curr (DSATreeNode<E>)
    E: queue (DSAQueue<String>) */
    public DSAQueue<String> postOrder()
    {
        DSAQueue<String> queue = new DSAQueue<String>();

        queue = postOrder(root, queue);

        return queue;       
    }

  /*Sub Module: postOrder
    I: curr (DSATreeNode<E>)
    E: queue (DSAQueue<String>) */
    private DSAQueue<String> postOrder(DSATreeNode<E> curr,
                                       DSAQueue<String> queue)
    {

        if (curr != null)
        {
            queue = postOrder(curr.getLeft(), queue);
             
            queue = postOrder(curr.getRight(), queue);

            queue.enqueue(curr.getKey());
        }
        //END IF
        
        return queue;
    }

  /*Sub Module: serialize
    I: file (String), tree (DSABinarySearchTree)
    E: None */
    public static void serialize(String file, DSABinarySearchTree<String> tree)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        
        try
        {
            fileStrm = new FileOutputStream(file);
            objStrm = new ObjectOutputStream(fileStrm);
           
            objStrm.writeObject(tree);
 
            objStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("Error while serializing: "+e.getMessage());
        }
        //END TRY-CATCH
    }

  /*Sub Module: deserialize
    I: file (String)
    E: tree (DSABinarySearchTree<String>) */
    public static DSABinarySearchTree<String> deserialize(String file)
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSABinarySearchTree<String> tree;

        try
        {
            fileStrm = new FileInputStream(file);
            objStrm = new ObjectInputStream(fileStrm);

            tree = (DSABinarySearchTree<String>)(objStrm.readObject());

            objStrm.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("DSABinarySearchTree class not found.");
            throw new IllegalArgumentException();
        }
        catch(IOException ex2)
        { 
            throw new IllegalArgumentException("Error reading file.");
        }
        //END TRY-CATCH

        return tree;
    }

  //Inner Class DSATreeNode<E>
    private class DSATreeNode<E> implements Serializable
    {
      //Class Fields
        private String key;
        private E value;
        private DSATreeNode<E> leftChild;
        private DSATreeNode<E> rightChild;

      //Constructor
        public DSATreeNode(String inKey, E inValue)
        {
            if (inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null.");
            }
            //END IF

            key = inKey;
            value = inValue;
            leftChild = null;
            rightChild = null;
        }

      //Getters
      /*Sub Module: getKey
        I: None
        E: key (String) */
        public String getKey()
        {
            return key;
        }

      /*Sub Module: getKey
        I: None
        E: value (E) */
        public E getValue()
        {
            return value;
        }

      /*Sub Module: getLeft
        I: None
        E: left (DSATreeNode<E>) */
        public DSATreeNode<E> getLeft()
        {
            return leftChild;
        }

      /*Sub Module: getRight
        I: None
        E: right (DSATreeNode<E>) */
        public DSATreeNode<E> getRight()
        {
            return rightChild;
        }

      //Mutators
      /*Sub Module: setLeft
        I: None
        E: None */
        public void setLeft(DSATreeNode<E> inLeft)
        {
            leftChild = inLeft;
        }

      /*Sub Module: setRight
        I: None
        E: None */
        public void setRight(DSATreeNode<E> inRight)
        {
            rightChild = inRight;
        }

    }
  //END Inner Clas

}




