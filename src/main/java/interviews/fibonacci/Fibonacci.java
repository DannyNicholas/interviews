package interviews.fibonacci;

/**
 * Generate Fibonacci sequence.
 * One uses recursion
 * One uses iteration (O(n) time complexity and O(1) space complexity).
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci sol = new Fibonacci();
        sol.start();
    }

    public void start() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " - " + fibonacci(i));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " - " + nonRecursiveFibonacci(i));
        }
    }

    public int fibonacci(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int nonRecursiveFibonacci(int n) {

        int nMinus1 = 0;
        int nMinus2 = 0;
        int sum = 0;

        for (int i = 0; i <= n; i++) {

            if (i == 1) {
                sum = 1;
            }
            else {
                sum = nMinus1 + nMinus2;
            }

            nMinus2 = nMinus1;
            nMinus1 = sum;
        }

        return sum;
    }
}
