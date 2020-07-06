/*Matthew Loe
  Student ID: 19452425
  Date Created: 13/9/2018
  Date Last Modified: 29/9/2018 */

import java.util.*;
import java.lang.*;

public class DSAGraph
{
  //Class Fields
    private DSALinkedList<DSAVertex> vertices;

  //Default Constructor    
    public DSAGraph()
    {
        vertices = new DSALinkedList<DSAVertex>();
    }

  //Alternate
    public DSAGraph(String file)
    {
        DSALinkedList<String> vectors = new DSALinkedList<String>();
        Iterator<String> iter;
        String str;
        String[] label;

        FileIO.readFile(file, vectors); 
        
        vertices = new DSALinkedList<DSAVertex>();

        iter = vectors.iterator();
        
        while (iter.hasNext())
        {
            str = iter.next();
            label = str.split(" ");
            System.out.println(str+"  "+label[0]+" "+label[1]);
            if (label.length != 2)
            {
                System.out.println(str+" is invalid.");
            }
            //END IF

            addLink(label[0],label[1]);
        }
        //END WHILE

    }

  //Getters
  /*Sub Module: getVertexCount
    I: None
    E: count (Integer) */
    public int getVertexCount()
    {
        int count = 0;
        Iterator<DSAVertex> iter = vertices.iterator();
        DSAVertex vertex;
   
        while (iter.hasNext())
        {
            vertex = iter.next();
            count++;
        }
        //END WHILE

        return count;
    }

  /*Sub Module: getEdgeCount
    I: None 
    E: count (Integer) */
/*    public int getEdgeCount()
    {

    }*/

  /*Sub Module: getVertex
    I: label (String)
    E: vertex (DSAVertex) */
    public DSAVertex getVertex(String label)
    {
        DSALinkedList<DSAVertex> tmp;
        DSAVertex vertex = null;  
        boolean check = true;

        if (vertices.isEmpty())
        {
            throw new IllegalArgumentException("No vertices.");
        }
        else
        {
            while (!vertices.isEmpty() && check)
            {
                vertex = vertices.removeFirst();
                
                if (label.equals(vertex.getLabel()))
                {
                    vertices.insertLast(vertex);
                    check = false;
                }
                else
                {
                    vertices.insertLast(vertex);
                    vertex = null;
                }
                //END IF
            }
            //END WHILE
        }
    
        return vertex;
    }

  /*Sub Module: getAdjacent
    I: vertex (String)
    E: vertexList (String) */
    public String getAdjacent(String label)
    {
        Iterator<DSAVertex> iter = vertices.iterator();
        DSAVertex vertex = null;
        String vertexList = null;

        while (iter.hasNext())
        {
            vertex = iter.next();

            if ((vertex.getLabel()).equals(label))
            {
                vertexList = toList(vertex.getAdjacent());
            }
            //END IF   
        }
        //END WHILE

        return vertexList;
    }

  /*Sub Module: getFirst
    I: None
    E: label (String) */
    private String getFirst()
    {
        Iterator<DSAVertex> iter = vertices.iterator();
        DSAVertex vertex = iter.next();
        String label = vertex.getLabel();
        String str;
 
        while (iter.hasNext())
        {
            vertex = iter.next();
            str = vertex.getLabel();
            
            if (label.compareTo(str) > 0)
            {
                label = str;   
            }
            //END IF
        }
        //END WHILE

        return label;
    }

  //Mutators
  /*Sub Module: addVertex
    I: label (String), val (Object)
    E: None */
    public void addVertex(String label/*, Object val*/)
    {
        DSAVertex vertex;
        Iterator<DSAVertex> iter;
        boolean check = true;        

        if (vertices.isEmpty())
        {
            vertex = new DSAVertex(label);
            vertices.insertLast(vertex);
        }
        else
        {
            iter = vertices.iterator();
            
            while (iter.hasNext() && check)
            {
                vertex = iter.next();
                
                if (label.equals(vertex.getLabel()))
                {
                    check = false;
                }
                //END IF
            }
            //END WHILE

            if (check)
            {
                vertex = new DSAVertex(label);
                vertices.insertLast(vertex);
            }
            else
            {
                System.out.println("Vertex "+label+" already recorded.");
            }
            //END IF
        }
        //END IF

    }

