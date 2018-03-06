package interviews.fractions;

/**
 * Sum two fractions represented as arrays.
 * Simplify the summed fraction.
 */
public class Fractions {


    public static int[] fractionOne = new int[] { 1, 5 };
    public static int[] fractionTwo = new int[] { 2, 10 };

    public static void main(String[] args) {
        int[] addition = addFractions(fractionOne, fractionTwo);
        System.out.println("Addition: " + addition[0] + "/" + addition[1]);

        int[] simplified = simplify(addition);
        System.out.println("Simplified: " + simplified[0] + "/" + simplified[1]);
    }

    // add two fractions and return the result
    public static int[] addFractions(int[] fract1, int[] fract2) {

        int numerator1 = fract1[0];
        int denominator1 = fract1[1];

        int numerator2 = fract2[0];
        int denominator2 = fract2[1];

        int commonDenominator = denominator1 * denominator2;
        int addedNumerator = (numerator1 * denominator2) + (numerator2 * denominator1);

        int[] result = new int[2];
        result[0] = addedNumerator;
        result[1] = commonDenominator;
        return result;
    }

    // simplify the supplied fraction
    public static int[] simplify(int[] fract) {

        int gcd = euclidianGcd(fract[0], fract[1]);
        System.out.println("GCD: " + gcd);

        int[] result = new int[2];
        result[0] = fract[0] / gcd;
        result[1] = fract[1] / gcd;
        return result;
    }

    // find greatest common divisor.
    //
    // this is a brute-force method that reduces until it finds a divisor
    // so that numerator and denominator are completely divisible.
    //
    // more efficient to replace with Euclidian Algorithm for GCD
    private static int gcd(int a, int b) {
        int smallest = a < b ? a : b;

        for (int i = smallest; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }

    // more efficient GCD algorithm
    private static int euclidianGcd(int a, int b) {
        int smallest = a < b ? a : b;
        int largest = a < b ? b : a;
        int remainder = -1;

        while (remainder != 0) {
            remainder = largest % smallest;
            if (remainder > 0) {
                largest = smallest;
                smallest = remainder;
            }
        }

        return smallest;
    }
}
