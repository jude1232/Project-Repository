package proj4;

/**
 * Models a stack with an abstract data type.
 */
public class Stack<T>
{
    // Constants
    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_POSITION = 0;

    //instance variables
    private LinkedList<T> stackContents;
    private String postfix;
    private int size;
    
    public Stack() 
    {
       stackContents = new LinkedList<T>();
       postfix = "";
       size = DEFAULT_SIZE;
       
    }
   
    /**
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {  
    	return size() == 0;
    }

    /**
     * pushes an item to the beginning of the stack.
     * @param toPush the item to be added. 
     */
    public void push(T toPush) 
    {
        stackContents.insertAtHead(toPush);
        size ++;
    }
  
    /**
     * Pops the first item of the stack.
     * @return 
     */
    public T pop() 
    {
        // find data toPop
        // delete node from linkedlist
        //return data
        //postfix string += toPop lets gooooo
        T toPop = stackContents.getDataAtIndex(DEFAULT_POSITION);
        stackContents.deleteNode(toPop);
        size --;
        return toPop;

    } 
  
    /**
     * Peeks at the first item in the stack without removing it.
     * @return the first item in the stack
     */
    public T peek() 
    {
        T toPeek = stackContents.getDataAtIndex(DEFAULT_POSITION);
    	return toPeek; 
    } 
    
    /**
     * @return the size of the stack.
     */
    public int size()
    {
    	return size;  
    }
     
    /**
     * adds an item to the postfix string.
     * @param toAdd the object to add
     */
    public void addToPostfix(String toAdd)
    {
        postfix += toAdd;
    } 

    /**
     * returns the postfix string.
     */
    public String getPostfix()
    {
        return postfix;
    }

    /**
     * returns a String representation of the stack.
     */
    public String toString() {
        // start off as null
        String toReturn = "{>";
        // if not empty, iterate through and add all to toReturn
        if (isEmpty()) {
            toReturn += "}";
        }
        else {
            for (int i = DEFAULT_POSITION; i < size(); i++){
                if (i < size() - 1){
                    toReturn += stackContents.getDataAtIndex(i) + ",";
                }
                else {
                    toReturn += stackContents.getDataAtIndex(i);
                }
            }
            toReturn += "}";
        }
        return toReturn;    //erase this line
    }
    
} 
   