  /*Sub Module: addLink
    I: vertex (String), link (String)
    E: None */
    public void addLink(String link1, String link2)
    {
        DSALinkedList<DSAVertex> tmpList = new DSALinkedList<DSAVertex>();
        DSAVertex vertex1 = null;
        DSAVertex vertex2 = null;
        DSAVertex tmp;
        boolean check1 = true;
        boolean check2 = true;

        if (link1.equals(link2))
        {
            System.out.println("Same vertex.");
        }       
        else
        {
            if (vertices.isEmpty())
            {
                vertex1 = new DSAVertex(link1);
                vertex2 = new DSAVertex(link2);
                    
                vertex1.addEdge(link2);
                vertex2.addEdge(link1);

                vertices.insertLast(vertex1);
                vertices.insertLast(vertex2);
            }
            else
            {            
                while (!vertices.isEmpty()) //Checks if vertexs exsist
                {
                    tmp = vertices.removeFirst();
                    
                    if (link1.equals(tmp.getLabel()))
                    {
                        vertex1 = tmp;
                        check1 = false;
                    }
                    else if (link2.equals(tmp.getLabel()))
                    {
                        vertex2 = tmp;
                        check2 = false;
                    }
                    else
                    {
                        tmpList.insertLast(tmp);
                    }
                    //END IF
                }
                //END IF
            
                if (check1 && check2)  //Both do not exsist
                {
                    vertex1 = new DSAVertex(link1);
                    vertex2 = new DSAVertex(link2);
                        
                    vertex1.addEdge(link2);
                    vertex2.addEdge(link1);
                }
                else if (check1 && !check2) //Vertex 1 does not exsist
                {
                    vertex1 = new DSAVertex(link1);
                    
                    vertex1.addEdge(link2);
                    vertex2.addEdge(link1);
                }
                else if (!check1 && check2) //Vertex 2 does not exsist
                {
                    vertex2 = new DSAVertex(link2);

                    vertex1.addEdge(link2);
                    vertex2.addEdge(link1);
                }
                else if (!check1 && !check2)  //Both exsist
                {
                    vertex1.addEdge(link2);
                    vertex2.addEdge(link1);
                }
                //END IF
            
                tmpList.insertLast(vertex1);
                tmpList.insertLast(vertex2);

                vertices = tmpList;
            }
            //END IF
        }
        //END IF
    }

  /*Sub Module: displayList
    I: None
    E: None */
    public void displayList()
    {
        DSAVertex vertex;
        Iterator<DSAVertex> iter = vertices.iterator();
        String links;

        System.out.println("List");

        while (iter.hasNext())
        {
            vertex = iter.next();
    
            links = toList(vertex.getAdjacent());
            
            System.out.println("Vertex: "+vertex.getLabel()+" Links:"+links);
        }
        //END WHILE

    }

  /*Sub Module: toList
    I: links (DSALinkedList<String>)
    E: str (String) */
    private String toList(DSALinkedList<String> links)
    {
        String str = " ";
        Iterator<String> iter = links.iterator();

        while (iter.hasNext())
        {
            str = str + iter.next()+",";
        }
        //END WHILE

        return str;
    }


  /*Sub Module: displayMatrix
    I: None 
    E: None */
    public void displayMatrix()
    {
        Iterator<DSAVertex> iter = vertices.iterator();
        DSAVertex vertex;
        String str;

        System.out.println("Matrix");
        System.out.print(" ");

        while (iter.hasNext())
        {
            vertex = iter.next();
            System.out.print(" "+vertex.getLabel());
        }
        //END WHILE
        
        System.out.print("\n");

        iter = vertices.iterator();
    
        while (iter.hasNext())
        {
            vertex = iter.next();
            str = checkLinked(vertex);
            System.out.println(str);
        }
        //END WHILE
    }

  /*Sub Module: checkLinked
    I: vertex (DSAVertex)
    E: str (String) */
    private String checkLinked(DSAVertex vertex)
    {
        Iterator<DSAVertex> iter = vertices.iterator();
        DSAVertex tmp;
        String str = vertex.getLabel() + " ";
        DSALinkedList<String> links = vertex.getAdjacent();
        Iterator<String> linkIter;
        String label;
        boolean check;

        while (iter.hasNext())
        {
            check = false;
            tmp = iter.next();
            linkIter = links.iterator();
            while (linkIter.hasNext())
            {
                label = linkIter.next();

                if (label.equals(tmp.getLabel()))
                {
                    check = true;
                }
                //END IF
            }
            //END WHILE

            if (check)
            {
                str = str + "1 ";;
            }
            else
            {
                str = str + "0 ";
            }
            //END IF
        }
        //END WHILE

        return str;
    }

