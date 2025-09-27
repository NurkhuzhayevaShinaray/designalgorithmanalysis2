import org.junit.Test;
import sorting.HeapSort;
import metrics.PerformanceTracker;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        int[] arr = {4, 1, 3, 4, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 4}, arr);
    }
}
