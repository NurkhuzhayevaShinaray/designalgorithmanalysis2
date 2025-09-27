package org.example;

import sorting.HeapSort;
import metrics.PerformanceTracker;

import java.util.Arrays;

public class HeapSortRunner {
    public static void main(String[] args) {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));

        sorter.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Performance: " + tracker);
    }
}
