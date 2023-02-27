package proj4;


/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object. 
 *
 * This is the only class where I'll let you use public instance variables.
 * 
 */
public class ListNode<T>
{
    // public instance variables
    public T data;
    public ListNode<T> next;

    /**
     * Parameterized constructor
     * @param newData the data to be added to the node
     */
    public ListNode(T newData)
    {
        this.data = newData;
        this.next = null;
    }

    // Default constructor 
    public ListNode() 
    {
        this.data = null;
        this.next = null;
    }

    /**
     * Parameterized Constructor
     * @param newData the data to be added
     * @param next the next node
     */
    public ListNode(T newData, ListNode<T> next)
    {
        this.data = newData;
        this.next = next;
    }
    
    /**
     * Returns a string representation of the data contained
     * within the node
     */
    public String toString(){
    	return data.toString();
    }

}