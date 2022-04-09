package ru.skypro.HW15;

import java.util.Arrays;

public class ExaminationSort {

    int[] arr = creatArray();
    int[] arr1 = Arrays.copyOf(arr, arr.length);
    int[] arr2 = Arrays.copyOf(arr, arr.length);
    int[] arr3 = Arrays.copyOf(arr, arr.length);
    int[] arr4 = Arrays.copyOf(arr, arr.length);

    public int[] creatArray() {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (600 + 1)) - 200;
        }
        return arr;
    }

    public void sortBubbleTested() {
        long start = System.currentTimeMillis();
        SortMethod.sortBubble(arr1);
        System.out.println("Размер массива: " + arr1.length);
        System.out.print("Пузырьковая сортировка: ");
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void sortInsertionTested() {
        long start = System.currentTimeMillis();
        SortMethod.sortInsertion(arr2);
        System.out.println("Размер массива: " + arr2.length);
        System.out.print("Сортировка вставкой: ");
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void sortSelectionTested() {
        long start = System.currentTimeMillis();
        SortMethod.sortSelection(arr3);
        System.out.println("Размер массива: " + arr3.length);
        System.out.print("Сортировка выбором: ");
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void sortQuick() {
        long start = System.currentTimeMillis();
        SortMethod.quickSort(arr4);
        System.out.println("Размер массива: " + arr4.length);
        System.out.print("Быстрая сортировка: ");
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
