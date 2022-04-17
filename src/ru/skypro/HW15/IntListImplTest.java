package ru.skypro.HW15;

import org.junit.jupiter.api.Test;
import ru.skypro.Exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class IntListImplTest {

    IntListImpl intList = new IntListImpl();

    @Test
    void add() {
        assertEquals(1, intList.add(1));
    }

    @Test
    void shouldBeEmpty() {
        IntListImpl intList = new IntListImpl();
        assertEquals(0, intList.size());
    }

    @org.junit.jupiter.api.Test
    void shouldAddByIndex1() {
        intList.add(1);
        intList.add(1, 1);
        assertEquals(1, intList.get(0));
        assertEquals(1, intList.get(1));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowWhenIndexBigAdded() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(1, 1)); // если разрыв между ячейками
    }

    @org.junit.jupiter.api.Test
    void shouldItemGet() {
        intList.add(1);
        assertEquals(1, intList.get(0));
    }

    @org.junit.jupiter.api.Test
    void shouldTrowItemGet() {
        intList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.get(13));
    }

    @org.junit.jupiter.api.Test
    void size() {
        intList.add(1);
        intList.add(1);
        assertEquals(2, intList.size());
    }

    @org.junit.jupiter.api.Test
    void trueIsEmpty() {
        assertEquals(true, intList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void falseIsEmpty() {
        intList.add(1);
        assertEquals(false, intList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.clear();
        assertEquals(true, intList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void shouldSet() {
        intList.add(0);
        intList.add(1);
        intList.add(2);
        assertEquals(1, intList.set(1, 15));
        assertEquals(15, intList.get(1));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowWhenIndexBigSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.set(0, 1));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveItem() {
        int test = 1;
        intList.add(test);
        assertEquals(test, intList.removeByValue(test));
        assertEquals(0, intList.size());
    }

    @org.junit.jupiter.api.Test
    void shouldThrowRemoveItem() {
        assertThrows(NotFoundException.class, () -> intList.removeByValue(3));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveIndex() {
        intList.add(0);
        intList.add(1);
        assertEquals(0, intList.removeByIndex(0));
        assertEquals(1, intList.size());
        assertEquals(1, intList.get(0));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowRemoveIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.removeByIndex(0));
    }

    @org.junit.jupiter.api.Test
    void shouldTrueContains() {
        intList.add(1);
        assertEquals(true, intList.contains(1));
    }

    @org.junit.jupiter.api.Test
    void shouldFalseItemContains() {
        assertEquals(false, intList.contains(1));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        intList.add(0);
        intList.add(1);
        intList.add(1);
        intList.add(3);
        intList.add(4);
        assertEquals(1, intList.indexOf(1));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        intList.add(0);
        intList.add(1);
        intList.add(1);
        intList.add(3);
        intList.add(4);
        assertEquals(2, intList.lastIndexOf(1));
    }


    @org.junit.jupiter.api.Test
    void testEquals() {
        IntList firstIntList = new IntListImpl();
        IntList secondIntList = new IntListImpl();
        assertTrue(firstIntList.equals(secondIntList));
        assertTrue(secondIntList.equals(firstIntList));
    }

    @org.junit.jupiter.api.Test
    void testEquals1() {
        int i = 1;
        IntList firstIntList = new IntListImpl();
        firstIntList.add(i);
        IntList secondIntList = new IntListImpl();
        secondIntList.add(i);
        assertTrue(firstIntList.equals(secondIntList));
        assertTrue(secondIntList.equals(firstIntList));

    }

    @org.junit.jupiter.api.Test
    void testNotEquals() {
        IntList firstIntList = new IntListImpl();
        IntList secondIntList = new IntListImpl();
        secondIntList.add(1);
        assertFalse(firstIntList.equals(secondIntList));
        assertFalse(secondIntList.equals(firstIntList));
    }

    @org.junit.jupiter.api.Test
    void testNotEquals1() {
        IntList firstIntList = new IntListImpl();
        firstIntList.add(1);
        IntList secondIntList = new IntListImpl();
        secondIntList.add(2);
        assertFalse(firstIntList.equals(secondIntList));
        assertFalse(secondIntList.equals(firstIntList));
    }


    @org.junit.jupiter.api.Test
    void toArray() {
        IntList intList = new IntListImpl();
        var expected = new Integer[0];
        assertArrayEquals(expected, intList.toArray());
    }

    @org.junit.jupiter.api.Test
    void toArray1() {
        int i = 1;
        IntList intList = new IntListImpl();
        intList.add(i);
        var expected = new Integer[1];
        expected[0] = i;
        assertArrayEquals(expected, intList.toArray());
    }

    @org.junit.jupiter.api.Test
    void toArray2() {
        int i = 1;
        IntList intList = new IntListImpl();
        intList.add(i);
        var expected = new Integer[1];
        expected[0] = 1;
        assertFalse(expected.equals(intList.toArray()));
    }
}