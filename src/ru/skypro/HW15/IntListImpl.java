package ru.skypro.HW15;

import ru.skypro.Exception.NotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class IntListImpl implements IntList {

    private static final int CAPACITY = 13;
    private Integer[] array = new Integer[CAPACITY];
    private int size = 0;
    private final double EXPANDED_ARRAY = 1.5;

    private void growIfNeed() {
        if (size >= array.length) {
            growArray();
        }
    }

    @Override
    public Integer add(Integer item) {
        growIfNeed();
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        growIfNeed();
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        Integer old = get(index);
        array[index] = item;
        return old;
    }

    @Override
    public Integer removeByValue(Integer item) {
        int i = indexOf(item);
        if (i != -1) {
            removeByIndex(i);
        } else {
            throw new NotFoundException();
        }
        return item;
    }

    @Override
    public Integer removeByIndex(int index) {
        Integer element = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(Integer item) {
        var x = Arrays.copyOf(array, size);
        return binarySearch(x, item) >= 0;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null) {
            return false;
        }
        boolean result = true;
        if (this.size != otherList.size()) {
            result = false;
        } else {
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(otherList.get(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        array = new Integer[13];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        Integer mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }


    private int binarySearch(Integer[] arr, int desired) {
        mergeSort(arr);
        return Arrays.binarySearch(arr, desired);
    }

    private void growArray() {
        double newCapacity = (array.length * EXPANDED_ARRAY);
        Integer[] extended = new Integer[(int) Math.ceil(newCapacity)];
        System.arraycopy(array, 0, extended, 0, array.length);
        array = extended;
    }
}


