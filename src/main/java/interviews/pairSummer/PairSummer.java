package interviews.pairSummer;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Count how many pairs of numbers add up a given target number
 */
public class PairSummer {

    public static void main(String[] args) {
        PairSummer ps = new PairSummer();
        int pairs = ps.pairSummer(new int[]{6, 8, 4, 11, 1, 5, 7}, 12);
        System.out.println("Pairs found: " + pairs);
    }

    public int pairSummer(int[] array, int target) {

        Set<Integer> searchSet = Arrays.stream(array).boxed().collect(Collectors.toSet());
        int pairs = 0;

        for(int nextNum : array) {

            // remove nextNum so we don't match with ourselves.
            // also once we've checked this number pairs with others,
            // we don't need to re-check other numbers pair with this number.
            // this would create duplicate pairs.
            searchSet.remove(nextNum);

            // calculate what number we need to make a pair
            int searchFor = target - nextNum;

            // do we have a matching pair?
            if (searchSet.contains(searchFor)) {
                System.out.println(nextNum + " + " + searchFor + " = " + target);
                pairs++;
            }
        }

        return pairs;
    }

}
