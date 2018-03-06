package interviews.medianFinder;

/**
 * Find the median value from two sorted arrays.
 *
 * Work-in-progress: attempting to find median
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

        int index = mf.partition(listTwo, 2);
        System.out.println(index);
        index = mf.partition(listTwo, 4);
        System.out.println(index);
        index = mf.partition(listTwo, 6);
        System.out.println(index);
        index = mf.partition(listTwo, 0);
        System.out.println(index);
        index = mf.partition(listTwo, 9);
        System.out.println(index);

//        int value = mf.median(listOne, listTwo);
//        System.out.println(value);


//        int oddMedian = mf.efficientMedian(listOne, listTwo);
//        System.out.println("Odd Median: " + oddMedian);
//
//        int evenMedian = mf.efficientMedian(listThree, listFour);
//        System.out.println("Even Median: " + evenMedian);

    }


    public int median(int[] arrayOne, int[] arrayTwo) {


        int guess = -1;
        int totalLength = arrayOne.length + arrayTwo.length;
        int wantedIndex = totalLength/2;


        boolean medianFound = false;
        int guessIndex = arrayOne.length / 2;
        while (!medianFound) {

            guess = arrayOne[guessIndex];

            int partition = partition(arrayTwo, guess);

            int valuesBelow = guessIndex + partition;
            if (valuesBelow == wantedIndex) {
                medianFound = true;
            }
            else if (valuesBelow < wantedIndex) {
                guessIndex++;
            }
            else {
                guessIndex--;
            }



        }

        return guess;

    }

    // partition a list in two
    // return index of partition so that...
    // < value exist in lower partition
    // >= value exist in upper partition
    public int partition(int[] array, int value) {

        int lowerPointer = 0;
        int upperPointer = array.length;

        while(upperPointer-lowerPointer > 0) {
            int midIndex = lowerPointer + ((upperPointer - lowerPointer) / 2);

            if (value >= array[midIndex]) {
                lowerPointer = midIndex + 1;
            }
            else {
                upperPointer = midIndex - 1;
            }

            // if lowerPointer has exceeded the array size, all
            // elements are lower than the searched value
            if (lowerPointer >= array.length) {
                return array.length;
            }



//            System.out.println(midIndex);
//            System.out.println(upperPointer);
//            System.out.println(lowerPointer);
//            System.out.println(array[lowerPointer]);
//            System.out.println("------------------------------------------");




        }

        return lowerPointer;




    }



}
