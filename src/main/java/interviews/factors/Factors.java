package interviews.factors;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all factors for value N
 */
public class Factors {

    public static void main(String[] args) {
        factors(1);
        factors(24);
        factors(25);
        factors(50);
        factors(100);
        factors(1000);

        System.out.println("------------------------");

        factorsSqrt(1);
        factorsSqrt(24);
        factorsSqrt(25);
        factorsSqrt(50);
        factorsSqrt(100);
        factorsSqrt(1000);
    }

    private static int factors(int N) {

        List<Integer> factors = new ArrayList<>();
        List<Integer> divisors = new ArrayList<>();

        // we don't need to test 1 - will always be factor.
        factors.add(1);
        divisors.add(N / 1);
        int count = 1;

        // test the remaining possible factors
        for (int i = 2; i <= N / 2; i++) {
            if (N % i == 0) {
                count++;
                factors.add(i);
                divisors.add(N / i);
            }
        }

        // add N as a factor - will always be factor.
        if (N > 1) {
            factors.add(N);
            divisors.add(N / N);
            count++;
        }

        System.out.println(N + " = " + factors);
        System.out.println(N + " = " + divisors);

        return count;
    }

    /**
     * Faster square root technique.
     *
     * @param N
     * @return
     */
    private static int factorsSqrt(int N) {

        if (N == 1) {
            System.out.println(N + " = " + 1);
            return 1;
        }

        // try for square root technique
        int count = 0;
        for (int i = 1; i <= Math.sqrt(N); i++)
        {
            if (N % i == 0) {
                count++;
            }
        }

        // if N is a perfect square root (e.g. 25 = 5) then remove 1
        if ((int) Math.sqrt(N) * (int) Math.sqrt(N) == N) {
            System.out.println(N + " = " + ((count * 2) - 1));
            return (count * 2) - 1;
        }

        System.out.println(N + " = " + (count * 2));
        return count * 2;
    }

}
