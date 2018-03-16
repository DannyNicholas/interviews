package interviews.primesErathosthenes;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        System.out.println(calculatePrimes(100));
        System.out.println(calculatePrimes(97));
        System.out.println(calculatePrimes(200));
    }

    /**
     * Return all primes up to max.
     *
     * @param max
     * @return
     */
    private static List<Integer> calculatePrimes(int max) {

        List<Integer> primes = new ArrayList<>();

        // initially everything could be a prime
        boolean[] possiblePrimes = new boolean[max+1];
        for (int i = 2; i <= max; i++) {
            possiblePrimes[i] = true;
        }

        // find all primes from 2 to max
        for (int i = 2; i <= max; i++) {

            // test number has not already been excluded
            // if not, then test if it is a prime number
            if (possiblePrimes[i] && isPrime(i)) {
                primes.add(i);

                // exclude multiples of prime to prevent re-checking later
                // prime = 2 will exclude 4, 6, 8, etc...
                for (int j = i*i; j <= max; j += i) {
                    possiblePrimes[j] = false;
                }
            }
        }

        return primes;

    }

    /**
     * Is n a prime number?
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
