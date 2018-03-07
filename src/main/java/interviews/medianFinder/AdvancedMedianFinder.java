package interviews.medianFinder;

/**
 * Find the median value from two sorted arrays.
 *
 * Attempts to find median
 * by counting elements either side.
 */
public class AdvancedMedianFinder {

    public static void main(String[] args) {

        // 2 lists - odd - median should be 5
        int[] listOne = new int[] { 1, 3, 5, 7, 8, 9 };
        int[] listTwo = new int[] { 2, 4, 6 };

        // 2 lists - even -  median should be 6 (4+8)/2
        int[] listThree = new int[] { 1, 4, 9 };
        int[] listFour = new int[] { 2, 8, 10 };


        AdvancedMedianFinder mf = new AdvancedMedianFinder();

        System.out.println("Odd list");
        int oddValue = mf.median(listOne, listTwo);
        System.out.println(oddValue);

        System.out.println("-----------------------------------");

        System.out.println("Even list");
        int evenValue = mf.median(listThree, listFour);
        System.out.println(evenValue);
    }

    public int median(int[] arrayOne, int[] arrayTwo) {

        int totalLength = arrayOne.length + arrayTwo.length;
        int wantedIndex = totalLength/2;
        System.out.println("Array Length: " + totalLength);
        System.out.println("Median Expected at Overall Index: " + wantedIndex);

        int median = findValueAtOverallIndex(arrayOne, arrayTwo, wantedIndex);

        if (totalLength % 2 == 0) {
            int previousValue = findValueAtOverallIndex(arrayOne, arrayTwo, wantedIndex - 1);
            return (median + previousValue) / 2;
        }
        else {
            return median;
        }
    }

    // find the value from two sorted arrays at the supplied overall index
    // if the index is not contained in list one, it will try list two
    public int findValueAtOverallIndex(int[] arrayOne, int[] arrayTwo, int wantedIndex) {
        int listOneMedian = searchArray(wantedIndex,arrayOne, arrayTwo);
        if (listOneMedian != -1) {
            return listOneMedian;
        }
        int listTwoMedian = searchArray(wantedIndex, arrayTwo, arrayOne);
        if (listTwoMedian != -1) {
            return listTwoMedian;
        }

        return -1;
    }

    // find number of elements from start of array to searched value
    // it is possible that value doesn't exist so we have to find expected
    // position (e.g. searching for 3 which doesn't exist but 2 and 4 do).
    public int distanceTo(int[] array, int search) {

        // is search value less than entire array?
        if (search < array[0]) {
            return 0;
        }

        // is search value greater than entire array?
        if (search > array[array.length-1]) {
            return array.length;
        }

        int lowerPointer = 0;
        int upperPointer = array.length - 1;
        int midIndex = -1;
        int missedIndex = -1;

        while(lowerPointer <= upperPointer) {

            midIndex = (upperPointer + lowerPointer) / 2;
            int foundValue = array[midIndex];

            if (foundValue == search) {
                return midIndex;
            }

            // this is not a match but is but we need to calculate an index to
            // represent the search's value position (e.g. 3 is not found but it would be
            // between existing values 2 and 4)
            if (search > array[lowerPointer] && search < array[upperPointer]) {
                missedIndex = (foundValue < search) ? upperPointer : midIndex;
            }

            if (foundValue < search) {
                lowerPointer = midIndex + 1;
            }
            else {
                upperPointer = midIndex - 1;
            }
        }

        return missedIndex;
    }

    // use a binary search technique to guess and refine the index of the overall median
    // each guess can be tested against the other array to create an overall index
    // if the median can't be found in this array return -1
    private int searchArray(int wantedIndex, int[] array, int[] otherArray) {
        int start = 0;
        int finish = array.length - 1;

        while (start<=finish) {

            int index = (start + finish) / 2;
            int guess = array[index];
            int distanceToGuess = index +  distanceTo(otherArray, guess);

            System.out.println("Guess = "+ guess + ". Overall Index = " + distanceToGuess + ".");

            if (distanceToGuess == wantedIndex) {
                System.out.println("Found!");
                return guess;
            }

            if (distanceToGuess < wantedIndex) {
                start++;
            }
            else {
                finish--;
            }
        }

        return -1;
    }
}
