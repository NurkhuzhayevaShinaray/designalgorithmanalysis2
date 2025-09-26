package sorting;

import metrics.PerformanceTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShellSort {

    public static PerformanceTracker sort(int[] arr) {
        PerformanceTracker tracker = new PerformanceTracker();
        if (arr == null || arr.length <= 1)
            return tracker;
        tracker.start();

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap) {
                    tracker.incrementComparisons();
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        tracker.incrementSwaps();
                        j -= gap;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
        }
        tracker.stop();
        return tracker;
    }


    public static PerformanceTracker sortWithKnuth(int[] arr) {
        PerformanceTracker tracker = new PerformanceTracker();
        if (arr == null || arr.length <= 1)
            return tracker;
        tracker.start();

        List<Integer> gaps = new ArrayList<>();
        int h = 1;
        while (h < arr.length) {
            gaps.add(h);
            h = 3 * h + 1;
        }
        Collections.reverse(gaps);

        for (int gap : gaps) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap) {
                    tracker.incrementComparisons();
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        tracker.incrementSwaps();
                        j -= gap;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
        }

        tracker.stop();
        return tracker;
    }

    public static PerformanceTracker sortWithSedgewick(int[] arr) {
        PerformanceTracker tracker = new PerformanceTracker();
        if (arr == null || arr.length <= 1)
            return tracker;
        tracker.start();

        List<Integer> gaps = new ArrayList<>();
        int k = 0;
        while (true) {
            int gap;
            if (k % 2 == 0) {
                gap = (int) (9 * Math.pow(2, k) * Math.pow(2, k) - 9 * Math.pow(2, k) + 1);
            } else {
                gap = (int) (8 * Math.pow(2, k) - 6 * Math.pow(2, (k + 1)/2) + 1);
            }
            if (gap >= arr.length)
                break;
            gaps.add(gap);
            k++;
        }

        Collections.reverse(gaps);

        for (int gap : gaps) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap) {
                    tracker.incrementComparisons();
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        tracker.incrementSwaps();
                        j -= gap;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
        }

        tracker.stop();
        return tracker;
    }

}
