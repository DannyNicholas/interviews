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

        int value = mf.median(listOne, listTwo);
        System.out.println(value);

        int value2 = mf.median(listThree, listFour);
        System.out.println(value2);


//        int oddMedian = mf.efficientMedian(listOne, listTwo);
//        System.out.println("Odd Median: " + oddMedian);
//
//        int evenMedian = mf.efficientMedian(listThree, listFour);
//        System.out.println("Even Median: " + evenMedian);

    }


    public int median(int[] arrayOne, int[] arrayTwo) {


        //int guess = -1;
        int totalLength = arrayOne.length + arrayTwo.length;
        int wantedIndex = totalLength/2;


        boolean medianFound = false;
        int guessIndex = arrayOne.length / 2;


        int start = 0;
        int finish = arrayOne.length - 1;


        while (start<=finish) {

            int index = (start + finish)/2;
            int guess = arrayOne[index];

            //guess = arrayOne[guessIndex];

            int partition = partition(arrayTwo, guess);

            int valuesBelow = guessIndex + partition + 1;
            int valuesAbove = (arrayOne.length - guessIndex) + (arrayTwo.length - partition);

            System.out.println("Index= "+ index + ". Guess= "+ guess + ". Values Below= " + valuesBelow + ". Values Above= " + valuesAbove);

            if (valuesBelow == wantedIndex) {
                medianFound = true;
                System.out.println("Found!");
                return guess;
            }

            if (valuesBelow < wantedIndex) {
                start++;
            }
            else {
                finish--;
            }



        }

        return -1;

    }

    // partition a list in two
    // return index of partition so that...
    // < value exist in lower partition
    // >= value exist in upper partition
    public int partition(int[] array, int search) {

        int lowerPointer = 0;
        int upperPointer = array.length - 1;
        int midIndex = -1;

        while(lowerPointer <= upperPointer) {

            midIndex = (upperPointer + lowerPointer) / 2;
            int foundValue = array[midIndex];

            if (foundValue == search) {
                return midIndex;
            }

            if (foundValue < search) {
                lowerPointer = midIndex + 1;
            }
            else {
                upperPointer = midIndex - 1;
            }

//            System.out.println(midIndex);
//            System.out.println(upperPointer);
//            System.out.println(lowerPointer);
//            System.out.println(array[lowerPointer]);
//            System.out.println("------------------------------------------");




        }

        return midIndex;




    }



}
