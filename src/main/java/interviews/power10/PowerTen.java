package interviews.power10;

/**
 * Confirm any supplied number is a power of 10
 */
public class PowerTen {

    public static void main(String[] args) {

        PowerTen sol = new PowerTen();

        sol.isPowerTen(10);
        sol.isPowerTen(1000);
        sol.isPowerTen(50);
        sol.isPowerTen(1);
        sol.isPowerTen(6);
        sol.isPowerTen(0);
    }

    private void log(String type, int number, boolean result) {
        System.out.println(type + " : " + number + " = " + result);
    }

    private void isPowerTen(int number) {
        boolean iterativeResult = isPowerOfTen(number);
        log("Iterative", number, iterativeResult);
        boolean recursiveResult = recursivePowerOfTen(number);
        log("Recursive", number, recursiveResult);
    }

    public boolean isPowerOfTen(int number) {

        while (number > 1) {

            if (number % 10 != 0) {
                return false;
            }

            number = number / 10;
        }

        return (number == 1);
    }


    public boolean recursivePowerOfTen(int number) {

        if (number == 1) {
            return true;
        }

        if (number < 1 || number % 10 != 0) {
            return false;
        }

        return recursivePowerOfTen(number/10);
    }
}
