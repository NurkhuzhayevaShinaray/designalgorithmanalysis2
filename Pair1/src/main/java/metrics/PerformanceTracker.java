package metrics;

public class PerformanceTracker {
    private int comparisons;
    private int swaps;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons + ", Swaps: " + swaps;
    }
}