  /*Sub Module: depthFirstSearch
    I: None
    E: traversal (DSALinkedList<String>) */
    public DSALinkedList<String> depthFirstSearch()
    {
        DSALinkedList<String> traversal = new DSALinkedList<String>();
        DSAVertex vertex;
        String label = getFirst();

        setNew();

        vertex = getVertex(label);
        vertex.setVisited();
        vertices.insertFirst(vertex);
        depthRecursive(vertex,traversal);


        return traversal;
    }

  /*Sub Module: depthRecursive
    I: vertex (DSAVertex), traversal (DSALinkedList<String>)
    E: None */
    private void depthRecursive(DSAVertex vertex, DSALinkedList<String> traversal)
    {
        Iterator<String> iter;
        DSAVertex vertexLink;
        DSALinkedList<String> links;

        links = vertex.getAdjacent();
        iter = links.iterator();

        while (iter.hasNext())
        {
            vertexLink = getVertex(iter.next());
            if (!vertexLink.getVisited())
            {
                vertexLink.setVisited();
                traversal.insertLast("("+vertex.getLabel()+","+vertexLink.getLabel()+")");
                depthRecursive(vertexLink,traversal);
            }
            else
            {
                vertices.insertLast(vertexLink);
            }
            //END IF
        }
        //END WHILE
    }

  /*Sub Module: breadthFirstSearch
    I: None
    E: traversal (DSALinkedList<String> */
    public DSALinkedList<String> breadthFirstSearch()
    {
        DSAQueue<DSAVertex> queue = new DSAQueue<DSAVertex>();
        DSAVertex vertex;
        DSAVertex old;
        DSALinkedList<String> traversal = new DSALinkedList<String>();
        DSALinkedList<String> links;
        Iterator<String> iter;
        String label;

        setNew();

        label = getFirst();
        vertex = getVertex(label);
        vertex.setVisited();   
        vertices.insertFirst(vertex);
        queue.enqueue(vertex);

        while (!queue.isEmpty())
        {
            old = queue.dequeue();
            links = old.getAdjacent();
            iter = links.iterator();

            while (iter.hasNext())
            {
                vertex = getVertex(iter.next());

                if (!vertex.getVisited())  //Checks if unvisited vertex
                {
                    traversal.insertLast("("+old.getLabel()+","+vertex.getLabel()+")");
                    vertex.setVisited();
                    queue.enqueue(vertex);
                }
                //END IF

                vertices.insertLast(vertex);
            }
            //END WHILE
        }
        //END WHILE

        return traversal;
    }

  /*Sub Module: setNew
    I: None
    E: None */
    private void setNew()
    {
        DSAVertex vertex;
        int vertexCount = getVertexCount();        

        for (int ii = 0; ii < vertexCount; ii++)
        {
            vertex = vertices.removeFirst();
            vertex.clearVisited();
            vertices.insertLast(vertex);
        }
        //END WHILE    
    } 

  //DSAVertex
    private class DSAVertex
    {
      //Class Fields
        private String label;
      //private Object value;
        private DSALinkedList<String> links;
        private boolean visited;

      //Alternate
        public DSAVertex(String inLabel/*,inValue*/)
        {
            label = inLabel;
            links = new DSALinkedList<String>();
            visited = false;
        }

      //Getters
      /*Sub Module: getLabel
        I: None 
        E: label (String) */
        public String getLabel()
        {
            return label;
        }

      /*Sub Module: getValue
        I: None 
        E: value (Object) */
//        public Object getValule()
//        {
//            return value;
//        }

       /*Sub Module: getAdjacent
        I: None 
        E: vertexList (DSALinkedList<String>) */
        public DSALinkedList<String> getAdjacent()
        {
            return links;
        }

      /*Sub Module: getVisited
        I: None
        E: visited (boolean) */
        public boolean getVisited()
        {
            return visited;
        } 

      //Mutators
      /*Sub Module: addEdge
        I: vertex (String)
        E: None */
        public void addEdge(String vertex)
        {
            links.insertLast(vertex);
        }

      /*Sub Module: clearVisited
        I: None 
        E: None */
        public void clearVisited()
        {
            visited = false;
        }       

 
      /*Sub Module: setVisited
        I: None
        E: None */
        public void setVisited()
        {
            visited = true;
        }

      /*Sub Module: toString
        I: None
        E: str (String) */
        public String toString()
        {
            String str = "";
            String link;
            int length;
            Iterator<String> iter = links.iterator();

            while (iter.hasNext())
            {
                link = iter.next();
                str = str + label + link +"\n";

                if (iter.hasNext())  //Removes last newline character
                {
                    length = str.length();
                    str = str.substring(0,length-2);
                }
                //END IF
            }
            //END WHILE
        
            return str;
        }

    }
    //END INNER CLASS
}


