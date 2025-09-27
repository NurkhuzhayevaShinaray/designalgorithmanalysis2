package sorting;

import metrics.PerformanceTracker;

public class HeapSort {
    private PerformanceTracker tracker;

    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) tracker.incrementComparisons();
        if (right < n) tracker.incrementComparisons();

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        tracker.incrementSwaps();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
