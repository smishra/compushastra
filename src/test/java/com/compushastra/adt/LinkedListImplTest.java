package com.compushastra.adt;

import junit.framework.TestCase;
import org.junit.Before;
import java.util.List;

public class LinkedListImplTest extends TestCase {
    @Before
    public void setup() {
    }

    public void testIsEmpty() {
        LinkedList l = new LinkedListImpl();
        assertTrue(l.isEmpty());
    }

    public void testLength() {
        LinkedList l = new LinkedListImpl();
        assertEquals(0, l.length());
        List.of("one", "two", "three").forEach(l::add);
        assertEquals(3, l.length());
    }

    public void testEmpty() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertFalse(l.isEmpty());
        l.empty();
        assertTrue(l.isEmpty());
    }

    public void testGet() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals("one", l.get(0));
        assertEquals("three", l.get(2));
        try {
            l.get(3);
            fail("Exception should be thrown");
        }
        catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void testInsertAtBeginning() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        l.insertAt(0, "zero");
        assertEquals(4, l.length());
        assertEquals("zero", l.get(0));
    }

    public void testInsert() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals("two", l.get(1));
        l.insertAt(1, "one and half");
        assertEquals(4, l.length());
        assertEquals("one and half", l.get(1));
        assertEquals("two", l.get(2));
        System.out.println(l);
    }

    public void testInsertAtEnd() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        l.insertAt(l.length(), "last");
        assertEquals(4, l.length());
        assertEquals("last", l.get(3));
    }

    public void testInsertAtGreaterThanLength() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        try {
            l.insertAt(l.length() + 2, "last");
            fail("Exception should be thrown");
        }
        catch (IndexOutOfBoundsException ignored){}
    }


    public void testRemoveAtTheBeginning() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals("one", l.get(0));
        Object removed = l.removeAt(0);
        assertEquals("one", removed);
        assertEquals(2, l.length());
        assertEquals("two", l.get(0));
        System.out.println(l);
    }

    public void testRemoveAt() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals("two", l.get(1));
        Object removed = l.removeAt(1);
        assertEquals("two", removed);
        assertEquals(2, l.length());
        assertEquals("three", l.get(1));
        System.out.println(l);
    }

    public void testRemoveAtTheEnd() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals("three", l.get(l.length()-1));
        Object removed = l.removeAt(l.length()-1);
        assertEquals("three", removed);
        assertEquals(2, l.length());
        assertEquals("two", l.get(l.length()-1));
        System.out.println(l);
    }

    public void testRemoveAtGreaterThanLength() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        try {
            l.removeAt(l.length());
            fail("Exception should be thrown");
        }
        catch (IndexOutOfBoundsException ignored) {}
    }

    public void testRemoveFromEmptyList() {
        LinkedList l = new LinkedListImpl();
        assertEquals(-1, l.remove("some"));
    }

    public void testRemoveNonExisting() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals(-1, l.remove("some"));
    }

    public void testRemove() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals(0, l.remove("one"));
        assertEquals(0, l.remove("two"));
        assertEquals(0, l.remove("three"));

        List.of("one", "two", "three").forEach(l::add);
        assertEquals(2, l.remove("three"));
        assertEquals(1, l.remove("two"));
        assertEquals(0, l.remove("one"));
    }

    public void testIndexOfFromEmptyList() {
        LinkedList l = new LinkedListImpl();
        assertEquals(-1, l.indexOf("some"));
    }

    public void testIndexOfNonExisting() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals(-1, l.indexOf("some"));
    }

    public void testIndexOf() {
        LinkedList l = new LinkedListImpl();
        List.of("one", "two", "three").forEach(l::add);
        assertEquals(0, l.indexOf("one"));
        assertEquals(1, l.indexOf("two"));
        assertEquals(2, l.indexOf("three"));
    }
}