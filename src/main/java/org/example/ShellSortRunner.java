package org.example;

import metrics.PerformanceTracker;
import sorting.ShellSort;
import java.util.Arrays;

public class ShellSortRunner {
    public static void main(String[] args) {
        int[] arr = {97, 14, 68, 103, 6, 94, -1, 25, 129, 433, 931, 0, 6436};


        int[] arrShell = arr.clone();
        int[] arrKnuth = arr.clone();
        int[] arrSedgewick = arr.clone();

        PerformanceTracker t1 = ShellSort.sort(arrShell);
        PerformanceTracker t2 = ShellSort.sortWithKnuth(arrKnuth);
        PerformanceTracker t3 = ShellSort.sortWithSedgewick(arrSedgewick);


        System.out.println("Array:   " + Arrays.toString(arr));
        System.out.println("Shell:      " + Arrays.toString(arrShell) + " - " + t1);
        System.out.println("Knuth:      " + Arrays.toString(arrKnuth) + " - " + t2);
        System.out.println("Sedgewick:  " + Arrays.toString(arrSedgewick) + " - " + t3);
    }
}
