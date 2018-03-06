package interviews.recursion;

import java.util.Arrays;

/**
 * The last hop a child makes to a nth step was either a
 * 3-step, 2-step or 1-step hop.
 *
 * How many ways are there to get to the nth step?
 */
public class ChildrenSteps {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            int ways = countWays(i);
            long finish = System.nanoTime();
            System.out.println("n = "+ i + ". Ways = " + ways + ". Time (us) = " + (finish-start)/1_000D);

        }
    }

    private static int countWays(int n) {
        // cache to store calculated values for each step
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return countWays(n, cache);
    }


    private static int countWays(int n, int[] cache) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (cache[n] != -1) {
            return cache[n];
        }

        int ways = (countWays(n - 1, cache) + countWays(n - 2, cache) + countWays(n - 3, cache));
        cache[n] = ways;
        return ways;
    }
}
