package metrics;

public class PerformanceTracker {
    private int comparisons;
    private int swaps;
    private long startTime;
    private long endTime;


    public void start() {

        startTime = System.currentTimeMillis();
    }

    public void stop() {

        endTime = System.currentTimeMillis();
    }

    public long elapsedMs() {

        return endTime - startTime;
    }

    public void incrementComparisons() {

        comparisons++;
    }

    public void incrementSwaps() {

        swaps++;
    }


    @Override
    public String toString() {
        return "Time: " + elapsedMs() + " ms, Comparisons: " + comparisons + ", Swaps: " + swaps;
    }
}
