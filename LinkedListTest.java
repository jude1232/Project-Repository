package proj3;


import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    // @Rule // a test will fail if it takes longer than 1/10 of a second to run
    // public Timeout timeout = Timeout.millis(100); 


    @Test //tests the construction of an empty list and toString Method
    public void testConstructList_toString()
    {
        LinkedList l = new LinkedList();
        assertEquals("()", l.toString());
    }

    @Test // test of the length of the list on construction.
    public void testGetLength() 
    {
        LinkedList l = new LinkedList();
        assertEquals(0, l.getLength());
    }

    @Test // test of insertAtHead
    public void testInsertAtHead()
    {
        LinkedList l = new LinkedList();
        String data = "data";
        l.insertAtHead(data);
        assertEquals("(data)", l.toString());
    }

    @Test
    public void testAddAfter()
    {
        LinkedList l = new LinkedList();
        l.insertAtHead("value");
        l.addAfter("value1", l.getIntIndex("value"));
        assertEquals("(value, value1)", l.toString());
    }

    @Test
    public void testAddAt()
    {
        LinkedList l = new LinkedList();
        l.insertAtHead("value");
        l.addAfter("value3", l.getIntIndex("value"));
        l.addAt("value2", "value", "value3" );
        assertEquals("(value, value2, value3)", l.toString());
        
    }

    @Test
    public void testAddBefore()
    {
        LinkedList l = new LinkedList();
        l.insertAtHead("value");
        l.addAfter("value1", l.getIntIndex("value"));
        l.addBefore("testValue", l.getIntIndex("value"));
        assertEquals("(testValue, value, value1)", l.toString());
    }

    @Test
    public void testRemoveItem()
    {
        LinkedList l = new LinkedList();
        l.insertAtHead("testValue");
        l.addAfter("testVal2", l.getIntIndex("testValue"));
        l.deleteNode("testValue");
        assertEquals("(testVal2)", l.toString());
    }

    // @Test
    // public void testIndexReturn() 
    // {
    //     LinkedList l = new LinkedList();
    //     l.insertAtHead("value");
    //     assertEquals(0,l.getIntIndex("value"));
    // }

    // @Test
    // public void testIndexReturn_multi() 
    // {
    //     LinkedList l = new LinkedList();
    //     l.insertAtHead("value");
    //     l.addAfter("value1", "value2");
    //     assertEquals(2,l.getIntIndex("value2"));
    // }

    @Test
    public void testNumElements()
    {
        LinkedList l = new LinkedList();
        l.insertAtHead("value");
        l.addAfter("value1", l.getIntIndex("value"));
        assertEquals(2, l.getLength());
    }

    @Test
    public void testAddAll()
    {

    }


}
