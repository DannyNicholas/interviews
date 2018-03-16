package interviews.primeCountdown;

/**
 * Create a prime number countdown from n
 */
public class PrimeCountdown {

    public static void main(String[] args) {
        primeCountDown(35);
    }

    private static void primeCountDown(int n) {

        for (int i = n; i > 1; i--) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
