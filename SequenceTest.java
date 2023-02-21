/**
 * Unit Tests for the Sequence Class.
 * Author: Jude Kappel
 */

package proj3;

import org.junit.Test;
import static org.junit.Assert.*;

public class SequenceTest {


    @Test // Size should equal 0 on construction. initial capacity should equal 10. // current index is zero and current element is null.
    public void constructDefaultSequence() 
    {
        Sequence s = new Sequence();
        // assertEquals(0, s.size());
        assertEquals(10, s.getCapacity());
        assertNull(s.getCurrent());
    }

    @Test // Size should equal 0 on construction. initial capacity should equal 24. // current index is zero and current element is null.
    public void constructParameterizedSequence() 
    {
        Sequence s = new Sequence(24);
        // assertEquals(0,s.size());
        assertEquals(24, s.getCapacity());
        assertNull(s.getCurrent());
    }

    @Test // testing addbefore and getCurrent methods. should return the expected element at the current index
    public void addBefore_UnderCapacity() 
    {
        Sequence s = new Sequence();
        s.addBefore("testElement");
        assertEquals(1, s.size());
        assertEquals("testElement", s.getCurrent()); 
    }

    @Test // add to a full sequence.  capacity should not change.
    public void addBefore_fullSequence() 
    {
        Sequence s = new Sequence(1);
        s.addBefore("testValue");
        assertEquals("testValue", s.getDesiredIndex(0));
        assertEquals(1, s.getCapacity());
    }

    @Test // same as addBefore_underCapacity. should return the expected element at the current index
    public void addAfter_UnderCapacity() 
    {
        Sequence s = new Sequence();
        s.addAfter("testElement");
        assertEquals(1, s.size());
        assertEquals("testElement", s.getCurrent());
    }

    @Test // add to a full sequence.  capacity should not change.
    public void addAfter_fullSequence() 
    {
        Sequence s = new Sequence(1);
        s.addAfter("testValue");
        assertEquals("testValue", s.getDesiredIndex(0));
        assertEquals(1, s.getCapacity());
    }

    @Test  // add to under capacity sequence
    public void addBefore_UnderCapacity_CurrentElement() 
    {
        Sequence s = new Sequence();
        s.addBefore("testElement");
        s.addBefore("testValue1");
        assertEquals(2, s.size());
        assertEquals("testValue1", s.getCurrent());
        assertEquals("{>testValue1, testElement} (capacity = 10)", s.toString());
        // assertEquals("testValue1", s.getCurrent()); 
    }

    @Test // testing capacity test
    public void addBefore_AtCapacity() 
    {
        Sequence s = new Sequence();
        s.addBefore("testElement1");
        s.addBefore("testElement2");
        s.addBefore("testElement3");
        s.addBefore("testElement4");
        s.addBefore("testElement5");
        s.addBefore("testElement6");
        s.addBefore("testElement7");
        s.addBefore("testElement8");
        s.addBefore("testElement9");
        s.addBefore("testElement10");
        s.addBefore("testElement_11");
        assertEquals(11, s.size());
        assertEquals(21, s.getCapacity());
        assertEquals("testElement_11", s.getCurrent()); 
    }

    @Test  // get current element and size test
    public void addAfter_UnderCapacity_CurrentElement() 
    {
        Sequence s = new Sequence();
        s.addAfter("testElement");
        s.addAfter("testValue1");
        assertEquals(2, s.size());
        assertEquals("testValue1", s.getCurrent()); 
    }

    @Test // remove the first element
    public void removeCurrent_firstElement()
    {
        Sequence s = new Sequence();
        s.addAfter("testElement");
        s.addAfter("testElement1");
        s.addAfter("testElement2");
        s.set(0);
        s.removeCurrent();
        assertEquals("testElement1", s.getCurrent());
    }

    @Test // tostring test
    public void toString_testSequenceWithElements() 
    {
        Sequence s = new Sequence();
        s.addAfter("A");
        // s.addBefore("b");
        s.addAfter("f");
        assertEquals("{A, >f} (capacity = 10)", s.toString());
    }

    @Test // addAll to a populated sequence
    public void addAll_emptySequenceToPopulated()
    {
        Sequence s = new Sequence();
        Sequence newSequence = new Sequence();
        s.addAfter("a");
        s.addAfter("b");
        s.addAll(newSequence);
        assertEquals("{a, >b} (capacity = 10)", s.toString());
    }

