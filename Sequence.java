package proj3;  // Gradescope needs this.
/**
 *  Author: Jude Kappel
 *  I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 *  accordance with the Union College Honor Code and the course syllabus.
 *
 */
public class Sequence
{
    //  Constants 
    private final static int INITIAL_CAPACITY = 10;
    public final int DEFAULT_POSITION = 0;
    public static final int NEXT_POSITION = 1;
    private final static int NO_CURRENT_VAL = -1;
    private static final int DEFAULT_SIZE = 0;

    // Instance variables:
	private LinkedList contents;
    private int linkedListCapacity;
    private int currentElementIndex;
    private int size;
	// maybe more??
	
    /**
     * Creates a new sequence with initial capacity 10.
     */
    public Sequence() 
    {
        linkedListCapacity = INITIAL_CAPACITY;
    	contents = new LinkedList();
        currentElementIndex = NO_CURRENT_VAL;
        size = DEFAULT_SIZE;
    }
    

    /**
     * Creates a new sequence.
     * 
     * @param initialCapacity the initial capacity of the sequence.
     */
    public Sequence(int initialCapacity)
    {
        linkedListCapacity = initialCapacity;
    	contents = new LinkedList();
        currentElementIndex = NO_CURRENT_VAL;
        size = DEFAULT_SIZE;
    }

    /**
     * sets the capacity to the desired capacity.
     * @param desiredCapacity the desired capacity.
     */
    private void setCapacity(int desiredCapacity)
    {
        linkedListCapacity = desiredCapacity; 
    }


     /**
     * sets the current element index to the new value.
     * @param newValue the integer representing the new current element index
     */
    public void set(int newValue)
    {
        currentElementIndex = newValue;
    }

    /**
     * increases the capacity of the sequence.
     * @param currentCapacity the current capacity of the sequence.
     */
    private void increaseSequenceSize(int currentCapacity)
    {
        setCapacity((2* currentCapacity) + NEXT_POSITION);
    }

    /**
     * returns the data at the desired index of the sequence.
     * @param index the int representation of the desired index
     * @return the data at the desired index
     */
    public String getDesiredIndex(int index)
    {
        return contents.getDataAtIndex(index);
    }

