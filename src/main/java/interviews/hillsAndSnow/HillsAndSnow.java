package interviews.hillsAndSnow;

import java.util.Arrays;

/**
 * You are given an array of Integers representing the height of hills.
 * You need to calculate the sum of all the snow that can rest in the valleys between the peaks, e.g.:
 *
 *                                     X
 *                 X   *   *   *   *   X   *   *   X         *   Snow
 *                 X   *   X   *   *   X   *   *   X         X   Hill
 *             X   X   *   X   X   *   X   *   X   X
 * Height: 0   1   3   0   2   1   0   4   0   1   3   0
 * Index:  0   1   2   3   4   5   6   7   8   9   10  11
 *
 * Total snow = 14
 *
 */

public class HillsAndSnow {

    public static void main(String[] args) {

        int[] hills = new int[] {0, 1, 3, 0, 2, 1, 0, 4, 0, 1, 3, 0};

        // find max height
        int maxHeight = Arrays.stream(hills).max().getAsInt();
        System.out.println("Max height: " + maxHeight);

        // iterate through each height in descending order
        // for each height we are looking for hills
        // snow can only exist between hills
        int snowSum = 0;
        for (int height = maxHeight; height > 0; height--) {

            System.out.println("Height:" + height);
            Boolean foundHill = false;
            Integer hillStartIndex = null;
            for (int i = 0; i< hills.length; i++) {
                if(hills[i] >= height && !foundHill) {
                    System.out.println("Hill starts at:" + i);
                    foundHill = true;
                    hillStartIndex = i;
                }
                else if(hills[i] >= height && foundHill) {
                    System.out.println("Hill ends at:" + i);
                    int snow = (i - hillStartIndex - 1);
                    System.out.println("Snow in valley:" + snow);
                    snowSum += snow;
                    hillStartIndex = i;
                }
            }
            System.out.println("----------------");
        }
        System.out.println("Total snow: " + snowSum);
    }


}