    @Test // no current addBefore test
    public void addBefore_noCurrent() 
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        s.addAfter("value2");
        s.set(-1);
        assertEquals(false, s.isCurrent());
        s.addBefore("testvalue");
        assertEquals("{>testvalue, value, value1, value2} (capacity = 10)", s.toString());
    }

    @Test // two empty sequences should be equal
    public void testEquals_emptySequence() 
    {
        Sequence s = new Sequence();
        Sequence newSeq = new Sequence();
        assertTrue(s.equals(newSeq));
    }

    @Test // testing equal sequences with different caps
    public void testEquals_SequenceDiffCapacity() 
    {
        Sequence s = new Sequence(1);
        Sequence newSeq = new Sequence();
        assertTrue(s.equals(newSeq));
    }

    @Test // test of cloning an empty sequence
    public void testCloned_emptySequence() 
    {
        Sequence s = new Sequence();
        Sequence n = s.clone();
        assertEquals(s.toString(), n.toString());
        assertEquals(n.toString(), s.toString());
    }


    @Test // testing mutability.  the clone should not change the original, and vice versa.
    public void testChangedClone() 
    {
        Sequence s = new Sequence(1);
        Sequence n = s.clone();
        s.addAfter("value");
        assertFalse(s.equals(n));
        assertNotEquals(n.toString(), s.toString());
    }

    @Test // testing addall to a nonempty sequence
    public void testAddAll_NonEmptyStrings()
    {
        Sequence s = new Sequence(1);
        Sequence newSeq = new Sequence(3);
        s.addAfter("value");
        newSeq.addAfter("value1");
        newSeq.addAfter("value2");
        newSeq.addAfter("value3");
        s.addAll(newSeq);
        assertEquals("{>value, value1, value2, value3} (capacity = 3)", s.toString());
    }

    @Test // if sequence s = sequence n, by symmetry n should also equal s.
    public void equals_testSymmetry()
    {
        Sequence s = new Sequence();
        s.addBefore("value");
        s.addAfter("value1");
        Sequence n = new Sequence();
        n.addBefore("value");
        n.addAfter("value1");
        assertTrue(n.equals(s));
        assertTrue(s.equals(n));
    }

    @Test // two sequences should not be equal. after advancing to  value , >value1 for both, should return True.
    public void equals_testAdvanceToEqual()
    {
        Sequence s = new Sequence();
        s.addBefore("value1");
        s.addBefore("value");
        Sequence n = new Sequence();
        n.addBefore("value");
        n.addAfter("value1");
        assertFalse(n.equals(s));
        s.advance();
        assertEquals(s.size(), n.size());
        assertEquals(n.checkOrder(s),s.checkOrder(n));
        assertEquals(n.getCurrent(), s.getCurrent());
        assertEquals(s.getCurrentIndex(), s.getCurrentIndex());
        assertEquals(n.toString(), s.toString());
        assertEquals(n.toString(),s.toString());
        assertTrue(s.equals(n));
    }

    @Test // tostring + isCurrent test, isCurrent should be true and the current element should be at testValue
    public void addAfter_noCurrentTest() 
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        s.addAfter("value2");
        s.set(-1);
        s.addAfter("testValue");
        assertEquals("{value, value1, value2, >testValue} (capacity = 10)", s.toString());
        assertTrue(s.isCurrent());


    }

    @Test // capcity should grow to specified size (in this case 9)
    public void ensureCapacityTest() 
    {
        Sequence s = new Sequence(2);
        s.ensureCapacity(9);
        assertEquals(9, s.getCapacity());
    }

    @Test // start/clear test 
    public void startTest()
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        s.start();
        assertEquals(0, s.getCurrentIndex());
        s.clear();
        assertEquals(-1, s.getCurrentIndex());
    }

    @Test
    public void addAfterTest_endSequence()
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        s.set(-1);
        s.addAfter("testValue");
        assertEquals("{value, value1, >testValue} (capacity = 10)", s.toString());
    }

    @Test // testing add all and getting the current element 
    public void testCurrentElement_AddAll()
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        Sequence n = new Sequence();
        s.addAll(n);
        assertTrue( "n has no current", n.getCurrent() == null);
    }


    @Test // removing the current element last in sequence
    public void removeCurrentLast() 
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        s.addAfter("testValue");
        s.removeCurrent();
        assertEquals("{value, value1} (capacity = 10)", s.toString());
        // assertEquals("value1", s.getCurrent());
    }


    @Test // removing the current element first in sequence
    public void removeCurrentFirst()
    {
        Sequence s = new Sequence();
        s.addAfter("value");
        s.addAfter("value1");
        s.addAfter("testValue");
        s.set(0);
        s.removeCurrent();
        assertEquals("{>value1, testValue} (capacity = 10)", s.toString());
        assertEquals("value1", s.getCurrent());
    }

}
