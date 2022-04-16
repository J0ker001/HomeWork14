package ru.skypro.HW14;

import ru.skypro.Exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringListImpl stringList = new StringListImpl();


    @org.junit.jupiter.api.Test
    void add() {
        assertEquals("hello", stringList.add("hello"));
    }

    @org.junit.jupiter.api.Test
    void shouldBeEmpty() {
        StringListImpl newStringList = new StringListImpl();
        assertEquals(0, stringList.size());
    }

    @org.junit.jupiter.api.Test
    void shouldAddByIndex1() {
        stringList.add("1");
        stringList.add(1, "1");
        assertEquals("1", stringList.get(0));
        assertEquals("1", stringList.get(1));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowWhenIndexBigAdded() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(1, "Hello")); // если разрыв между ячейками
    }

    @org.junit.jupiter.api.Test
    void shouldItemGet() {
        stringList.add("hello");
        assertEquals("hello", stringList.get(0));
    }

    @org.junit.jupiter.api.Test
    void shouldTrowItemGet() {
        stringList.add("hello");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(13));
    }

    @org.junit.jupiter.api.Test
    void size() {
        stringList.add("1");
        stringList.add("1");
        assertEquals(2, stringList.size());
    }

    @org.junit.jupiter.api.Test
    void trueIsEmpty() {
        assertEquals(true, stringList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void falseIsEmpty() {
        stringList.add("1");
        assertEquals(false, stringList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");
        stringList.clear();
        assertEquals(true, stringList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void shouldSet() {
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        assertEquals("1", stringList.set(1, "15"));
        assertEquals("15", stringList.get(1));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowWhenIndexBigSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(0, "Hello"));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveItem() {
        String test = "test";
        stringList.add(test);
        assertEquals(test, stringList.remove(test));
        assertEquals(0, stringList.size());
    }

    @org.junit.jupiter.api.Test
    void shouldThrowRemoveItem() {
        assertThrows(NotFoundException.class, () -> stringList.remove("3"));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveIndex() {
        stringList.add("0");
        stringList.add("1");
        assertEquals("0", stringList.remove("0"));
        assertEquals(1, stringList.size());
        assertEquals("1", stringList.get(0));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowRemoveIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(0));
    }

    @org.junit.jupiter.api.Test
    void shouldTrueContains() {
        stringList.add("1");
        assertEquals(true, stringList.contains("1"));
    }

    @org.junit.jupiter.api.Test
    void shouldFalseItemContains() {
        assertEquals(false, stringList.contains("1"));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        stringList.add("0");
        stringList.add("1");
        stringList.add("1");
        stringList.add("3");
        stringList.add("4");
        assertEquals(1, stringList.indexOf("1"));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        stringList.add("0");
        stringList.add("1");
        stringList.add("1");
        stringList.add("3");
        stringList.add("4");

        assertEquals(2, stringList.lastIndexOf("1"));
    }


    @org.junit.jupiter.api.Test
    void testEquals() {
        StringList firstStringList = new StringListImpl();
        StringList secondStringList = new StringListImpl();
        assertTrue(firstStringList.equals(secondStringList));
        assertTrue(secondStringList.equals(firstStringList));
    }

    @org.junit.jupiter.api.Test
    void testEquals1() {
        String str = "her";
        StringList firstStringList = new StringListImpl();
        firstStringList.add(str);
        StringList secondStringList = new StringListImpl();
        secondStringList.add(str);
        assertTrue(firstStringList.equals(secondStringList));
        assertTrue(secondStringList.equals(firstStringList));

    }

    @org.junit.jupiter.api.Test
    void testNotEquals() {
        StringList firstStringList = new StringListImpl();
        StringList secondStringList = new StringListImpl();
        secondStringList.add("str");
        assertFalse(firstStringList.equals(secondStringList));
        assertFalse(secondStringList.equals(firstStringList));
    }

    @org.junit.jupiter.api.Test
    void testNotEquals1() {
        StringList firstStringList = new StringListImpl();
        firstStringList.add("map");
        StringList secondStringList = new StringListImpl();
        secondStringList.add("str");
        assertFalse(firstStringList.equals(secondStringList));
        assertFalse(secondStringList.equals(firstStringList));
    }


    @org.junit.jupiter.api.Test
    void toArray() {
        StringList stringList = new StringListImpl();
        var expected = new String[0];
        assertArrayEquals(expected, stringList.toArray());
    }

    @org.junit.jupiter.api.Test
    void toArray1() {
        String str = "test";
        StringList stringList = new StringListImpl();
        stringList.add(str);
        var expected = new String[1];
        expected[0] = str;
        assertArrayEquals(expected, stringList.toArray());
    }

    @org.junit.jupiter.api.Test
    void toArray2() {
        String str = "test";
        StringList stringList = new StringListImpl();
        stringList.add(str);
        var expected = new String[1];
        expected[0] = "str";
        assertFalse(expected.equals(stringList.toArray()));
        ;

    }
}