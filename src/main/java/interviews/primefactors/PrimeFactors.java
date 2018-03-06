package interviews.primefactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Express any number as a list of prime factors.
 * e.g. 6 = [2, 3]
 * e.g. 12 = [2, 2, 3]
 */
public class PrimeFactors {

    private final int[] primes;

    public static void main(String[] args) {

        PrimeFactors sol = new PrimeFactors();
        sol.factorise(12);
        sol.factorise(6);
        sol.factorise(22);
        sol.factorise(11);
    }

    public PrimeFactors() {
        this.primes = generatePrimes(50);
    }

    private Integer[] factorise(int n) {

        int index = 0;
        int prime = primes[index];
        int remaining = n;
        List<Integer> factors = new ArrayList<>();

        while (remaining > 1) {

            if (remaining % prime == 0) {
                remaining = remaining / prime;
                factors.add(prime);
            }
            else {
                prime = primes[++index];
            }
        }

        System.out.println(n + " = " + factors);

        Integer factorArray[] = new Integer[factors.size()];
        factorArray = factors.toArray(factorArray);

        return factorArray;
    }

    // this is O(n^2) time complexity
    static public int[] generatePrimes(int max) {

        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= max; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j < i; j++ ) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }

        System.out.println("Primes: " + primes);

        int[] primeArray = new int[primes.size()];
        for (int p = 0; p < primes.size(); p++){
            primeArray[p] = primes.get(p);
        }

        return primeArray;
    }
}