    /**
     * @return the index of the current element.
     */
    public int getCurrentIndex()
    {
        return currentElementIndex; // contents.getIntIndex(getCurrent());
    }

    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value)
    {
        if (isFull()){
            increaseSequenceSize(getCapacity());
        }
        if (isCurrent() && size() > 1) {
            contents.addBefore(value, getCurrentIndex());
        }
        else {
            contents.insertAtHead(value);
            set(DEFAULT_POSITION);
        }
        size ++;
        ensureCapacity(getCapacity());
    }
    
    
    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value)
    {
        if (isFull()) {
            increaseSequenceSize(getCapacity());
        }
        if (isCurrent() && size() > 1) {
            contents.addAfter(value, getCurrentIndex());
            set(getCurrentIndex() + NEXT_POSITION);
        }
        else if (size() == 0) {
            contents.insertAtHead(value);
            set(DEFAULT_POSITION);
        }
        else if (isCurrent() && size() == 1) {
            contents.addLast(value);
            set(size());
        }
        else {
            contents.addLast(value);
            set(size());
        }
        size ++;
        ensureCapacity(getCapacity());
    }

    
    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent()
    {
        return (getCurrentIndex() >= 0 && getCurrentIndex() < size());
    }
    
    
    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
        return linkedListCapacity;
    }

    
    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
        if (isCurrent()) {
            return getDesiredIndex(currentElementIndex);
        }
        else {
            return null;
        }
    }
    
    
    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (getCapacity() < minCapacity) {
            setCapacity(minCapacity);
        }
    }

    
    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make (just enough) room for
     * all of the elements to be added.
     * 
     * Postcondition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another)
    {
        if (another.size() + this.size() > this.getCapacity()) {
            increaseSequenceSize(this.size());
        }
        for (int i = 0; i < another.size(); i++){
            contents.addLast(another.getDesiredIndex(i));
            if (another.getDesiredIndex(i).equals(this.getCurrent())) {
                this.set(NO_CURRENT_VAL);
            }
            size++;
        }
        if (another.getCurrent() == null && this.getCurrent() != null) {
            another.set(NO_CURRENT_VAL);
        }
        else if (another.getCurrent() != null && this.getCurrent() == null) {
            this.set(NO_CURRENT_VAL);
        }
        else if (another.getCurrent() == null && this.getCurrent() == null){
            this.set(NO_CURRENT_VAL);
            another.set(NO_CURRENT_VAL);
        }
        ensureCapacity(getCapacity());
    }

    
    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     */
    public void advance()
    {
        if (isCurrent() && getCurrentIndex() < size()) {
            currentElementIndex += 1;
        }
        else if (isCurrent() && getCurrentIndex() == size()) {
            set(NO_CURRENT_VAL);
        }
    }

    
    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     * 
     * Postcondition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */
    public Sequence clone()
    {
        Sequence copiedSequence = new Sequence();
        copiedSequence.set(this.getCurrentIndex());
        copiedSequence.setCapacity(this.getCapacity());
        copiedSequence.size = this.size;
        copiedSequence.contents = this.contents.cloneList();
        return copiedSequence;
    }
   
    
    /**
     * Remove the current element from this sequence.  The following
     * element, if there was one, becomes the current element.  If
     * there was no following element (current was at the end of the
     * sequence), the sequence now has no current element.
     *
     * If there is no current element, does nothing.
     */
    public void removeCurrent()
    {
        if (isCurrent()){
            contents.deleteNode(getCurrent());
            if (getCurrentIndex() == size()-1) {
                set(NO_CURRENT_VAL);
            }
            else{
                set(getCurrentIndex());
            }
            size --;
        }
    }

    
    /**
     * @return the number of elements stored in the sequence.
     */
    public int size()
    {
        return size;
    }

    
    /**
     * Sets the current element to the start of the sequence.  If the
     * sequence is empty, the sequence has no current element.
     */
    public void start()
    {
        if (!isEmpty()) {
            set(DEFAULT_POSITION);
        }
        else {
            set(NO_CURRENT_VAL);
        }
    }

    
    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {
        setCapacity(size());    
    }
    
    
    /**
     * Produce a string representation of this sequence.  The current
     * location is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the current element, and the
     * capacity is 5, would print as:
     * 
     *    {A, >B} (capacity = 5)
     * 
     * The string you create should be formatted like the above example,
     * with a comma following each element, no comma following the
     * last element, and all on a single line.  An empty sequence
     * should give back "{}" followed by its capacity.
     * 
     * @return a string representation of this sequence.
     */
    public String toString() 
    {
        String toReturn = "{";
        if (isEmpty()) {
            toReturn += "} (capacity = " + getCapacity() + ")";
        }
        else {
            for (int i = DEFAULT_POSITION; i < size() ; i++) {
                if (i == getCurrentIndex() && i < size()-1) {
                    toReturn += ">" + getCurrent() + ", ";
                }
                else if (i == getCurrentIndex() && i == size()-1) {
                    toReturn += ">" + getCurrent();
                }
                else if (i == size()-1  && i != getCurrentIndex()){
                    toReturn += getDesiredIndex(i);
                }
                else if (i == size()-1 && i == getCurrentIndex()) {
                    toReturn += ">" + getCurrent();
                }
                else {
                    toReturn += getDesiredIndex(i) + ", ";
                }
            } 
            toReturn += "} (capacity = " + getCapacity() + ")";
        }
        return toReturn;
    }
    
    /**
     * Checks whether another sequence is equal to this one.  To be
     * considered equal, the other sequence must have the same size
     * as this sequence, have the same elements, in the same
     * order, and with the same element marked
     * current.  The capacity can differ.
     * 
     * Postcondition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     * 
     * @param other the other Sequence with which to compare
     * @return true iff the other sequence is equal to this one.
     */
    public boolean equals(Sequence other) 
    {
        boolean equals = true;
        if (this.size() == other.size()) {
            if(!this.checkOrder(other)){
                if (this.isCurrent() && other.isCurrent()){
                    if (this.getCurrentIndex() == other.getCurrentIndex()) {
                        equals = true;
                        if (this.getCurrent().equals(other.getCurrent())){
                            equals = true;
                        }
                        else{ 
                            return false;
                        } 
                    } 
                    else {
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }
        return equals;
    }
    
    /**
     * 
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * @return True if each element of two arrays are in the same order, false otherwise
     */
    public boolean checkOrder(Sequence other)
    {
        boolean orderCheck = true;
        for (int i = DEFAULT_POSITION; i < this.size(); i++) {
            if (this.getDesiredIndex(i) != other.getDesiredIndex(i)) {
               return false;
            }
        }
        return orderCheck;
    }

    /**
     * Checks to see if the sequence is full.
     * @return True if full, false otherwise.
     */
    private boolean isFull()
    {
        return size() == linkedListCapacity;
    }
    
    
    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear()
    {
        contents.clearList();
        set(NO_CURRENT_VAL);
        size = 0;
        
    }

}