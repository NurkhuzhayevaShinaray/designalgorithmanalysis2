import org.junit.jupiter.api.Test;
import sorting.ShellSort;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShellSortTest {

    @Test
    void testSmallManualArray() {
        int[] arr = {5, 2, 9, 1, 6, 3};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        int[] shell = arr.clone();
        int[] knuth = arr.clone();
        int[] sedgewick = arr.clone();

        ShellSort.sort(shell);
        ShellSort.sortWithKnuth(knuth);
        ShellSort.sortWithSedgewick(sedgewick);

        assertArrayEquals(expected, shell, "Shell’s sequence failed");
        assertArrayEquals(expected, knuth, "Knuth’s sequence failed");
        assertArrayEquals(expected, sedgewick, "Sedgewick’s sequence failed");
    }

    @Test
    void testRandomArrays() {
        Random rnd = new Random(42);
        for (int t = 0; t < 50; t++) {
            int n = 20 + rnd.nextInt(100);
            int[] arr = rnd.ints(n, -1000, 1000).toArray();

            int[] expected = arr.clone();
            Arrays.sort(expected);

            int[] shell = arr.clone();
            int[] knuth = arr.clone();
            int[] sedgewick = arr.clone();

            ShellSort.sort(shell);
            ShellSort.sortWithKnuth(knuth);
            ShellSort.sortWithSedgewick(sedgewick);

            assertArrayEquals(expected, shell, "Shell’s sequence failed on random array");
            assertArrayEquals(expected, knuth, "Knuth’s sequence failed on random array");
            assertArrayEquals(expected, sedgewick, "Sedgewick’s sequence failed on random array");
        }
    }

    @Test
    void testSpecialCases() {
        int[] empty = {};
        ShellSort.sort(empty);
        ShellSort.sortWithKnuth(empty);
        ShellSort.sortWithSedgewick(empty);
        assertArrayEquals(new int[]{}, empty);


        int[] single = {42};
        ShellSort.sort(single);
        assertArrayEquals(new int[]{42}, single);


        int[] sorted = {1, 2, 3, 4, 5};
        int[] expected = sorted.clone();
        ShellSort.sort(sorted);
        assertArrayEquals(expected, sorted);


        int[] reverse = {5, 4, 3, 2, 1};
        int[] expectedRev = reverse.clone();
        Arrays.sort(expectedRev);
        ShellSort.sortWithKnuth(reverse);
        assertArrayEquals(expectedRev, reverse);
    }
}
