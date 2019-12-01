package prj5;

import java.util.Iterator;

import student.TestCase;

/**
 * 
 * @author Ryan Bui
 * @version 2019.11.27
 */
public class SinglyLinkedListTest extends TestCase {
    /**
     * fields
     */
    private SinglyLinkedList<String> test;

    /**
     * setUp
     */
    public void setUp() {
        test = new SinglyLinkedList<>();
    }

    /**
     * test size method
     */
    public void testSize() {

        assertEquals(0, test.size());
        test.add("test");
        assertEquals(1, test.size());
    }

    /**
     * test add method with only two parameter
     */
    public void testAdd() {
        Exception exception = null;
        try {
            test.add(-1, null);
            fail("add() is not throwing an exception when it should");
        }

        catch (Exception e) {
            exception = e;
        }

        assertTrue("add() is throwing the wrong type of exceptions",
                exception instanceof IllegalArgumentException);

        Exception exception1 = null;
        try {
            test.add(10, "word");
            fail("add() is not throwing an exception when it should");
        }

        catch (Exception e) {
            exception1 = e;
        }

        assertTrue("add() is throwing the wrong type of exceptions", 
                exception1 instanceof IndexOutOfBoundsException);
        
        Exception exception2 = null;
        try {
            test.add(-1, "word");
            fail("add() is not throwing an exception when it should");
        }

        catch (Exception e) {
            exception2 = e;
        }

        assertTrue("add() is throwing the wrong type of exceptions", 
                exception2 instanceof IndexOutOfBoundsException);

        assertEquals(0, test.size());
        test.add(0, "test");
        assertEquals(1, test.size());
        test.add(0, "test2");
        test.add(2, "wow");
        assertEquals("test", test.get(1));
        assertEquals("{test2, test, wow}", test.toString());
    }

    /**
     * test add method with one parameter
     */
    public void testAdd2() {
        Exception exception = null;
        try {
            test.add(null);
            fail("add() is not throwing an exception when it should");
        }

        catch (Exception e) {
            exception = e;
        }

        assertTrue("add() is throwing the wrong type of exceptions", 
                exception instanceof IllegalArgumentException);

        assertEquals(0, test.size());
        test.add("hello");
        assertEquals(1, test.size());
    }

    /**
     * is the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(test.isEmpty());
        test.add("hallo");
        assertFalse(test.isEmpty());
    }

    /**
     * test remove method for a specific object
     */
    public void testRemove1() {
        test.add("hallo");
        test.add("boo");
        test.add("halloween");
        test.remove("boo");
        assertEquals("{hallo, halloween}", test.toString());
        test.remove("halloween");
        assertEquals("{hallo}", test.toString());
        assertFalse(test.remove("poop"));
        test.remove("hallo");
        assertEquals("{}", test.toString());
    }

    /**
     * test remove method for a specific index
     */
    public void testRemove2() {
        Exception exception = null;
        try {
            test.remove(10);
            fail("remove() is throwing an exception when it should");
        }

        catch (Exception e) {
            exception = e;
        }

        assertTrue("remove() is throwing the wrong type of exception", 
                exception instanceof IndexOutOfBoundsException);
        test.add("hello");
        test.add("boo");
        test.add("halloween");
        test.remove(1);
        assertEquals("{hello, halloween}", test.toString());
        test.remove(1);
        assertEquals("{hello}", test.toString());
    }

    /**
     * test get method
     */
    public void testGet() {
        Exception exception = null;
        try {
            test.get(10);
            fail("get() is throwing an exception when it should");
        }

        catch (Exception e) {
            exception = e;
        }

        assertTrue("get() is throwing the wrong type of exception", 
                exception instanceof IndexOutOfBoundsException);

        String testS = "hello";
        test.add(testS);
        test.add("adsfasdf");

        assertTrue(testS.equals(test.get(0)));
    }

    /**
     * test the contains method
     */
    public void testContains() {
        test.add("hello");
        test.add("boo");
        test.add("halloween");
        assertTrue(test.contains("boo"));
        assertFalse(test.contains("doesn't exist"));
    }

    /**
     * test clear method
     */
    public void testClear() {
        test.add("hello");
        test.add("boo");
        test.add("halloween");
        assertEquals(3, test.size());
        test.clear();
        assertEquals(0, test.size());
    }

    /**
     * test lastIndexOf method
     */
    public void testLastIndexOf() {
        test.add("hello");
        test.add("boo");
        test.add("hello");
        test.add("halloween");

        assertEquals(2, test.lastIndexOf("hello"));
        assertEquals(-1, test.lastIndexOf("uwu"));
    }

    /**
     * test the toString method
     */
    public void testToString() {
        test.add("hello");
        test.add("boo");
        test.add("hello");
        test.add("halloween");
        assertEquals("{hello, boo, hello, halloween}", test.toString());
    }
    
    /**
     * test the equals method
     */
    public void testEquals() {
        test.add("test");
        SinglyLinkedList<String> same = test;
        SinglyLinkedList<String> same1 = new SinglyLinkedList<>();
        same1.add("test");
        SinglyLinkedList<String> notSame = new SinglyLinkedList<>();
        notSame.add("test2");
        SinglyLinkedList<String> diffSize = new SinglyLinkedList<>();
        diffSize.add("1");
        diffSize.add("2");
        String notList = "";
        SinglyLinkedList<String> nullList = null;
        
        assertTrue(test.equals(same));
        assertTrue(test.equals(same1));
        assertFalse(test.equals(notSame));
        assertFalse(test.equals(nullList));
        assertTrue(test.equals(test));
        assertFalse(test.equals(notList));
        assertFalse(test.equals(diffSize));
    }
    
    /**
     * test getIterator
     */
    public void testIterator() {
        assertFalse(test.iterator().hasNext());
        
        test.add("A");
        test.add("B");
        test.add("C");
        
        assertTrue(test.iterator().hasNext());
    }
}
