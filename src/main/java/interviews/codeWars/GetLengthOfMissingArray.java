package interviews.codeWars;

import java.util.HashSet;
import java.util.Set;

public class GetLengthOfMissingArray {
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
    {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }

        Set<Integer> lengths = new HashSet<>();
        for (Object[] array : arrayOfArrays) {
            if (array == null || array.length == 0) {
                return 0;
            }
            lengths.add(array.length);
        }

        Integer min = lengths.stream().mapToInt(Integer::intValue).min().getAsInt();
        Integer max = lengths.stream().mapToInt(Integer::intValue).max().getAsInt();

        for (int i = min; i <= max; i++) {
            if (!lengths.contains(i)) {
                return i;
            }
        }

        return 0;
    }


    public static class KataTests {

        public static void main(String[] args) {

            test(3, GetLengthOfMissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
            test(2, GetLengthOfMissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
            test(2, GetLengthOfMissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { null }, new Object[] { null, null, null } } ));
            test(5, GetLengthOfMissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 'a', 'a', 'a' }, new Object[] { 'a', 'a' }, new Object[] { 'a', 'a', 'a', 'a' }, new Object[] { 'a' }, new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }} ));
            test(0, GetLengthOfMissingArray.getLengthOfMissingArray(new Object[][] { }));
            test(0, GetLengthOfMissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 2, 2, 0, 3, 4 }, new Object[] { 4, 0 }, new Object[] { 4, 3, 1 }, new Object[] { 0, 2, 1, 2 }, new Object[0]}));
        }

        private static boolean test(int expected, int actual) {

            boolean result = expected == actual;
            System.out.println("Expected: " + expected + ". Actual: " + actual + ". Result: " + result);
            return result;


        }
    }
}
