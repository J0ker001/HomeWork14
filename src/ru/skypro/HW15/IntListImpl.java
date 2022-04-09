package ru.skypro.HW15;

import ru.skypro.Exception.NotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class IntListImpl implements IntList {
    private Integer[] array = new Integer[13];
    private int size = 0;

    @Override
    public Integer add(Integer item) {
        if (size >= array.length) {
            Integer[] extended = new Integer[array.length * 2];
            System.arraycopy(array, 0, extended, 0, array.length);
            array = extended;
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(item);
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        Integer old = get(index);
        array[index] = item;
        return old;
    }

    @Override
    public Integer remove(Integer item) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                a = i;
                break;
            }
        }
        if (a != -1) {
            remove(a);
        } else {
            throw new NotFoundException();
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
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
        boolean result = true;
        for (Integer i : array) {
            if (i != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        array = new Integer[13];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[this.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    private static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private int binarySearch(Integer[] arr, int desired) {
        sortInsertion(arr);
        return Arrays.binarySearch(arr, desired);
    }
}


