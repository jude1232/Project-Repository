package proj4;

/**
 *  Implementation of a Linked List.
 */
public class LinkedList<T>
{
    // instance variables
    private int length;
    private ListNode<T> head;

    /**
     * default constructor
     */
    public LinkedList()
    {
        length = 0;
        head = null;
    }

    /**
     * returns the head of the linked list.
     */
    private ListNode<T> getHead()
    {
        return this.head;
    }


    /**
     * sets a new node as the head
     */
    private void setHead(ListNode<T> newHead) 
    {
        this.head = newHead;
    }

    /**
     * returns the length of the linked list (the number of nodes).
     */
    public int getLength()
    {
        return length;
    }

    /**
     * returns the next node in the list. 
     * @param node a node
     * @return the node after the current node
     */
    private ListNode<T> getNext(ListNode<T> node)
    {
        return node.next;
    }

    /**
     * gets the data from a particular node.
     * @param node the node housing the data
     * @return the data from the node.
     */
    private T getData(ListNode<T> node)
    {
        return node.data;
    }

    /**
     * returns the data of the node at the desired index
     * @param desiredIndex the desired position of the linkedlist
     * @return the data at the desired index, null if the specified 
     * index doesnt exist in the list
     */
    public T getDataAtIndex(int desiredIndex)
    {
        T data = null;
        int nodeCount = 0;
        for (ListNode<T> runner = getHead(); runner != null; runner = runner.next){
            if (nodeCount == desiredIndex) {
                data = getData(runner);
            }
            nodeCount++;
        }
        return data;
    }
    
    /**
     * 
     * @param value
     * @return
     */
    public int getIntIndex(String value)
    {
        ListNode<T> runner = getHead();
        int indexCount = 0;
        while (runner != null) {
            if (getData(runner) == value) {
                return indexCount;
            }
            indexCount ++;
            setNext(runner, getNext(runner));
        }
        return -1;
    }


    /**
     * sets the desired node as the next node.
     * @param nodeBefore the node before the next node
     * @param newNode the node added
     */
    private void setNext(ListNode<T> nodeBefore, ListNode<T> newNode)
    {
        nodeBefore.next = newNode;
    }

    /**
     * private helper function for addAfter
     * @param toAdd the data to add 
     * @param nodeBefore the node before the node added  
     */
    private void addAfterNode(T toAdd, ListNode<T> nodeBefore)
    {
        if (nodeBefore != null) {
            ListNode<T> newNode = new ListNode<T>(toAdd, getNext(nodeBefore));
            setNext(nodeBefore, newNode);
        }
        length++;
    }

    /**
     * Insert a new integer into the list after the given data.
     * 
     * @param toAdd the new value to add to the list
     * @param itemIndexBefore the value after which to add the new item
     */
    public void addAfter(T toAdd, int itemIndexBefore) 
    {
        ListNode<T> newNode = new ListNode<T>(toAdd);

        ListNode<T> current = head;
        for (int i = 0; i < itemIndexBefore; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        length ++;
    }


    /**
     * adds a new node to the end of the linked list 
     * @param data the data to add
     */
    public void addLast(T data) {
        ListNode<T> newNode = new ListNode<T>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode<T> current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = newNode;
    }
    /**
     * Insert a new String into the list at the given position. 
     * 
     * @param toAdd the new value to add to the list
     * @param itemBefore the data of the node before the desired location
     * @param itemAfter the data of the node after the desired location
     */
    public void addAt(T toAdd, T itemBefore, T itemAfter) 
    {
        if (itemBefore.equals(null)) {
            insertAtHead(toAdd);
        }
        else {
            // find nodeBefore
            ListNode<T> runner = getHead();
            for (int i = 0; i <= getLength(); i ++) {
                if (runner != null && !getData(runner).equals(itemBefore)) {
                    setNext(runner, getNext(runner));
                }
                else{
                    addAfterNode(toAdd, runner); return;
                }
            }
        }
    }

    /**
     * inserts a new node to the linked list before the specified position.
     * @param toAdd the data to add to the list.
     * @param itemAfter the after the position in the linked list.
     */
    public void addBefore(T toAdd, int itemIndexBefore)
    {
        ListNode<T> newNode = new ListNode<T>(toAdd);

        if (itemIndexBefore == 0) {
        insertAtHead(toAdd);
          return;
        }
    
        ListNode<T> prev = head;
        for (int i = 0; i < itemIndexBefore - 1; i++) {
          prev = prev.next;
        }
    
        newNode.next = prev.next;
        prev.next = newNode;

        length ++;
    }


    /**
     * inserts a new node at the head of the list.
     * @param data the data to be added to the list.
     */
    public void insertAtHead(T data)
    {
        ListNode<T> newNode = new ListNode<T>(data);
        newNode.next = head;
        head = newNode;
        length ++;
        return;
    }

    /**
     * removes an item from the linked list
     * @param toRemove the item to be removed
     */
    public void deleteNode(T key)
    {
        ListNode<T> temp = head;
        ListNode<T> prev = null;
         if (temp != null && temp.data.equals(key)) {
            head = temp.next; // Changed head
            return;
        }
        while (temp != null && !temp.data.equals(key)) {
            prev = temp;
            temp = temp.next;
        }
         if (temp == null)
            return;
 
        prev.next = temp.next;
    }

    /**
     * adds a node to the list.
     * @param data
     */
    private void add(T data) 
    {
        ListNode<T> newNode = new ListNode<T>(data);
        setNext(newNode, getHead());
        setHead(newNode);
        length ++;
    }

    /**
     * increases the size of the LinkedList.
     * @param currentSize the current size of the linked list.
     */
    public void increaseSize(int currentSize) 
    {
        for(int i = 0; i < currentSize; i++) {
            add(null);
        }
    }

    /**
     * clears the linked list
     */
    public void clearList()
    {
        setHead(null);
    }

    /**
     * clones a linked list
     * @return the cloned list
     */
    public LinkedList<T> cloneList() 
    {
        LinkedList<T> newList = new LinkedList<T>();
        ListNode<T> oldListNode = head;
        
        while (oldListNode != null) {
            newList.addLast(getData(oldListNode));
            oldListNode = oldListNode.next;
            length++;
        }
        return newList;
    }
        

    /**
     * returns a string representation of the list.
     */
	public String toString()
    { 
		String toReturn = "(";
		ListNode<T> runner = head;
		while(runner != null){
			toReturn = toReturn + runner;
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}

}